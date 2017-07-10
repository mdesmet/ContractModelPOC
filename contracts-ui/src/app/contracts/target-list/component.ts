import {Component, Input, ChangeDetectionStrategy} from '@angular/core';
import {NgRedux, dispatch, select, select$, WithSubStore} from '@angular-redux/store';
import {Observable} from 'rxjs/Observable';

import {IAppState} from '../../store/model';
import {IContract, IContractHeader, IContractState, ITarget} from '../model';


@Component({
  selector: 'target-list',
  templateUrl: './component.html',
  styleUrls: ['./component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class TargetListComponent {
  @Input()
  targets: Observable<ITarget[]>;

  getKey(_, target: ITarget) {
    return target.name;
  }
}
