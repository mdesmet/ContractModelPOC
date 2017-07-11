import { Action } from '@ngrx/store';
import { Contract } from '../models/contract';

export const LOAD_ALL = '[Book] Load all';
export const LOAD = '[Book] Load';
export const SELECT = '[Book] Select';
export const UPDATE = '[Book] Update';

export class LoadAllAction implements Action {
  readonly type = LOAD_ALL;

  constructor(public payload: Contract[]) {
  }
}

export class LoadAction implements Action {
  readonly type = LOAD;

  constructor(public payload: Contract) {
  }
}

export class SelectAction implements Action {
  readonly type = SELECT;

  constructor(public payload: string) {
  }
}

export class UpdateAction implements Action {
  readonly type = UPDATE;

  constructor(public payload: Contract) {
  }
}

/**
 * Export a type alias of all actions in this action group
 * so that reducers can easily compose action types
 */
export type Actions
  = LoadAllAction
  | LoadAction
  | SelectAction
  | UpdateAction;
