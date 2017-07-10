import {Injectable} from "@angular/core";
import {createEpicMiddleware, Epic} from "redux-observable";
import {of} from "rxjs/observable/of";
import "rxjs/add/operator/catch";
import "rxjs/add/operator/map";
import "rxjs/add/operator/do";
import "rxjs/add/operator/startWith";

import {IAppState} from "../../store/model";
import {ContractAPIAction, ContractAPIActions} from "./actions";
import {ContractAPIService} from "./service";

type Predicate = (any) => boolean;

const actionIsForCorrectContractId = (id: string) =>
  (action: ContractAPIAction): boolean =>
  action.meta.id === id;

@Injectable()
export class ContractAPIEpics {
  constructor(private service: ContractAPIService,
              private actions: ContractAPIActions,) {
  }

  public createEpic() {
    return createEpicMiddleware(this.createLoadContractEpic());
  }

  private createLoadContractEpic(): Epic<ContractAPIAction, IAppState> {
    return (action$, store) => action$
      .ofType(ContractAPIActions.LOAD_CONTRACT)
      .switchMap(
        action => this.service.getContract(action.meta.id)
          .map(contract => this.actions.loadContractCompleted(action.meta.id, contract))
          .catch(response => of(this.actions.loadContractError(action.meta.id, {
            status: '' + response.status,
          })))
      );
  }

}
