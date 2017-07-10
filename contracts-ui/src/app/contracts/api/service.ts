import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/observable/of';

import {fromServer, IContract} from '../model';

@Injectable()
export class ContractAPIService {
  constructor(private http: Http) {
  }

  getContract = (id: string): Observable<IContract> => {
    // this.http.get(API_URL)
    //   .map(resp => resp.json())
    //   .map(record => record.map(fromServer));
    return Observable.of({
      id: 1,
      contractHeader: {
        name: "Contract 1",
        startDate: new Date("January 1, 2016 00:00:00"),
        endDate: new Date("December 31, 2016 00:00:00"),
        pointOfSales: [
          {
            name: "Belgium",
            code: "BE"
          },
          {
            name: "France",
            code: "FR"
          }
        ]
      },
      targets: [
        {
          name: "Target 1",
          payments: [
            {
              name: "Belgium payment",
            }
          ]
        },
        {
          name: "Target 2",
          payments: []
        }
      ]
    }).map(fromServer);
  }

}
