## prod.properties 配置详解
| name | example  | description |
| ----- | -----| ----- |
| database | SQL_SERVER | DB类型（固定） |
| database.url | jdbc:jtds:sqlserver://192.168.10.252:1433/bohc | DB连接地址 |
| database.username | boh | 账号 |
| database.password | ntmncdhzdlss | 密码 |
| database.driverClassName | net.sourceforge.jtds.jdbc.Driver | DB驱动的名称（固定） |
| cp.maxActive | 96 | 连接池的最大数据库连接数。设为0表示无限制。 |
| cp.maxIdle | 16 | 最大空闲数，数据库连接的最大空闲时间。超过空闲时间，数据库连接将被标记为不可用，然后被释放。设为0表示无限制。 |
| cp.minIdle | 0 | 最小空闲数 |
| cp.maxWait | 600000 | 最大建立连接等待时间。如果超过此时间将接到异常。设为-1表示无限制。 |
| mail.host | smtp.163.com | 邮箱类型 |
| mail.username | wyh_monstar@163.com | 邮件发送者账号 |
| mail.password | 1qaz2wsx3edc | 邮件发送者密码 |
| mail.p0014.subject | 初回カウンセリングアンケートの結果 | P0014邮件主题 |
| mail.p0014.to | 15828307054@163.com | 邮件接收者账号 |
| restPwd.url | 3 | 有效时间。单位（天） |
| web.sitePath | httphttp://boh.monstar.mydns.jp/pc/ | PC服务器域名 |
| shop.id | tshop00017590 | 商铺id |
| shop.secret | kx7m2bs8 | 密码 |
| shop.returl | http://boh.monstar.mydns.jp/api/payments | 回调url |
| shop.amount | 1000 | 付款金额 |
| shop.tax | 0 | 交税金额 |
| shop.receiptsdisp11 | name | 商铺名 |
| shop.receiptsdisp12 | 12345667 | 商铺电话 |
| shop.receiptsdisp13 | 09:00-18:00 | 营业时间 |
| shop.jobCd | CAPTURE | 类型 |
| shop.useCredit | 1 | 信用卡支付 |
| shop.usePayEasy | 1 | 便捷支付 |
| push.ios.certificatePath | E:/boh/B2C2/dev/BtoC/Server/api/diet-env/src/main/resources/META-INF/apns-dis-cert.p12 | IOS push证书路径 |
| push.ios.certificatePassword | 1234 | 密码 |
| push.android.sendId | AIzaSyDb8_u02Z6XscQrIFWldGAC6rjK6OVvAkI | Android push发送编号 |
| push.jump.baseURL | http://boh.monstar.mydns.jp/pc/index.html | push跳转url |
| boh.payment.duration | 90 | 服务周期。单位（日） |
| boh.user.backgroundImgPath | /api/imgs/ | 背景图片访问路径（固定） |
| file.upload.path | file:/mnt/upload/ | 文件保存路径 |
| boh.img.api | /api/imgs/ | 图片访问路径（固定） |
| mail.p0003.subject | mail.p0003.subject | 邮件主题（用于P0003） |
| url.p0005 | http://boh.monstar.mydns.jp/sp/index.html#p0005 | 访问路径（P0005页面） |
| mail.p0002.to | diet_info@bohc.co.jp | 接收邮件（用于P0002） |
| v_cube.recv.mail | boh_ml@monstar-lab.com | 接收者邮箱（用于v_cube） |
| v_club_add_reservation_url | http://meeting-try-api.nice2meet.us/api/v1/user/reservation/?.... too lang,Omission | 向VCube预约房间url（固定） |
| v_club_get_rooms | http://meeting-try-api.nice2meet.us/api/v1/user/..... too lang,Omission | 向VCube获取房间url（固定） |
| v_club_login_url | http://meeting-try-api.nice2meet.us/api/v1/user/.... too lang,Omission | Vcube登陆url（固定） |
