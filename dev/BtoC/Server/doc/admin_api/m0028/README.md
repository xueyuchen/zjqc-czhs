
# M0028 お知らせ一覧

## SUMMARY

info list

## REQUEST

### URL

/api/infos

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| size | Integer | false | - | 2 |
| page | Integer | false | - | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| content.infoId | Integer | true | お知らせid |
| content.infoTitle | String | true | お知らせタイトル |
| content.info | String | true | お知らせ内容 |
| content.fromDt | String | true | 開始日時 |
| content.toDt | String | true | 終了日時 |
| size | Number | false | - |
| number | Number | false | - |
| totalElements | Number | false | - |
| numberOfElements | Number | false | - |
| lastPage | Boolean | false | - |
| firstPage | Boolean | false | - |
| totalPages | Number | false | - |


#### success example

status:200

body:
```json
{
    "content": [
        {
            "infoId": 3,
            "infoTitle": "ccc",
            "info": "CCCCC",
            "fromDt": "2014-12-01 16:07",
            "toDt": "2014-12-26 16:07"
        },
        {
            "infoId": 4,
            "infoTitle": "ddd",
            "info": "DDDDC6",
            "fromDt": "2014-12-01 16:07",
            "toDt": "2014-12-26 16:07"
        }
    ],
    "size": 2,
    "number": 1,
    "numberOfElements": 2,
    "firstPage": false,
    "lastPage": false,
    "totalPages": 9,
    "totalElements": 17,
    "sort": null
}
```

* * *

## SUMMARY

to modify info

## REQUEST

### URL
/api/infos/{infoId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| infoId | Integer | true | お知らせid | 1 |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| infoId | Integer | true | お知らせid |
| infoTitle | String | true | お知らせタイトル |
| info | String | true | お知らせ内容 |
| content.fromDt | String | true | 開始日時 |
| content.toDt | String | true | 終了日時 |

#### success example

status:200

body:
```json
{
    "infoId": 2,
    "infoTitle": "bbb",
    "info": "BBBBB",
    "fromDt": "2014-01-01 16:07",
    "toDt": "2014-02-26 16:07"
}
```

* * *

## SUMMARY

delete info

## REQUEST

### URL

/api/infos/{infoId}

### METHOD

DELETE

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| infoId | Integer | true | お知らせid | 20 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | description |
| ----- | -----| ----- |
| code | String | -  |
| message | String | -  |

#### success example

status:200

body:
```json
{
    "code": "e.ex.mm.0000"
}
```

* * *

## SUMMARY

search info

## REQUEST

### URL

/api/infos/search

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| fromDt | String | true | 開始日時 | 2014-01-01 00:00 |
| toDt | String | true | 終了日時 | 2014-03-30 00:00 |
| size | Integer | false | - | - |
| page | Integer | false | - | - |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| content.infoId | Integer | true | お知らせid |
| content.infoTitle | String | true | お知らせタイトル |
| content.info | String | true | お知らせ内容 |
| content.fromDt | String | true | 開始日時 |
| content.toDt | String | true | 終了日時 |
| size | Number | false | - |
| number | Number | false | - |
| totalElements | Number | false | - |
| numberOfElements | Number | false | - |
| lastPage | Boolean | false | - |
| firstPage | Boolean | false | - |
| totalPages | Number | false | - |


#### success example

status:200

body:
```json
{
    "content": [
        {
            "infoId": 2,
            "infoTitle": "bbb",
            "info": "BBBBB",
            "fromDt": "2014-01-01 16:07",
            "toDt": "2014-02-26 16:07"
        }
    ],
    "size": 20,
    "number": 0,
    "totalPages": 1,
    "firstPage": true,
    "lastPage": true,
    "totalElements": 1,
    "sort": null,
    "numberOfElements": 1
}
```

* * *
