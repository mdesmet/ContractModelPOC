import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ContractComponent } from './contract.component';
import { ContractExistsGuard } from '../../shared/guards/contract-exists';

@NgModule({
  imports: [
    RouterModule.forChild([
      { path: 'contract/:id', component: ContractComponent, canActivate: [ContractExistsGuard] }
    ])
  ],
  exports: [RouterModule]
})
export class ContractRoutingModule { }
