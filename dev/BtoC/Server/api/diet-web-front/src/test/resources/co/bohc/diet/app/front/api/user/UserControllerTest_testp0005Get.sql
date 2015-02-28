DELETE FROM t_tmp_user;
SET IDENTITY_INSERT [dbo].[t_tmp_user] ON;
INSERT INTO [dbo].[t_tmp_user] ([tmp_user_id], [email], [onetime_key], [tmp_regist_dt], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('29', N'365887762@qq.com', 'e98223c6-0df5-4caf-910a-420ec00d258e', '2015-01-08 13:45:25.800', '2015-01-09 13:45:25.800', '2015-01-09 13:45:25.800', '11', '111', '0');
INSERT INTO [dbo].[t_tmp_user] ([tmp_user_id], [email], [onetime_key], [tmp_regist_dt], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg]) VALUES ('27', N'365887762@qq.com', 'e98223c6-0df5-4caf-910a-420ec00d259e', getdate(), getdate(), getdate(), '11', '111', '0');
SET IDENTITY_INSERT [dbo].[t_tmp_user] OFF;