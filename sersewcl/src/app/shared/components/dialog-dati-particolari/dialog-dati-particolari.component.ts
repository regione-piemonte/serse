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

import { Component, Inject, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ClasseDestinatario } from '@core/api-serse/model/classeDestinatario';
import { CondizioneOccupazionaleIgrue } from '@core/api-serse/model/condizioneOccupazionaleIgrue';
import { DatiPeculiari } from '@core/api-serse/model/datiPeculiari';
import { DatiPeculiariWrapper } from '@core/api-serse/model/datiPeculiariWrapper';
import { Destinatario } from '@core/api-serse/model/destinatario';
import { DettaglioClasseDestinatarioServizio } from '@core/api-serse/model/dettaglioClasseDestinatarioServizio';
import { EnteDestinatario } from '@core/api-serse/model/enteDestinatario';
import { Servizio } from '@core/api-serse/model/servizio';
import { TitoloStudioIgrue } from '@core/api-serse/model/titoloStudioIgrue';
import { DestinatariService } from '@core/services/destinatari.service';
import { HomeBagService } from '@home/services/home-bag.service';
import { ServiziService } from '@servizi/services/servizi.service';
import { DialogSettings } from '@shared/model/dialog-settings.model';
import { Validation } from '@shared/utils/validation';

@Component({
  selector: 'app-dialog-dati-particolari',
  templateUrl: './dialog-dati-particolari.component.html',
  styleUrls: ['./dialog-dati-particolari.component.scss']
})
export class DialogDatiParticolariComponent implements OnInit {

  constructor(
    @Inject(MAT_DIALOG_DATA) public dialogSettings: DialogSettings,
    private fb: FormBuilder,
    private serviziService: ServiziService,
    private destinatariService: DestinatariService,
    private homeBag: HomeBagService
  ) { }

  //condizioni per la visibilità dei campi
  showDatoPeculiare1: boolean = true
  showDatoPeculiare2: boolean = true
  showCondOcc: boolean = true
  showTitoloSt: boolean = true
  showDisab: boolean = true
  showSvantAbitativo: boolean = true

  errorNonCompilati: string = ""
  entiDestinatario: EnteDestinatario[] = [];
  enteDestinatarioAssociato?: EnteDestinatario;
  titoliDIStudio: TitoloStudioIgrue[] = [];
  condizioniOcuppazionale: CondizioneOccupazionaleIgrue[] = [];
  classiDestinatario: ClasseDestinatario[] = [];
  destinatario: Destinatario = this.dialogSettings.data ? this.dialogSettings.data[0] : {};
  datiParticolari: DatiPeculiariWrapper = this.dialogSettings.data ? this.dialogSettings.data[1] : {};
  servizio: Servizio = this.dialogSettings.data ? this.dialogSettings.data[2] : {};
  dettaglioClasseDestinatarioServizio: DettaglioClasseDestinatarioServizio = this.dialogSettings.data ? this.dialogSettings.data[3] : {};
  idPso: number = this.dialogSettings.data ? this.dialogSettings.data[4] : {};


  target = "";
  //----anagrafica
  anagrafica = this.fb.group({
    cognome: [''],
    nome: [''],
    codFisc: [''],
    dataNascita: [''],
  });
  datiPeculiariForm: FormGroup = this.fb.group({
    nomeEnte: ['',],
    datoPeculiare1: [{ value: null }],
    datoPeculiare2: ['', Validators.maxLength(500)],
    titoloDiStudio: [''],
    condizioneOccupazionale: [''],
    svantaggioAbitativo: [''],
    disabilita: [''],
    idPsoClasseDestinatario:['']
  })

  form = this.fb.group({
    anagrafica: this.anagrafica,
    datiPeculiari: this.datiPeculiariForm
  })

  labelDatoPeculiare1: string = ""
  labelDatoPeculiare2: string = ""
  ngOnInit(): void {
    if (this.destinatario) {
      //se richiamo la dialog dal destinatario
      this.target = "destinatario";
      this.fetchDatiDestinatario();
      this.initDatiDestinatario();

    } else {
      //se richiamo la dialog dal servizio
      this.target = "servizio";

      this.fetchDatiPeculiari();
      this.initDatiServizio();
    }

    if (!this.isModificabile || this.esisteElaborazioneInCorso) {
      this.form.disable();
    }
  }


