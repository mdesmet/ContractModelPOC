import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {ContractPageComponent} from "./page";
import {ContractModule} from "../contracts/module";
import {CoreModule} from "../core/module";
import {StoreModule} from "../store/module";


@NgModule({
  declarations: [ContractPageComponent],
  exports: [ContractPageComponent],
  imports: [CommonModule, ContractModule, CoreModule, StoreModule],
  providers: [],
})
export class ContractPageModule {
}
