# M0024 動画一覧画面

## SUMMARY 01

動画list

## REQUEST

### URL

/api/movies/{groupKbn}

### METHOD

GET

### HEADERS
* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description |
|------|------|------|------|
| groupKbn  | String | true | 大分類区分(ET：食事),(SP：運動),(ST：その他) |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | not null | example |
| ----- | ----- | ----- | ----- |
| [n].movieId  | Integer | true | 1  |
| [n].groupKbn | String | true | "ET" |
| [n].movieName | String | true | "movie" |
| [n].moviePath | String | true | "c://ss.rm" |
| [n].movieDescription | String | false | "very good" |
| [n].creDt | String | true | "2012-12-12 22:22:22" |
| [n].updDt | String | true | "2012-12-12 22:22:22" |
| [n].creUserId | Integer | true | 1 |
| [n].updUserId | Integer | true | 1 |
| [n].delFlg | Integer | true | 0 |

#### success example

status:200

body:
```json
 
   [
      {
           "movieId": 1,
            "groupKbn": "ET",
            "movieName": "Harry",
            "moviePath": "c://ss.rm",
            "movieDescription": "good movie",
            "movieDescription": 0,
            "creDt": "2012-12-12 22:22:22",
            "updDt": "2012-12-12 22:22:22",
            "creUserId": 1,
            "updUserId": 1,
            "delFlg": 0
      }
   ]

```

## SUMMARY 02

削除

## REQUEST

### URL

/api/movies/{movieId}

### METHOD

DELETE

### HEADERS
* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description |
|------|------|------|------|
| movieId  | Integer | true | 削除動画ID |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | not null | example |
| ----- | ----- | ----- | ----- |
| code  | String | true | "e.ex.mm.0000"  |

#### success example

status:200

body:
```json
 {
    "code":"e.ex.mm.0000"
}
```
