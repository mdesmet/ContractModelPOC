import { Observable } from 'rxjs/Observable';
import * as fromRoot from '../reducers';
import * as contract from '../actions/contract';
import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router } from '@angular/router';
import { Store } from '@ngrx/store';
import { ContractsService } from '../services/contracts.service';
import { of } from 'rxjs/observable/of';

@Injectable()
export class ContractExistsGuard implements CanActivate {
  constructor(private store: Store<fromRoot.State>,
              private contractsService: ContractsService,
              private router: Router) {
  }

  hasContractInStore(id: string): Observable<boolean> {
    return this.store.select(fromRoot.getContractEntities)
      .map(entities => !!entities[id])
      .take(1);
  }

  hasContractInApi(id: string): Observable<boolean> {
    return this.contractsService.retrieveContract(id)
      .map(bookEntity => new contract.LoadAction(bookEntity))
      .do((action: contract.LoadAction) => this.store.dispatch(action))
      .map(contract => !!contract)
      .catch(() => {
        this.router.navigate(['/404']);
        return of(false);
      });
  }

  hasContract(id: string): Observable<boolean> {
    return this.hasContractInStore(id)
      .switchMap(inStore => {
        if (inStore) {
          return of(inStore);
        }

        return this.hasContractInApi(id);
      });
  }

  /**
   * This is the actual method the router will call when our guard is run.
   *
   * Our guard waits for the collection to load, then it checks if we need
   * to request a book from the API or if we already have it in our cache.
   * If it finds it in the cache or in the API, it returns an Observable
   * of `true` and the route is rendered successfully.
   *
   * If it was unable to find it in our cache or in the API, this guard
   * will return an Observable of `false`, causing the router to move
   * on to the next candidate route. In this case, it will move on
   * to the 404 page.
   */
  canActivate(route: ActivatedRouteSnapshot): Observable<boolean> {
    return this.hasContract(route.params['id']);
  }
}
