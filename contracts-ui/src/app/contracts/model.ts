import { indexBy, prop } from 'ramda';

export interface IContract {
  id: string;
  contractHeader: IContractHeader,
  targets: ITargetList
}

export interface IContractHeader {
  name: string;
  startDate: Date,
  endDate: Date
  pointOfSales: ICountry[];
}

export interface ICountry {
  name: string;
  code: string;
}

export interface ITargetList {
  items: {}
}

export interface ITarget {
  name: string;
}

export interface IPayment {
  name: string;
  cycles: ICyclePayment[];
}

export interface ICyclePayment {
  startDate: Date,
  endDate: Date
}


export interface IContractState {
  contract: IContract;
  loading: boolean;
  error: any;
}

export const fromServer = (record: any): IContract => ({
  id: record.id,
  contractHeader: {
    name: record.contractHeader.name,
    pointOfSales: record.contractHeader.pointOfSales,
    startDate: record.contractHeader.startDate,
    endDate: record.contractHeader.endDate,
  },
  targets: {
    items: indexBy(prop('name'), record.targets)
  }
});
