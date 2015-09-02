var constants = {};
constants.api = {};

constants.api.base = 'http:' + '//' + 'localhost:8080' + '/diet-web-admin';
//constants.api.base = 'http:' + '//' + '115.28.209.203:80' + '/api';

constants.accessoriesSearch = constants.api.base + '/accessories/adminLucene';
constants.accessory = constants.api.base + '/accessories';
constants.login = constants.api.base + '/admin';
constants.copy = constants.api.base + '/accessories/copy';
constants.imgsUpload = constants.api.base + '/accessories/upload';
constants.imgsUploadToB = constants.api.base + '/accessories/uploadToB';
constants.searchByDate = constants.api.base + '/accessories/date';
constants.savephotoa = constants.api.base + '/accessories/copytoa';
constants.savephotob = constants.api.base + '/accessories/copytob';
constants.searchByLuceneA = constants.api.base + '/accessories/lucenea';
constants.searchByLuceneB = constants.api.base + '/accessories/luceneb';
constants.searchByLuceneAll = constants.api.base + '/accessories/luceneall';
constants.toModifyList = constants.api.base + '/accessories/toModifyList';
constants.saleHistory = constants.api.base + '/accessories/saledByWeek';
constants.saleBHistory = constants.api.base + '/accessories/saledBByWeek';
constants.stockB = constants.api.base + '/accessories/stock';