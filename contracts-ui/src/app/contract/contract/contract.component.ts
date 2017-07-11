import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Unsubscribable } from '../../shared/interfaces/unsubscribable';
import { Contract } from '../../shared/models/contract';
import * as fromRoot from '../../shared/reducers';
import * as contract from '../../shared/actions/contract';
import { Store } from '@ngrx/store';
import * as _ from 'lodash';
import { ContractsService } from '../../shared/services/contracts.service';


@Component({
  templateUrl: 'contract.component.html',
  styleUrls: ['contract.component.css']
})
export class ContractComponent extends Unsubscribable {

  contractView: Contract;
  contractEdit: Contract | null;
  viewMode: boolean = true;

  constructor(private _route: ActivatedRoute,
              private _store: Store<fromRoot.State>,
              private _contractsService: ContractsService) {
    super();
    _route.params
      .takeUntil(this._ngUnsubscribe$)
      .select<string>('id')
      .map(id => new contract.SelectAction(id))
      .subscribe(_store);
    _store.select(fromRoot.getSelectedContract)
      .takeUntil(this._ngUnsubscribe$)
      .subscribe((contract: Contract) => {
        this.contractView = _.cloneDeep(contract);
      });
  }

  cancelEdit() {
    this.viewMode = true;
    this.contractEdit = null;
  }

  submitEdit() {
    this._contractsService.updateContract(this.contractEdit);
    this.viewMode = true;
  }

  startEdit() {
    this.contractEdit = _.cloneDeep(this.contractView);
    this.viewMode = false;
  }

}
