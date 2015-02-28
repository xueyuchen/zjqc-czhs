# M0032 管理者/栄養士一覧

## SUMMARY

M0032 管理者/栄養士一覧

## REQUEST

### URL
/api/adminusers

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| page | Integer | true | 页 | 0 |
| size | Integer | true | 一页显示信息的条数 | 1 |


## RESPONSE

### BODY

| name | type | required | description |
| ----- | ----- | -----| ----- |
| adminUserId | Number | true | 管理者ユーザID  |
| adminUserName | String | true | 管理者名 |



#### success example

status:200

body:
```json
    {
        "content": [
            {
                "adminUserId": 9,
                "adminUserName": "aaa",
            },
            {
                "adminUserId": 10,
                "adminUserName": "bb",
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

* * *

# M0032 管理者/栄養士一覧(削除)

## SUMMARY

M0032 管理者/栄養士一覧(削除)

## REQUEST

### URL
/api/adminusers/{adminUserId}

### METHOD

DELETE

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| adminUserId | Integer | true | 营养师名 | 0 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type  | description |
| ----- | -----| ----- |
| adminUserId | Number | -  |
| adminRoleKbn | String | - |
| loginId | String | - |
| adminUserName | String | - |
| adminUserPhoto | String | - |
| delFlg | Number | - |

#### success example

status:200

body:
```json
    {
    "adminUserId": 3,
    "adminRoleKbn": "KE",
    "loginId": "222",
    "adminUserName": "二路营养师",
    "adminUserPhoto": null,
    "delFlg": 1
}
```

