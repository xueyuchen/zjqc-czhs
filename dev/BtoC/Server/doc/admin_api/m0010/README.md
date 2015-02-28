# M0010 ユーザー検索画面

## SUMMARY

M0010 ユーザー検索画面

## REQUEST

### URL
/api/users/mealcomment_statistics

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type  | required | description | example |
| ----- | -----| ----- | ----- | ----- |
| userId | Integer | false | 登録ID | 1 |
| userName | String | false | ユーザー名  | "username" |
| userNameKana | String | false | ユーザー名（カナ）| "usernamekana" |
| examNo | Integer | false | 遺伝子検体No. | 1 |
| adminUserId | Integer | false | 担当管理栄養士Id | 1 |
| mealCreDtStart | String | false | 投稿期間start | "yyyy-MM-dd" |
| mealCreDtEnd | Date | false | 投稿期間End | "yyyy-MM-dd" |
| timeLineFinished | List<Integer> | false | 1:済,0:未済 | 1 |
| evaluateFinished  | List<Integer> | false | 1:済,0:未済 | 1 |
| mealCommentFinished |  List<Integer> | false | 2:済,0:未済,1:差戻 | 1 |
| page | Integer | false | - | 1 |
| size | Integer | false | - | 1 |


## RESPONSE

### BODY

| name | type  | not null | description |
| ----- | -----| ----- | ----- |
| userId | Integer | true | 登録ID |
| userName | String| true |ユーザー名 |
| timeLineFinish | Number | false |TimeLineの対応済(1)/未済(0), null(9) |
| evaluateFinish | Number | false |食事5段階評価の対応済(1)/未済(0) |
| mealCommentFinish | Number | false | 食事アドバイスの対応済(2)/未済(0)/差戻し(1) |


#### success example

status:200

body:
```json
 {
    "content": [
        {
            "userId": 1,
            "userName": "user",
            "timeLineFinish": 0,
            "evaluateFinish": 0,
            "mealCommentFinish": 0
        }
    ],
    "size": 10,
    "number": 0,
    "firstPage": true,
    "lastPage": true,
    "totalPages": 1,
    "numberOfElements": 1,
    "totalElements": 1,
    "sort": null
}
```

## SUMMARY

担当管理栄養士名

## REQUEST

/api/adminusers/ke

## RESPONSE

### BODY

| name | type  | not null | description |
| ----- | -----| ----- | ----- |
| adminUserId | Number | true  | 管理者ユーザID |
| adminUserName | String | true  | 管理者名 |

#### success example

status:200

body:
```json
 
[
    {
        "adminUserId": 1,
        "adminUserName": "admin"
    }
]

```
