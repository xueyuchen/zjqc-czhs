# m0035 チェンジプラン記録画面

## SUMMARY

チェンジプラン記録画面

## REQUEST

### URL

/api/changeplanhist

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID  | 1 |
| fromDt | String | false | 开始日期  | 2014-12-12 |
| toDt | String | false | 结束日期 | 2014-12-19 |
| status | Integer | true | 周 | 2014-12-19 |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| hist[n].changePlanHistId | Integer | true | チェンジプラン履歴ID  |
| hist[n].recordDate | String | true | 記録日 |
| hist[n].changeplanTypeId | Number | true | - |
| hist[n].changeplanTypeName | String | true | - |
| hist[n].userId | Number | true | - |
| hist[n].complFlg | Number | true | - |
| fromDt | String | true | - |
| toDt | String | true | - |

#### success example

status:200

body:
```json
{
    "hist": [
        {
            "changePlanHistId": 1,
            "recordDate": "2014-01-01",
            "changeplanTypeId": 1,
            "changeplanTypeName": "ET-1-1-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 2,
            "recordDate": "2014-01-01",
            "changeplanTypeId": 2,
            "changeplanTypeName": "ET-1-1-2",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 3,
            "recordDate": "2014-01-01",
            "changeplanTypeId": 3,
            "changeplanTypeName": "ET-1-1-3",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 4,
            "recordDate": "2014-01-01",
            "changeplanTypeId": 9,
            "changeplanTypeName": "SP-2-1-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 5,
            "recordDate": "2014-01-02",
            "changeplanTypeId": 1,
            "changeplanTypeName": "ET-1-1-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 6,
            "recordDate": "2014-01-02",
            "changeplanTypeId": 2,
            "changeplanTypeName": "ET-1-1-2",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 7,
            "recordDate": "2014-01-02",
            "changeplanTypeId": 5,
            "changeplanTypeName": "ET-1-2-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 8,
            "recordDate": "2014-01-02",
            "changeplanTypeId": 8,
            "changeplanTypeName": "ET-1-2-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 9,
            "recordDate": "2014-01-02",
            "changeplanTypeId": 9,
            "changeplanTypeName": "SP-2-1-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 10,
            "recordDate": "2014-01-03",
            "changeplanTypeId": 9,
            "changeplanTypeName": "SP-2-1-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 11,
            "recordDate": "2014-01-03",
            "changeplanTypeId": 8,
            "changeplanTypeName": "ET-1-2-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 12,
            "recordDate": "2014-01-03",
            "changeplanTypeId": 5,
            "changeplanTypeName": "ET-1-2-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 13,
            "recordDate": "2014-01-03",
            "changeplanTypeId": 1,
            "changeplanTypeName": "ET-1-1-1",
            "userId": 1,
            "complFlg": 0
        },
        {
            "changePlanHistId": 14,
            "recordDate": "2014-01-03",
            "changeplanTypeId": 2,
            "changeplanTypeName": "ET-1-1-2",
            "userId": 1,
            "complFlg": 0
        }
    ],
    "fromDt": "2013-12-30",
    "toDt": "2014-01-05"
}
```
* * *
