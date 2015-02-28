# M0009 リクエストへの管理栄養士割当て画面

## SUMMARY

リクエストへの管理栄養士割当て画面

## REQUEST

### URL
/api/reserves/user

### METHOD

get

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId  | Number | false | ユーザID  | 1 |
| adminUserId  | Number | true | 管理者ユーザID | 1 |
| userName  | String | false | ユーザー名 | 1 |
| statuss  | Array | false | 検索条件（予約の状態） | 1 |
| reserveDate  | Date | false | 予約日 yyyy-MM-dd | 2014-12-12 |
| reserveTime  | Number |  false | 予約時刻 | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |

### BODY

| name | type|required  | description |
| ----- | -----|-----| ----- |
| info | object| true | 管理者ユーザ  |
| info.adminUserId | Number| true | 管理者ユーザID  |
| info.reserveStatus | Number| true | 予約の状態  |
| info.adminUserName | String| true | 管理者名   |
| info.reserveValid | Number | true | 状態 1:有效 2：vcube invalid 3：date invalid |
| content | Array| true | 内容 |
| content[n].reserveId | Number| true | 予約ID  |
| content[n].userId | Number | true | ユーザID  |
| content[n].userName | String | true | ユーザー名 |
| content[n].adminUserId | Number | false | 管理者ユーザID |
| content[n].status | Integer | true | 予約の状態  |

#### success example

status:200

body:
```json
{
    "content": [
        {
            "reserveId": 27,
            "userId": 5,
            "userName": "耳机公司",
            "adminUserId": null,
            "status": 0
        },
        {
            "reserveId": 26,
            "userId": 1,
            "userName": "xigua",
            "adminUserId": 3,
            "status": 1
        },
        {
            "reserveId": 25,
            "userId": 3,
            "userName": "雁荡风吹",
            "adminUserId": 2,
            "status": 1
        },
        {
            "reserveId": 2,
            "userId": 1,
            "userName": "xigua",
            "adminUserId": 1,
            "status": 1
        }
    ],
    "info": {
        "adminUserId": 2,
        "adminUserName": "一刀营养师",
        "reserveStatus": 1,
        "reserveValid":3
    },
    "size": 10,
    "number": 0,
    "sort": null,
    "firstPage": true,
    "lastPage": true,
    "numberOfElements": 4,
    "totalPages": 1,
    "totalElements": 4
}
```



* * *

## SUMMARY

## REQUEST

### URL
/api/reserves/user

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| reserverId | Integer | true | 预约id  | 13 |
| status | Integer | true | 予約の状態 | 0 |
| reserveDate | String | true | 予約日 yyyy-MM-dd| 2014-12-12 |
| reserveTime | String | true | 予約時刻 | 9 |
| adminUserId | Integer | true | 管理者ユーザID | 1 |
| userId | Integer | true | ユーザID  | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |

### BODY
| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| reserverId | Integer | true | 予約ID   | 13 |
| userId | Integer | true | ユーザID   | 13 |
| adminUserId | Integer | true | 管理者ユーザID   | 13 |
| requestFlg | Integer | true | 予約リクエストflg   | 13 |
| reserveDate | Integer | true | 予約日  | 13 |
| reserveTime | Integer | true | 予約時刻  | 13 |
| vcubeReserveId | Integer | true | V-CUBE予約ID   | 13 |
| vcubeReserveUrl | Integer | true | V-CUBE予約URL   | 13 |
| workSts | Integer | true | 出勤ステータス   | 13 |

#### success example

status:200

body:
```json
   { 
"reserveId" : 68,
 "userId" : 3,
 "adminUserId" : NULL,
 "requestFlg" : 2,
 "reserveDate" : "2014-12-13",
 "reserveTime" : "09:00:00.0000000",
 "vcubeReserveId" : NULL,
 "vcubeReserveUrl" : NULL,
 "workSts" : 0 
}



