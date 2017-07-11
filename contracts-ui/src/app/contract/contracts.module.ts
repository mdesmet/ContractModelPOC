import { NgModule } from '@angular/core';
import { ContractListModule } from './contract-list/contract-list.module';
import { ContractModule } from './contract/contract.module';


@NgModule({
  imports: [
    ContractListModule,
    ContractModule
  ]
})

export class ContractsModule {
}
