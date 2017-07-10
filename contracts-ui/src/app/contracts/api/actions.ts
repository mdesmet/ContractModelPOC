import {Injectable} from "@angular/core";
import {dispatch} from "@angular-redux/store";
import {FluxStandardAction} from "flux-standard-action";
import {IContract} from "../model";

// Flux-standard-action gives us stronger typing of our actions.
type Payload = IContract;

interface MetaData {
  id: string
}
;

export type ContractAPIAction = FluxStandardAction<Payload, MetaData>;

@Injectable()
export class ContractAPIActions {
  static readonly LOAD_CONTRACT = 'LOAD_CONTRACT';
  static readonly LOAD_CONTRACT_COMPLETED = 'LOAD_CONTRACT_COMPLETED';
  static readonly LOAD_CONTRACT_ERROR = 'LOAD_CONTRACT_ERROR';

  static readonly CREATE_CONTRACT = 'CREATE_CONTRACT';
  static readonly CREATE_CONTRACT_COMPLETED = 'CREATE_CONTRACT_COMPLETED';
  static readonly CREATE_CONTRACT_ERROR = 'CREATE_CONTRACT_ERROR';

  static readonly UPDATE_CONTRACT = 'UPDATE_CONTRACT';
  static readonly UPDATE_CONTRACT_COMPLETED = 'UPDATE_CONTRACT_COMPLETED';
  static readonly UPDATE_CONTRACT_ERROR = 'UPDATE_CONTRACT_ERROR';

  static readonly DELETE_CONTRACT = 'DELETE_CONTRACT';
  static readonly DELETE_CONTRACT_COMPLETED = 'DELETE_CONTRACT_COMPLETED';
  static readonly DELETE_CONTRACT_ERROR = 'DELETE_CONTRACT_ERROR';

  @dispatch()
  loadContract = (id: string): ContractAPIAction => ({
    type: ContractAPIActions.LOAD_CONTRACT,
    meta: {id},
    payload: null,
  });

  loadContractCompleted = (id: string, payload: Payload): ContractAPIAction => ({
    type: ContractAPIActions.LOAD_CONTRACT_COMPLETED,
    meta: {id},
    payload,
  });

  loadContractError = (id: string, error): ContractAPIAction => ({
    type: ContractAPIActions.LOAD_CONTRACT_ERROR,
    meta: {id},
    payload: null,
    error,
  });
}
