import {ChangeDetectionStrategy, Component, OnDestroy, OnInit} from "@angular/core";
import {ActivatedRoute} from "@angular/router";
import {ContractAPIActions} from "../contracts/api/actions";
import {Observable} from "rxjs/Observable";
import {IContract} from "../contracts/model";
import {select} from "@angular-redux/store/lib/src";


@Component({
  templateUrl: './page.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ContractPageComponent implements OnInit, OnDestroy {
  private id: string;
  private sub: any;

  @select(['contractState', 'contract'])
  readonly contract$: Observable<IContract>;

  @select(['contractState', 'loading'])
  readonly loading$: Observable<boolean>;

  @select(['contractState', 'error'])
  readonly error$: Observable<any>;

  constructor(private route: ActivatedRoute, private actions: ContractAPIActions) {
  }

  ngOnDestroy(): void {
    this.sub.unsubscribe();
  }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.id = params['id'];
      this.actions.loadContract(this.id);
    });
  }

}
