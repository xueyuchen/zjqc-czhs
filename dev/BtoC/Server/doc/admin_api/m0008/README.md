# M0008 管理栄養士予定表

## SUMMARY-01

管理栄養士予定表 - 查询

## REQUEST

### URL

/api/reserves/details

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| adminUserId | Integer | true | 管理者ユーザID  | 13 |
| reserveDate  | String | true | 予約日 | "2014-01-02" |

## RESPONSE

## BODY

| name | type|required  | description |
| ----- | -----|-----| ----- |
| adminUserId | Number | true | 管理者ユーザID |
| adminUserName | Number | true | 管理者名 |
| [n].reserveId | Number | true | 预约ID |
| [n].reserveTime | String |true | HH:mm 可预约时间 |
| [n].workSts | Number|true | 工作状态(0-休 1-空闲 2-预约)  |
| [n].requestFlg | Boolean | true | 予約リクエストflg  |
| [n].userId | String| false | 预约用户ID  |
| [n].lastNameKanji | String | false| 姓（漢字） |
| [n].firstNameKanji | String | false| 名（漢字） |
| [n].valid | String | true| 状態 1:valid 2：vcube invalid 3：date invalid |



#### success example

```json
{
    "adminUserId": 2,
    "adminUserName": "admin_user22me1",
    "reserves": [
        {
            "reserveId": 701,
            "userId": null,
            "lastNameKanji": null,
            "firstNameKanji": null,
            "requestFlg": 0,
            "reserveDate": "2015-01-16",
            "reserveTime": "10:00",
            "workSts": 2,
            "valid": 1
        },
        {
            "reserveId": 1096,
            "userId": 103,
            "lastNameKanji": "last_name_kanji103",
            "firstNameKanji": "first_name_kanji103",
            "requestFlg": 0,
            "reserveDate": "2015-01-16",
            "reserveTime": "19:30",
            "workSts": 2,
            "valid": 0
        }
    ]
}
```

* * *

## SUMMARY-02

管理栄養士予定表 - 批量更新

## REQUEST

### URL
/api/reserves/update

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| adminUserId  | Number | false | 营养师ID | 1 |
| reserveDate | String | true | 可预约日期 | "2013-13-21" |
| [n]._delete | Boolean | true | 是否删除 | true |
| [n].reserveId  | Number | false | 预约ID(空表示条目增加) | 1 |
| [n].workSts  | Number | false | 工作状态 | 1 |
| [n].reserveTime  | String | true | HH:mm 预约时间 | 1 |

## RESPONSE

### BODY

| name | type|required  | description |
| ----- | -----|-----| ----- |
| adminUserId | Number | true | 管理者ユーザID  |
| adminUserName | Number | true | 管理者名 |
| [n].reserveId | Number | true | 预约ID |
| [n].reserveTime | String | true | 可预约时间 |
| [n].workSts | Number|true | 出勤ステータス (0:休み 1:空き 2:予約済み)  |
| [n].requestFlg | Boolean | true | 予約リクエストflg |
| [n].userId | String| false | ユーザID |
| [n].lastNameKanji | String | false| 姓（漢字） |
| [n].firstNameKanji | String | false| 名（漢字） |
| [n].valid | String | true | 状態 1:valid 2：vcube invalid 3：date invalid |

#### success example

```json
{
	"adminUserId": 1,
    "adminUserName": "mmm",
    "reserves": [
        {
            "reserveId": 33322,
            "reserveTime": "09:00",
            "workSts": 1,
            "requestFlg":true,
            "userId": 203,
            "lastNameKanji": "guokai",
            "firstNameKanji": "mmmm",
            "valid":1
        }
    ]
}
