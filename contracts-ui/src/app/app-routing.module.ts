import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forRoot([
      {path: '', redirectTo: '/contract-list', pathMatch: 'full'},
    ], {useHash: true})
  ],
  exports: [RouterModule],
  schemas: []
})
export class AppRoutingModule {
}