  fetchDatiPeculiari() {
    this.classiDestinatario = [];
    if (this.datiParticolari.sportMonitoraggio?.flgCondizioneOccupazionale) {
      this.destinatariService.getCondizioneOccupazionaleIgrue().subscribe({
        next: response => this.condizioniOcuppazionale = response
      })

      if (this.datiParticolari.sportMonitoraggio?.flgCondizioneOccupazionale == "O") {
        this.datiPeculiariForm.get("condizioneOccupazionale")?.setValidators(Validators.required)
      }
    } else {
      this.showCondOcc = false
    }

    if (this.datiParticolari.sportMonitoraggio?.flgTitoloStudio) {
      this.destinatariService.getTitoliIgrue().subscribe({
        next: response => this.titoliDIStudio = response
      })

      if (this.datiParticolari.sportMonitoraggio?.flgTitoloStudio == "O") {
        this.datiPeculiariForm.get("titoloDiStudio")?.setValidators(Validators.required)
      }
    } else {
      this.showTitoloSt = false
    }

    if (this.datiParticolari.sportMonitoraggio?.flgDisabilita) {
      if (this.datiParticolari.destinatarioServizioMonitoraggio?.flgDisabilita && this.destinatario) {
        this.datiPeculiariForm.get("disabilita")?.setValue(this.datiParticolari.destinatarioServizioMonitoraggio?.flgDisabilita)
      } else if (this.servizio && this.servizio.flgDisabilita) {
        this.datiPeculiariForm.get("disabilita")?.setValue(this.servizio.flgDisabilita)
      } else if (this.datiParticolari.sportMonitoraggio?.flgDisabilitaDefault) {
        this.datiPeculiariForm.get("disabilita")?.setValue(this.datiParticolari.sportMonitoraggio?.flgDisabilitaDefault)
      }

      if (this.datiParticolari.sportMonitoraggio?.flgDisabilita == "O") {
        this.datiPeculiariForm.get("disabilita")?.setValidators(Validators.required)
      }
    } else {
      this.showDisab = false
    }

    if (this.datiParticolari.sportMonitoraggio?.flgSvantaggioAbitativo) {
      if (this.datiParticolari.destinatarioServizioMonitoraggio?.flgSvantaggioAbitativo && this.destinatario) {
        this.datiPeculiariForm.get("svantaggioAbitativo")?.setValue(this.datiParticolari.destinatarioServizioMonitoraggio?.flgSvantaggioAbitativo)
      } else if (this.servizio && this.servizio.flgSvantaggioAbitativo) {
        this.datiPeculiariForm.get("svantaggioAbitativo")?.setValue(this.servizio.flgSvantaggioAbitativo);
      } else if (this.datiParticolari.sportMonitoraggio.flgSvantaggioAbitativoDefault) {
        this.datiPeculiariForm.get("svantaggioAbitativo")?.setValue(this.datiParticolari.sportMonitoraggio.flgSvantaggioAbitativoDefault)
      }

      if (this.datiParticolari.sportMonitoraggio.flgSvantaggioAbitativo == "O") {
        this.datiPeculiariForm.get("svantaggioAbitativo")?.setValidators(Validators.required)
      }
    } else {
      this.showSvantAbitativo = false
    }


    if (this.datiParticolari.regComportPsoSport?.labelDatoPeculiare1) {
      this.labelDatoPeculiare1 = this.datiParticolari.regComportPsoSport?.labelDatoPeculiare1;
      this.destinatario ?
        this.datiPeculiariForm.get('datoPeculiare1')!.setValue(this.datiParticolari.destinatarioServizio?.valoreDatoPeculiare1!) :
        this.datiPeculiariForm.get('datoPeculiare1')!.setValue(this.servizio.valoreDatoPeculiare1!);
      this.destinatariService.getClassiDestinatario(this.idPso).subscribe({
        next: response => {       
          let dettaglio = this.destinatario ? this.datiParticolari.dettaglioClasseDestinatario : this.dettaglioClasseDestinatarioServizio;
          this.classiDestinatario = response;
          if (dettaglio!.idPsoClasseDestinatario != null) {
            if (!this.classiDestinatario.some(a => a.idPsoClasseDestinatario == dettaglio!.idPsoClasseDestinatario)) {
              let classeDestinatario: any = {
                idPsoClasseDestinatario: dettaglio!.idPsoClasseDestinatario,
                descrClasseDestinatario: dettaglio!.descrClasseDestinatario
              }
              this.classiDestinatario.push(classeDestinatario);
            }
            this.datiPeculiariForm.get('idPsoClasseDestinatario')!.setValue(dettaglio!.idPsoClasseDestinatario);
          } else if (dettaglio!.valoreDatoPeculiare1 != null) {
            let classeDestinatario: any = {
              idPsoClasseDestinatario: -1,
              descrClasseDestinatario: dettaglio!.valoreDatoPeculiare1
            }
            this.classiDestinatario.push(classeDestinatario);
            this.datiPeculiariForm.get('idPsoClasseDestinatario')!.setValue(-1);
          }
          this.classiDestinatario.sort((a, b) => (a.idPsoClasseDestinatario! - b.idPsoClasseDestinatario!));
        }
      })
    } else {
      this.showDatoPeculiare1 = false
    }

    if (this.datiParticolari.regComportPsoSport?.labelDatoPeculiare2) {
      
      this.labelDatoPeculiare2 = this.datiParticolari.regComportPsoSport?.labelDatoPeculiare2
      this.destinatario ?
        this.datiPeculiariForm.get('datoPeculiare2')!.setValue(this.datiParticolari.destinatarioServizio?.valoreDatoPeculiare2!) :
        this.datiPeculiariForm.get('datoPeculiare2')!.setValue(this.servizio.valoreDatoPeculiare2!);

    } else {
      this.showDatoPeculiare2 = false
    }
  }

