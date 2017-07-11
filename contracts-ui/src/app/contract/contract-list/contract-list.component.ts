import { ChangeDetectionStrategy, ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { ContractsService } from '../../shared/services/contracts.service';
import * as contract from '../../shared/actions/contract';
import { Store } from '@ngrx/store';

import * as fromRoot from '../../shared/reducers';
import { ContractListDataSource } from './contract-list.data-source';
import { Router } from '@angular/router';

export type UserProperties = 'contractId' | 'description' | 'systemName' | 'currencyCode' | 'action' | undefined;

@Component({
  templateUrl: './contract-list.component.html',
  styleUrls: ['contract-list.component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ContractListComponent implements OnInit {

  displayedColumns: UserProperties[] = [];
  dataSource: ContractListDataSource | null;

  constructor(private _contractService: ContractsService,
              private _store: Store<fromRoot.State>,
              private _changeDetector: ChangeDetectorRef,
              private _router: Router) {
  }

  ngOnInit(): void {
    this.displayedColumns = ['contractId', 'description', 'systemName', 'currencyCode', 'action'];
    this.dataSource = new ContractListDataSource(this._store);
    this._contractService.retrieveContracts()
      .take(1)
      .map(contracts => new contract.LoadAllAction(contracts))
      .subscribe((action: contract.LoadAllAction) => this._store.dispatch(action));
    // temporary fix for current bug with ng2 material
    setTimeout(() => {
      this._changeDetector.detectChanges();
    }, 1)
  }

  gotoContract(contractId: number) {
    this._router.navigate(['/contract', contractId]);
  }
}
