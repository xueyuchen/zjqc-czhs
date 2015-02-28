# M0025 定型文一覧

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

fixedPrase list

## REQUEST

### URL

/api/fixedphrases

### METHOD

GET

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json

### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| fixedPhraseTypeId | Integer | true | 定型文種類id | 3 |
| page | Integer | false | - | 1 |
| size | Integer | false | - | 1 |

## RESPONSE


### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type | required | description |
| ----- | ----- | ----- | ----- |
| content.fixedPhraseId | Integer | true | 定型文id |
| content.fixedPhrase | String | true | 定型文 |
| size | Number | false | - |
| number | Number | false | - |
| totalElements | Number | false | - |
| numberOfElements | Number | false | - |
| lastPage | Boolean | false | - |
| firstPage | Boolean | false | - |
| totalPages | Number | false | - |

#### success example

status:200

body:
```json
{
    "content": [
        {
            "fixedPhraseId": 12,
            "fixedPhrase": "modify9999"
        }
    ],
    "size": 1,
    "number": 1,
    "sort": null,
    "totalPages": 2,
    "lastPage": true,
    "firstPage": false,
    "numberOfElements": 1,
    "totalElements": 2
}
```

* * *

## SUMMARY

to modify fixedphrase

## REQUEST

### URL

/api/fixedphrases/{fixedPhraseId}

### METHOD

GET

### HEADERS

Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| fixedPhraseId | Integer | true | 定型文id | 11 |


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
    "fixedPhraseId": 11,
    "fixedPhrase": "modify9999",
}
```

* * *

## SUMMARY

delete 定型文

## REQUEST

### URL
/api/fixedphrases/{fixedPhraseId}

### METHOD

DELETE

### HEADERS

* Content-Type=application/x-www-form-urlencoded
* Accept=application/json


### PARAMS

| name | type | required | description | example |
|----- | -----| ----- | ----- | -----|
| fixedPhraseId | Integer | true | 定型文id | 1 |


## RESPONSE

### STATUS

| value | description |
| ----- | -----|
| 200 | OK |

### BODY

| name | type  | required | description |
| ----- | -----| ----- | ----- |
| code | String | false  |  -  |


#### success example

```json
{
    "code": "e.ex.mm.0000"
}
```
