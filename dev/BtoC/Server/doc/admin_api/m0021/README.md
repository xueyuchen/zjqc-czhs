# m0021 チェンジプラン設定

## SUMMARY

 get drop_down list Mgroup

## REQUEST

### URL

/api/changeplanmgroups

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| groupKbn | String | true | 大分類区分 | ET |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| changeplanMGroupId | Integer | true | チェンジプラン中分類id |
| groupKbn | String | true | 大分類区分  |
| changeplanMGroupName | String | true | チェンジプラン中分類名 |

#### success example

status:200

body:
```json
[
    {
        "changeplanMGroupId": 1,
        "groupKbn": "ET",
        "changeplanMGroupName": "ET-1"
    },
    {
        "changeplanMGroupId": 2,
        "groupKbn": "ET",
        "changeplanMGroupName": "ET-2"
    },
    {
        "changeplanMGroupId": 3,
        "groupKbn": "ET",
        "changeplanMGroupName": "ET-3"
    },
    {
        "changeplanMGroupId": 4,
        "groupKbn": "ET",
        "changeplanMGroupName": "ET-4"
    }
]
```
* * *

## SUMMARY

 get drop_down list Sgroup

## REQUEST

### URL

/api/changeplansgroups

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| changeplanMGroupId | String | true | 中分類区分  | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| changplanSGroupId | Integer | true | チェンジプラン小分類id |
| changplanSGroupName | String | true | チェンジプラン小分類名 |

#### success example

status:200

body:
```json
[
    {
        "changplanSGroupId": 1,
        "changplanSGroupName": "ET-1-1"
    },
    {
        "changplanSGroupId": 2,
        "changplanSGroupName": "ET-1-2"
    },
    {
        "changplanSGroupId": 3,
        "changplanSGroupName": "ET-1-3"
    }
]
```
* * *

## SUMMARY

set plan work/unwork

## REQUEST

### URL

/api/changeplans

### METHOD

PUT

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| changeplanId | Integer | false | チェンジプランid | 1 |
| delFlg | Integer | true | - | tchangeplan 削除flg |
| changeplanTypeId | Integer | true | ェンジプラン種類id | 1 |
| userId | Integer | true | ユーザID | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type |
|----- | -----|
| code | String |

#### success example

status:200

```json
{
    "code": "e.ex.mm.0000"
}
```

* * *

## SUMMARY

 select user's plan

## REQUEST

### URL

/api/changeplans

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID | 1 |
| changplanSGroupId | Integer | true | チェンジプラン小分類id | 1 |
| changeplanMGroupId | Integer | true | チェンジプラン中分類id | 1 |
| groupKbn | String | true | 大分類区分 | ET |
| page | Integer | false | - | 0 |
| size | Integer | false | - | 2 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | -----| ----- | ----- |
| page.content.changeplanTypeId | Integer | true | ェンジプラン種類id |
| page.content.point | Integer | true | ポイント |
| page.content.groupKbn | String | true | 大分類区分 |
| page.content.changeplanTypeName | String | true | チェンジプラン種類名 |
| page.content.delFlg | Integer | false | tchangeplan 削除flg |
| page.content.changeplanId | Integer | true | チェンジプランid |
| page.content.userId | Integer | false | ユーザID |
| page.content.changplanSGroupId | Integer | チェンジプラン小分類id |
| page.totalElements | Integer | true | - |
| page.totalPages | Integer | true | - |
| page.firstPage | Boolean | true | - |
| page.lastPage | Boolean | true | - |
| userOutput.userId | Integer | true | ユーザID |
| userOutput.name | String | true | - |
| userOutput.nikeName | String | true | ニックネーム |


#### success example

status:200

body:
```json
{
    "page": {
        "content": [
            {
                "changeplanTypeId": 1,
                "point": 10,
                "groupKbn": "ET",
                "changeplanTypeName": "ET-1-1-1",
                "changeplanId": 1,
                "changeplanSGroupId": 1,
                "userId": 1,
                "delFlg": 0
            },
            {
                "changeplanTypeId": 2,
                "point": 20,
                "groupKbn": "ET",
                "changeplanTypeName": "ET-1-1-2",
                "changeplanId": 2,
                "changeplanSGroupId": 1,
                "userId": 1,
                "delFlg": 0
            }
        ],
        "size": 2,
        "number": 0,
        "totalPages": 2,
        "firstPage": true,
        "lastPage": false,
        "totalElements": 3,
        "numberOfElements": 2,
        "sort": null
    },
    "info": {
        "userId": 1,
        "name": "xigua",
        "nikeName": "西瓜"
    }
}
```

* * *
