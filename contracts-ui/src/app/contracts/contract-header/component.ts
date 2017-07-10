import {ChangeDetectionStrategy, Component} from "@angular/core";
import {select} from "@angular-redux/store";
import {Observable} from "rxjs/Observable";
import {ICountry} from "../model";


@Component({
  selector: 'contract-header',
  templateUrl: './component.html',
  styleUrls: ['./component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ContractHeaderComponent {

  @select(['contractState', 'contract', 'id'])
  readonly id$: Observable<string>;

  @select(['contractState', 'contract', 'contractHeader', 'pointOfSales'])
  readonly pointOfSales$: Observable<ICountry[]>;

  @select(['contractState', 'contract', 'contractHeader', 'name'])
  readonly name$: Observable<string>;
}
