# Common 获取当前登陆用户信息

## SUMMARY

获取当前登陆用户信息

## REQUEST

### URL
/api/adminusers/current

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

None

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type  | not ull | description |
| ----- | -----| ----- | ----- |
| loginId | Number | true | -  |
| adminUserPhoto | String | false | -  |
| adminRoleKbn | String | true  | -  |
| loginId | String |  true  |  -  |
| adminUserName | String | true | -  |

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
        "code": "e.ex.mm.1011",
        "message": "Access denied."
    }
```
