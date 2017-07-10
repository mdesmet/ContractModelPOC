import {ContractPageComponent} from "./contract-page/page";

export const appRoutes = [
  {path: '', redirectTo: '/contract/create', pathMatch: 'full'},
  {path: 'contract/create', component: ContractPageComponent},
  {path: 'contract/:id', component: ContractPageComponent},
];
