# M0033 管理者/栄養士の作成/編集


## SUMMARY

M0033 管理者/栄養士の作成


## REQUEST

### URL
/api/adminusers/{adminUserId}

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| adminUserId | Integer | true | -  | 1 |

 
 
## RESPONSE

### BODY

| name | type | required | description |
| ----- | ----- | -----| ----- |
| adminUserId | Number | true | 管理者ユーザID  |
| adminUserName | String | false | 管理者名 |
| loginId | Sting | true | ログインID   | 
| password | Sting | true | 密码   | 
| adminUserPhoto | String | true | 管理者写真ファイルパス  |




#### success example

status:200

body:
```json
        {
            "adminUserId": 10,
            "adminUserName": "bb",
             "adminRoleKbn": "KE",
             "loginId": "bb",
             "adminUserPhoto": "http://aaaa.jpg",
        }
```


* *  *

# M0033 管理者/栄養士の作成/編集


## SUMMARY

M0033 管理者/栄養士の作成


## REQUEST

### URL
/api/adminusers/create

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| password | Sting | true | パスワード  | sdasd |
| adminRoleKbn  | String | true | 管理者区分   SU：管理者 KE：管理栄養士 | KE |
| loginId | Sting | true | ログインID   | sdasd |
| adminUserName | Sting | true | 管理者名   | sdasd |
| adminUserImg | Byte | true | 管理者写真ファイルパス  | - |
 
 
## RESPONSE

### BODY

| name | type | required | description |
| ----- | ----- | -----| ----- |
| adminUserId | Number | true | 管理者ユーザID  |
| adminUserName | String | false | 管理者名 |
| loginId | Sting | true | ログインID   | 
| password | Sting | true | 密码   | 
| adminUserPhoto | String | true | 管理者写真ファイルパス  |




#### success example

status:200

body:
```json
        {
            "adminUserId": 10,
            "adminUserName": "bb",
             "adminRoleKbn": "KE",
             "loginId": "bb",
             "adminUserPhoto": "http://aaaa.jpg",
        }
```


* * *

## SUMMARY

M0033 管理者/栄養士の編集



## REQUEST

### URL
/api/adminusers/update

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| adminUserId | Number | true | 管理者ユーザID  | 2 |
| adminRoleKbn  | String | false | 管理者区分   SU：管理者 KE：管理栄養士 | KE |
| loginId | Sting | false | ログインID   | sdasd |
| adminUserName | Sting | false | 管理者名   | sdasd |
| adminUserPhoto | Byte | false | 管理者写真ファイルパス  | - |
 
 
## RESPONSE

### BODY

| name | type | required | description |
| ----- | ----- | -----| ----- |
| adminUserId | Number | true | 管理者ユーザID  |
| adminUserName | String | true | 管理者名 |
| adminUserPhoto | String | true | 管理者写真ファイルパス  |
| adminRoleKbn | String | true | -  |
| loginId | String | true | -  |



#### success example

status:200

body:
```json
        {
            "adminUserId": 10,
            "adminUserName": "bb",
             "adminRoleKbn": "KE",
             "loginId": "bb",
             "adminUserPhoto": "http://aaaa.jpg",
        }
```
