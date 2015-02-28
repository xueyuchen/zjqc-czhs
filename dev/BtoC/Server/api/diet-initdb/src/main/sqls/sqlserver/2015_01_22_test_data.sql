-- ----------------------------  
-- Test data t_user  
-- ----------------------------  
  
INSERT INTO t_user ( [password], [email], [last_name_kanji], [first_name_kanji], [first_name_kana], [last_name_kana], [sex], [nick_name], [birthday], [zip], [prefecture], [address1], [address2], [phone_number], [mobile_number], [payment_kbn], [payment_dt], [order_num], [start_rec_date], [target_weight ], [first_weight ], [target_point], [auth_token], [user_img_path], [background_img_no], [height], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( N'password', N'username@163.com', N'last_name_kanji', N'first_name_kanji', N'first_name_kana', N'last_name_kana', '1', N'nick_name', '2014-12-25', N'zip', N'prefe', N'address1', N'address2', N'phone_number', N'mobile_number', N'pa', '2014-12-25 10:52:28.000', N'order_num', '2014-12-25', '1.0', '1.0', '1', N'auto_token', N'user_img_path', '1', '1.0', '2014-12-25 10:53:14.000', '2014-12-25 10:53:17.000', '1', '1', '1');  

DECLARE  
	@i INT  
SET @i = 0  
WHILE @i < 12  
BEGIN  
INSERT INTO t_user ([password],[email],[last_name_kanji],[first_name_kanji],[first_name_kana],[last_name_kana],[sex],[nick_name],[birthday],[zip],[prefecture],[address1],[address2],[phone_number],[mobile_number],[payment_kbn],[payment_dt],[order_num],[start_rec_date],[target_weight ],[first_weight ],[target_point],[auth_token],[user_img_path],[background_img_no],[height],[cre_dt],[upd_dt],[cre_user_id],[upd_user_id],[del_flg])   
SELECT [password],[email],[last_name_kanji],[first_name_kanji],[first_name_kana],[last_name_kana],[sex],[nick_name],[birthday],[zip],[prefecture],[address1],[address2],[phone_number],[mobile_number],[payment_kbn],[payment_dt],[order_num],[start_rec_date],[target_weight ],[first_weight ],[target_point],[auth_token],[user_img_path],[background_img_no],[height],[cre_dt],[upd_dt],[cre_user_id],[upd_user_id],[del_flg] FROM t_user  
SET @i = @i + 1  
END  
  
  
  
UPDATE t_user  
SET email = 'user' +CONVERT(VARCHAR, user_id )+ '@163.com',  
 last_name_kanji = 'last_name_kanji' + CONVERT(VARCHAR, user_id ),  
 first_name_kanji = 'first_name_kanji' + CONVERT(VARCHAR, user_id ),  
 last_name_kana = 'last_name_kana' + CONVERT(VARCHAR, user_id ),  
 first_name_kana = 'first_name_kana' + CONVERT(VARCHAR, user_id ),  
 sex =   
	CASE user_id % 10  
	WHEN 0 THEN  
		9  
	ELSE  
		user_id % 3  
	END  
,  
 nick_name = 'nick_name' + CONVERT(VARCHAR, user_id ),  
 birthday = DATEADD(DAY, user_id, '1991-12-25'),  
 zip = 'zip' + CONVERT(VARCHAR, user_id ),  
 prefecture ='p'+ CONVERT(VARCHAR, user_id%1000),  
 address1 = 'address1' + CONVERT(VARCHAR, user_id ),  
 address2 = 'address2' + CONVERT(VARCHAR, user_id ),  
 phone_number = 81662291181+user_id%100000 ,  
 mobile_number =81662291181+user_id%100000 ,  
 payment_kbn =   
	CASE  
		user_id % 2  
	WHEN  0 THEN  
		'CD'  
	ELSE  
		'BK'  
	END  
,  
 payment_dt = DATEADD(DAY, - (user_id % 90), '2014-12-25'),  
 order_num = 'order_num' + CONVERT(VARCHAR, user_id ),  
 start_rec_date = DATEADD(DAY, - (user_id % 90), '2014-12-25'),  
 target_weight = 40 + user_id % 20,  
 first_weight = 40 + user_id % 20 + 10,  
 target_point = 300 + user_id % 200,  
 auth_token = 'auth_token' + CONVERT(VARCHAR, user_id ),  
 user_img_path = CONVERT(VARCHAR, user_id ) + '.jpg',  
 background_img_no = 1 + user_id % 10,  
 height = 150 + user_id % 30,  
 cre_dt = DATEADD(DAY, - (user_id % 90), '2014-12-25'),  
 upd_dt = DATEADD(DAY, - (user_id % 90), '2014-12-25'),  
 cre_user_id = user_id,  
 upd_user_id = user_id,  
 del_flg = user_id % 2;  
   
UPDATE t_user SET password=SUBSTRING(sys.fn_VarBinToHexStr(hashbytes('SHA1', '123' +'{'+CONVERT(VARCHAR,email)+'}')),3,40);

-- ----------------------------  
-- Test data t_meal  
-- ----------------------------  
INSERT INTO [t_meal] ( [time_kbn], [eat_dt], [user_id], [ingestion_flg], [user_meal_comment], [calorie], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( 'BR', '2014-12-25 14:29:10.000', '1', '1', 'user_meal_comment', '1', '2014-12-25 14:29:22.000', '2014-12-25 14:29:27.000', '1', '1', '1');  
DECLARE @j INT  
SET @j = 0  
WHILE @j < 19  
BEGIN  
INSERT INTO t_meal( [time_kbn],[eat_dt],[user_id],[ingestion_flg],[user_meal_comment],[calorie],[cre_dt],[upd_dt],[cre_user_id],[upd_user_id],[del_flg])  
SELECT [time_kbn],[eat_dt],[user_id],[ingestion_flg],[user_meal_comment],[calorie],[cre_dt],[upd_dt],[cre_user_id],[upd_user_id],[del_flg] FROM t_meal  
SET @j = @j + 1  
END  
  
  
UPDATE t_meal  
SET time_kbn = CASE meal_id % 4  
WHEN 0 THEN  
	'BR'  
WHEN 1 THEN  
	'LC'  
WHEN 2 THEN  
	'DN'  
ELSE  
	'KS'  
END,  
 eat_dt = DATEADD(  
	DAY,  
	- (meal_id% 90),  
	'2014-12-25'  
),  
 user_id = (meal_id % 180000)/90+1,  
 ingestion_flg = CASE meal_id % 5  
WHEN 0 THEN  
	1  
ELSE  
	0  
END,  
 user_meal_comment = 'user_meal_comment' + CONVERT (VARCHAR, meal_id),  
 calorie = 500 + meal_id % 500,  
 cre_dt = DATEADD(  
	DAY,  
	-(meal_id % 90),  
	'2014-12-25'  
),  
 upd_dt = DATEADD(  
	DAY,  
	- (meal_id % 90),  
	'2014-12-25'  
),  
 cre_user_id = user_id,  
 upd_user_id = user_id,  
 del_flg = 0;  
  
   
 -- ----------------------------  
-- Test data m_admin_user  
-- ----------------------------  
  
DECLARE @k INT  
SET @k = 0  
WHILE @k < 110  
BEGIN  
	INSERT INTO [m_admin_user] (  
		[password],  
		[admin_role_kbn],  
		[login_id],  
		[admin_user_name],  
		[admin_user_photo],  
		[cre_dt],  
		[upd_dt],  
		[cre_user_id],  
		[upd_user_id],  
		[del_flg]  
	)  
VALUES  
	(  
		'password'+ CONVERT (VARCHAR ,@k),  
		CASE WHEN @k<100 THEN 'KE' ELSE 'SU' END,  
		'admin'+ CONVERT (VARCHAR ,@k),  
		'admin_user_name'+ CONVERT (VARCHAR ,@k),  
		CONVERT (VARCHAR ,@k)+'.jpg',  
		'2014-12-25 15:09:47',  
		'2014-12-25 15:09:51',  
		1,  
		1,  
		CASE @k%10 WHEN 0 THEN 1 ELSE 0 END  
	)   
SET @k =@k + 1  
END  

UPDATE m_admin_user SET password=SUBSTRING(sys.fn_VarBinToHexStr(hashbytes('SHA1', '123')),3,40);
  
   
-- ----------------------------  
-- Test data t_stamp  
-- ---------------------------- 

DECLARE
    @p INT
SET @p = 1
WHILE @p < 50
BEGIN
    INSERT INTO [m_stamp] (
        [stamp_name],
        [stamp_img_path],
        [cre_dt],
        [upd_dt],
        [cre_user_id],
        [upd_user_id],
        [del_flg]
    )
VALUES
    (
        'stamp'+CONVERT(VARCHAR, @p),
        'stampPath'+CONVERT(VARCHAR, @p)+'.jpg',
        GETDATE(),
        GETDATE(),
        1,
        1,
        0
    )
SET @p = @p + 1
END

-- ----------------------------  
-- Test data t_timeline  
-- ----------------------------  
  
INSERT INTO [t_time_line] ([admin_user_id], [stamp_id], [tl_message], [user_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg])   
VALUES ('1', '1', N'1', '1', '2014-12-25 17:04:54.000', '2014-12-25 17:04:57.000', '1', '1', '0');  
DECLARE @m INT  
SET @m=0  
WHILE @m<8  
BEGIN  
INSERT INTO [t_time_line] ([admin_user_id], [stamp_id], [tl_message], [user_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg])   
SELECT [admin_user_id], [stamp_id], [tl_message], [user_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg] FROM t_time_line  
SET @m=@m+1  
END  
  
UPDATE t_time_line  
SET admin_user_id = time_line_id % 100 + 1,  
    stamp_id = (time_line_id % 5)+1,
 tl_message = 'tl_message' + CONVERT (VARCHAR, admin_user_id),  
 user_id = time_line_id % 2000 + 1,  
 cre_dt = DATEADD(  
    DAY ,- (time_line_id % 90),  
    '2014-12-25'  
),  
 upd_dt = DATEADD(  
    DAY ,- (time_line_id % 90),  
    '2014-12-25'  
),  
 cre_user_id = admin_user_id,  
 upd_user_id = admin_user_id,  
 del_flg = 0 ;  
  
-- ----------------------------  
-- Test data t_evaluate  
-- ----------------------------  
  
ALTER TABLE t_evaluate DROP CONSTRAINT t_evaluate__user_id__eval_date; 
  
  
INSERT INTO [t_evaluate] ([eval_quantity], [eval_balance], [eval_fat], [eval_glycolipid], [eval_time], [admin_user_id], [user_id], [evel_date], [eval_dt], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg])   
SELECT  1,1,1,1,1,1,m.user_id, convert(date,m.eat_dt),convert(date,m.eat_dt),convert(date,m.eat_dt),convert(date,m.eat_dt),1,1,0  
FROM t_meal m  
group by convert(date,m.eat_dt),m.user_id  

ALTER TABLE t_evaluate ADD CONSTRAINT  t_evaluate__user_id__eval_date UNIQUE(user_id, evel_date);
 -- ----------------------------  
-- Test data t_meal_comment  
-- ----------------------------  
  
SET datefirst 1  
  
  
ALTER TABLE t_meal_comment DROP CONSTRAINT t_meal_comment__user_id__from_date;  
  
  
INSERT INTO [t_meal_comment] (  
	[meal_comment],  
	[approval_sts],  
	[approval_dt],  
	[admin_user_id],  
	[user_id],  
	[comment_dt],  
	[from_date],  
	[cre_dt],  
	[upd_dt],  
	[cre_user_id],  
	[upd_user_id],  
	[del_flg]  
) SELECT  
	'meal_comment' + CONVERT(VARCHAR,m.user_id),  
	1,  
	'2014-12-25',  
	1,  
	m.user_id,  
	'2014-12-25',  
	CONVERT (  
		DATE,  
		(  
			DATEADD(  
				DAY,  
				- (6 + DATEPART(dw, m.eat_dt)),  
				m.eat_dt  
			)  
		)  
	),  
	'2014-12-25',  
	'2014-12-25',  
	1,  
	1,  
	0  
FROM  
	t_meal m  
GROUP BY  
	CONVERT (  
		DATE,  
		(  
			DATEADD(  
				DAY,  
				- (6 + DATEPART(dw, m.eat_dt)),  
				m.eat_dt  
			)  
		)  
	),  
	m.user_id  
  
UPDATE t_meal_comment   
SET approval_sts=(CASE  WHEN meal_comment_id%1000=0 THEN 2 WHEN meal_comment_id%100=0 THEN 0 ELSE 1 END);  
ALTER TABLE t_meal_comment ADD CONSTRAINT t_meal_comment__user_id__from_date UNIQUE (user_id, from_date);
  
  
------------------------------------  
--update t_user because of foreign key on column admin_user_id in this table   
------------------------------------  
UPDATE t_user SET admin_user_id=user_id%100+1  
 
-- ----------------------------  
-- Test data t_push_msg  
-- ----------------------------  
INSERT INTO [dbo].[t_push_msg] ([user_id], [push_msg_type], [push_msg], [push_send_reserve_dt], [push_send_flg], [push_send_dt], [open_flg], [send_all_flg], [link_url], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( '1', N'IF', N'new info', '2015-01-14 18:36:15.000', '0', '1900-01-01 00:00:00.000', '0', '1', N'push_url', '2015-01-14 18:36:42.000', '2015-01-14 18:36:45.000', '1', '1', '0');

-- ----------------------------  
-- Test data t_info  
-- ----------------------------  
  
INSERT t_info ([info_title],[info],[from_dt],[to_dt],[cre_dt],[upd_dt],[cre_user_id],[upd_user_id],[del_flg],[push_msg_id])
VALUES('infoTitle','info','2014-12-31 13:46:03.000','2015-01-10 13:46:08.000','2014-12-31 13:46:17.000','2014-12-31 13:46:20.000','1','1','0','1');

DECLARE  
@n INT  
SET @n = 0  
WHILE @n < 8
BEGIN  

INSERT INTO t_info ([info_title],[info],[from_dt],[to_dt],[cre_dt],[upd_dt],[cre_user_id],[upd_user_id],[del_flg],[push_msg_id]) 
SELECT [info_title],[info],[from_dt],[to_dt],[cre_dt],[upd_dt],[cre_user_id],[upd_user_id],[del_flg],[push_msg_id]
FROM t_info

SET @n = @n + 1  
END  

UPDATE t_info 
SET
 [info_title] = 'infoTitle' + CONVERT(VARCHAR, info_id ),
 [info] = 'info' + CONVERT(VARCHAR, info_id ),
 [from_dt] = DATEADD(DAY,  info_id, '2014-10-25'), 
 [to_dt] =  DATEADD(DAY,  info_id, '2014-11-25'), 
 [cre_dt] = '2014-12-31 13:46:17.000',
 [upd_dt] = '2014-12-31 13:46:20.000',
 [cre_user_id] = '1',
 [upd_user_id] = '1',
 [del_flg] = info_id%2;

 -- ----------------------------  
-- Test data m_hurikaeri_item  
-- ----------------------------  

SET IDENTITY_INSERT [dbo].[m_hurikaeri_item] ON
INSERT INTO [dbo].[m_hurikaeri_item] ([hurikaeri_item_name_id], [hurikaeri_item_name], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'1', N'name1', N'2015-01-04 10:42:24.000', N'2015-01-04 10:42:26.000', N'1', N'1', N'0');
INSERT INTO [dbo].[m_hurikaeri_item] ([hurikaeri_item_name_id], [hurikaeri_item_name], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'2', N'name2', N'2015-01-04 10:42:45.000', N'2015-01-04 10:42:47.000', N'1', N'1', N'0');
INSERT INTO [dbo].[m_hurikaeri_item] ([hurikaeri_item_name_id], [hurikaeri_item_name], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'3', N'name3', N'2015-01-04 10:42:58.000', N'2015-01-04 10:43:00.000', N'1', N'1', N'0');
INSERT INTO [dbo].[m_hurikaeri_item] ([hurikaeri_item_name_id], [hurikaeri_item_name], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'4', N'name4', N'2015-01-04 10:43:10.000', N'2015-01-04 10:43:13.000', N'1', N'1', N'0');
INSERT INTO [dbo].[m_hurikaeri_item] ([hurikaeri_item_name_id], [hurikaeri_item_name], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'5', N'name5', N'2015-01-04 10:43:23.000', N'2015-01-04 10:43:26.000', N'1', N'1', N'0');
SET IDENTITY_INSERT [dbo].[m_hurikaeri_item] OFF

------------------------------------  
--t_exam
------------------------------------  
  
INSERT INTO [t_exam] ([user_id], [status_kbn],[status_kbn_change_dt] , [apply_dt], [receipt_dt], [exam_dt], [exam_no], [adrb3], [ucp1], [ardb2], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('1', 'NC', '2015-01-06', '2015-01-06', '2015-01-06', '2015-01-06', '11111', N'1', N'1', N'1', '2015-01-06 11:13:34.000', '2015-01-06 11:13:39.000', '1', '1', '0');

DECLARE  
    @o INT  
SET @o = 0  
WHILE @o < 12  
BEGIN
INSERT INTO [t_exam] ([user_id], [status_kbn], [status_kbn_change_dt] ,[apply_dt], [receipt_dt], [exam_dt], [exam_no], [adrb3], [ucp1], [ardb2], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg])
SELECT [user_id], [status_kbn], [status_kbn_change_dt] ,[apply_dt], [receipt_dt], [exam_dt], [exam_no], [adrb3], [ucp1], [ardb2], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg] FROM t_exam
SET @o = @o + 1  
END  

UPDATE t_exam  SET user_id=exam_id,
status_kbn=(CASE exam_id%8 WHEN 0 THEN 'SS' WHEN 1 THEN 'NK' WHEN 2 THEN 'NC' WHEN 3 THEN 'SE' WHEN 4 THEN 'KS' WHEN 5 THEN 'WR' WHEN 6 THEN 'CP' ELSE 'IM' END),
apply_dt=DATEADD(DAY, -(exam_id%30), GETDATE()),
receipt_dt=GETDATE(),
exam_dt=GETDATE(),
exam_no=2000+exam_id

UPDATE u SET u.payment_dt = NULL  FROM t_user u,t_exam e  WHERE u.user_id = e.user_id AND e.status_kbn IN ('SS','NK')
-- ----------------------------  
-- Test data t_fixed_phrase_type  
-- ---------------------------- 
DECLARE  
    @p2 INT  
SET @p2 = 1  
WHILE @p2 < 13
BEGIN 
    INSERT INTO  [dbo].[t_fixed_phrase_type] (
        [fixed_phrase_type],
        [cre_dt],
        [upd_dt],
        [cre_user_id],
        [upd_user_id],
        [del_flg]
    )
    VALUES
        (
            @p2,
            '2015-01-05 17:43:52.000',
            '2015-01-05 17:43:55.000',
            '1',
            '1',
            '0'
        )
SET @p2 = @p2 + 1  
END

-- ----------------------------  
-- Test data m_fixed_phrase  
-- ---------------------------- 
DECLARE  
    @q INT  
SET @q = 1 
WHILE @q < 80
BEGIN 
INSERT INTO [dbo].[m_fixed_phrase] (
    [fixed_phrase],
    [fixed_phrase_type_id],
    [cre_dt],
    [upd_dt],
    [cre_user_id],
    [upd_user_id],
    [del_flg]
)
VALUES
    (
        'test' + CONVERT(VARCHAR, @q ),
        1,
        '2015-01-05 17:50:50.000',
        '2015-01-05 17:50:53.000',
        '1',
        '1',
        '0'
    )
SET @q = @q + 1  
END

UPDATE [dbo].[m_fixed_phrase] SET fixed_phrase_type_id = (fixed_phrase_id%12)+1


-- ----------------------------
--  Records of [dbo].[t_reserve]
-- ----------------------------
DELETE from t_reserve
DBCC CHECKIDENT(N'[dbo].[t_reserve]', RESEED, 0)
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('3', '0', '9', '2014-12-13', '10:00:00.0000000', NULL, NULL, '2', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');

DECLARE @j1 INT  
SET @j1 = 0  
WHILE @j1 < 10
BEGIN  
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg])  
SELECT [user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg] FROM t_reserve  
SET @j1 = @j1 + 1  
END

