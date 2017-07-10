import {BrowserModule} from "@angular/platform-browser";
import {NgModule} from "@angular/core";
import {FormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import {HttpModule} from "@angular/http";
import {NgReduxModule} from "@angular-redux/store";
import {NgReduxRouterModule} from "@angular-redux/router";

import {AppComponent} from "./app.component";
import {appRoutes} from "./routes";
import {ContractPageModule} from "./contract-page/module";
import {CoreModule} from "./core/module";
import {ContractModule} from "./contracts/module";
import {StoreModule} from "./store/module";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    FormsModule,
    HttpModule,
    NgReduxModule,
    NgReduxRouterModule,
    CoreModule,
    ContractPageModule,
    ContractModule,
    StoreModule
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
