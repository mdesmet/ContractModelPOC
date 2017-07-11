import { DataSource } from '@angular/cdk';
import { Store } from '@ngrx/store';

import * as fromRoot from '../../shared/reducers';
import { Observable } from 'rxjs/Observable';
import { Contract } from '../../shared/models/contract';

export class ContractListDataSource extends DataSource<Contract> {
  constructor(private _store: Store<fromRoot.State>) {
    super();
  }

  /** Connect function called by the table to retrieve one stream containing the data to render. */
  connect(): Observable<Contract[]> {
    return this._store.select(fromRoot.getContractEntities);
  }

  disconnect() {}
}
