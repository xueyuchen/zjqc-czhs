# M0015 食事コメント評価済/未済一覧画面

## SUMMARY

 M0015 食事コメント評価済/未済一覧画面

## REQUEST

### URL
/api/mealcomments/user/{userId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true |ユーザID  | 1 |
| page | Integer | false | 页| 1 |
| size | Integer | false | 限制条数 | 1 |


## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| -------| ----- |
| info| Array |  true | ユーザ |
| info.userId | Number|  true | ユーザID  |
| info.userName| String|  true | ユーザー名 |
| info.nikeName| String|  true | ニックネーム |
| content | Array | false | 内容  |
| content[n].mealCommentId | true| Number | 食事コメントID   |
| content[n].fromDt | Date | true| コメント対象開始日  yyyy-MM-dd |
| content[n].endDt | Date | true |コメント対象終了日 yyyy-MM-dd |
| content[n].status | Number | true | 処理ステータス 0:未済 1:済 2:回退 |
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
    "info": {
      "userId": 1,
      "name": "mmm",
      "nickName": "ddxxx"
    },
    "content": [
        {
            "mealCommentId": 9,
            "fromDt": "2014-12-07",
            "endDt": "2014-12-14",
            "status": 0
        },
        {
            "mealCommentId": 3,
            "fromDt": "2014-12-07",
            "endDt": "2014-12-14",
            "status": 0
        }
    ],
    "size": 10,
    "number": 0,
    "sort": null,
    "totalElements": 2,
    "totalPages": 1,
    "numberOfElements": 2,
    "firstPage": true,
    "lastPage": true
}
```


