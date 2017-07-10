import {ChangeDetectionStrategy, Component, Input} from "@angular/core";
import {Observable} from "rxjs/Observable";

@Component({
  selector: 'gsm-error-well',
  templateUrl: './component.html',
  styleUrls: ['./component.css'],
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class ErrorWellComponent {
  @Input() statusCode$: Observable<number>;
}
