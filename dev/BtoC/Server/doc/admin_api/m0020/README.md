# M0020 遺伝子/生活習慣アンケート結果画面 

## SUMMARY

遺伝子/生活習慣アンケート結果画面 

## REQUEST

### URL

/api/enqueteanses

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded

### PARAMS

| name | type | required | description | example |
| ----- | -----| ----- | ----- | ----- |
| Q1_1 | Number | true | 答案一 | 12.2 |
| Q2_1 | Number | true | 答案一 | 12.2 |
| Q3_1 | Number | true | 答案一 | 12.2 |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| enqueteAnsId | Integer | true | 答案ID |
| ansJson | String | true | 答案json |
| enqueteVer | Integer | false | 题目版本 |

#### success example

status:200

body:
```json
{
  "enqueteAnsId": 1,
  "ansJson": "{xxx}",
  "enqueteVer": 1
}
```
