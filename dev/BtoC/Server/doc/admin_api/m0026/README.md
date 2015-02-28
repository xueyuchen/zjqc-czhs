# M0026 定型文作成編集

## SUMMARY

list 定型文 分類

## REQUEST

### URL

/api/fixedphrasetypes

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

N/A

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | required | description |
| ----- | ----- | ----- | ----- |
| fixedPhraseTypeId | Integer | true | 定型文種類id  |
| fixedPhraseType | String | true | 定型文種類 |

#### success example

status:200

body:
```json
[
    {
        "fixedPhraseTypeId": 3,
        "fixedPhraseType": "555"
    },
    {
        "fixedPhraseTypeId": 4,
        "fixedPhraseType": "modify-4"
    },
    {
        "fixedPhraseTypeId": 5,
        "fixedPhraseType": "777"
    },
    {
        "fixedPhraseTypeId": 6,
        "fixedPhraseType": "888"
    },
    {
        "fixedPhraseTypeId": 7,
        "fixedPhraseType": "999"
    },
    {
        "fixedPhraseTypeId": 8,
        "fixedPhraseType": "saveNew"
    }
]
```

* * *

## SUMMARY

creat fixedphrase

## REQUEST

### URL

/api/fixedphrases

### METHOD

POST

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| fiexdPhraseTypeId | Integer | true | 定型文種類id | 8 |
| fixedPhrase | String | true | 定型文 | testCreat |

## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | description |
| ----- | -----| ----- |
| fixedPhraseId | Integer | 定型文id |
| fixedPhrase | String | 定型文 |

#### success example

status:200

body:
```json
{
    "fixedPhraseId": 19,
    "fixedPhrase": "testCreat"
}
```
* * *

## SUMMARY

modify fixedPrase

## REQUEST

### URL
/api/fixedphrases/{fixedPhraseId}

### METHOD

PUT

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| fixedPhraseId | Integer | true | 定型文id | 4 |
| fiexdPhraseTypeId | Integer | true | 定型文種類id | 3 |
| fixedPhrase | String | true | 定型文 | modifyCreat |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| fixedPhraseId | Integer | true | 定型文id |
| fixedPhrase | String | true | 定型文 |

#### success example

status:200

body:
```json
{
    "fixedPhraseId": 4,
    "fixedPhrase": "modifyCreat"
}
```
