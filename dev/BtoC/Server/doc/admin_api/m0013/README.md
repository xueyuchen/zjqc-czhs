# M0013  食事評価済/未済一覧画面

## SUMMARY

M0013  食事評価済/未済一覧画面

## REQUEST

### URL
/api/evaluates

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| userId | Integer | true | ユーザID | 1 |
| page | Integer | false | 页 | 1 |
| size | Integer | false | 限制条数 | 1 |


## RESPONSE

### BODY

| name | type  | required | description |
| ----- | -----| ------ | ----- |
| content | Array |  false | 内容  |
| content[n].evaluateId | Number | true |  評価id   |
| content[n].evelDate | Date | true | 評価対象日 yyyy-MM-dd |
| content[n].status | Number | true | 処理ステータス 0:未済 1:済 |
| info | Object | true |  ユーザ   |
| info.userId | Number | true |  ユーザID    |
| info.name | String | true |  ユーザー名   |
| info.nickName | String | true |  ニックネーム  |
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
            "evaluateId": 1,
            "evelDate": "2014-12-14",
            "status": 0
        },
        {
            "evaluateId": 2,
            "evelDate": "2014-12-13",
            "status": 1
        },
        {
            "evaluateId": 3,
            "evelDate": "2014-12-12",
            "status": 1
        },
        {
            "evaluateId": 9,
            "evelDate": "2014-12-11",
            "status": 1
        }
    ],
    "info": {
        "userId": 1,
        "name": "aabb",
        "nikeName": "abcd"
    },
    "size": 10,
    "number": 0,
    "firstPage": true,
    "lastPage": true,
    "totalPages": 1,
    "numberOfElements": 4,
    "sort": null,
    "totalElements": 4
}
```


