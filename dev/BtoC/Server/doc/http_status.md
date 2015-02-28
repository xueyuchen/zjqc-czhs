# HttpStatus

http://www.cnblogs.com/cxd4321/archive/2008/11/20/1337776.html

200 OK

301 Moved Permanently

302 Found

304 Not Modified

307 Temporary Redirect

400 Bad Request

401 Unauthorized

403 Forbidden

404 Not Found

410 Gone

500 Internal Server Error

501 Not Implemented

100 Continue
  初始的请求已经接受，客户应当继续发送请求的其余部分

101 Switching Protocols
  服务器将遵从客户的请求转换到另外一种协议

200 OK
  一切正常，对GET和POST请求的应答文档跟在后面

201 Created
  服务器已经创建了文档，Location头给出了它的URL。

202 Accepted
  已经接受请求，但处理尚未完成。

203 Non-Authoritative Information
  文档已经正常地返回，但一些应答头可能不正确，因为使用的是文
档的拷贝

204 No Content
  没有新文档，浏览器应该继续显示原来的文档。如果用户定期地刷新页面，而Servlet可以确定用户文档足够新，这个状态代码是很有用的

205 Reset Content
  没有新的内容，但浏览器应该重置它所显示的内容。用来强制浏览器清除表单输入内容

206 Partial Content
  客户发送了一个带有Range头的GET请求，服务器完成了它

300 Multiple Choices

301 Moved Permanently

302 Found

303 See Other

304 Not Modified

305 Use Proxy

307 Temporary Redirect

400 Bad Request

401 Unauthorized

403 Forbidden

404 Not Found

405 Method Not Allowed

406 Not Acceptable

407 Proxy Authentication Required

408 Request Timeout

409 Conflict

410 Gone

411 Length Required

412 Precondition Failed

413 Request Entity Too Large

414 Request URI Too Long

416 Requested Range Not Satisfiable

500 Internal Server Error

501 Not Implemented

502 Bad Gateway

503 Service Unavailable

504 Gateway Timeout

505 HTTP Version Not Supported





