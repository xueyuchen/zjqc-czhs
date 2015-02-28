# M0006 カウンセリング予約状況-1

## SUMMARY

カウンセリング予約状況-1

## REQUEST

### URL
/api/reserves/date_statistics

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| date | String | true | 时间yyyy-MM-dd | "2014-12-01" |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |
| 401 |Unauthorized |
### BODY

| name | type|required  | description |
| ----- | -----| -----| ----- |
| workHour | String| true | 時間  |
| admins | Number | true | 出勤 |
| users | Number | true | 予約決定 |
| requests | Number | true | リクエスト予約 |

#### success example

status:200

body:
```json
[
    {
        "workHour": "09:00",
        "admins": 1,
        "users": 0,
        "requests": 0
    },
    {
        "workHour": "10:00",
        "admins": 2,
        "users": 1,
        "requests": 0
    },
    {
        "workHour": "11:00",
        "admins": 1,
        "users": 0,
        "requests": 0
    },
    {
        "workHour": "12:00",
        "admins": 1,
        "users": 1,
        "requests": 0
    },
    {
        "workHour": "13:00",
        "admins": 1,
        "users": 0,
        "requests": 0
    }
]
```

