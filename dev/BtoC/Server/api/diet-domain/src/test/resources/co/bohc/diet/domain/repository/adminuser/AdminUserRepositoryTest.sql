SET IDENTITY_INSERT [dbo].[m_admin_user] ON;

INSERT INTO [dbo].[m_admin_user] ([admin_user_id], [password], [admin_role_kbn], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg], [login_id]) VALUES ('1', 'a40546cc4fd6a12572828bb803380888ad1bfdab', 'SU', '2014-12-01', '2014-12-01', '1', '1', '0', 'admin');

INSERT INTO [dbo].[m_admin_user] ([admin_user_id], [password], [admin_role_kbn], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg], [login_id]) VALUES ('2', 'b6b1f4781776979c0775c71ebdd8bdc084aac5fe', 'KE', '2014-12-01', '2014-12-01', '1', '1', '0', 'user');

INSERT INTO [dbo].[m_admin_user] ([admin_user_id], [password], [admin_role_kbn], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg], [login_id]) VALUES ('3', 'b6b1f4781776979c0775c71ebdd8bdc084aac5fe', 'SU', '2014-12-01', '2014-12-01', '1', '1', '0', 'test001');

INSERT INTO [dbo].[m_admin_user] ([admin_user_id], [password], [admin_role_kbn], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg], [login_id]) VALUES ('4', 'b6b1f4781776979c0775c71ebdd8bdc084aac5fe', 'SU', '2014-12-01', '2014-12-01', '1', '1', '0', 'test002');

INSERT INTO [dbo].[m_admin_user] ([admin_user_id], [password], [admin_role_kbn], [cre_dt], [upd_dt], [cre_user_id], [upd_user_id], [del_flg], [login_id]) VALUES ('5', 'b6b1f4781776979c0775c71ebdd8bdc084aac5fe', 'KE', '2014-12-01', '2014-12-01', '1', '1', '0', 'test005');

SET IDENTITY_INSERT [dbo].[m_admin_user] OFF;