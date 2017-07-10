import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";

import {CoreModule} from "../core/module";
import {ContractAPIActions} from "./api/actions";
import {ContractAPIService} from "./api/service";
import {StoreModule} from "../store/module";
import {ContractAPIEpics} from "./api/epics";
import {ContractHeaderComponent} from "./contract-header/component";
import {ContractContainerComponent} from "./contract-container/component";
import {TargetListComponent} from "./target-list/component";
import {TargetComponent} from "./target/component";


@NgModule({
  declarations: [ContractContainerComponent, ContractHeaderComponent, TargetListComponent, TargetComponent],
  exports: [ContractContainerComponent, ContractHeaderComponent, TargetListComponent, TargetComponent],
  imports: [CoreModule, StoreModule, CommonModule],
  providers: [ContractAPIActions, ContractAPIService, ContractAPIEpics],
})
export class ContractModule {
}
