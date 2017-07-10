import {combineReducers} from "redux";
import {composeReducers, defaultFormReducer} from "@angular-redux/form";
import {routerReducer} from "@angular-redux/router";
import {contractReducer} from "../contracts/api/reducer";

export const rootReducer = composeReducers(
  defaultFormReducer(),
  combineReducers({
    contractState: contractReducer,
    routerState: routerReducer,
  }));
