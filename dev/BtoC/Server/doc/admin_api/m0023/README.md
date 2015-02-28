# m0023 チェンジプラン作成編集

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
| groupKbn | String | true | 大分類区分  | ET |

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

/api/changeplansgroup

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

チェンジプラン编辑

## REQUEST

### URL

/api/changeplantypes/{changeplanTypeId}

### METHOD

PUT

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| point | Integer | true | ポイント（1 ~ 75） | 55 |
| changeplanTypeName | String | true | チェンジプラン種類名 | testChange |
| groupKbn | String | true | 大分類区分 | SP |
| changeplanTypeId | Integer | true | チェンジプラン種類id | 3 |
| changplanSGroupId | Integer | true | チェンジプラン小分類id | 11 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | description |
| ----- | -----| ----- |
| changeplanTypeId | Integer | チェンジプラン種類id |
| point | Integer | ポイント |
| changeplanTypeName | String | チェンジプラン種類名 |
| groupKbn | String | 大分類区分 |

#### success example

status:200

body:
```json
{
    "changeplanTypeId": 3,
    "point": 55,
    "changeplanTypeName": "testChange",
    "groupKbn": "SP"
}
```

* * *

## SUMMARY

チェンジプラン作成

## REQUEST

### URL
/api/changeplantypes

### METHOD

POST

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| point | Integer | true | ポイント（1-75） | 55 |
| changeplanTypeName | String | true | チェンジプラン種類名 | testCreat |
| groupKbn | String | true | 大分類区分 | SP |
| changplanSGroupId | Integer | true | チェンジプラン小分類id | 11 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | description |
| ----- | -----| ----- |
| changeplanTypeId | Integer | チェンジプラン種類id |
| point | Integer | ポイント（1-75） |
| changeplanTypeName | String | チェンジプラン種類名 |
| groupKbn | String | 大分類区分 |

#### success example

status:200

body:
```json
{
    "changeplanTypeId": 25,
    "point": 55,
    "changeplanTypeName": "testCreat",
    "groupKbn": "SP"
}
```


