import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { Contract } from '../models/contract';
import { CONTRACT1 } from './contract-data';
import { of } from 'rxjs/observable/of';
import * as contract from '../../shared/actions/contract';
import * as fromRoot from '../../shared/reducers';
import { Store } from '@ngrx/store';

@Injectable()
export class ContractsService {

  private _updatedContract: Contract;

  constructor(private _store: Store<fromRoot.State>) {
  }

  retrieveContract(id: string): Observable<Contract> {
    if (this._updatedContract) {
      return of(this._updatedContract);
    }
    return of(JSON.parse(CONTRACT1));
  }

  retrieveContracts(): Observable<Contract[]> {
    if (this._updatedContract) {
      return of([this._updatedContract]);
    }
    return of([JSON.parse(CONTRACT1)]);
  }

  updateContract(updatedContract: Contract) {
    this._updatedContract = updatedContract;
    this._store.dispatch(new contract.UpdateAction(updatedContract))
  }

}
