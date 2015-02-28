# M0002 入金確認画面

## SUMMARY 01

M0002 入金確認検索画面

## REQUEST

### URL
/api/users/payment_status

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type  | required | description | example |
| ----- | -----| ----- | ----- | ----- |
| userId | Integer | false | 登録ID | 1 |
| userNameKanji | String | false | ユーザー名  | "usernamekanji" |
| userNameKana | String | false | ユーザー名（カナ）| "usernamekana" |
| applyDtStart | String | false | 申込み期間start | "yyyy-MM-dd HH:mm:SS" |
| applyDtEnd | String | false | 申込み期間end | "yyyy-MM-dd HH:mm:SS" |
| page | Integer | false | false | 1 |
| size | Integer | false | false | 1 |


## RESPONSE

### BODY

| name | type  | not null | description |
| ----- | -----| ----- | ----- |
| applyDt | String | true  | 申込日 |
| userId | Number | true | 登録ID |
| orderNum  | String| true | 注文番号 |
| email | String | true | メールアドレス |
| userNameKanji | String | true | ユーザー名 |
| userNameKana | String | true | ユーザー名（カナ） |
| statusKbn | String | true | 入金済(NC),未入金(NK),登録申請済み(SS) |


#### success example

status:200

body:
```json
 {
    "content": [
        {
            "applyDt": "2015/01/04",
            "userId": 1,
            "orderNum": "111",
            "email": "user@xxx.com",
            "userNameKanji": "user",
            "userNameKana": "user",
            "statuskbn": "NC"
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
## SUMMARY 02

M0002 キャンセル

## REQUEST

### URL
/api/users/cancel/{userId}

### METHOD

DELETE

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type  | required | description | example |
| ----- | -----| ----- | ----- | ----- |
| userId | Integer | true | 登録ID | 1 |

## RESPONSE

### BODY

| name | type  | description |
| ----- | -----| ----- |
| code | String | successfully paid  |

#### success example

status:200

```json
    {
      "code": "e.ex.mm.0000"
    }
```
