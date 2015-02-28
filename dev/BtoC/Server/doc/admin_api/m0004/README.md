# M0004 ユーザー食事写真

## SUMMARY

## REQUEST

### URL
/api/mealcomments/{mealCommentId}

### METHOD

get

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| mealCommentId | Integer | true | 食事コメントID  | 13 |



## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type | required | description 
|----- | -----| ----- | ----- | -----|
| mealCommentId | Numrber | true | 食事コメントID|
| approvalSts | Numrber | true | 承認flg   |
| mealComment | String | true | 食事コメント  |
| userId | Number | true | ユーザID  |
| userName | String | true  | ユーザー名 |
| fromDate | Date | true  | コメント対象開始日  |
| nickName | String | true  | ニックネーム |
| mealDatas | Array | true | 长度为7的数组，分别为周一到周日的就餐情况 |
| mealDatas[n] | Array | true | 一天中，每餐的饮食情况 |
| mealDatas[n][n].mealId | Number | true | 食事ID  |
| mealDatas[n][n].timeKbn | String | true | 時間区分 BR：朝食 LC：昼食 DN：夕食 KS：間食 |
| mealDatas[n][n].eatDt | String | false | 食事日時(为null时表示没有吃) |
| mealDatas[n][n].imgs | Array | false | 食事写真 |
| mealDatas[n][n].imgs[n].imgId | Number | true | 食事写真id  |
| mealDatas[n][n].imgs[n].imgPath | String | true | 画像パス  |



#### success example

status:200

body:
```json
 {
    "mealCommentId": 2,
    "userId": 1,
    "userName": "xigua",
    "fromDate": "2014-12-15",
     "nickName": "西瓜",
    "approvalSts": 1,
    "mealComment": "good",
    "mealDatas": [
        [],
        [],
        [],
        [],
        [],
        [],
        [
            {
                "mealId": 2,
                "timeKbn": "BR",
                "imgs": [
                    {
                        "imgId": 8,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 4,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 5,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 7,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 6,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    }
                ],
                "eatDt": "09:38"
            },
            {
                "mealId": 3,
                "timeKbn": "LC",
                "imgs": [
                    {
                        "imgId": 12,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 11,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 9,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 13,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    },
                    {
                        "imgId": 10,
                        "imgPath": "http://localhost:8080/diet-web-admin/logo_s.png"
                    }
                ],
                "eatDt": "12:38"
            }
        ]
    ]
}
```

* * *

## SUMMARY

## REQUEST

### URL
/api/mealcomments/{mealCommentId}

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| mealCommentId | Integer | true | 食事コメントID  | 13 |
| approvalSts | Integer | true | 承認ステータス 1：济 2：回退   | 0 |



## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type  | required | description |
| ----- | -----| ----- | ----- |
| mealCommentId | Numrber | true | 食事コメントID   |
| adminUserId | Numrber | true| 管理者ユーザID  |
| mealComment | String | true| 食事コメント  |
| commentDt | Date | true| 食事コメント yyyy-MM-dd HH:mm |
| userId | Number | true| ユーザID  |
| approvalSts | String | true|  承認ステータス 0:未济 1：济 2：回退    |
| approvalDt | String | true |  承認日 yyyy-MM-dd |
| fromDate | String | true | コメント対象開始日 yyyy-MM-dd |

#### success example

status:200

body:
```json
{
    "mealCommentId": 2,
    "userId": 1,
    "adminUserId": 1,
    "mealComment": "12",
    "approvalSts": 2,
    "approvalDt": "2014-12-25",
    "commentDt": "2014-12-25 16:52",
    "fromDate": "2014-12-08"
}
```
