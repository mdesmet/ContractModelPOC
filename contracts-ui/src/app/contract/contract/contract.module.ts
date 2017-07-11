import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ContractRoutingModule } from './contract-routing.module';
import { ContractComponent } from './contract.component';


@NgModule({
  imports: [SharedModule, ContractRoutingModule],
  declarations: [ContractComponent],
  exports: [ContractComponent],
  providers: [],
})
export class ContractModule {
}
