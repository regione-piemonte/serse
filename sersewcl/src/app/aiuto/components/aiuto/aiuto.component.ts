/**
 * @license
 *
 * Copyright © 2025 Regione Piemonte
 *
 * Licensed under the EUPL, Version 1.2 or – as soon they will be
 * approved by the European Commission - subsequent versions of the
 * EUPL (the "Licence");
 *
 * You may not use this work except in compliance with the Licence.
 * You may obtain a copy of the Licence at:
 *
 * https://interoperable-europe.ec.europa.eu/collection/eupl/eupl-text-eupl-12
 * or
 * https://opensource.org/license/EUPL-1.2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the Licence is distributed on an "AS IS" basis,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Licence for the specific language governing permissions and
 * limitations under the Licence.
 */

import { Component, OnInit, ViewChild, AfterViewInit, ChangeDetectorRef, Renderer2, ElementRef } from '@angular/core';
import { FormControl } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { MatIconRegistry } from '@angular/material/icon';

//-Components
import { GuideComponent } from '../guide/guide.component';

//-Services
import { TitleService } from '@core/services/title.service';
import { AiutoService } from '@aiuto/services/aiuto.service';

//-Const
import { Incontro_HELP, Intervento_HELP, Modello_HELP, Servizio_HELP } from 'src/app/aiuto/const/list-help.const';
import { IconsSettings } from '@shared/const/icons-settings';

// importazione dinamica di pdfMake
// in modo da ridurre il bundle size iniziale

async function loadPdfMake() {
  const pdfMake = await import('pdfmake/build/pdfmake');
  const pdfFonts = await import('pdfmake/build/vfs_fonts');
  (pdfMake as any).vfs = pdfFonts.pdfMake.vfs;
  return pdfMake;
}

declare var pdfMake: any;
loadPdfMake().then((p) => { pdfMake = p; });


@Component({
  selector: 'app-aiuto',
  templateUrl: './aiuto.component.html',
  styleUrls: ['./aiuto.component.css']
})
export class AiutoComponent implements OnInit {

  @ViewChild("guida") guidaComp!:GuideComponent;
  indice = -1;

  @ViewChild('parentElement') parentElement!: ElementRef;


  domandaForm: FormControl = new FormControl('');

  indexActivated = 0;
  categoriaList = ["Modelli di intervento",
                    "Interventi",
                    "Servizi",
                    "Funzioni trasversali",
                    "Caricamento da file"
                  ]

  modelloIcon = IconsSettings.MODELLI_ICON;
  interventoIcon = IconsSettings.INTERVENTI_ICON;
  servizioIcon = IconsSettings.SERVIZI_ICON;
  strumentiIcon = IconsSettings.STRUMENTI_ICON;
  excelIcon="xlsx_icon"
  icons = [this.modelloIcon, this.interventoIcon, this.servizioIcon, this.strumentiIcon,this.excelIcon]

  constructor(
    private title: TitleService,
    private renderer: Renderer2,

    //-Icone
    private matIconRegistry: MatIconRegistry,
    private domSanitizer: DomSanitizer,

    private aiutoService: AiutoService
  ) {}

  ngOnInit() {
    this.title.setTitle("Aiuto SERSE");
    this.uploadIcons();
    this.aiutoService.subject.subscribe((newValue)=>{
      this.zoomValue += newValue;
      if(this.zoomValue < 1) this.zoomValue = 1;
      if(newValue>0){
        this.zoomIn();
      } else {
        this.zoomOut();
      }

    })
  }

