import {Injectable} from "@angular/core";


import {ContractAPIEpics} from "../contracts/api/epics";

@Injectable()
export class RootEpics {
  constructor(private contractEpics: ContractAPIEpics) {
  }

  public createEpics() {
    return [
      this.contractEpics.createEpic()
    ];
  }
}