DELETE FROM t_reserve WHERE reserve_id > 700;

DECLARE
	@i1 INT DECLARE
		@y1 INT
	SET @i1 = 0
	SET @y1 = 0
	WHILE @i1 < 100
	BEGIN

	SET @y1 = 0
	WHILE @y1 < 7
	BEGIN
		UPDATE t_reserve
	SET user_id = (
		CASE @y1
		WHEN 0 THEN
			NULL
		ELSE
			@i1 + 1
		END
	),
	admin_user_id = (
		CASE @y1
		WHEN 6 THEN
			NULL
		ELSE
			@i1 + 1
		END
	),
	reserve_date = DATEADD(DAY, @i1, '2015-01-16'),
	reserve_time = (
		CASE @y1
		WHEN 0 THEN
			'10:00'
		WHEN 1 THEN
			'11:30'
		WHEN 2 THEN
			'13:30'
		WHEN 3 THEN
			'15:00'
		WHEN 4 THEN
			'16:30'
		WHEN 5 THEN
			'18:00'
		WHEN 6 THEN
			'19:30'
		END
	),
	work_sts = (CASE @y1 WHEN 6 THEN 0 ELSE 2 END),
	request_flg = (CASE @y1 WHEN 6 THEN 1 ELSE 0 END)
WHERE
	reserve_id = (@i1 * 7 + @y1 + 1)
