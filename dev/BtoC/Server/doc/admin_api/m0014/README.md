# M0014  食事4段階評価

## SUMMARY

食事4段階評価

## REQUEST

### URL
/api/meals/date

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID  | 1 |
| eatDt | Date | true | 食事日時 | 1 |


## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| ------ | ----- |
| meals | Array | false |  食事   |
| meals[n].mealId | Number | true |  食事ID   |
| meals[n].timeKbn | String | true | 時間区分 BR：朝食 LC：昼食 DN：夕食 KS：間食|
| meals[n].imgs | Array | false | 食事写真 |
| meals[n].imgs[n].imgId | Number | true |  食事写真id    |
| meals[n].imgs[n].imgPath | String | true | 画像パス |
| meals[n].eatDt | Date | true | 食事日時 HH:mm |
| evaluateDetailOutput | Object | false | 食事4段階評価 |
| evaluateId | Number | true | 評価id   | 
| evalMeet | Number | true | 評価値_肉  | 
| evalFish | Number | true | 評価値_魚  | 
| evalFruit | Number | true | 評価値_果物  |
| evalVegetables | Number | true | 評価値_野菜  |
| evalCarbohydrate | Number | true | 評価値_炭水化物 |




#### success example

status:200

body:
```json
{
    "meals": [
        {
            "mealId": 102,
            "timeKbn": "DN",
            "ingestionFlg": 0,
            "imgs": [
            {
                "imgId": 2,
                "imgPath": "bbb.jpg"
            }
            ],
            "eatDt": "00:00"
        },
        {
            "mealId": 180102,
            "timeKbn": "DN",
            "ingestionFlg": 0,
            "imgs": [],
            "eatDt": "00:00"
        },
        {
            "mealId": 360102,
            "timeKbn": "DN",
            "ingestionFlg": 0,
            "imgs": [
            {
                "imgId": 2,
                "imgPath": "bbb.jpg"
            }
            ],
            "eatDt": "00:00"
        }
    ],
    "evaluateDetailOutput": {
        "evaluateId": 12919,
        "evalQuantity": 1,
        "evalBalance": 1,
        "evalFat": 1,
        "evalGlycolipid": 1,
        "evalTime": 1
    }
}
```


* * *

# M0014  食事5段階評価

## SUMMARY

食事5段階評価

## REQUEST

### URL
/api/evaluates

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| eatDt | Date | true | 食事日時 yyyy-MM-dd  | 1 |
| userId | Integer | true | ユーザID   | 1 |
| evalMeet | Integer | true | 評価値_肉  | 1 |
| evalFish | Integer | true | 評価値_魚  | 1 |
| evalFruit | Integer | true | 評価値_果物  | 1 |
| evalVegetables | Integer | true | 評価値_野菜  | 1 |
| evalCarbohydrate | Integer | true | 評価値_炭水化物 | 1 |


## RESPONSE

### BODY

| name | type | required | description | 
|----- | -----| ----- | ----- | 
| evaluateId | Number | true | 評価id  | 
| userId | Date | true | ユーザID | 
| adminUserId | Number | true | 管理者ユーザID |
| evalQuantity | Number | true | 評価値_食事量   | 
| evalBalance | Number | true | 評価値_栄養バランス   | 
| evalFat | Number | true | 評価値_脂質  | 
| evalGlycolipid | Number | true | 評価値_糖質   | 
| evalTime | Number | true | 評価値_時間 |
| evelDate | Date | true | 評価対象日  |
| evalDt | Date | true | 評価日時  |

#### success example

status:200

body:
```json
{
    "evaluateId":1,
    "userId":1,
    "adminUserId":1,
    "evalQuantity":1,
    "evalBalance":1,
    "evalFat":1,
    "evalGlycolipid":1,
    "evalTime":1,
    "evelDate":"2014-12-25",
    "evalDt":"2014-12-25 14:05"
}
```


