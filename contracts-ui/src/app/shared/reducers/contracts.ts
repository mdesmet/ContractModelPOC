import { createSelector } from 'reselect';
import { Contract } from '../models/contract';
import * as contract from '../actions/contract';
import 'rxjs/add/operator/filter';

export interface State {
  ids: number[];
  entities: { [id: number]: Contract };
  selectedContractId: string | null;
}

export const initialState: State = {
  ids: [],
  entities: {},
  selectedContractId: null,
};

export function reducer(state = initialState, action: contract.Actions): State {
  switch (action.type) {
    case contract.LOAD_ALL: {
      const contracts = action.payload;
      const newContracts = contracts.filter(contract => !state.entities[contract.id]);

      const newContractIds = newContracts.map(contract => contract.id);
      const newContractEntities = newContracts.reduce((entities: { [id: string]: Contract }, contract: Contract) => {
        return Object.assign(entities, {
          [contract.id]: contract
        });
      }, {});

      return {
        ids: [...state.ids, ...newContractIds],
        entities: Object.assign({}, state.entities, newContractEntities),
        selectedContractId: state.selectedContractId
      };
    }

    case contract.LOAD: {
      const contract = action.payload;

      if (state.ids.indexOf(contract.id) > -1) {
        return state;
      }

      return {
        ids: [...state.ids, contract.id],
        entities: Object.assign({}, state.entities, {
          [contract.id]: contract
        }),
        selectedContractId: state.selectedContractId
      };
    }

    case contract.SELECT: {
      return {
        ids: state.ids,
        entities: state.entities,
        selectedContractId: action.payload
      };
    }

    case contract.UPDATE: {
      const contract = action.payload;
      return {
        ids: state.ids,
        entities: Object.assign({}, state.entities, {
          [contract.id]: contract
        }),
        selectedContractId: state.selectedContractId
      };
    }

    default: {
      return state;
    }
  }
}

export const getEntities = (state: State) => state.entities;

export const getIds = (state: State) => state.ids;

export const getSelectedId = (state: State) => state.selectedContractId;

export const getSelected = createSelector(getEntities, getSelectedId, (entities, selectedId) => {
  return entities[selectedId];
});

export const getAll = createSelector(getEntities, getIds, (entities, ids) => {
  return ids.map(id => entities[id]);
});
