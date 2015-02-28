# M0003 ユーザー検索（承認用）画面

## SUMMARY

ユーザー検索（承認用）画面

## REQUEST

### URL
/api/mealcomments

### METHOD

get

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | String | false | ログインID | "123123" |
| userName | String | false | ユーザー名 | "123" |
| userNameKana | String | false | ユーザー名（カナ）| "usernamekana" |
| examNo | Integer | false | 遺伝子検体No.(长度为8) | 123 |
| startDate | Date | false | コメント対象開始日 yyyy-MM-dd | "2014-11-03" |
| endDate | Date | false | コメント対象終了日 yyyy-MM-dd | "2014-11-05" |
| approvalStss[]  | Array | false | 処理ステータス検索条件 | [1,2] |
| size  | Integer | true | 限制条数 | 10 |
| page  | Integer | true |  页数 | 0 |




## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type | required  | description |
| ----- | -----| ------ | ----- |
| content | Array |  true | 内容  |
| content[n].userId | Numrber | true | ユーザID  |
| content[n].loginId | String | true | ログインID  |
| content[n].userName | String | true | ユーザー名  |
| content[n].status | Number | true | 承認ステータス 0:未济 1：济 2：回退  |
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
            "userId": 1,
            "loginId": "water",
            "userName": "xigua",
            "status": 0
        },
        {
            "userId": 9,
            "loginId": "u666",
            "userName": "阿哥邮件",
            "status": 2
        },
        {
            "userId": 6,
            "loginId": "u333",
            "userName": "黄瓜东方",
            "status": 2
        },
        {
            "userId": 3,
            "loginId": "u000",
            "userName": "雁荡风吹",
            "status": 1
        }
    ],
    "size": 10,
    "number": 0,
    "sort": null,
    "totalPages": 1,
    "numberOfElements": 4,
    "totalElements": 4,
    "firstPage": true,
    "lastPage": true
}
```

