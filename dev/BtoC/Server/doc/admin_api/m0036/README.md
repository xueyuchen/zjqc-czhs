# M0036食事アドバイス評価済/未済一覧

## SUMMARY

  M0036食事アドバイス評価済/未済一覧

## REQUEST

### URL
/api/mealcomments/userinfo/{userId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID  | 1 |
| page | Integer | true | 页 | 1 |
| size | Integer | true | 限制条数 | 1 |


## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| ------- |----- |
| content | Array |  true | 内容 |
| content[n].mealCommentId | Number | true | 食事コメントID   |
| content[n].fromDate | Date | true | 投稿期間(开始时间) yyyy-MM-dd HH:mm |
| content[n].endDate | Date | true | 投稿期間(结束时间)  yyyy-MM-dd HH:mm |
| content[n].status | Number | true | 0:未処理 1:処理済み 2:差戻し |
| info | Object | true | ユーザ |
| info.userId | Number | true | 0:未济 1:济 2:退回 |
| info.name | String | false | ユーザー名 |
| info.nikeName | String | true | ニックネーム | 
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
            "mealCommentId": 1,
            "fromDate": "2014-12-01",
            "endDate": "2014-12-07",
            "status": 0
        },
        {
            "mealCommentId": 2,
            "fromDate": "2014-12-08",
            "endDate": "2014-12-14",
            "status": 1
        }
    ],
    "info": {
        "userId": 1,
        "name": "xigua",
        "nikeName": "西瓜"
    },
    "size": 10,
    "number": 0,
    "sort": null,
    "totalPages": 1,
    "numberOfElements": 2,
    "firstPage": true,
    "lastPage": true,
    "totalElements": 2
}
```


