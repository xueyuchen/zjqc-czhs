DELETE FROM t_day_record;
SET IDENTITY_INSERT [dbo].[t_day_record] ON;
INSERT INTO [dbo].[t_day_record] ([day_record_id], [weight], [step], [body_fat], [record_date], [user_id], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('8', '45.5', '67', '22.4', '2015-12-31', '11', '2014-12-31 16:09:12.153', '2014-12-31 16:09:12.153', '11', '11', '0');
SET IDENTITY_INSERT [dbo].[t_day_record] OFF;