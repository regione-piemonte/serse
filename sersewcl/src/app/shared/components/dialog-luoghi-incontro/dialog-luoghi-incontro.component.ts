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
import { FormBuilder, Validators } from '@angular/forms';
import { MatDialog, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ComuneRistretto } from '@core/api-serse/model/comuneRistretto';
import { LuogoIncontro } from '@core/api-serse/model/luogoIncontro';
import { Bacino, Comune, Provincia } from '@core/api-serse/model/models';
import { ProvinciaRistretto } from '@core/api-serse/model/provinciaRistretto';
import { InfoComuniService } from '@core/services/info-comuni.service';
import { DialogButton, DialogSettings } from '@shared/model/dialog-settings.model';
import { catchError } from 'rxjs';
import { LuoghiService } from 'src/app/incontri/services/luoghi.service';
import { DialogConfermaComponent } from '../dialog-conferma/dialog-conferma.component';
import { HomeBagService } from '@home/services/home-bag.service';

@Component({
  selector: 'app-dialog-luoghi-incontro',
  templateUrl: './dialog-luoghi-incontro.component.html',
  styleUrls: ['./dialog-luoghi-incontro.component.scss']
})
export class DialogLuoghiIncontroComponent implements OnInit {
  provinciaList: ProvinciaRistretto[] = [];
  comuniList: Comune[] = [];
  baciniList: Bacino[]=[]
  luogIncontro?: LuogoIncontro;
  selectionFrom:string="";
  idProvenienza:number|null=null;
  isModificabile=true;
  constructor(

    private fb:FormBuilder,
    private homeBag:HomeBagService,
    private infoComuni: InfoComuniService,
    private luoghiService:LuoghiService,
    private dialog: MatDialog,

    @Inject(MAT_DIALOG_DATA) public data: DialogSettings,

  ) { }

  formLuogo=this.fb.group({

    provincia:['',Validators.required],
    bacino:[''],
    comune:['',Validators.required],
    indirizzo:['',Validators.required],
    presso:['',Validators.required],
    note:[''],
  })
  ngOnInit(): void {
    this.fetchProvincia();
    //this.selectionFrom=this.data.data![1]


    //this.isModificabile=this.data.data![3]



    if(this.data.data && this.data.data[0]){

      this.luogIncontro=this.data.data[0]
      this.selectionFrom=this.data.data[1]
      this.idProvenienza=this.data.data[2]
      this.isModificabile=this.data.data![3]
      if(this.data.data[0].fullComune){
      this.formLuogo.get("provincia")?.setValue(this.data.data[0].fullComune?.provincia?.codiceProvincia!);

      if(this.data.data[0].fullComune?.bacino){
        this.baciniList=[this.data.data[0].fullComune?.bacino!];
        this.formLuogo.get("bacino")?.setValue(this.data.data[0].fullComune?.bacino?.codBacino!);

      }
      this.comuniList=[this.data.data[0].fullComune!];
      this.formLuogo.get("comune")?.setValue(this.data.data[0].fullComune?.codiceIstatComune!);
      this.formLuogo.get("indirizzo")?.setValue(this.data.data[0].indirizzo!)
      if(this.data.data[0].denominazione!){
        this.formLuogo.get("presso")?.setValue(this.data.data[0].denominazione!)
      }else{
        this.formLuogo.get("presso")?.setValue(this.data.data[0].nome!)
      }

    }else{
      this.formLuogo.get("provincia")?.setValue(this.data.data[0].comuneIncontro?.provincia?.codiceProvincia);
      this.formLuogo.get("bacino")?.setValue(this.data.data[0].comuneIncontro?.bacino.codBacino);
      this.baciniList=[this.data.data[0].comuneIncontro?.bacino];
      this.formLuogo.get("comune")?.setValue(this.data.data[0].comuneIncontro?.codiceIstatComune);
      this.comuniList=[this.data.data[0].comuneIncontro];
      this.formLuogo.get("presso")?.setValue(this.data.data[0].denominazioneLuogo)

      this.formLuogo.get("indirizzo")?.setValue(this.data.data[0].indirizzoLuogo)

    }
    this.formLuogo.get("provincia")?.disable();
    this.formLuogo.get("bacino")?.disable();
    this.formLuogo.get("comune")?.disable();
    this.formLuogo.get("presso")?.disable()

    this.formLuogo.get("indirizzo")?.disable();

    this.formLuogo.get("note")?.setValue(this.data.data[0].note!)

      if(this.data.data[3]==false){
        this.formLuogo.get("presso")?.disable();
        this.formLuogo.get("note")?.disable();
      }
    }

  }

  fetchProvincia() {
    this.infoComuni.getProvincePiemonte()
      .subscribe((risposta) => (this.provinciaList = risposta));
  }


  onSelectedProvincia() {
    this.luoghiService.getBaciniProvinca(this.formLuogo.get('provincia')?.value!).subscribe({
      next: ris=>{
        this.baciniList=ris
      }
    })



  }

  onSelectedBacino(){
    if(this.formLuogo.get('bacino')?.value!){
      this.luoghiService.getcomuniBacino(this.formLuogo.get('bacino')?.value!).subscribe({
        next:ris=>{
          this.comuniList=ris
        }
      })
    }
  }

  onSalva(){
    this.formLuogo.markAllAsTouched()
    if(this.formLuogo.valid){
      let luogo:LuogoIncontro=this.createLuogo();


      this.data.buttons![0].action!(luogo)

    }else{
      this.openAttentionDialog(["dati obbligatori mancanti"])
      return
    }
  }

  createLuogo():LuogoIncontro{
    return {

      idLuogoIncontro:this.data.data![0] ? this.data.data![0].idLuogoIncontro : 0,
      indirizzoLuogo:  this.formLuogo.get("indirizzo")?.value!,
      note: this.formLuogo.get("note")?.value!,
      comuneIncontro: {
          ...this.luogIncontro?.comuneIncontro,
          codiceIstatComune: this.formLuogo.get("comune")?.value!,
          provincia:{
            ...this.luogIncontro?.comuneIncontro?.provincia,
            codiceProvincia:this.formLuogo.get('provincia')?.value!
          },
          bacino:{
            ...this.luogIncontro?.comuneIncontro?.bacino,
            codBacino:Number(this.formLuogo.get('bacino')?.value!)
          }
      },
      denominazioneLuogo:this.formLuogo.get('presso')?.value!,
      provenienzaLuogo:{
        idProvenienzaLuogo:this.idProvenienza ? this.idProvenienza: undefined
      },
      codUserInserim:this.homeBag.userInfo.codFisc,
      codUserAggiorn:this.homeBag.userInfo.codFisc,
      dInserim:this.luogIncontro?.dInserim
    }
  }
  openAttentionDialog(msg:string[], buttons?:DialogButton[]){
    this.openDialog("Attenzione!",msg,"card-body--warning", buttons)
  }
  openDialog(title:string, msg:string[],cssClass:string,buttons?:DialogButton[]){
    this.dialog.open(DialogConfermaComponent,{
      data: new DialogSettings(title, msg, cssClass, "", buttons)
    })
  }
}
