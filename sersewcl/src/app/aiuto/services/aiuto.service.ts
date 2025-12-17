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
import { BreadcrumbService } from '@core/services/breadcrumb.service';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AiutoService {


  subject = new BehaviorSubject(1);

  constructor(
    private breadCrumbService: BreadcrumbService,
  ) { }

  /**
   * intervento   Servizio
   * 0- Ricerca    =
   * 1- Crea       =
   * 2- assoc M     targ/car
   * 3- corr        enti
   * 4- enti        peculiari
   * 5- dest.int    dest
   * 6- assoc s     prev/finan
   * 7- attiv       chius
   * 8- chius       elim
   * 9- elim        mod
   * 10- mod        dupp
   * 11- dupp       exel
   * 12- exel
   */
  private _modelloKeysWorlds = [
    ["ricerc", "cerc"] ,//-0
    ["cre","inseri"] ,//-1
    ["correlat"] ,//-2
    ["target", "destinatar","caratteristic"] ,//-3
    ["ent"] ,//-4
    ["tipologi", "serviz"] ,//-5
    ["pubblic"] ,//-6
    ["chiu"] ,//-7
    ["elimin"] ,//-8
    ["modific"] ,//-9
    ["dupplic"] ,//-10
    ["excel", "scaric", "download"] ,//-11
  ];
  private _interventoKeysWorlds = [
    ["ricerc", "cerc"] ,//-0
    ["cre","inseri"] ,//-1
    ["modello"] ,//-2 caso difficile???
    ["correlat"] ,//-3
    ["ent"] ,//-4
    ["destinatar"] ,//-5
    ["serviz"] ,//-6 caso difficile???
    ["attiv"] ,//-7
    ["chiu"] ,//-8
    ["elimin"] ,//-9
    ["modific"] ,//-10
    ["dupplic"] ,//-11
    ["excel", "scaric", "download"] ,//-12
  ];
  private _servizioKeysWorlds = [
    ["ricerc", "cerc"] ,//-0
    ["cre","inseri"] ,//-1
    ["target", "caratteristic"] ,//-2
    ["ent"] ,//-3
    ["peculiar"] ,//-4
    ["destinatar"] ,//-5
    ["calcol", "peventivo", "richie", "finanzi"] ,//-6
    ["chiu"] ,//-7
    ["elimin"] ,//-8
    ["modific"] ,//-9
    ["dupplic"] ,//-10
    ["excel", "scaric", "download"] ,//-11
    ["inc","incontr", "contr"], //-12
    ["luo","luogo"],//-13
  ];
  private _incontroKeysWorlds = [
    ["ricerc", "cerc"] ,//-0
    ["cre","inseri"] ,//-1
    ["chiu"] ,//-7
    ["elimin"] ,//-8
    ["modific"] ,//-9


  ];

  private _caricamentoKeyWorlds=[
    ["caric","caricamento","file","excel","import"]

  ]
  keysWords: { [key: string]: string[][] } =
  { 'modello': this._modelloKeysWorlds,
    'intervento': this._interventoKeysWorlds,
    'servizio': this._servizioKeysWorlds,
    'caricamento': this._caricamentoKeyWorlds
    // 'incontro': this._modelloKeysWorlds
  };



  indexDocByLastUrl(): number {
    let lasturl = this.breadCrumbService.lastUrl;
    return this.indexDocView(lasturl);
  }
  indexDocView(sentence:string): number {
    //- intervento e servizio nella stessa frase  [-OK-]
    //-- OK perché controlla prima se è presente intervento



    if((sentence.includes("file") || sentence.includes("caricam")) && !sentence.includes("scarica")){
      return 4;
    }
    const regex = /modell[oi](?:\s+(di\s+)?intervent[oi])?/i;
    if (regex.test(sentence)) {
      return 0;
    }
    //- intervento e modello di intervento nella stessa frase
    if (/\bmodell\b/i.test(sentence) && /\bintervent\b/i.test(sentence)) {
      return 1;
    }

    if(sentence.includes("intervent")){
      //-quindi qua va un controllo approfondito su dove deve andare

      return 1;
    }else if(sentence.includes("serv") || sentence.includes("incontr")){
      return 2;
    }
    else if(sentence.includes("incontr")){
      return 3;
    }
    return 0;
  }


  onSearch(domanda:string): {doc:number, responce:number}{
    domanda = domanda.toLowerCase();

    let indexDoc = this.indexDocView(domanda);
    let indexOfResponce = -1;

    let valueMap: string[][];

    switch(indexDoc){
      case 1: //-intervento
        valueMap = this.keysWords['intervento'];
      break;

      case 2: //-servizio
        valueMap = this.keysWords['servizio'];
      break;

      case 3: //-incontro?
        valueMap = this.keysWords['incontro'];
      break;

      case 4: //-caricamento?
        valueMap = this.keysWords['caricamento'];
      break;

      default: //-Modello == case 0:
        valueMap = this.keysWords['modello'];
      break;
    }
    indexOfResponce = this.searchOnKeysWords(domanda, valueMap);
    return {doc:indexDoc, responce:indexOfResponce};
  }

  private searchOnKeysWords(domanda:string, valueMap:string[][]){
    let found = false;
    let index = -1;
    for (let i = 0; i < valueMap.length && !found; i++) {
      for(const world of valueMap[i]){
        if(domanda.includes(world)){
          found = true;
          break;
        }
      }
      if(found){
        index = i;
      }
    }
    return index;
  }



}
