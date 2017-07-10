import {ContractAPIAction, ContractAPIActions} from "./actions";
import {IContract, IContractState} from "../model";

const INITIAL_STATE: IContractState = {
  contract: null,
  loading: false,
  error: null,
};

export function contractReducer(state: IContractState = INITIAL_STATE,
                                action: ContractAPIAction): IContractState {

  switch (action.type) {
    case ContractAPIActions.LOAD_CONTRACT:
      return {
        ...state,
        contract: null,
        loading: true,
        error: null,
      };
    case ContractAPIActions.LOAD_CONTRACT_COMPLETED:
      return {
        ...state,
        contract: action.payload,
        loading: false,
        error: null,
      };
    case ContractAPIActions.LOAD_CONTRACT_ERROR:
      return {
        ...state,
        contract: null,
        loading: false,
        error: action.error,
      };
  }

  return state;
}
