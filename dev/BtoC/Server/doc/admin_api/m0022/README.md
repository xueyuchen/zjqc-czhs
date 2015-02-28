# m0022 チェンジプラン一覧

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

list plantype 

## REQUEST

### URL

/api/changeplantypes

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| groupKbn | String | true | 大分類区分 | SP |
| changeplanMGroupId | Integer | true | チェンジプラン中分類id | 6 |
| changplanSGroupId | Integer | true | チェンジプラン小分類id | 11 |
| size | Integer | false | - | 20 |
| page | Integer | false | - | 0 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| content.changeplanTypeId | Integer | true | チェンジプラン種類id  |
| content.point | Integer | true | ポイント |
| content.changeplanTypeName | String | true | チェンジプラン種類名 |
| content.groupKbn | String | true | 大分類区分 |
| content.changplanSGroupId | Integer | true | チェンジプラン小分類id |
| content.changeplanMGroupId | Integer | true | チェンジプラン中分類id |
| size | Integer | true | -  |
| number | Integer | true | - |
| numberOfElements | Integer | true | -  |
| totalPages | Integer | true | -  |
| firstPage | Boolean | true | - |
| lastPage | Boolean | true | -  |
| totalElements | Integer | true | - |
| sort | - | false | -  |

#### success example

status:200

body:
```json
{
    "content": [
        {
            "changeplanTypeId": 3,
            "point": 55,
            "changeplanTypeName": "testChange",
            "groupKbn": "SP",
            "changeplanMGroupId": 6,
            "changplanSGroupId": 11
        },
        {
            "changeplanTypeId": 9,
            "point": 5,
            "changeplanTypeName": "SP-2-1-1",
            "groupKbn": "SP",
            "changeplanMGroupId": 6,
            "changplanSGroupId": 11
        },
        {
            "changeplanTypeId": 10,
            "point": 36,
            "changeplanTypeName": "SP-2-1-2",
            "groupKbn": "SP",
            "changeplanMGroupId": 6,
            "changplanSGroupId": 11
        },
        {
            "changeplanTypeId": 24,
            "point": 55,
            "changeplanTypeName": "testChange",
            "groupKbn": "SP",
            "changeplanMGroupId": 6,
            "changplanSGroupId": 11
        },
        {
            "changeplanTypeId": 25,
            "point": 55,
            "changeplanTypeName": "testCreat",
            "groupKbn": "SP",
            "changeplanMGroupId": 6,
            "changplanSGroupId": 11
        }
    ],
    "size": 20,
    "number": 0,
    "numberOfElements": 5,
    "sort": null,
    "firstPage": true,
    "totalPages": 1,
    "lastPage": true,
    "totalElements": 5
}
```
* * *

## SUMMARY

delete plan type

## REQUEST

### URL

/api/changeplantypes/{changeplanTypeId}

### METHOD

DELETE

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| changeplanTypeId | Integer | true | チェンジプラン種類id | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | description |
| ----- | -----| ----- |
| code | String | -  |

#### success example

status:200

```json
    {
      "code": "e.ex.mm.0000"
    }
```

* * *

## SUMMARY

to modify plantype

## REQUEST

### URL

/api/changeplantypes/{changeplanTypeId}

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| changeplanTypeId | Integer | true | チェンジプラン種類id | 3 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required  | description |
|----- | -----| ----- | ----- | -----|
| content.changeplanTypeId | Integer | true | チェンジプラン種類id |
| content.point | Integer | true | ポイント |
| content.changeplanTypeName | String | true | チェンジプラン種類名 |
| content.groupKbn | String | true | 大分類区分 |
| content.changplanSGroupId | Integer | true | チェンジプラン小分類id |

#### success example

status:200

body:
```json
{
    "changeplanTypeId": 3,
    "point": 50,
    "changeplanTypeName": "ET-1-1-3",
    "groupKbn": "ET",
    "changplanSGroupId": null
}
```

* * *




