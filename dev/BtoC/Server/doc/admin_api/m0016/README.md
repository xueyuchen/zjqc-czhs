# M0016 食事アドバイス画面

## SUMMARY
食事アドバイス画面
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
| mealCommentId | Numrber | true | 食事コメントID   |
| approvalSts | Numrber | false | 承認flg   |
| mealComment | String | false | 食事コメント  |
| userId | Number | true | ユーザID  |
| userName | String | true  | ユーザー名 |
| fromDate | Date | true  | コメント対象開始日  |
| nickName | String | true  | ニックネーム |
| mealDatas | Array | true | 长度为7的数组，分别为周一到周日的就餐情况 |
| mealDatas[n].mealId | Number | true | 食事ID  |
| mealDatas[n].timeKbn | String | true | 時間区分 BR：朝食 LC：昼食 DN：夕食 KS：間食 |
| mealDatas[n].eatDt | String | false | 食事日時(为null时表示没有吃) |
| mealDatas[n].imgs | Array | false | 食事写真 |
| mealDatas[n].imgs[n].imgId | Number | true | 食事写真id  |
| mealDatas[n].imgs[n].imgPath | String | true | 画像パス  |

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
    "mealComment": null,
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
--------------------------------------------------------------------------------------------------------------

# M0016


## SUMMARY

M0012 get  fixedphrases


## REQUEST

### URL
/api/fixedphrasetypes/details

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS
 
 
## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| ------- |----- |
| [n].fixedPhraseTypeId | Number|  true | 定型文種類id  |
| [n].fixedPhraseType| String|  true | 定型文種類  |
| [n].fixedPhrases| array|  false | 定型文 |
| [n].fixedPhrases[n].fixedPhraseId| Integer|  true | 定型文id  |
| [n].fixedPhrases[n].fixedPhrase| String|  true | 定型文  |



#### success example

status:200

body:
```json

     [
        {
            "fixedPhraseTypeId": 1,
            "fixedPhraseType": "223",
            "fixedPhrases": [
                {
                    "fixedPhraseId": 1,
                    "fixedPhrase": "qw"
                }
            ]
        },
        {
            "fixedPhraseTypeId": 3,
            "fixedPhraseType": "555",
            "fixedPhrases": []
        },
        {
            "fixedPhraseTypeId": 4,
            "fixedPhraseType": "modify-4",
            "fixedPhrases": []
        },
        {
            "fixedPhraseTypeId": 5,
            "fixedPhraseType": "777",
            "fixedPhrases": []
        },
        {
            "fixedPhraseTypeId": 6,
            "fixedPhraseType": "888",
            "fixedPhrases": []
        },
        {
            "fixedPhraseTypeId": 7,
            "fixedPhraseType": "999",
            "fixedPhrases": []
        },
        {
            "fixedPhraseTypeId": 8,
            "fixedPhraseType": "saveNew",
            "fixedPhrases": []
        }
    ]
```

* * *
-------------------------------------------------------------------------------------------------------

# M0016


## SUMMARY

M0012 get  fixedphrases


## REQUEST

### URL
/api/mealcomments

### METHOD

post

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS
| name | type  | required | description |
| ----- | -----| ------- |----- |
| mealCommentId | Number|  true | 食事コメントID  |
| mealComment | String|  true | 食事コメント  |
 
## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| ------- |----- |
| mealCommentId | String|  true | 食事コメントID  |
| adminUserId | Number|  true | 管理者ユーザID  |
| userId | Number|  true | ユーザID  |
| mealComment | Number|  true | 食事コメント  |
| approvalSts | Number|  true | 承認ステータス  |
| approvalDt | Number|  true | 承認日 yyyy-MM-dd |
| commentDt | Number|  true | コメント日時 yyyy-MM-dd HH:mm |
| fromDate | Date|  true | コメント対象開始日 yyyy-MM-dd |


#### success example

```
{
    "mealCommentId": 1,
    "userId": 1,
    "adminUserId": 1,
    "mealComment": "good",
    "approvalSts": 1,
    "approvalDt": "2014-12-25",
    "commentDt": "2014-12-26 15:46",
    "fromDate": "2014-12-01"
}
```
