import { createSelector } from 'reselect'
import { ActionReducer } from '@ngrx/store';
import * as fromRouter from '@ngrx/router-store';

import { compose } from '@ngrx/core/compose';

import { storeFreeze } from 'ngrx-store-freeze';

import { combineReducers } from '@ngrx/store';

import * as fromContracts from './contracts';
import { environment } from '../../../environments/environment';

export interface State {
  contracts: fromContracts.State;
  router: fromRouter.RouterState;
}

const reducers = {
  contracts: fromContracts.reducer,
  router: fromRouter.routerReducer,
};

const developmentReducer: ActionReducer<State> = compose(storeFreeze, combineReducers)(reducers);
const productionReducer: ActionReducer<State> = combineReducers(reducers);

export function reducer(state: any, action: any) {
  if (environment.production) {
    return productionReducer(state, action);
  } else {
    return developmentReducer(state, action);
  }
}

export const getContractsState = (state: State) => state.contracts;

export const getContractEntities = createSelector(getContractsState, fromContracts.getAll);
export const getSelectedContract = createSelector(getContractsState, fromContracts.getSelected);
