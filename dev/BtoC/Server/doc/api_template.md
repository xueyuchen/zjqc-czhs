# < API name >

## SUMMARY

< sumary >

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
| username | String | true | - | "user" |
| password | String | true | - | "123" |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |

### BODY

| name | type  | required | description |
| ----- | -----| ----- | ----- |
| code | String | true  |  -  |
| message | String | false |  -  |
| result | Object | false |  -  |
| result.userId | Number | false |  -  |
| result.userName | String | false |  -  |

#### success example

status:200

body:
```json
    {
        "code": "e.ex.mm.0000",
        "message": "正常終了",
        "result": {
            "userId":1,
            "userName":"user"
        }
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
