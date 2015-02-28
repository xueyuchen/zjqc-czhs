# m0029 お知らせ作成

## SUMMARY

creat info

## REQUEST

### URL
/api/infos

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| infoTitle | String | true | お知らせタイトル | testCreat |
| info | String | true | お知らせ内容 | 123 |
| fromDt | String | true | 開始日時 | 2014-20-20 00:00 |
| toDt | String | true | 終了日時 | 2014-20-30 00:00 |


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
| fromDt | String | true | 開始日時 |
| toDt | String | true | 終了日時 |

#### success example

status:200

body:
```json
{
    "infoId": 20,
    "infoTitle": "testCreat",
    "info": "123",
    "fromDt": "2014-12-20 00:00",
    "toDt": "2014-12-30 00:00"
}
```

* * *

## SUMMARY

modify info to save

## REQUEST

### URL

/api/infos/{infoId}

### METHOD

PUT

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| infoId | Integer | true | お知らせid | 20 |
| infoTitel | String | true | お知らせタイトル | ttestCcREAT |
| info | String | true | お知らせ内容 | AAA |
| fromDt | String | true | 開始日時 | "2015-01-01 12:12" |
| toDt | String | true | 終了日時 | "2015-02-01 12:12" |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
|----- | -----| ----- | ----- |
| infoId | Integer | true | お知らせid |
| infoTitel | String | true | お知らせタイトル |
| info | String | true | お知らせ内容 |
| fromDt | String | true | 開始日時 |
| toDt | String | true | 終了日時 |

#### success example

status:200

body:
```json
{
    "infoId": 20,
    "infoTitle": "ttestCcREAT",
    "info": "AAA",
    "fromDt": "2015-01-01 12:12",
    "toDt": "2015-02-01 12:12"
}
```

#### error example
```json
  {
    "code": "e.xx.fw.9001",
    "message": "System error occurred!",
    "errorResults": [
        {
            "code": "NotBlank",
            "message": "不能为空",
            "itemPath": "info"
        }
    ]
}
```

* * *


