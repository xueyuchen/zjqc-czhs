# m0034 ユーザー個人情報

## SUMMARY

 ユーザー個人情報

## REQUEST

### URL

/api/users/detailes/{userId}

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID  | 1 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| userId | Integer | true |  	ユーザID |
| lastNameKanji | String | true | 姓（漢字） |
| firstNameKana | String | true | 姓（カナ） |
| firstNameKanji | String | true | 名（漢字） |
| lastNameKana | String | true | 名（カナ） |
| namekanji | String | true | 姓名（漢字） |
| namekana | String | true | 姓名（カナ） |
| nikeName | String | true | ニックネーム |
| examId | String | true | 大分類区分  |
| birthday | String | true | 誕生日 |
| sex | String | true | 性別 |
| loginId | String | true |	ログインID |
| prefecture | String | true | 都道府県 |
| address1 | String | true | 市区町村 |
| address2 | String | true | 番地以下 |
| phoneNumber | String | true | 電話番号（ハイフン付き） |
| detailedAddr | String | true | 住所 |

#### success example

status:200

body:
```json
{
    "userId": 1,
    "lastNameKanji": "xi",
    "firstNameKanji": "gua",
    "firstNameKana": "シ",
    "lastNameKana": "グア",
    "namekanji": "xi gua",
    "namekana": "グア シ",
    "nikeName": "西瓜",
    "examId": null,
    "birthday": "1999-09-09",
    "sex": 1,
    "loginId": "water",
    "prefecture": null,
    "address1": null,
    "address2": null,
    "phoneNumber": null,
    "detailedAddr": "null null null"
}
```
* * *
