SET IDENTITY_INSERT [dbo].[t_hurikaeri] ON;
INSERT INTO [dbo].[t_hurikaeri] ([hurikaeri_id], [user_id], [hurikaeri_date], [sleep_time], [hurikaeri_comment], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'20000', N'2', N'2015-01-03', N'8', N'comment', N'2015-01-03 20:50:59.000', N'2015-01-03 20:51:06.000', N'2', N'2', N'0');
SET IDENTITY_INSERT [dbo].[t_hurikaeri] OFF;

INSERT INTO [dbo].[t_hurikaeri_item] ([hurikaeri_id], [level], [hurikaeri_item_name_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'20000', N'1', N'1', N'2015-01-04 20:51:37.000', N'2015-01-04 20:51:45.000', N'2', N'2', N'0');
INSERT INTO [dbo].[t_hurikaeri_item] ([hurikaeri_id], [level], [hurikaeri_item_name_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'20000', N'3', N'2', N'2015-01-04 20:52:05.000', N'2015-01-04 20:52:08.000', N'2', N'2', N'0');
INSERT INTO [dbo].[t_hurikaeri_item] ([hurikaeri_id], [level], [hurikaeri_item_name_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'20000', N'2', N'3', N'2015-01-04 20:52:24.000', N'2015-01-04 20:52:26.000', N'2', N'2', N'0');
INSERT INTO [dbo].[t_hurikaeri_item] ([hurikaeri_id], [level], [hurikaeri_item_name_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'20000', N'2', N'4', N'2015-01-04 20:52:44.000', N'2015-01-04 20:52:47.000', N'2', N'2', N'0');
INSERT INTO [dbo].[t_hurikaeri_item] ([hurikaeri_id], [level], [hurikaeri_item_name_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES (N'20000', N'1', N'5', N'2015-01-04 20:53:01.000', N'2015-01-04 20:53:03.000', N'2', N'2', N'0');

