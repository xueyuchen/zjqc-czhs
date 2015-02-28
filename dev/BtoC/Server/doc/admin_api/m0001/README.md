# M0001 ログイン

## SUMMARY

login

## REQUEST

### URL
/api/login

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| username | String | true | ログインID  | "user" |
| password | String | true | パスワード | "123" |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type  | required | description |
| ----- | -----| ----- | ----- |
| adminUserId | Number | true | 管理者ユーザID   |
| loginId | Number | true | ログインID  |
| adminUserPhoto | String | false | ユーザ写真  |
| adminRoleKbn | String | true  | 管理者区分   |
| adminUserName | String | true | 管理者名 |

#### success example

status:200

body:
```json
    {
        "adminUserId": 1,
        "adminUserPhoto": null,
        "adminRoleKbn": "SU",
        "loginId": "admin",
        "adminUserName": "supper user"
    }
```

#### error example
status:401

body:
```json
    {
        "code": "e.ex.mm.1001",
        "message": "Username is not found."
    }
```
