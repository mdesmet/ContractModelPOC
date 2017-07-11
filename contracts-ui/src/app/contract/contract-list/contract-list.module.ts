import { NgModule } from '@angular/core';
import { SharedModule } from '../../shared/shared.module';
import { ContractListRoutingModule } from './contact-list-routing.module';
import { ContractListComponent } from './contract-list.component';
import { CdkTableModule } from '@angular/cdk';


@NgModule({
  imports: [SharedModule, ContractListRoutingModule],
  declarations: [ContractListComponent],
  exports: [ContractListComponent, CdkTableModule],
  providers: []
})
export class ContractListModule {
}
