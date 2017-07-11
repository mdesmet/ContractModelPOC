export const CONTRACT1 = `
{
  "id": 1,
  "contractScope": {
    "description": "MyContract",
    "systemName": "systematic",
    "currencyCode": "EUR",
    "owner": "jackson pollock",
    "validityStartDate": "2016-10-06",
    "validityEndDate": "2017-10-07",
    "typeCode": "SLA",
    "statusCode": "draft",
    "mainSupplier": {
      "name": "BS",
      "code": "bestSupplier"
    },
    "dateTypeCode": "Booking Date",
    "pointOfSaleScopeCode": "international",
    "pointsOfSale": [
      {
        "name": "algeria",
        "code": "aa"
      }
    ],
    "active": true,
    "validatingSuppliers": [
      {
        "name": "BS",
        "code": "bestSupplier"
      }
    ],
    "marketingSuppliers": [
      {
        "name": "BS",
        "code": "bestSupplier"
      }
    ],
    "operatingSuppliers": [
      {
        "name": "BS",
        "code": "bestSupplier"
      }
    ],
    "businessDivisionCodes": [
      "Commercial"
    ],
    "contractLevel": "TICKET",
    "remark": "hello"
  },
  "targets": [
    {
      "name": "target1",
      "agreementTypeCode": "Performance Based",
      "countsForTotalTraffic": true,
      "revenueTypeCode": "Service Fee",
      "safetyNets": [
        "safetyfirst"
      ],
      "capping": {
        "type": "Amount",
        "amount": 20000
      },
      "paymentTerms": "terms",
      "remarks": "remarksText",
      "additionalDateRuleTypeCodes": [
        "Arrival Date"
      ],
      "payments": [
        {
          "type": "linear",
          "name": "my Linear Payment",
          "currencyCode": "EUR",
          "paymentMetrics": {
            "paymentDataMeasure": "Value",
            "paymentDataInputType": "Coupon",
            "rebateType": "Amount per unit"
          },
          "targetMetrics": {
            "targetDataMeasure": "% vs Baseline",
            "targetDataInputType": "Coupon",
            "targetType": "Index"
          },
          "cycles": [
            {
              "startDate": "2017-09-01",
              "endDate": "2017-09-01",
              "remark": "no remarks",
              "capping": {
                "type": "Amount",
                "amount": 3300
              },
              "minimum": {
                "target": 2,
                "rebate": 30
              },
              "maximum": {
                "target": 10,
                "rebate": 40
              },
              "curveFactor": 1
            }
          ]
        },
        {
          "type": "linearInflection",
          "name": "my inflection payment",
          "currencyCode": "EUR",
          "paymentMetrics": {
            "paymentDataMeasure": "Value",
            "paymentDataInputType": "Coupon",
            "rebateType": "Amount per unit"
          },
          "targetMetrics": {
            "targetDataMeasure": "% vs Baseline",
            "targetDataInputType": "Coupon",
            "targetType": "Index"
          },
          "cycles": [
            {
              "startDate": "2017-09-01",
              "endDate": "2017-09-01",
              "remark": "no remarks",
              "capping": {
                "type": "amount",
                "amount": 3300
              },
              "minimum": {
                "target": 2,
                "rebate": 30
              },
              "maximum": {
                "target": 10,
                "rebate": 40
              },
              "inflections": [
                {
                  "target": 5,
                  "rebate": 35
                }
              ]
            }
          ]
        },
        {
          "type": "qualitative",
          "name": "my variable payment",
          "currencyCode": "EUR",
          "paymentMetrics": {
            "paymentDataMeasure": "Value",
            "paymentDataInputType": "Coupon",
            "rebateType": "Amount per unit"
          },
          "targetMetrics": null,
          "cycles": [
            {
              "startDate": "2017-03-01",
              "endDate": "2017-03-02",
              "remark": "nothing to see here",
              "capping": {
                "type": "Amount",
                "amount": 3300
              },
              "rebate": 10000
            }
          ]
        },
        {
          "type": "fixed",
          "name": "myFixedPayment",
          "currencyCode": "EUR",
          "cycles": [
            {
              "startDate": "2017-01-07",
              "endDate": "2017-01-08",
              "amount": 1000,
              "remark": "hello"
            }
          ]
        },
        {
          "type": "variable",
          "name": "my variable payment",
          "currencyCode": "EUR",
          "paymentMetrics": {
            "paymentDataMeasure": "Value",
            "paymentDataInputType": "Coupon",
            "rebateType": "Amount per unit"
          },
          "cycles": [
            {
              "startDate": "2017-03-01",
              "endDate": "2017-03-02",
              "remark": "nothing to see here",
              "capping": {
                "type": "Amount",
                "amount": 3300
              },
              "rebate": 10000
            }
          ]
        },
        {
          "type": "layer",
          "name": "myLayerPayment",
          "currencyCode": "EUR",
          "paymentMetrics": {
            "paymentDataMeasure": "Value",
            "paymentDataInputType": "Coupon",
            "rebateType": "Amount per unit"
          },
          "targetMetrics": {
            "targetDataMeasure": "% vs Baseline",
            "targetDataInputType": "Coupon",
            "targetType": "Index"
          },
          "cycles": [
            {
              "startDate": "2017-02-07",
              "endDate": "2017-02-08",
              "remark": "hello",
              "capping": {
                "type": "Amount",
                "amount": 123
              },
              "layers": [
                {
                  "fromNumber": 2,
                  "toNumber": 3,
                  "rebate": 50
                },
                {
                  "fromNumber": 3,
                  "toNumber": 20,
                  "rebate": 500
                }
              ]
            }
          ]
        },
        {
          "type": "slidingScale",
          "name": "myLayerPayment",
          "currencyCode": "EUR",
          "paymentMetrics": {
            "paymentDataMeasure": "Value",
            "paymentDataInputType": "Coupon",
            "rebateType": "Amount per unit"
          },
          "targetMetrics": {
            "targetDataMeasure": "% vs Baseline",
            "targetDataInputType": "Coupon",
            "targetType": "Index"
          },
          "cycles": [
            {
              "startDate": "2017-02-07",
              "endDate": "2017-02-08",
              "remark": "hello",
              "capping": {
                "type": "Amount",
                "amount": 123
              },
              "layers": [
                {
                  "fromNumber": 2,
                  "toNumber": 3,
                  "rebate": 50
                },
                {
                  "fromNumber": 3,
                  "toNumber": 20,
                  "rebate": 500
                }
             ]
            }
          ]
        },
        {
          "type": "matrix",
          "name": "my matrix payment",
          "currencyCode": "EUR",
          "paymentMetrics": {
            "paymentDataMeasure": "Value",
            "paymentDataInputType": "Coupon",
            "rebateType": "Amount per unit"
          },
          "targetMetricsXaxis": {
            "targetDataMeasure": "% vs Baseline",
            "targetDataInputType": "Coupon",
            "targetType": "Index"
          },
          "targetMetricsYaxis": {
            "targetDataMeasure": "% vs Baseline",
            "targetDataInputType": "Coupon",
            "targetType": "Index"
          },
          "cycles": [
            {
              "startDate": "2017-04-01",
             "endDate": "2017-04-02",
              "remark": "nothing to see here",
              "capping": {
                "type": "Amount",
                "amount": 3300
              },
              "matrixEntries": [
                {
                  "triggerX": 2,
                  "triggerY": 2,
                  "rebate": 44
                },
                {
                  "triggerX": 1,
                  "triggerY": 2,
                  "rebate": 77
                },
                {
                  "triggerX": 2,
                  "triggerY": 1,
                  "rebate": 33
                },
                {
                  "triggerX": 1,
                  "triggerY": 1,
                  "rebate": 55
                }
              ]
            }
          ]
        }
      ]
    }
  ],
  "safetyNets": [
    {
      "name": "safetyfirst",
      "agreementType": "agree1",
      "cappingType": "flatcap",
      "countsForTotalTraffic": false,
      "targetRevenueType": "safetyRev",
      "paymentTerms": null,
      "cappingAmount": null,
      "remarks": null,
      "trafficScopeId": null,
      "additionalDateRuleDateTypes": null,
      "payments": null
    }
  ]
}
`;
