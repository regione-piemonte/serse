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

import { Injectable } from '@angular/core';
import { Ruolo } from '@core/api-serse/model/ruolo';

// Models
import { UserInfo } from '@core/api-serse/model/userInfo';
import { InfoOperatore } from '@core/api-serse/model/infoOperatore';
import { TipologiaPso } from '@core/api-serse/model/tipologiaPso';


// Compare
import { TipoGestioneSportello } from '@core/api-serse/model/tipoGestioneSportello';
import { Sportello } from '@core/api-serse/model/sportello';
import { PsoRistretto } from '@core/api-serse/model/psoRistretto';

@Injectable({
  providedIn: 'root'
})
export class HomeBagService {


  // private _op:InfoOperatore[]=[];
  private _userInfo: UserInfo={};

  private _selectedRuolo: Ruolo = {};
  private _selectedInfoOpratore: InfoOperatore = {};

  private _codiceOperatore :string = '';
  private _gruppoOperatore :string = '';
  private _descriOperatore :string = '';
  //MDI= modello di intervento
  //INT= intervento
  //SER= servizio
  private _userCase:string='';

  private _selectedTPSO: TipologiaPso = {};
  private _selectedPso: PsoRistretto = {};
  private _selectedSportello: Sportello = {};

  private _tipologiaGestioneSportello : TipoGestioneSportello = {};



  constructor() {}

  //##############################################
  //##############################################
  setUserInfo(userInfo: UserInfo){
    this._userInfo = userInfo;
    localStorage.setItem("userInfo",JSON.stringify(userInfo))
  }
  setSelectedRuolo( ruolo : Ruolo){
    this._selectedRuolo = ruolo;
    localStorage.setItem("ruolo",JSON.stringify(ruolo));
  }
  setSelectedInfoOperatore( infoOperatore : InfoOperatore){
    // this._selectedInfoOpratore = infoOperatore;
    localStorage.setItem("infoOperatore", JSON.stringify(infoOperatore));
    this._codiceOperatore = infoOperatore.codOperatore
                            ?infoOperatore.codOperatore.toString()
                            :'';
    localStorage.setItem("codiceOperatore",infoOperatore.codOperatore!.toString());
    this._gruppoOperatore = infoOperatore.gruppoOperatore
                            ?infoOperatore.gruppoOperatore
                            :'';
    localStorage.setItem("gruppoOperatore",infoOperatore.gruppoOperatore!.toString())
    this._descriOperatore = infoOperatore.descrOperatore
                            ?infoOperatore.descrOperatore
                            :'';
    localStorage.setItem("descriOperatore",infoOperatore.descrOperatore!.toString())
  }
  setInfoOperatore(codiceOperatore: string , gruppoOperatore:string, descriOperatore?:string){
    let infoOperatore:InfoOperatore={
      codOperatore:+codiceOperatore,
      gruppoOperatore:gruppoOperatore,
      descrOperatore:descriOperatore,
      codDbOperatore:+codiceOperatore,
    }
    localStorage.setItem("infoOperatore", JSON.stringify(infoOperatore));
    this._codiceOperatore = codiceOperatore;
    this._gruppoOperatore = gruppoOperatore;
    this._descriOperatore = this._gruppoOperatore + this._codiceOperatore + " - "
                            + (descriOperatore
                                  ?descriOperatore
                                  :'');
    localStorage.setItem("descriOperatore",this._descriOperatore);
    localStorage.setItem("gruppoOperatore",this._gruppoOperatore);
    localStorage.setItem("codiceOperatore",this._codiceOperatore);
  }

  get userInfo():UserInfo{
    return JSON.parse(localStorage.getItem("userInfo")!);
     //this._userInfo;
  }
  get selectedRuolo():Ruolo{
    return JSON.parse(localStorage.getItem("ruolo")!)
    //return this._selectedRuolo;
  }
  get selectedOperatore():InfoOperatore{
    return JSON.parse(localStorage.getItem("infoOperatore")!)
    //return this._selectedInfoOpratore;
  }
  get codiceOperatore():string{
    return localStorage.getItem("codiceOperatore")!
    //return this._codiceOperatore;
  }
  get gruppoOperatore():string{
    return localStorage.getItem("gruppoOperatore")!
    //return this._gruppoOperatore;
  }
  get descriOperatore(){
    return localStorage.getItem("descriOperatore")
    //return this._descriOperatore;
  }

  //##############################################
  //##############################################
  setSelectedTipologiaPSO(tipologiaPso:TipologiaPso ){
    this._selectedTPSO = tipologiaPso;
    localStorage.setItem("selectedTipologiaPso",JSON.stringify(tipologiaPso));
  }
  setSelectedPso(pso:PsoRistretto ){
    this._selectedPso = pso;
    localStorage.setItem("selectedPso",JSON.stringify(pso));
  }
  setSelectedSportello(sportello:Sportello ){
    this._selectedSportello = sportello;
    localStorage.setItem("selectedSportello",JSON.stringify(sportello))
  }

  get selectedTipologiaPSO(): TipologiaPso{
    return JSON.parse(localStorage.getItem("selectedTipologiaPso")!)
    //return this._selectedTPSO;
  }
  get selectedPso(): PsoRistretto{
    return JSON.parse(localStorage.getItem("selectedPso")!)
    //return this._selectedPso;
  }
  get selectedSportello(): Sportello{
    return JSON.parse(localStorage.getItem("selectedSportello")!)
   // return this._selectedSportello;
  }

  setTipologiaGestioneSportello(tipologia: TipoGestioneSportello){
    this._tipologiaGestioneSportello = tipologia;
    localStorage.setItem("tipologiaGestioneSportello",JSON.stringify(tipologia))
  }
  get gestioneSportello():TipoGestioneSportello{
    return JSON.parse(localStorage.getItem("tipologiaGestioneSportello")!)
    //return this._tipologiaGestioneSportello;
  }

  set userCase(userCase:string){
    this._userCase=userCase;
  }

  get userCase(){
    return this._userCase
  }

}
