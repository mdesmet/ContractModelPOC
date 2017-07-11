import 'hammerjs';

import 'rxjs/add/operator/scan';
import 'rxjs/add/operator/takeUntil';
import 'rxjs/add/operator/take';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/do';
import 'rxjs/add/operator/catch';
import '@ngrx/core/add/operator/select';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/operator/switchMap';
import 'rxjs/add/operator/combineLatest';
import 'rxjs/add/operator/withLatestFrom';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { AppRoutingModule } from './app-routing.module';
import { SharedModule } from './shared/shared.module';
import { ContractsModule } from './contract/contracts.module';
import { MaterialModule } from '@angular/material';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    AppRoutingModule,
    ContractsModule,
    MaterialModule,
    // CoreModule,
    // ContractPageModule,
    // MyContractModule,
    // StoreModule,
    SharedModule.forRoot()
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
