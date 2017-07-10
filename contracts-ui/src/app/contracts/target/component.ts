import {ChangeDetectionStrategy, Component, Input} from "@angular/core";
import {select, WithSubStore} from "@angular-redux/store";
import {Observable} from "rxjs/Observable";

import {targetComponentReducer} from "./reducers";


@WithSubStore({
  basePathMethodName: 'getBasePath',
  localReducer: targetComponentReducer,
})
@Component({
  selector: 'target',
  templateUrl: './component.html',
  styleUrls: ['./component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TargetComponent {

  @Input()
  key: string;

  @select()
  readonly name$: Observable<string>;

  @select(state => state.payments.filter(payment => payment.name === 'Belgium payment').pop().name)
  readonly test$: Observable<string>;


  getBasePath = () => this.key ?
    [ 'contractState', 'contract', 'targets', 'items', this.key ] :
    null;
}