  initDatiDestinatario() {

    this.anagrafica.controls['cognome'].disable();
    this.anagrafica.controls['nome'].disable();
    this.anagrafica.controls['codFisc'].disable();
    this.anagrafica.controls['dataNascita'].disable();

    //this.datiPeculiariForm.get("nomeEnte")!.setValue(this.datiParticolari.destinatarioServizio?.idEnteCoinvoltoServizio!.toString()!)

    this.datiPeculiariForm.get('condizioneOccupazionale')!.setValue(this.datiParticolari!.destinatarioServizioMonitoraggio!.codCondizioneOccupazionaleIgrue!);
    this.datiPeculiariForm.get('titoloDiStudio')!.setValue(this.datiParticolari!.destinatarioServizioMonitoraggio!.codTitoloStudioIgrue!);
  }

  initDatiServizio() {
    this.datiPeculiariForm.get('condizioneOccupazionale')!.setValue(this.servizio!.codCondizioneOccupazionaleIgrue!);
    this.datiPeculiariForm.get('titoloDiStudio')!.setValue(this.servizio!.codTitoloStudioIgrue!);
  }

  fetchDatiDestinatario() {
    this.datiParticolari.destinatarioServizioMonitoraggio!.codiceCitadinanza = this.destinatario.codCittadinanza!
    this.serviziService.getEntiCoinvoltiAssociatiDestinatario(this.serviziService.servizio.idServizio!.toString())
      .subscribe({
        next: (response) => {
          this.entiDestinatario = response

          if (this.datiParticolari.destinatarioServizio?.idEnteCoinvoltoServizio) {
            this.enteDestinatarioAssociato = response.find(ente =>
              ente.idEnteConvoltoServizio == this.datiParticolari.destinatarioServizio?.idEnteCoinvoltoServizio
            )

            this.datiPeculiariForm.get("nomeEnte")!.setValue(this.datiParticolari.destinatarioServizio?.idEnteCoinvoltoServizio.toString())

          } else if (this.entiDestinatario.length == 1 && this.isModificabile && !this.esisteElaborazioneInCorso) {
            this.enteDestinatarioAssociato = this.entiDestinatario[0]
            this.datiPeculiariForm.get("nomeEnte")!.setValue(this.entiDestinatario[0].idEnteConvoltoServizio?.toString()!)
          }
        }
      })

    this.fetchDatiPeculiari();

  }
  onConferma() {

    if (this.datiPeculiariForm.valid) {
      //se richiamo la dialog dal destinatario
      if (this.destinatario) {
        let datiPeculiari: DatiPeculiari = this.getDatiPeculiari()
        if (datiPeculiari.destinatarioServizioMonitoraggio?.codUserInserim == null) {
          datiPeculiari.destinatarioServizioMonitoraggio!.codUserInserim = this.homeBag.userInfo!.codFisc!

        }
        this.errorNonCompilati = ""
        this.dialogSettings.buttons![1].action!(datiPeculiari)
      } else {
        //se richiamo la dialog dal servizio
        let servizio: Servizio = this.getServizio();
        this.errorNonCompilati = ""
        this.dialogSettings.buttons![1].action!(servizio)
      }
    } else {
      this.datiPeculiariForm.markAllAsTouched()
      this.errorNonCompilati = "Attenzione: compilare tutti i campi obbligatori"
    }

  }

