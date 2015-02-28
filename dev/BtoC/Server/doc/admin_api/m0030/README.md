# M0030 動画の作成/編集画面

## SUMMARY

動画の作成/編集画面

## REQUEST

### URL

/api/movies

### METHOD

POST

### HEADERS

* Content-Type=application/form-data
* Accept=application/json

### PARAMS

| name | type | required | description |
|------|------|------|------|
| movieId  | Integer | false | 編集movie |
| groupKbn  | String | true | 大分類区分(ET：食事),(SP：運動),(ST：その他) |
| movie  | MultipartFile | true | 動画のアップロード |
| movieName  | String | true | 動画名 |
| movieDescription  | String | false | 動画説明 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | not null | example |
| ----- | ----- | ----- | ----- |
| movieId  | Integer | true | 1  |
| groupKbn | String | true | "ET" |
| movieName | String | true | "movie" |
| moviePath | String | true | "c://ss.rm" |
| movieDescription | String | false | "very good" |
| creDt | String | true | "2012-12-12 22:22:22" |
| updDt | String | true | "2012-12-12 22:22:22" |
| creUserId | Integer | true | 1 |
| updUserId | Integer | true | 1 |
| delFlg | Integer | true | 0 |

#### success example

status:200

body:
```json
{
      "movieId":"1",
      "groupKbn":"ET",
      "movieName":"name",
      "moviePath":"c://",
      "movieDescription":"hehe",
      "creDt":"2012-12-12 22:22:22",
      "updDt":"2012-12-12 22:22:22",
      "creUserId":"1",
      "updUserId":"1",
      "delFlg":"0"
  
}
```

