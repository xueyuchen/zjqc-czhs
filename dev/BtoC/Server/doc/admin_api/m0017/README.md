# M0017食事記録閲覧画面

## SUMMARY
食事記録閲覧画面

## REQUEST

### URL
/api/mealcomments/detail

### METHOD

get

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID  | 13 |
| fromDate | Integer | true | コメント対象開始日 yyyy-MM-dd | 2014-12-12 |
| status | Integer | true | 状态 0：当前周 1：下一周 2：上一周  | 0 |

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
| mealDatas[n][n].mealId | Number | false | 食事ID  |
| mealDatas[n][n].timeKbn | String | true | 時間区分 BR：朝食 LC：昼食 DN：夕食 KS：間食 |
| mealDatas[n][n].eatDt | String | false | 食事日時(为null时表示没有吃) |
| mealDatas[n][n].imgs | Array | false | 食事写真 |
| mealDatas[n][n].imgs[n].imgId | Number | true | 食事写真id  |
| mealDatas[n][n].imgs[n].imgPath | String | true | 画像パス  |
| evaluates | array | false | 食事評価 |
| evaluates[n].evaluateId | Number | true | 評価id |
| evaluates[n].evalQuantity | Number | true | 評価値_食事量  |
| evaluates[n].evalBalance | Number | true | 評価値_栄養バランス |
| evaluates[n].evalFat | Number | true | 評価値_脂質  |
| evaluates[n].evalGlycolipid | Number | true | 評価値_糖質  |
| evaluates[n].evalTime | Number | true | 評価値_時間  |


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
    "approvalSts": 2,
    "mealComment": "12",
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
                "timeKbn": "NR",
                "ingestionFlg": 0,
                "imgs": [],
                "eatDt": "15:38"
            },
            {
                "mealId": 3,
                "timeKbn": "DR",
                "ingestionFlg": 0,
                "imgs": [],
                "eatDt": "15:38"
            }
        ]
    ],
    "evaluates": [
        {
            "evaluateId": 6,
            "evalQuantity": 1,
            "evalBalance": 1,
            "evalFat": 1,
            "evalGlycolipid": 1,
            "evalTime": 1
        }
    ]
}
```

