import { indexBy, prop } from 'ramda';

export interface MainSupplier {
  name: string;
  code: string;
}

export interface PointsOfSale {
  name: string;
  code: string;
}

export interface ValidatingSupplier {
  name: string;
  code: string;
}

export interface MarketingSupplier {
  name: string;
  code: string;
}

export interface OperatingSupplier {
  name: string;
  code: string;
}

export interface ContractScope {
  description: string;
  systemName: string;
  currencyCode: string;
  owner: string;
  validityStartDate: string;
  validityEndDate: string;
  typeCode: string;
  statusCode: string;
  mainSupplier: MainSupplier;
  dateTypeCode: string;
  pointOfSaleScopeCode: string;
  pointsOfSale: PointsOfSale[];
  active: boolean;
  validatingSuppliers: ValidatingSupplier[];
  marketingSuppliers: MarketingSupplier[];
  operatingSuppliers: OperatingSupplier[];
  businessDivisionCodes: string[];
  contractLevel: string;
  remark: string;
}

export interface Capping {
  type: string;
  amount: number;
}

export interface PaymentMetrics {
  paymentDataMeasure: string;
  paymentDataInputType: string;
  rebateType: string;
}

export interface TargetMetrics {
  targetDataMeasure: string;
  targetDataInputType: string;
  targetType: string;
}

export interface Minimum {
  target: number;
  rebate: number;
}

export interface Maximum {
  target: number;
  rebate: number;
}

export interface Inflection {
  target: number;
  rebate: number;
}

export interface Layer {
  fromNumber: number;
  toNumber: number;
  rebate: number;
}

export interface MatrixEntry {
  triggerX: number;
  triggerY: number;
  rebate: number;
}

export interface Cycle {
  startDate: string;
  endDate: string;
  remark: string;
  capping: Capping;
  minimum: Minimum;
  maximum: Maximum;
  curveFactor: number;
  inflections: Inflection[];
  rebate?: number;
  amount?: number;
  layers: Layer[];
  matrixEntries: MatrixEntry[];
}

export interface TargetMetricsXaxis {
  targetDataMeasure: string;
  targetDataInputType: string;
  targetType: string;
}

export interface TargetMetricsYaxis {
  targetDataMeasure: string;
  targetDataInputType: string;
  targetType: string;
}

export interface Payment {
  type: string;
  name: string;
  currencyCode: string;
  paymentMetrics: PaymentMetrics;
  targetMetrics: TargetMetrics;
  cycles: Cycle[];
  targetMetricsXaxis: TargetMetricsXaxis;
  targetMetricsYaxis: TargetMetricsYaxis;
}

export interface Target {
  name: string;
  agreementTypeCode: string;
  countsForTotalTraffic: boolean;
  revenueTypeCode: string;
  safetyNets: string[];
  capping: Capping;
  paymentTerms: string;
  remarks: string;
  additionalDateRuleTypeCodes: string[];
  payments: Payment[];
}

export interface SafetyNet {
  name: string;
  agreementType: string;
  cappingType: string;
  countsForTotalTraffic: boolean;
  targetRevenueType: string;
  paymentTerms?: any;
  cappingAmount?: any;
  remarks?: any;
  trafficScopeId?: any;
  additionalDateRuleDateTypes?: any;
  payments?: any;
}

export interface Contract {
  id: number;
  contractScope: ContractScope;
  targets: Target[];
  safetyNets: SafetyNet[];
}