  onAnnulla() {
    if (this.dialogSettings.buttons![0].action) {
      this.dialogSettings.buttons![0].action()
    }
  }

  getServizio(): Servizio {
    return {
      ...this.servizio,
      valoreDatoPeculiare1: this.datiPeculiariForm.get('datoPeculiare1')!.value!,
      valoreDatoPeculiare2: this.datiPeculiariForm.get('datoPeculiare2')!.value!,
      idPsoClasseDestinatario: this.datiPeculiariForm.get('idPsoClasseDestinatario')!.value! != -1 ? this.datiPeculiariForm.get('idPsoClasseDestinatario')!.value! : null,
      codCondizioneOccupazionaleIgrue: this.datiPeculiariForm.get("condizioneOccupazionale")!.value! ? this.datiPeculiariForm.get("condizioneOccupazionale")!.value! : undefined,
      codTitoloStudioIgrue: this.datiPeculiariForm.get("titoloDiStudio")!.value! ? this.datiPeculiariForm.get("titoloDiStudio")!.value! : undefined,
      flgDisabilita: this.datiPeculiariForm.get("disabilita")!.value!,
      flgSvantaggioAbitativo: this.datiPeculiariForm.get("svantaggioAbitativo")!.value!,
    }
  }

  getDatiPeculiari(): DatiPeculiari {
    return {
      destinatarioServizio: {
        idServizio: this.datiParticolari.destinatarioServizio?.idServizio,
        idEnteCoinvoltoServizio: Number(this.datiPeculiariForm.get("nomeEnte")!.value) ? Number(this.datiPeculiariForm.get("nomeEnte")!.value) : undefined,
        valoreDatoPeculiare1: this.datiPeculiariForm.get('datoPeculiare1')!.value!,
        valoreDatoPeculiare2: this.datiPeculiariForm.get('datoPeculiare2')!.value!,
        // se l'idPsoClasseDestinatario e' uguale a -1 significa che l'option scelta non e' un dato presente nella lista estratta da db
        // ma e' una stranga perche2 il dato peculiare 1, precedentemente, era stato inserito come stringa
        idPsoClasseDestinatario: this.datiPeculiariForm.get('idPsoClasseDestinatario')!.value! != -1 ? this.datiPeculiariForm.get('idPsoClasseDestinatario')!.value! : null,
        destinatario: {
          idDestinatario: this.destinatario.idDestinatario
        },
        codUserAggiorn: this.homeBag.userInfo!.codFisc!,
        dInserim: this.datiParticolari.destinatarioServizio?.dInserim,
        codUserInserim: this.datiParticolari.destinatarioServizio?.codUserInserim
      },
      destinatarioServizioMonitoraggio: {
        codCondizioneOccupazionaleIgrue: this.datiPeculiariForm.get("condizioneOccupazionale")!.value!,
        codTitoloStudioIgrue: this.datiPeculiariForm.get("titoloDiStudio")!.value!,
        flgDisabilita: this.datiPeculiariForm.get("disabilita")!.value!,
        flgSvantaggioAbitativo: this.datiPeculiariForm.get("svantaggioAbitativo")!.value!,
        codUserAggiorn: this.homeBag.userInfo!.codFisc!,
        codiceCitadinanza: this.destinatario.codCittadinanza!,
        dInserim: this.datiParticolari.destinatarioServizioMonitoraggio?.dInserim,
        codUserInserim: this.datiParticolari.destinatarioServizio?.codUserInserim
      }
    }
  }
  get isModificabile() {
    return this.serviziService.isModificabile;
  }
  get esisteElaborazioneInCorso() {
    return this.serviziService.esisteElaborazioneInCorso;
  }
}

/*(((flgDisabilita)::text = ANY ((ARRAY['S'::character varying, 'N'::character varying])::text[])))*/
