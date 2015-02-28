# M0007 カウンセリング予約状況-2

## SUMMARY

カウンセリング予約状況-2

## REQUEST

### URL
/api/reserve/date_plan

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| date | String | true | 时间 yyyy-MM-dd | "2014-12-01" |
| page | Number | false | 页数 default:0 | 5 |
| size | Number | false | 限制条数 default:10 | 5 |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type  | required | description |
| ----- | -----| -------- | ----- |
| reserveId | Number | true | 予約ID  |
| content | Array | false | 内容  |
| content[n].reserveId | true | Number | ユーザID   |
| content[n].adminUserId | true | Number | 管理者ユーザID   |
| content[n].adminUserName | true | String | 管理者名   |
| content[n].userId | Number | false | ユーザID  |
| content[n].userName | String | false | ユーザー名  |
| content[n].workHour | String | true | HH:mm 予約時刻   |
| content[n].requestFlg | Number | true | 予約リクエストflg 0:未请求 1:予約リクエスト 2:予約キャンセル的请求 |
| info| Array| false| request 信息|
| info[n].reserveTime| String | true | 预约时刻 |
| info[n].counts| Number| true | request 请求总数 |
| info[n].vcubeSurplus| Number| true | vcube 剩余总数 |
| content[n].workSts | Number | true | 出勤ステータス   |
| size | Number | true| 限制条数 |
| number | Number | true| 当前页 |
| totalElements | Number | true| 总条数 |
| numberOfElements | Number | true| 当前也条数 |
| firstPage | Boolean | true| 第一页 |
| lastPage | Boolean | true| 最后一页 |
| totalPages | Number | true | 总页数 |

#### success example

status:200

body:
```json
{
    "content": [
        {
            "adminUserId": 2,
            "adminUserName": "qqqqqqqqqqqqq2",
            "reserveId": 718,
            "userId": null,
            "userName": null,
            "workHour": "10:00",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 2,
            "adminUserName": "qqqqqqqqqqqqq2",
            "reserveId": 747,
            "userId": null,
            "userName": null,
            "workHour": "11:30",
            "workSts": 1,
            "requestFlg": 0
        },
        {
            "adminUserId": 2,
            "adminUserName": "qqqqqqqqqqqqq2",
            "reserveId": 749,
            "userId": null,
            "userName": null,
            "workHour": "16:30",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 2,
            "adminUserName": "qqqqqqqqqqqqq2",
            "reserveId": 750,
            "userId": 6,
            "userName": "last_name_kanji6first_name_kanji6",
            "workHour": "18:00",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 2,
            "adminUserName": "qqqqqqqqqqqqq2",
            "reserveId": 751,
            "userId": 104,
            "userName": "last_name_kanji104first_name_kanji104",
            "workHour": "19:30",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 2,
            "adminUserName": "qqqqqqqqqqqqq2",
            "reserveId": 776,
            "userId": null,
            "userName": null,
            "workHour": "15:00",
            "workSts": 1,
            "requestFlg": 0
        },
        {
            "adminUserId": 4,
            "adminUserName": "admin_user_name3",
            "reserveId": 752,
            "userId": null,
            "userName": null,
            "workHour": "10:00",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 4,
            "adminUserName": "admin_user_name3",
            "reserveId": 753,
            "userId": null,
            "userName": null,
            "workHour": "11:30",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 4,
            "adminUserName": "admin_user_name3",
            "reserveId": 754,
            "userId": null,
            "userName": null,
            "workHour": "13:30",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 4,
            "adminUserName": "admin_user_name3",
            "reserveId": 755,
            "userId": null,
            "userName": null,
            "workHour": "15:00",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 4,
            "adminUserName": "admin_user_name3",
            "reserveId": 756,
            "userId": null,
            "userName": null,
            "workHour": "16:30",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 4,
            "adminUserName": "admin_user_name3",
            "reserveId": 757,
            "userId": null,
            "userName": null,
            "workHour": "18:00",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 4,
            "adminUserName": "admin_user_name3",
            "reserveId": 758,
            "userId": null,
            "userName": null,
            "workHour": "19:30",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 5,
            "adminUserName": "123123123",
            "reserveId": 793,
            "userId": null,
            "userName": null,
            "workHour": "10:00",
            "workSts": 1,
            "requestFlg": 0
        },
        {
            "adminUserId": 5,
            "adminUserName": "123123123",
            "reserveId": 794,
            "userId": null,
            "userName": null,
            "workHour": "11:30",
            "workSts": 2,
            "requestFlg": 0
        },
        {
            "adminUserId": 6,
            "adminUserName": "admin_user_name5",
            "reserveId": null,
            "userId": null,
            "userName": null,
            "workHour": null,
            "workSts": null,
            "requestFlg": null
        },
        {
            "adminUserId": 8,
            "adminUserName": "admin_user_name7",
            "reserveId": null,
            "userId": null,
            "userName": null,
            "workHour": null,
            "workSts": null,
            "requestFlg": null
        },
        {
            "adminUserId": 9,
            "adminUserName": "23123123123",
            "reserveId": null,
            "userId": null,
            "userName": null,
            "workHour": null,
            "workSts": null,
            "requestFlg": null
        }
    ],
    "size": 6,
    "number": 0,
    "sort": null,
    "totalElements": 95,
    "totalPages": 16,
    "numberOfElements": 6,
    "info": [
        {
            "reserveTime": "11:30",
            "counts": 1，
            "vcubeSurplus":1
        },
        {
            "reserveTime": "13:30",
            "counts": 1,
             "vcubeSurplus":1
        },
        {
            "reserveTime": "15:00",
            "counts": 4,
             "vcubeSurplus":1
        },
        {
            "reserveTime": "16:30",
            "counts": 1,
             "vcubeSurplus":1
        },
        {
            "reserveTime": "19:30",
            "counts": 5,
             "vcubeSurplus":1
        }
    ],
    "lastPage": false,
    "firstPage": true
}
```