  uploadIcons(){
    this.matIconRegistry.addSvgIcon(
      this.modelloIcon,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconMDI)
    );
    this.matIconRegistry.addSvgIcon(
      this.interventoIcon,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconINT)
    );
    this.matIconRegistry.addSvgIcon(
      this.servizioIcon,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconSER)
    );
    this.matIconRegistry.addSvgIcon(
      this.strumentiIcon,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.menuIconSTR)
    );
    this.matIconRegistry.addSvgIcon(
      this.excelIcon,
      this.domSanitizer.bypassSecurityTrustResourceUrl(IconsSettings.ICON_URL + "xlsx_icon.svg")
    );
  }

  ngAfterViewInit(): void {
    this.setIndex(this.aiutoService.indexDocByLastUrl());
  }
  setIndex(i:number){
    this.indexActivated = i;
  }


  //- Zoom-IN/OUT
  fontSize: number = 16; // Dimensione del font iniziale
  zoomValue = 0;

  zoomIn() {
    let value = this.zoomValue;
    if (this.parentElement) {
      this.renderer.setStyle(this.parentElement.nativeElement, 'transform', `scale(${value})`);
    }
  }

  zoomOut() {
    if( this.zoomValue < 1) return;
    let value = this.zoomValue;
    if (this.parentElement) {
      this.renderer.setStyle(this.parentElement.nativeElement, 'transform', `scale(${value})`);
    }
  }





  onSearchClick(){
    let domanda: string = this.domandaForm.value;
    if(!domanda) return;

    let indexsReponce = this.aiutoService.onSearch(domanda);
    let indexCategory = indexsReponce.doc;
    let indexResponce = indexsReponce.responce;
    this.setIndex(indexCategory);

    if(indexResponce != -1){
      this.indice = indexResponce;
    }
  }

  pannelliPronti(){
    this.indice = -1;
  }

  getImageAsBase64(imageName: string): Promise<string> {
    const imagePath = `${imageName}`;

    return fetch(imagePath)
      .then((response) => {
        if (response.ok) {
          return response.blob();
        } else {
          throw new Error(`Failed to load image: ${response.status} ${response.statusText}`);
        }
      })
      .then((blob) => {
        return new Promise<string>((resolve) => {
          const reader = new FileReader();
          reader.onloadend = () => {
            if (typeof reader.result === 'string') {
              resolve(reader.result);
            } else {
              resolve("");
            }
          };
          reader.readAsDataURL(blob);
        });
      })
      .catch((error) => {
        console.error(error);
        return "";
      });
  }
  async separaTesto(testo: string): Promise<( { text: string; style?: string; tocItem?: boolean; } |
                                              {image:string, width:number, height:number})[]> {
    // Utilizza una regex per dividere la stringa in base a '<' e '>'
    const arrayDiviso = testo.split(/(<[^>]+>)/);

    const risultato: any[] = [];

    for (const element of arrayDiviso) {
      if (element.startsWith('<img') && element.includes("src=")) {
        // Estrai il valore dell'attributo "src" dalla stringa
        const srcValueMatch = element.match(/src=['"]([^'"]+)['"]/);
        if (srcValueMatch && srcValueMatch.length > 1) {
          risultato.push({ image: await this.getImageAsBase64(srcValueMatch[1]), width: 450, height: 200 });
        }
      } else if (element.startsWith('<') && !element.includes("img")) {
        risultato.push({ text: " ", tocItem: false });
      } else {
        risultato.push({ text: element, tocItem: false });
      }
    }

    return risultato;
  }
  async downloadPdf(){
    const content :any[]=  [
      { text: 'Documentazione', style: 'mainHeader', tocItem: true, pageBreak: 'before', margin: [ 50, 50, 50, 50 ]   }, // Titolo principale
      { text: '\n' }, // Spazio tra il titolo principale e il contenuto
    ];

    let i = 0;
    let titoli = ["Modello di intervento", "Intervento", "Servizio", "Incontro"]
    for (const HELP of [Modello_HELP, Intervento_HELP, Servizio_HELP, Incontro_HELP]) {
      content.push(
        { text: `${titoli[i]}`, style: 'mainHeader', tocItem: true, pageBreak: 'before', tocStyle:'tocHeader' }, // Titolo principale
        { text: '' },
      )
      for (const es of HELP) {
        const titleText = { text: String(es.title), style: 'subHeader', tocItem: true, tocStyle:'tocSubHeader' };
        const descriptionText = { text: es.descrizione ?? '', tocItem: false };

        content.push(
            titleText,
            ...await this.separaTesto(descriptionText.text),
            { text: '', tocItem: false });
      }
      i++;
    }


    // Genera il sommario (TOC)
    const tableOfContents = {
      toc: {
        title: { text: 'Indice', style: 'header', id:'contents'},
        numberStyle: { bold: true },
      },
    };

    // Definizione del documento
    const documentDefinition = {
      content: [
        tableOfContents,
        ...content,
      ],
      footer: {
        columns: [' ',' ', ' ', { text: 'Torna a table of contents', linkToDestination: 'contents', style:'torna' }]
      },
      styles: {
        // header: { fontSize: 18, bold: true },
        // subheader: { fontSize: 14, bold: true },
        header: {
          fontSize: 16,
          bold: true,
          lineHeight: 1.3

        },
        mainHeader: {
          fontSize: 18,
          bold: true, // Titoli principali in grassetto
          lineHeight: 1.3
        },
        subHeader: {
          fontSize: 14,
          italics: true, // Titoli secondari in corsivo
          bold: true,
          lineHeight: 1.5
        },


        tocHeader: {
          fontSize: 16,
          bold: true, // Stile per gli elementi del sommario
          lineHeight: 1.3
        },
        tocSubHeader:{
          fontSize: 12,
          italics: true, // Titoli secondari in corsivo
          bold: false, // Stile per gli elementi del sommario
          lineHeight: 1.3
        },
        torna:{
          fontSize: 9,
          color: 'blue',
          italics: true,
          bold: true
        }


      },
      defaultStyle: {
        fontSize: 12,
      },
      pageBreakBefore: (currentNode:any) => {
        return currentNode.tocItem;
      },
    };

    //-Download del pdf
    pdfMake.createPdf(documentDefinition).download('documentazione.pdf');
  }


}