SET @y1 = @y1 + 1
END
SET @i1 = @i1 + 1
END
DELETE FROM t_reserve WHERE reserve_id > 700;
DBCC CHECKIDENT(N'[dbo].[t_reserve]', RESEED, 700)

INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( NULL, '0', '101', '2015-01-16', '10:00:00.0000000', NULL, NULL, '2', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( NULL, '0', '102', '2015-01-16', '10:00:00.0000000', NULL, NULL, '2', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( NULL, '0', '103', '2015-01-16', '10:00:00.0000000', NULL, NULL, '2', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( NULL, '0', '104', '2015-01-16', '10:00:00.0000000', NULL, NULL, '2', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ( NULL, '0', '105', '2015-01-16', '10:00:00.0000000', NULL, NULL, '2', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');

INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('101', '1', NULL, '2015-01-16', '19:30:00.0000000', NULL, NULL, '0', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('102', '1', NULL, '2015-01-16', '19:30:00.0000000', NULL, NULL, '0', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('103', '1', NULL, '2015-01-16', '19:30:00.0000000', NULL, NULL, '0', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('104', '1', NULL, '2015-01-16', '19:30:00.0000000', NULL, NULL, '0', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');
INSERT INTO [dbo].[t_reserve] ([user_id], [request_flg], [admin_user_id], [reserve_date], [reserve_time], [vcube_reserve_id], [vcube_reserve_url], [work_sts], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('105', '1', NULL, '2015-01-16', '19:30:00.0000000', NULL, NULL, '0', '2014-12-13 14:41:03.000', '2014-12-13 14:41:09.000', '1', '1', '0');



-- ----------------------------  
-- Test data t_hurikaeri  
-- ---------------------------- 
DECLARE
    @r INT
SET @r = 1
WHILE @r < 30
BEGIN
    INSERT INTO [t_hurikaeri] (
        [user_id],
        [hurikaeri_date],
        [sleep_time],
        [hurikaeri_comment],
        [cre_dt],
        [upd_dt],
        [cre_user_id],
        [upd_user_id],
        [del_flg]
    )
VALUES
    (
        '2',
        DATEADD(
        DAY ,- (@r),
        '2014-12-25'
    ),
        '10',
        'comment' + CONVERT (VARCHAR, @r),
        DATEADD(
        DAY ,- (@r),
        '2014-12-25'
    ),
        DATEADD(
        DAY ,- (@r),
        '2014-12-25'
    ),
        '1',
        '1',
        '0'
    ) ;
SET @r = @r + 1
END

 -- ----------------------------  
-- Test data t_hurikaeri_item  
-- ----------------------------  

DECLARE
    @m1 INT
SET @m1 = 1
WHILE @m1 < 30
BEGIN
DECLARE
    @p1 INT
SET @p1 = 1
WHILE @p1 < 4
BEGIN
    INSERT INTO [t_hurikaeri_item] (
        [hurikaeri_id],
        [level],
        [hurikaeri_item_name_id],
        [cre_dt],
        [upd_dt],
        [cre_user_id],
        [upd_user_id],
        [del_flg]
    )
VALUES
    (
        @m1,
        @p1,
        @p1,
        GETDATE(),
        GETDATE(),
        1,
        1,
        0
    ) ;
SET @p1 = @p1 + 1
END
SET @m1 = @m1 + 1
END

-- ----------------------------
-- Records of t_user_photo
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_user_photo] ON

INSERT INTO [dbo].[t_user_photo] ([user_photo_id], [photo_face_file], [photo_body_file], [photo_etc_file], [shoot_dt], [user_id], [user_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'1', N'1face.jpg', N'1body.jpg', N'1etc.jpg', N'2015-01-07 00:00:34.000', N'2', N'tt', N'2015-01-07 15:09:17.000', N'2015-01-07 15:09:19.000', N'2', N'2', N'0')
INSERT INTO [dbo].[t_user_photo] ([user_photo_id], [photo_face_file], [photo_body_file], [photo_etc_file], [shoot_dt], [user_id], [user_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'2', N'2face.jpg', N'2body.jpg', N'2etc.jpg', N'2015-01-06 00:12:00.000', N'2', N'tt', N'2015-01-06 15:09:58.000', N'2015-01-06 15:10:01.000', N'2', N'2', N'0')

INSERT INTO [dbo].[t_user_photo] ([user_photo_id], [photo_face_file], [photo_body_file], [photo_etc_file], [shoot_dt], [user_id], [user_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'3', N'3face.jpg', N'3body.jpg', N'3etc.jpg', N'2015-01-05 00:00:22.000', N'2', N'tt', N'2015-01-05 15:10:35.000', N'2015-01-05 15:10:38.000', N'2', N'2', N'0')

INSERT INTO [dbo].[t_user_photo] ([user_photo_id], [photo_face_file], [photo_body_file], [photo_etc_file], [shoot_dt], [user_id], [user_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'4', N'4face.jpg', N'4body.jpg', N'4etc.jpg', N'2015-01-04 00:00:10.000', N'2', N'tt', N'2015-01-04 15:11:16.000', N'2015-01-04 15:11:19.000', N'2', N'2', N'0')

INSERT INTO [dbo].[t_user_photo] ([user_photo_id], [photo_face_file], [photo_body_file], [photo_etc_file], [shoot_dt], [user_id], [user_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'5', N'5face.jpg', N'5body.jpg', N'5etc.jpg', N'2015-01-03 00:00:50.000', N'2', N'tt', N'2015-01-03 15:11:52.000', N'2015-01-03 15:11:56.000', N'2', N'2', N'1')

INSERT INTO [dbo].[t_user_photo] ([user_photo_id], [photo_face_file], [photo_body_file], [photo_etc_file], [shoot_dt], [user_id], [user_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'6', N'6face.jpg', N'6body.jpg', N'6etc.jpg', N'2015-01-02 00:00:30.000', N'2', N'tt', N'2015-01-02 15:15:33.000', N'2015-01-02 15:15:40.000', N'2', N'2', N'1')

INSERT INTO [dbo].[t_user_photo] ([user_photo_id], [photo_face_file], [photo_body_file], [photo_etc_file], [shoot_dt], [user_id], [user_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'7', N'7face.jpg', N'7body.jpg', N'7etc.jpg', N'2015-01-02 00:00:40.000', N'2', N'tt', N'2015-01-02 15:16:36.000', N'2015-01-02 15:16:40.000', N'2', N'2', N'0')

SET IDENTITY_INSERT [dbo].[t_user_photo] OFF

-- ----------------------------
-- Records of t_enquete_ans
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_enquete_ans] ON

INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'1', N'1', N'ans_json1', N'2', N'2015-01-09 17:08:06.150', N'2015-01-09 17:08:06.150', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'2', N'2', N'ans_json2', N'3', N'2015-01-09 17:08:06.297', N'2015-01-09 17:08:06.297', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'3', N'3', N'ans_json3', N'1', N'2015-01-09 17:08:06.300', N'2015-01-09 17:08:06.300', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'4', N'4', N'ans_json4', N'2', N'2015-01-09 17:08:06.300', N'2015-01-09 17:08:06.300', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'5', N'5', N'ans_json5', N'3', N'2015-01-09 17:08:06.300', N'2015-01-09 17:08:06.300', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'6', N'6', N'ans_json6', N'1', N'2015-01-09 17:08:06.300', N'2015-01-09 17:08:06.300', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'7', N'7', N'ans_json7', N'2', N'2015-01-09 17:08:06.300', N'2015-01-09 17:08:06.300', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'8', N'8', N'ans_json8', N'3', N'2015-01-09 17:08:06.303', N'2015-01-09 17:08:06.303', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'9', N'9', N'ans_json9', N'1', N'2015-01-09 17:08:06.303', N'2015-01-09 17:08:06.303', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'10', N'10', N'ans_json10', N'2', N'2015-01-09 17:08:06.307', N'2015-01-09 17:08:06.307', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'11', N'11', N'ans_json11', N'3', N'2015-01-09 17:08:06.307', N'2015-01-09 17:08:06.307', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'12', N'12', N'ans_json12', N'1', N'2015-01-09 17:08:06.307', N'2015-01-09 17:08:06.307', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'13', N'13', N'ans_json13', N'2', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'14', N'14', N'ans_json14', N'3', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'15', N'15', N'ans_json15', N'1', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'16', N'16', N'ans_json16', N'2', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'17', N'17', N'ans_json17', N'3', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'18', N'18', N'ans_json18', N'1', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'19', N'19', N'ans_json19', N'2', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'20', N'20', N'ans_json20', N'3', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'21', N'21', N'ans_json21', N'1', N'2015-01-09 17:08:06.310', N'2015-01-09 17:08:06.310', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'22', N'22', N'ans_json22', N'2', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'23', N'23', N'ans_json23', N'3', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'24', N'24', N'ans_json24', N'1', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'25', N'25', N'ans_json25', N'2', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'26', N'26', N'ans_json26', N'3', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'27', N'27', N'ans_json27', N'1', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'28', N'28', N'ans_json28', N'2', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'29', N'29', N'ans_json29', N'3', N'2015-01-09 17:08:06.313', N'2015-01-09 17:08:06.313', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'30', N'30', N'ans_json30', N'1', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'31', N'31', N'ans_json31', N'2', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'32', N'32', N'ans_json32', N'3', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'33', N'33', N'ans_json33', N'1', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'34', N'34', N'ans_json34', N'2', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'35', N'35', N'ans_json35', N'3', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'36', N'36', N'ans_json36', N'1', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'37', N'37', N'ans_json37', N'2', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'38', N'38', N'ans_json38', N'3', N'2015-01-09 17:08:06.317', N'2015-01-09 17:08:06.317', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'39', N'39', N'ans_json39', N'1', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'40', N'40', N'ans_json40', N'2', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'41', N'41', N'ans_json41', N'3', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'42', N'42', N'ans_json42', N'1', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'43', N'43', N'ans_json43', N'2', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'44', N'44', N'ans_json44', N'3', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'45', N'45', N'ans_json45', N'1', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'46', N'46', N'ans_json46', N'2', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'47', N'47', N'ans_json47', N'3', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'48', N'48', N'ans_json48', N'1', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')
INSERT INTO [dbo].[t_enquete_ans] ([enquete_ans_id], [user_id], [ans_json], [enquete_ver], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'49', N'49', N'ans_json49', N'2', N'2015-01-09 17:08:06.320', N'2015-01-09 17:08:06.320', N'1', N'1', N'0')

SET IDENTITY_INSERT [dbo].[t_enquete_ans] OFF
