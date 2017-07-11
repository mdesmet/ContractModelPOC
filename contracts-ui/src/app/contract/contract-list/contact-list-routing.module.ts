import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ContractListComponent } from './contract-list.component';

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: 'contract-list', component: ContractListComponent }
    ])
  ],
  exports: [RouterModule]
})
export class ContractListRoutingModule { }
