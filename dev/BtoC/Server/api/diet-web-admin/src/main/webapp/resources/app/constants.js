var constants = {};
constants.api = {};

constants.api.base = 'http:' + '//' + 'localhost:8080' + '/diet-web-admin';
//constants.api.base = 'http:' + '//' + '115.28.209.203:80' + '/api';

constants.accessoriesSearch = constants.api.base + '/accessories/adminLucene';
constants.accessory = constants.api.base + '/accessories';
constants.login = constants.api.base + '/admin';
constants.copy = constants.api.base + '/accessories/copy';
constants.imgsUpload = constants.api.base + '/accessories/upload';
constants.searchByDate = constants.api.base + '/accessories/date';
constants.savephotoa = constants.api.base + '/accessories/copytoa';