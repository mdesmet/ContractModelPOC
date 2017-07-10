import {ChangeDetectionStrategy, Component, Input} from "@angular/core";
import {select$} from "@angular-redux/store";
import {Observable} from "rxjs/Observable";

import {pipe, prop, sortBy, values} from "ramda";
import {IContractState, ITarget} from "../model";

export const sortTargets = (targetDictionary$: Observable<{}>) =>
  targetDictionary$.map(
    pipe(
      values,
      sortBy(prop('name'))));

@Component({
  selector: 'contract-container',
  templateUrl: './component.html',
  styleUrls: ['./component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ContractContainerComponent {
  @Input()
  contract: Observable<IContractState>;
  @Input()
  loading: Observable<boolean>;
  @Input()
  error: Observable<any>;

  @select$(['contractState', 'contract', 'targets', 'items'], sortTargets)
  readonly targets$:Observable<ITarget[]>;
}
