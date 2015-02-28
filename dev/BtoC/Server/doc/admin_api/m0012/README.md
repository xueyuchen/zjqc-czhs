
# M0012 meals Time Line画面


## SUMMARY

Time Line画面


## REQUEST

### URL
/api/meals

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId| Integer | true | ユーザID | 1 |
| page | Integer | false| 页数 | 0 |
| size | Integer | false| - |限制条数 | 10 |
 
 
## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| ------- |----- |
| info| Array |  true | ユーザ |
| info.userId | Number|  true | ユーザID  |
| info.userName| String|  true | ユーザー名 |
| info.nikeName| String|  true | ニックネーム |
| content | Array |  false| 内容 |
| content[n].userMealComment| String | true | ユーザ食事コメント |
| content[n].mealId| Number | true | 食事ID |
| content[n].timeKbn| Date | true | 時間区分  |
| content[n].eatDt| Date | true | 食事日時  |
| content[n].imgs| Array| false| 食事写真 |
| content[n].imgs[n].imgId| Integer| true |食事写真id  |
| content[n].imgs[n].imgPath| String| true | 画像パス |
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
            "mealId": 1,
            "timeKbn": "BR",
            "imgs": [
                {
                    "imgId": 1,
                    "imgPath": "asdasd.jpg"
                }
            ],
            "eatDt": "2014-12-14 15:38"
        },
        {
            "mealId": 2,
            "timeKbn": "BR",
            "userMealComment":"adf",
            "imgs": [],
            "eatDt": "2014-12-13 15:38"
        },
        {
            "mealId": 3,
            "timeKbn": "BR",
            "userMealComment":"adf",
            "imgs": [],
            "eatDt": "2014-12-13 15:38"
        }
    ],
    "size": 10,
    "number": 0,
    "totalElements": 3,
    "sort": null,
    "totalPages": 1,
    "numberOfElements": 3,
    "firstPage": true,
    "lastPage": true
}
```

* * *


# M0012 meals


## SUMMARY

M0012 获取スタンプ和定型文


## REQUEST

### URL
/api/stampandfixedphrases

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
| fixedPhraseInfos| Array |  false | 定型文種類 |
| fixedPhraseInfos[n].fixedPhraseTypeId | Number|  true | 定型文種類id  |
| fixedPhraseInfos[n].fixedPhraseType| String|  true |定型文種類  |
| fixedPhraseInfos[n].fixedPhrases| array|  false | 定型文 |
| fixedPhraseInfos[n].fixedPhrases[n].fixedPhraseId| Integer|  true | 定型文id  |
| fixedPhraseInfos[n].fixedPhrases[n].fixedPhrase| String|  true | 定型文 |
| stampInfos | Array |  false| スタンプ |
| stampInfos[n].stampId| Number | true | スタンプid  |
| stampInfos[n].stampName| Date | true | スタンプ名  |
| stampInfos[n].stampImgPath| Date | true | スタンプ画像パス |


#### success example

status:200

body:
```json
{
    "fixedPhraseInfos": [
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
    ],
    "stampInfos": [
        {
            "stampId": 1,
            "stampName": "23123",
            "stampImgPath": "12312"
        }
    ]
}
```

* * *


# M0012 timeline评价


## SUMMARY

 timeline评价


## REQUEST

### URL
/api/timelines

### METHOD

post

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS
| name | type  | required | description |
| ----- | -----| ------- |----- |
| userId| Integer |  true | ユーザID  |
| adminUserId | Integer |  true | 管理者ユーザID  |
| stampId | Integer |  false | スタンプid |
| tlMessage | Integer |  false | タイムラインメッセージ |
 
## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| ------- |----- |
| code| String |  true | 编号 |
| message | String|  true | 内容 |



#### success example

status:200
body:
{
 "code":"0001",
 "message":"success"
}

* * *

## SUMMARY

Time Line画面()

## REQUEST

### URL
/api/timelines/{userId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type  | required | description |
| ----- | -----| ----- | ----- |
| lastCreTime | Number | false  | 上次查询最后一条的时间戳，第一次查询不需要 |
| userId | Number | true  | 用户ID |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |

### BODY

| name | type  | not null | description |
| ----- | -----| ----- | ----- |
| timeLines[n].mealId | Number | true  | 食事ID |
| timeLines[n].timeKbn | String | true | 時間区分 |
| timeLines[n].eatDt | String | true  | 食事日時 |
| timeLines[n].creDt | Number | true  | 作成日時 |
| timeLines[n].user.userId | Number | true | ユーザID |
| timeLines[n].user.nickName | String | true |  |
| timeLines[n].user.userImgPath | String | true | ユーザ写真ID |
| timeLines[n].ingestionFlg | Number | true  | 食事をしていないflg(1没吃、0吃了) |
| timeLines[n].userMealComment | String | true | NO.6 ユーザ食事コメント |
| timeLines[n].calorie | Number | true  | N0.4 カロリー |
| timeLines[n].imgs[n].imgId | Number | true  | NO.5 食事写真id |
| timeLines[n].imgs[n].imgUrl | String | true  | NO.5 画像パス |
| timeLines[n].modifyFlg | Number | true  | NO.3 是否能够编辑（0不能编辑、1可以编辑） |
| timelines[m].timeLineId | Number | true  | タイムラインid |
| timelines[m].creDt | Number | true  | NO.8 作成日時 |
| timelines[m].stamp.stampId | Number | true | スタンプid |
| timelines[m].stamp.stampName | String | true | NO.9 スタンプ名 |
| timelines[m].stamp.stampImgUrl | String | true | NO.9 スタンプ画像パス |
| timelines[m].tlMessage | String | true  | NO.9 タイムラインメッセージ |
| timelines[m].adminUser.adminUserId | Number | true | 管理者ユーザID |
| timelines[m].adminUser.adminUserPhoto | String | true  | NO.7 理者写真ファイルパス |
| timelines[m].adminUser.adminUserName | String | true | NO.8 管理者名 |
| timeLines[m].modifyFlg | Number | true  | NO.3 是否能够编辑（0不能编辑、1可以编辑） |
| timeLines[i].hurikaeriId | Number | false | 振返りid  |
| timeLines[i].hurikaeriDate | String | false |振返り日 |
| timeLines[i].user.userId | Number | true | ユーザID |
| timeLines[i].user.nickName | String | true |  |
| timeLines[i].user.userImgPath | String | true | ユーザ写真ID |
| timeLines[i].sleepTime | Number | false | 睡眠時間 |
| timeLines[i].creDt | Number | true  | 作成日時 |
| timeLines[i].hurikaeriComment | String | false | 振返りコメント |
| timeLines[i].items[n].itemType.hurikaeriItemNameId | Number | true | 振返り項目名id |
| timeLines[i].items[n].itemType.hurikaeriItemName | String | true | 振返り項目名 |
| timeLines[i].items[n].level | Number | true | 0:未設定,1:✕,2:△ ,3:○ | 
| timeLines[i].modifyFlg | Number | true  | NO.3 是否能够编辑（0不能编辑、1可以编辑） |
| lastCreTime | Number | true | 下一次查询条件 |   

#### success example

status:200

body:
```json
{
    "timeLines": [
        {
            "mealId": 524327,
            "timeKbn": "DN",
            "eatDt": "2015-01-29 17:04",
            "ingestionFlg": 0,
            "userMealComment": "test 1231",
            "calorie": 3000,
            "modifyFlg": 1,
            "creDt": "2015-01-29 17:04",
            "imgs": [
                {
                    "imgId": 516115,
                    "imgPath": "api/imgs/meal/c4838d50-cb59-4596-a55a-24a59cb87169.jpeg"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422518669113
        },
        {
            "mealId": 524326,
            "timeKbn": "LC",
            "eatDt": "2015-01-29 16:57",
            "ingestionFlg": 0,
            "userMealComment": "测试图片",
            "calorie": 5400,
            "modifyFlg": 1,
            "creDt": "2015-01-29 16:57",
            "imgs": [
                {
                    "imgId": 516114,
                    "imgPath": "api/imgs/meal/6e2a4dd4-9d09-406e-92f5-843db6278c25.png"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422518269213
        },
        {
            "hurikaeriId": 20009,
            "hurikaeriDate": "2015-01-28",
            "sleepTime": 270,
            "hurikaeriComment": "qwda111",
            "creDt": "2015-01-29 11:31",
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "modifyFlg": 1,
            "items": [
                {
                    "hurikaeriItemId": 1089,
                    "itemType": {
                        "hurikaeriItemNameId": 5,
                        "hurikaeriItemName": "食事の満足度"
                    },
                    "level": 1
                },
                {
                    "hurikaeriItemId": 1088,
                    "itemType": {
                        "hurikaeriItemNameId": 1001,
                        "hurikaeriItemName": "意欲"
                    },
                    "level": 3
                },
                {
                    "hurikaeriItemId": 1086,
                    "itemType": {
                        "hurikaeriItemNameId": 2,
                        "hurikaeriItemName": "お通じ"
                    },
                    "level": 1
                },
                {
                    "hurikaeriItemId": 1091,
                    "itemType": {
                        "hurikaeriItemNameId": 1,
                        "hurikaeriItemName": "睡眠の質"
                    },
                    "level": 1
                },
                {
                    "hurikaeriItemId": 1090,
                    "itemType": {
                        "hurikaeriItemNameId": 4,
                        "hurikaeriItemName": "疲労感"
                    },
                    "level": 3
                },
                {
                    "hurikaeriItemId": 1087,
                    "itemType": {
                        "hurikaeriItemNameId": 3,
                        "hurikaeriItemName": "全体的な気分"
                    },
                    "level": 2
                }
            ],
            "creatDt": 1422498687427
        },
        {
            "timeLineId": 1,
            "tlMessage": "tl_message1",
            "creDt": "2015-01-29 01:00",
            "stamp": {
                "stampId": 2,
                "stampName": "stamp2",
                "stampImgPath": "api/imgs/stamp/3.png"
            },
            "adminUser": {
                "adminUserId": 2,
                "adminRoleKbn": "KE",
                "loginId": "admin1",
                "adminUserName": "admin_user22me1",
                "adminUserPhoto": "api/imgs/admin/08a10d48-7d93-4c11-98c2-20af4409cfe0.jpg"
            },
            "creatDt": 1422460800000
        },
        {
            "mealId": 524322,
            "timeKbn": "BR",
            "eatDt": "2014-12-28 21:52",
            "ingestionFlg": 0,
            "userMealComment": "",
            "calorie": 0,
            "modifyFlg": 0,
            "creDt": "2015-01-28 21:46",
            "imgs": [
                {
                    "imgId": 516110,
                    "imgPath": "api/imgs/meal/f4c0d58e-520b-40c7-844c-9a322253b912.jpeg"
                },
                {
                    "imgId": 516108,
                    "imgPath": "api/imgs/meal/e67aa06d-479a-4f65-92e9-8e0d8b532340.jpeg"
                },
                {
                    "imgId": 516109,
                    "imgPath": "api/imgs/meal/60524443-152e-4298-9ca6-1ecf6bc178c8.jpeg"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422449215780
        },
        {
            "hurikaeriId": 1005,
            "hurikaeriDate": "2015-01-27",
            "sleepTime": 0,
            "hurikaeriComment": "",
            "creDt": "2015-01-28 18:34",
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "modifyFlg": 0,
            "items": [
                {
                    "hurikaeriItemId": 1017,
                    "itemType": {
                        "hurikaeriItemNameId": 1,
                        "hurikaeriItemName": "睡眠の質"
                    },
                    "level": 0
                },
                {
                    "hurikaeriItemId": 1021,
                    "itemType": {
                        "hurikaeriItemNameId": 4,
                        "hurikaeriItemName": "疲労感"
                    },
                    "level": 0
                },
                {
                    "hurikaeriItemId": 1020,
                    "itemType": {
                        "hurikaeriItemNameId": 3,
                        "hurikaeriItemName": "全体的な気分"
                    },
                    "level": 0
                },
                {
                    "hurikaeriItemId": 1018,
                    "itemType": {
                        "hurikaeriItemNameId": 5,
                        "hurikaeriItemName": "食事の満足度"
                    },
                    "level": 0
                },
                {
                    "hurikaeriItemId": 1019,
                    "itemType": {
                        "hurikaeriItemNameId": 2,
                        "hurikaeriItemName": "お通じ"
                    },
                    "level": 0
                }
            ],
            "creatDt": 1422437658677
        },
        {
            "mealId": 524320,
            "timeKbn": "BR",
            "eatDt": "2014-12-28 21:29",
            "ingestionFlg": 0,
            "userMealComment": "",
            "calorie": 0,
            "modifyFlg": 0,
            "creDt": "2015-01-28 16:28",
            "imgs": [
                {
                    "imgId": 516106,
                    "imgPath": "api/imgs/meal/e4551d9f-7ed7-400a-a37f-b25958f195ba.jpeg"
                },
                {
                    "imgId": 516107,
                    "imgPath": "api/imgs/meal/070ec927-493c-44e9-bee6-ec705215d975.jpeg"
                },
                {
                    "imgId": 516104,
                    "imgPath": "api/imgs/meal/f804f856-ff1c-4f81-af82-c5b6c770abdc.jpeg"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422430131127
        },
        {
            "mealId": 524319,
            "timeKbn": "BR",
            "eatDt": "2014-12-28 16:18",
            "ingestionFlg": 0,
            "userMealComment": "4321",
            "calorie": 4321,
            "modifyFlg": 0,
            "creDt": "2015-01-28 16:13",
            "imgs": [
                {
                    "imgId": 516102,
                    "imgPath": "api/imgs/meal/3e2c3fe1-91b4-4a16-8bf8-4e660f4979f3.jpeg"
                },
                {
                    "imgId": 516103,
                    "imgPath": "api/imgs/meal/db7bf361-c277-4b53-95b6-9f73d55975db.jpeg"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422429222213
        },
        {
            "mealId": 524314,
            "timeKbn": "BR",
            "eatDt": "2014-12-28 18:08",
            "ingestionFlg": 0,
            "userMealComment": "",
            "calorie": 0,
            "modifyFlg": 0,
            "creDt": "2015-01-27 18:05",
            "imgs": [
                {
                    "imgId": 516096,
                    "imgPath": "api/imgs/meal/1c1f5c45-31d9-4e9c-9f4f-6ff2ab24a10f.jpeg"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422349521847
        },
        {
            "mealId": 524312,
            "timeKbn": "BR",
            "eatDt": "2014-12-28 17:11",
            "ingestionFlg": 0,
            "userMealComment": "",
            "calorie": 0,
            "modifyFlg": 0,
            "creDt": "2015-01-27 17:06",
            "imgs": [
                {
                    "imgId": 516091,
                    "imgPath": "api/imgs/meal/56746914-23d3-4a6d-86bb-189f9594d7f7.jpeg"
                },
                {
                    "imgId": 516090,
                    "imgPath": "api/imgs/meal/6bf878cc-a41a-4f52-8d31-a57034c686c4.jpeg"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422346017480
        },
        {
            "mealId": 524311,
            "timeKbn": "BR",
            "eatDt": "2014-12-28 16:59",
            "ingestionFlg": 0,
            "userMealComment": "",
            "calorie": 0,
            "modifyFlg": 0,
            "creDt": "2015-01-27 17:00",
            "imgs": [
                {
                    "imgId": 516085,
                    "imgPath": "api/imgs/meal/edaea854-c862-489c-8d3b-8f220ab0617f.jpeg"
                },
                {
                    "imgId": 516089,
                    "imgPath": "api/imgs/meal/11edfdde-852f-4a98-9cb4-03d6e4d4b6d2.jpeg"
                },
                {
                    "imgId": 516088,
                    "imgPath": "api/imgs/meal/20739922-5775-4be6-a004-d7cb13c42d24.jpeg"
                },
                {
                    "imgId": 516086,
                    "imgPath": "api/imgs/meal/434040ac-1252-4a3d-948e-75c0b367e18f.jpeg"
                },
                {
                    "imgId": 516087,
                    "imgPath": "api/imgs/meal/45e83ab0-03ac-4b1d-8b08-27fa5f6995d9.jpeg"
                }
            ],
            "user": {
                "userId": 2,
                "nickName": "nick_name2",
                "userImgPath": "api/imgs/user/4.png"
            },
            "creatDt": 1422345630600
        }
    ],
    "lastCreTime": 1422345630600
}
```
