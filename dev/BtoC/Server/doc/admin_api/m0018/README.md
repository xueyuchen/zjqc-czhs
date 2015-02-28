
# M0018 

## SUMMARY

ユーザーの基本情報とカウンセリング結果を表示、記録する

## REQUEST

### URL

/api/adminusers/getallke

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| adminUserId | Integer | true | 管理者ユーザID |
| adminRoleKbn | String | true | 管理者区分 |
| loginId | Integer | false | ログインID |
| adminUserName | String | true | 管理者名 |
| adminUserPhoto | String | false | 管理者写真ファイルパス |

#### success example

status:200

body:
```json
[
    {
        "adminUserId": 2,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "一刀营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 3,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "二路营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 4,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "三维营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 5,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "斯基营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 6,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "无码营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 7,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "路灯营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 8,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "凄凉营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 9,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "八嘎营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 10,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "久久营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 11,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "饿啊营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 12,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "傻傻营养师",
        "adminUserPhoto": null
    },
    {
        "adminUserId": 13,
        "adminRoleKbn": "KE",
        "loginId": null,
        "adminUserName": "天天营养师",
        "adminUserPhoto": null
    }
]
```

* * *

## SUMMARY

## REQUEST

### URL

/api/counselings/{userId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| counselingId | Integer | false | カウンセリングid |
| dietThema | String | false | ダイエットテーマ |
| content1 | String | false | カウンセリング内容_1 |
| counselingDt1 | String | false | カウンセリング日時_1 |
| content2 | String | false | カウンセリング内容_2 |
| counselingDt2 | String | false | カウンセリング日時_2 |
| content3 | String | false | カウンセリング内容_3 |
| counselingDt3 | String | false | カウンセリング日時_3 |

#### success example

status:200

body:
```json
{
    "counselingId": 1,
    "dietThema": "AAAA",
    "content1": "AA-1",
    "counselingDt1": "2014-12-21 00:00",
    "content2": "AA-2",
    "counselingDt2": "2014-12-22 00:00",
    "content3": "AA-3",
    "counselingDt3": "2014-12-23 00:00",
}
```

* * *

## SUMMARY



## REQUEST

### URL
/api/counselings/Theme/{userId}

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| counselingId | Integer | false | カウンセリングid | 3 |
| dietThema | String | true | ダイエットテーマ | test |
| userId | Integer | true | ダイエットテーマ | 1 |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| counselingId | Integer | true | カウンセリングid |
| dietThema | String | true | ダイエットテーマ |
| content1 | String | false | カウンセリング内容_1 |
| counselingDt1 | String | false | カウンセリング日時_1 |
| content2 | String | false | カウンセリング内容_2 |
| counselingDt2 | String | false | カウンセリング日時_2 |
| content3 | String | false | カウンセリング内容_3 |
| counselingDt3 | String | false | カウンセリング日時_3 |

#### success example

status:200

body:
```json
{
    "counselingId": 3,
    "dietThema": "test",
    "content1": null,
    "counselingDt1": null,
    "content2": null,
    "counselingDt2": null,
    "content3": null,
    "counselingDt3": null
}
```

* * *

## SUMMARY


## REQUEST

### URL
/api/counselings/content/{userId}

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| counselingId | Integer | false | カウンセリングid | 3 |
| counselingDt | String | true | カウンセリング日時 | 2014-12-12 12:12 |
| content | String | true | カウンセリング内容 | zzzzzz |
| contentNo | String | true | 初回1、中間2、最終3 | 3 |
| userId | Integer | true | カウンセリングid | 3 |
| dietThema | String | true | ダイエットテーマ | dewfe |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| counselingId | Integer | true | カウンセリングid |
| dietThema | String | true | ダイエットテーマ |
| content1 | String | false | カウンセリング内容_1 |
| counselingDt1 | String | false | カウンセリング日時_1 |
| content2 | String | false | カウンセリング内容_2 |
| counselingDt2 | String | false | カウンセリング日時_2 |
| content3 | String | false | カウンセリング内容_3 |
| counselingDt3 | String | false | カウンセリング日時_3 |

#### success example

status:200

body:
```json
{
    "counselingId": 3,
    "dietThema": "dewfe",
    "content1": "xxxxxx1",
    "counselingDt1": "2014-12-12 12:12",
    "content2": "qqqq3",
    "counselingDt2": "2014-12-12 12:12",
    "content3": "zzzzzz",
    "counselingDt3": "2014-12-12 12:12"
}
```

* * *

## SUMMARY


## REQUEST

### URL
/api/users/target/{userId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| userId | Integer | true | ユーザID |
| lastNameKanji | String | true | 姓（漢字） |
| firstNameKanji | String | true | 名（漢字） |
| firstNameKana | String | true | 姓（カナ） |
| lastNameKana | String | true | 名（カナ） |
| nikeName | String | true | ニックネーム |
| sex | Integer | true | 性別 |
| birthday | String | true | 誕生日 |
| height | Decimal | true | 身長 |
| targetWeight | Decimal | true | 目標体重 |
| firstWeight | Decimal | true | 初回体重 |
| targetPoint | Integer | true | 目標チェンジポイント |
| weight | Double | true | 体重 |
| startRecDate | String | true | 記録開始日 |
| adminUserId | String | true | 管理者ユーザID |
| totalPoint | Integer | true | チェンジポイント |

#### success example

status:200

body:
```json
{
    "userId": 1,
    "lastNameKanji": "xi",
    "firstNameKanji": "gua",
    "firstNameKana": "シ",
    "lastNameKana": "グア",
    "nikeName": "西瓜",
    "sex": 1,
    "birthday": "1999-09-09",
    "height": null,
    "targetWeight": 80.3,
    "firstWeight": null,
    "targetPoint": 200,
    "weight": 60.5,
    "startRecDate": "2014-12-12",
    "adminUserId": 1,
    "totalPoint": 80
}
```

* * *

## SUMMARY


## REQUEST

### URL
/api/users/target/{userId}

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID | 2 |
| startRecDate | String | true | 記録開始日 | 2014-12-12 12:12 |
| targetWeight | Double | true | 目標体重 | 80.3 |
| targetPoint | Integer | true | 目標チェンジポイント | 200 |
| adminUserId | Integer | true | 管理者ユーザID | 1 |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| userId | Integer | true | ユーザID |
| startRecDate | String | true | 記録開始日 |
| targetWeight | Double | true | 目標体重 |
| targetPoint | Integer | true | 目標チェンジポイント |
| adminUserId | Integer | true | 管理者ユーザID |

#### success example

status:200

body:
```json
{
    "userId": 1,
    "startRecDate": "2014-12-12 12:12",
    "targetWeight": 80.3,
    "targetPoint": 200,
    "adminUserId": 1
}
```

* * *

## SUMMARY


## REQUEST

### URL

/api/usersheets

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Number | true | - | text |
| sheetRegDt | String | true | - | 2015-01-01 12:12 |
| sheetText | String | true | - | text |
| sheetTitle | String | true | - | text |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| userId | Number | true | - |
| sheetRegDt | String | true | - |
| sheetText | String | true | - |
| sheetTitle | String | true | - |

#### success example

status:200

body:
```json
{
    
    "userId": 1,
    "userSheetId": 1,
    "sheetTitle": "text",
    "sheetRegDt": 2015-01-01 12:12,
    "sheetText": text
}
```

* * *

## SUMMARY


## REQUEST

### URL

/api/usersheets

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Number | true | - | text |
| userSheetId | Number | true | - | text |
| sheetRegDt | String | true | - | 2015-01-01 12:12 |
| sheetText | String | true | - | text |
| sheetTitle | String | true | - | text |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| userId | Number | true | - |
| userSheetId | Number | true | - |
| sheetTitle | String | true | - |
| sheetRegDt | String | true | - |
| sheetText | String | true | - |

#### success example

status:200

body:
```json
{
    "userId": 1,
    "userSheetId": 1,
    "sheetTitle": text,
    "sheetRegDt": 2015-01-01 12:12,
    "sheetText": text
}
```

* * *

## SUMMARY

## REQUEST

### URL

/api/usersheets/{userId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| userId | Number | true | ユーザID |
| userSheetId | Number | true | ユーザシートID |
| sheetRegDt | Date | true | シート登録日時 |
| sheetText | String | true | シートテキスト |
| sheetTitle | String | true | シートタイトル |

#### success example

status:200

body:
```json
[
    {
        "userId": 1,
        "userSheetId": 1,
        "sheetRegDt": "2014-12-21 00:00",
        "sheetText": "AAA",
        "sheetTitle": "aaa"
    },
    {
        "userId": 1,
        "userSheetId": 2,
        "sheetRegDt": "2014-12-21 00:00",
        "sheetText": "BBB",
        "sheetTitle": "bbb"
    },
]
```

* * *
