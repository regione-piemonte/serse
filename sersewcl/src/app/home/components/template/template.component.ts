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

import { AfterViewInit, Component, OnInit, ElementRef, ViewChild, AfterViewChecked } from '@angular/core';
import { FormControl } from '@angular/forms';
import { DomSanitizer, SafeHtml } from '@angular/platform-browser';
import { NavigationStart, Router } from '@angular/router';

// Models
import { UserInfo } from '@core/api-serse/model/userInfo';
import { DialogButton } from '@shared/model/dialog-settings.model';
import { FlaidoorService } from '@home/services/flaidoor.service';

// Services
import { HomeBagService } from '@home/services/home-bag.service';
import { AiutoService } from 'src/app/aiuto/services/aiuto.service';

//-Const
import { ARRAY_HELP } from 'src/app/aiuto/const/list-help.const';

@Component({
  selector: 'app-template',
  templateUrl: './template.component.html',
  styleUrls: ['./template.component.scss']
})
export class TemplateComponent implements OnInit , AfterViewInit, AfterViewChecked {

  chatHidden = true;
  domandaForm = new FormControl('');

  aiutoHidden = true;
  messages: {message:SafeHtml, sender:boolean, buttons:DialogButton[]}[] = [
      {message:'Come posso aiutarti ?', sender:false, buttons:[]},
  ]
  indexLastMsg = -1;
  get messageLastPosition():number{
    return this.indexLastMsg;
  }

  isHovered = false
  showToolTip = 0;
  constructor(
    private homeBagService: HomeBagService,
    private flaidoorService: FlaidoorService,
    private sanitizer: DomSanitizer,
    private router: Router,

    private aiutoService:AiutoService) {

    this.router.events.subscribe((event) => {
        if (event instanceof NavigationStart && this.chatHidden) {
          if(this.showToolTip == 0) {
            this.isHovered = true
            setTimeout(() => {
              this.isHovered = false
            }, 5000);
            this.showToolTip = 5;
          }
          this.showToolTip--;
        }
      });
  }

  ngAfterViewInit(): void {
    this.flaidoorService.getUserInfo()
       .subscribe( risposta => this.homeBagService.setUserInfo(risposta));

    this.isHovered = true
    setTimeout(() => {
      this.isHovered = false;
      this.showToolTip = 5;

    }, 5000);
  }
  ngOnInit(): void {}


  openChatHelp(){
    this.chatHidden = false;
  }
  closeChatHelp(){
    this.chatHidden = true;
  }
  openHelp(){
    this.aiutoHidden = false;
  }
  cleanChatHelp(){
    this.messages = [{message:'Come posso aiutarti ?', sender:false, buttons:[]}]
    this.primaDomanda = true;
  }

  @ViewChild('chatArea', { static: true }) chatAreaRef!: ElementRef;
  scrollHeight = 0;
  previousHeight = 0;
  ngAfterViewChecked() {
    const currentHeight = this.chatAreaRef.nativeElement.scrollHeight;

    if (currentHeight !== this.previousHeight) {
      this.chatAreaRef.nativeElement.scrollTop = this.scrollHeight
      this.previousHeight = currentHeight;
    }
  }
  primaDomanda = true;
  onDomanda(){
    if(!this.domandaForm.value){
      return;
    }

    //- Build chat
    this.messages.push({message:this.domandaForm.value, sender:true, buttons:[]});
    //- create responce
    this.messages.push({
      message:this.analizzatore(this.domandaForm.value),
      sender:false,
      buttons:[
        new DialogButton(
          "Approfondisci",
          "btn btn--outline-primary",
          ()=>{
            this.openHelp()
            this.closeChatHelp()
          },
          "documentazione completa"
        )]});

    this.domandaForm.setValue(""); //-Reset Input
    if(!this.primaDomanda){
      this.scrollHeight = this.chatAreaRef.nativeElement.scrollHeight;
      this.scrollHeight -=100;
    }

    this.primaDomanda = false;
    this.indexLastMsg = this.messages.length-2;
    setTimeout(() => {
      this.indexLastMsg = -1;
    }, 1000);

  }

  analizzatore(domanda:string){
    let indexs = this.aiutoService.onSearch(domanda);
    let helpSection = ARRAY_HELP[indexs.doc];
    let argument = indexs.responce != -1
                    ?helpSection[indexs.responce]
                    :{title:'Nessun risultato', descrizione:''};

    let risposta:string = "";
    risposta = `Possibile risposta: ${argument.title} `+
                `<br> <br><br>  ${argument.descrizione}`;

    return this.sanitizer.bypassSecurityTrustHtml(risposta+ `<br><br> per altre informazioni fai una domanda oppure naviga alla documentazione cliccando qui sotto`);
  }

  //===================================================================
  //===================================================================
  //- Zoom IN/OUT
  zoomIn(){
    this.aiutoService.subject.next(+0.25)
  }
  zoomOut(){
    this.aiutoService.subject.next(-0.25)
  }

  //===================================================================
  //===================================================================
  //- Image handler
  isOpen = false; // Variabile di stato per determinare se l'overlay è aperto
  imageUrl = '';
  visible = false;

  closeImageOverlay() {
    // Chiude l'overlay quando viene fatto clic su di esso
    this.isOpen = false;
    this.visible = false;
  }
  openImage(event: MouseEvent) {
    const target = event.target as HTMLElement;

    if (target.tagName === 'IMG') {
      const imageUrl = target.getAttribute('src');

      if (imageUrl) {
        this.isOpen = true;
        this.visible = true;
        this.imageUrl = imageUrl;

        // Apri l'immagine a schermo intero (utilizzando il componente image-overlay)
        // Passa l'URL dell'immagine al componente image-overlay
        // Puoi utilizzare un servizio o una variabile per comunicare con image-overlay.
      }
      else{
        console.error("no immagine D:")
      }
    }
  }


  //===================================================================
  //===================================================================
  //- getter
  get userInfo(): UserInfo{
    return this.homeBagService.userInfo;
  }
  get descrizioneRuolo():string|undefined{
    return this.homeBagService.selectedRuolo==null?undefined:this.homeBagService.selectedRuolo.descrizione;
  }
  get descrizioneOperatore():string|undefined{
    return this.homeBagService.descriOperatore==null?undefined:this.homeBagService.descriOperatore;
  }
}
