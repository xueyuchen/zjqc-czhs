
# M0005 遺伝子検体管理

## SUMMARY-01

遺伝子検体管理 - 查询

## REQUEST

### URL

/api/exams

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| statusKbn | String | true | 検査状態区分 | "KS" |
| fromDt  | String | false | 投稿期間始 | "2014-12-23" |
| toDt  | String | false | 投稿期間终 | "2014-12-30" |

## RESPONSE

## BODY(带分页信息)

| name | type|required  | description |
| ----- | -----|-----| ----- |
| content[n].userId | Number | true | ユーザID |
| content[n].firstNameKaji | String | true | 名（漢字） |
| content[n].lastNameKaji | String | true | 姓（漢字） |
| content[n].firstNameKana | String|true | 姓（カナ） |
| content[n].lastNameKana | String|true | 名（カナ） |
| content[n].examId | Number | false | 遺伝子検体ID |
| content[n].examNo | String | true | 検体番号 |
| content[n].email | String| true | メールアドレス |
| content[n].updDt | String| true | 検査状態更新日時  |
| content[n].statusKbn | String| true | 検査状態区分  |
| content[n].applyDt | String| true | 申請日  |
| content[n].receiptDt | String| true | 検査結果受信日  |
| content[n].examDt | String| true | 検体結果入力日  |
| content[n].statusKbnChangeDt | String| true | 検査状態区分変更日時  |

#### success example

```json
{
    "content": [
        {
            "lastNameKanji": "二房",
            "firstNameKanji": "姑娘",
            "firstNameKana": "guniang",
            "lastNameKana": "erfang",
            "email": "abc@x.com",
            "examNo": 510104208,
            "updDt": "2014-12-23 11:57",
            "statusKbn": "KS",
            "examId": 11,
            "applyDt": "2014-12-07",
            "receiptDt": "2014-12-13",
            "examDt": null,
            "userId": 10, 
            "statusKbnChangeDt": "2014-12-23 11:57"
        },
        {
            "lastNameKanji": "粉色",
            "firstNameKanji": "诱惑",
            "firstNameKana": "youhua",
            "lastNameKana": "fense",
            "email": "abc@x.com",
            "examNo": 510104209,
            "updDt": "2014-12-23 11:57",
            "statusKbn": "KS",
            "examId": 12,
            "applyDt": "2014-12-06",
            "receiptDt": "2014-12-12",
            "examDt": null,
            "userId": 11, 
            "statusKbnChangeDt": "2014-12-23 11:57"
        }
    ],
    "size": 20,
    "number": 0,
    "totalElements": 2,
    "numberOfElements": 2,
    "sort": null,
    "lastPage": true,
    "firstPage": true,
    "totalPages": 1
}
```

* * *

## SUMMARY-02

遺伝子検体管理 - 创建

## REQUEST

### URL
/api/exams

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId  | Number | true | ユーザID | 11 |
| examNo | String | true | 検体番号 | "5000233" |

## RESPONSE

## BODY

| name | type|required  | description |
| ----- | -----|-----| ----- |
| userId | Number | true | ユーザID |
| applyDt | String | true | 申請日 |
| receiptDt | String | true | 検査結果受信日 |
| examDt | String|true | 検体結果入力日 |
| examId | Number | false | 遺伝子検体ID |
| examNo | String | true | 検体番号  |
| statusKbn | String| true | 検査状態区分  |

#### success example

```json
{
    "examNo": 5000233,
    "examId": 13,
    "userId": 11,
    "statusKbn": "SE",
    "applyDt": "2014-12-23",
    "receiptDt": null,
    "examDt": null
}
```

## SUMMARY-03

遺伝子検体管理 - 更新

## REQUEST

### URL
/api/exams/{examId}

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| examId | Number | true | 遺伝子検体ID | 13 |
| statusKbn | String | true | 検査状態区分 | "SE" |
| examNo | Integer | false | 検体番号 | "5101041999" |

## RESPONSE

## BODY

| name | type|required  | description |
| ----- | -----|-----| ----- |
| userId | Number | true | ユーザID |
| applyDt | String | true | 申請日 |
| receiptDt | String | true | 検査結果受信日 |
| examDt | String|true | 検体結果入力日 |
| examId | Number | false | 遺伝子検体ID |
| examNo | String | true | 検体番号  |
| statusKbn | String| true | 検査状態区分  |

#### success example

```json
{
    "examNo": 5101041999,
    "examId": 13,
    "userId": 11,
    "statusKbn": "KT",
    "applyDt": "2014-12-23",
    "receiptDt": null,
    "examDt": null
}
```
