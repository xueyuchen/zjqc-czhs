/* Drop Tables */

IF ObJECt_ID('[t_counseling]') IS NOT NULL DROP TABLE [t_counseling];
IF ObJECt_ID('[t_reserve]') IS NOT NULL DROP TABLE [t_reserve];
IF ObJECt_ID('[t_evaluate]') IS NOT NULL DROP TABLE [t_evaluate];
IF ObJECt_ID('[t_meal_comment]') IS NOT NULL DROP TABLE [t_meal_comment];
IF ObJECt_ID('[t_tel_counseling]') IS NOT NULL DROP TABLE [t_tel_counseling];
IF ObJECt_ID('[t_last_ref]') IS NOT NULL DROP TABLE [t_last_ref];
IF ObJECt_ID('[t_user_photo]') IS NOT NULL DROP TABLE [t_user_photo];
IF ObJECt_ID('[t_enquete_ans]') IS NOT NULL DROP TABLE [t_enquete_ans];
IF ObJECt_ID('[t_change_plan_hist]') IS NOT NULL DROP TABLE [t_change_plan_hist];
IF ObJECt_ID('[t_exam_kbn_hist]') IS NOT NULL DROP TABLE [t_exam_kbn_hist];
IF ObJECt_ID('[t_exam]') IS NOT NULL DROP TABLE [t_exam];
IF ObJECt_ID('[t_time_line]') IS NOT NULL DROP TABLE [t_time_line];
IF ObJECt_ID('[t_user_sheet]') IS NOT NULL DROP TABLE [t_user_sheet];
IF ObJECt_ID('[t_point_hist]') IS NOT NULL DROP TABLE [t_point_hist];
IF ObJECt_ID('[t_img]') IS NOT NULL DROP TABLE [t_img];
IF ObJECt_ID('[t_meal]') IS NOT NULL DROP TABLE [t_meal];
IF ObJECt_ID('[t_info]') IS NOT NULL DROP TABLE [t_info];
IF ObJECt_ID('[t_push_msg]') IS NOT NULL DROP TABLE [t_push_msg];
IF ObJECt_ID('[t_forget_pwd]') IS NOT NULL DROP TABLE [t_forget_pwd];
IF ObJECt_ID('[t_change_plan_comp]') IS NOT NULL DROP TABLE [t_change_plan_comp];
IF ObJECt_ID('[t_change_plan]') IS NOT NULL DROP TABLE [t_change_plan];
IF ObJECt_ID('[t_hurikaeri_item]') IS NOT NULL DROP TABLE [t_hurikaeri_item];
IF ObJECt_ID('[t_hurikaeri]') IS NOT NULL DROP TABLE [t_hurikaeri];
IF ObJECt_ID('[t_day_record]') IS NOT NULL DROP TABLE [t_day_record];
IF ObJECt_ID('[t_user]') IS NOT NULL DROP TABLE [t_user];
IF ObJECt_ID('[m_admin_user]') IS NOT NULL DROP TABLE [m_admin_user];
IF ObJECt_ID('[m_changeplan_type]') IS NOT NULL DROP TABLE [m_changeplan_type];
IF ObJECt_ID('[m_changplan_s_group]') IS NOT NULL DROP TABLE [m_changplan_s_group];
IF ObJECt_ID('[m_changeplan_m_group]') IS NOT NULL DROP TABLE [m_changeplan_m_group];
IF ObJECt_ID('[m_fixed_phrase]') IS NOT NULL DROP TABLE [m_fixed_phrase];
IF ObJECt_ID('[m_hurikaeri_item]') IS NOT NULL DROP TABLE [m_hurikaeri_item];
IF ObJECt_ID('[m_movie]') IS NOT NULL DROP TABLE [m_movie];
IF ObJECt_ID('[m_stamp]') IS NOT NULL DROP TABLE [m_stamp];
IF ObJECt_ID('[m_vcube_account]') IS NOT NULL DROP TABLE [m_vcube_account];
IF ObJECt_ID('[t_fixed_phrase_type]') IS NOT NULL DROP TABLE [t_fixed_phrase_type];
IF ObJECt_ID('[t_tmp_user]') IS NOT NULL DROP TABLE [t_tmp_user];
IF ObJECt_ID('[t_user_cancel_hist]') IS NOT NULL DROP TABLE [t_user_cancel_hist];




/* Create Tables */

CREATE TABLE [m_admin_user]
(
	[admin_user_id] int NOT NULL IDENTITY ,
	-- 暗号化
	[password] nvarchar(256) NOT NULL,
	-- SU：管理者
	-- KE：管理栄養士
	[admin_role_kbn] char(2) NOT NULL,
	[login_id] nvarchar(30) NOT NULL UNIQUE,
	[admin_user_name] nvarchar(20),
	[admin_user_photo] nvarchar(256),
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([admin_user_id])
);


CREATE TABLE [m_changeplan_m_group]
(
	[changeplan_m_group_id] int NOT NULL IDENTITY ,
	-- ET：食事
	-- SP：運動
	-- ST：その他
	[group_kbn] nvarchar(2) NOT NULL,
	[changeplan_m_group_name] nvarchar(80) NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([changeplan_m_group_id])
);


CREATE TABLE [m_changeplan_type]
(
	[changeplan_type_id] int NOT NULL IDENTITY ,
	[point] int NOT NULL,
	[changeplan_type_name] nvarchar(80) NOT NULL,
	-- ET：食事
	-- SP：運動
	-- ST：その他
	[group_kbn] nvarchar(2) NOT NULL,
	-- 0:デフォルトではない
	-- 1:デフォルトでチェンジプランに追加する
	[default_flg] int NOT NULL,
	[changplan_s_group_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([changeplan_type_id])
);


CREATE TABLE [m_changplan_s_group]
(
	[changplan_s_group_id] int NOT NULL IDENTITY ,
	[changplan_s_group_name] nvarchar(80) NOT NULL,
	[changeplan_m_group_id] int NOT NULL,
	PRIMARY KEY ([changplan_s_group_id])
);


CREATE TABLE [m_fixed_phrase]
(
	[fixed_phrase_id] int NOT NULL IDENTITY ,
	[fixed_phrase] text NOT NULL,
	[fixed_phrase_type_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([fixed_phrase_id])
);


CREATE TABLE [m_hurikaeri_item]
(
	[hurikaeri_item_name_id] int NOT NULL IDENTITY ,
	[hurikaeri_item_name] nvarchar(80) NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([hurikaeri_item_name_id])
);


CREATE TABLE [m_movie]
(
	[movie_id] int NOT NULL IDENTITY ,
	-- ET：食事
	-- SP：運動
	-- ST：その他
	[group_kbn] nvarchar(2) NOT NULL,
	[movie_name] nvarchar(80) NOT NULL,
	[movie_path] nvarchar(256) NOT NULL,
	[movie_description] text,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([movie_id])
);


CREATE TABLE [m_stamp]
(
	[stamp_id] int NOT NULL IDENTITY ,
	[stamp_name] nvarchar(20) NOT NULL,
	[stamp_img_path] nvarchar(256) NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([stamp_id])
);


CREATE TABLE [m_vcube_account]
(
	[vcube_account_id] int NOT NULL IDENTITY ,
	[vucube_user_id] nvarchar(64) NOT NULL,
	[vcube_user_pwd] nvarchar(64) NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([vcube_account_id])
);


CREATE TABLE [t_change_plan]
(
	[change_plan_id] int NOT NULL IDENTITY ,
	[user_id] int NOT NULL,
	[changeplan_type_id] int NOT NULL,
	-- ユーザが削除できないflg（管理栄養士が設定したもの）
	[dont_remove_flg] int DEFAULT 0 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([change_plan_id]),
	CONSTRAINT t_change_plan__user_id__change_plan_type_id UNIQUE ([user_id], [changeplan_type_id])
);


CREATE TABLE [t_change_plan_comp]
(
	[change_plan_comp_id] int NOT NULL IDENTITY ,
	[change_plan_id] int NOT NULL,
	[comp_date] date NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([change_plan_comp_id]),
	CONSTRAINT t_change_plan_comp__change_plan_id__comp_date UNIQUE ([change_plan_id], [comp_date])
);


-- このデータは、毎日0時に前日分のデータをバッチで作成する。
-- ＜作成手順＞
-- １．t_change_planの数分、このデータを作成する
-- 　このときt_change_planのcre_dtが本日のものは除外する
-- ２．t_change_plan_compの中で完了日が前日のものを抽出する
-- ３．１で作成したデータから、２で抽出したデータと同じchange_plan_type_idを持つデータの完了flgをonにする
-- ４．２で抽出したデータは、t_change_plan_compから物理削除する。
CREATE TABLE [t_change_plan_hist]
(
	[change_plan_hist_id] int NOT NULL IDENTITY ,
	[record_date] date NOT NULL,
	[user_id] int NOT NULL,
	[changeplan_type_id] int NOT NULL,
	-- 0：未完了
	-- 1：完了
	[compl_flg] int DEFAULT 0 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([change_plan_hist_id]),
	CONSTRAINT t_change_plan_hist__user_id__reg_date__change_plan_type_id UNIQUE ([record_date], [user_id], [changeplan_type_id])
);


CREATE TABLE [t_counseling]
(
	[counseling_id] int NOT NULL IDENTITY ,
	-- ダイエットのテーマを入力した管理者（管理栄養士）のID
	[admin_user_id] int NOT NULL,
	[user_id] int NOT NULL,
	-- 初回カウンセリングのときに入れる
	[diet_thema] nvarchar(256),
	[content_1] text,
	[counseling_dt_1] datetime,
	[content_2] text,
	[counseling_dt_2] datetime,
	[content_3] text,
	[counseling_dt_3] datetime,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([counseling_id]),
	CONSTRAINT t_counseling__user_id UNIQUE ([user_id])
);


CREATE TABLE [t_day_record]
(
	[day_record_id] int NOT NULL IDENTITY ,
	[weight] decimal(4,1),
	[step] int,
	[body_fat] decimal(4,1),
	[record_date] date NOT NULL,
	[user_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([day_record_id])
);


CREATE TABLE [t_enquete_ans]
(
	[enquete_ans_id] int NOT NULL IDENTITY ,
	[user_id] int NOT NULL,
	-- 以下のようなjson形式ので回答を全回答を格納する。
	-- {<質問id>:<回答>,  ～以降繰り返し～}
	-- ・質問id：
	-- 　"Q12_1"のような形式
	-- 　BOHC_画面定義書_BtoC_PC_一般user画面.xlsxの「アンケート内容」シートを参照のこと
	-- ・回答：
	-- 　文字入力の場合：入力文字
	-- 　数値入力の場合：数値
	-- 　ラジオボタンの場合：選択された番号
	-- 　チェックボックスの場合：0 - off、1 - on
	[ans_json] text NOT NULL,
	-- アンケートの内容が変化すると回答が合致しなくなるため、アンケートのバージョンを記録する
	[enquete_ver] int DEFAULT 1 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([enquete_ans_id])
);


CREATE TABLE [t_evaluate]
(
	[evaluate_id] int NOT NULL IDENTITY ,
	-- 1~4
	[eval_quantity] int DEFAULT 0 NOT NULL,
	-- 1~4
	[eval_balance] int DEFAULT 0 NOT NULL,
	-- 1～4
	[eval_fat] int DEFAULT 0 NOT NULL,
	-- 1～4
	[eval_glycolipid] int DEFAULT 0 NOT NULL,
	-- 1～4
	[eval_time] int DEFAULT 0 NOT NULL,
	[admin_user_id] int,
	[user_id] int NOT NULL,
	[evel_date] date NOT NULL,
	[eval_dt] datetime,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([evaluate_id]),
	CONSTRAINT t_evaluate__user_id__eval_date UNIQUE ([user_id], [evel_date])
);


CREATE TABLE [t_exam]
(
	[exam_id] int NOT NULL IDENTITY ,
	[user_id] int NOT NULL,
	[apply_dt] datetime NOT NULL,
	-- ・SS：登録申請済み
	-- ・NK：入金待ち
	-- ・NC：支払い済み（ユーザーへの発送待ち）
	-- ・SE：検体キット送信済み（検体受信待ち）
	-- ・KS：ユーザから検体キット受信済み（検査機関への発送待ち）
	-- ・WR：検査機関へ送付済み（検査機関からの結果待ち）
	-- ・CP：検査機関から受信済み（検体No.入力済み）
	-- ・IM：遺伝子結果取り込み済み
	[status_kbn] char(2) NOT NULL,
	[status_kbn_change_dt] datetime NOT NULL,
	[receipt_dt] date,
	[exam_dt] date,
	[exam_no] int DEFAULT 0 NOT NULL,
	-- T/T, C/C のような値が入る
	[adrb3] nvarchar(3),
	-- A/G, G/G のような値が入る
	[ucp1] nvarchar(3),
	-- A/A, A/G のような値が入る
	[ardb2] nvarchar(3),
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([exam_id])
);


CREATE TABLE [t_exam_kbn_hist]
(
	[exam_kbn_hist_id] int NOT NULL IDENTITY ,
	-- ・SS：登録申請済み
	-- ・NK：入金待ち
	-- ・NC：支払い済み（ユーザーへの発送待ち）
	-- ・SE：検体キット送信済み（検体受信待ち）
	-- ・KS：ユーザから検体キット受信済み（検査機関への発送待ち）
	-- ・WR：検査機関へ送付済み（検査機関からの結果待ち）
	-- ・CP：検査機関から受信済み（検体No.入力済み）
	-- ・IM：遺伝子結果取り込み済み
	[status_kbn] char(2) NOT NULL,
	[kbn_change_dt] datetime NOT NULL,
	[exam_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([exam_kbn_hist_id]),
	CONSTRAINT t_exam_kbn_hist__exam_id__status_kbn UNIQUE ([status_kbn], [exam_id])
);


CREATE TABLE [t_fixed_phrase_type]
(
	[fixed_phrase_type_id] int NOT NULL IDENTITY ,
	[fixed_phrase_type] nvarchar(20) NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([fixed_phrase_type_id])
);


CREATE TABLE [t_forget_pwd]
(
	[forget_pwd_id] int NOT NULL IDENTITY ,
	-- これをメールのURLに埋め込む
	[one_time_key] nvarchar(256) NOT NULL,
	-- ここからn時間（システムプロパティ値）以上経過している場合は、無効とする。
	[send_dt] datetime NOT NULL,
	[user_id] int NOT NULL,
	-- 0:未使用
	-- 1:使用済み
	[used_flg] int DEFAULT 0 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([forget_pwd_id])
);


CREATE TABLE [t_hurikaeri]
(
	[hurikaeri_id] int NOT NULL IDENTITY ,
	[user_id] int NOT NULL,
	[hurikaeri_date] date NOT NULL,
	[sleep_time] int DEFAULT 0 NOT NULL,
	[hurikaeri_comment] text,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([hurikaeri_id]),
	CONSTRAINT t_hurikaeri__user_id__hurikaeri_date UNIQUE ([user_id], [hurikaeri_date])
);


CREATE TABLE [t_hurikaeri_item]
(
	[hurikaeri_item_id] int NOT NULL IDENTITY ,
	[hurikaeri_id] int NOT NULL,
	-- 0:未設定
	-- 1:✕
	-- 2:△
	-- 3:○
	-- 
	-- 
	[level] int DEFAULT 0 NOT NULL,
	[hurikaeri_item_name_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([hurikaeri_item_id])
);


CREATE TABLE [t_img]
(
	[img_id] int NOT NULL IDENTITY ,
	-- 「xxxxxxxxx.jpg」のようなファイル名が入る.
	-- ※画像ファイルは、推測しずらい名称にすること
	[img_path] nvarchar(256) NOT NULL,
	[meal_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([img_id])
);


CREATE TABLE [t_info]
(
	[info_id] int NOT NULL IDENTITY ,
	[info_title] nvarchar(128) NOT NULL,
	[info] text NOT NULL,
	[from_dt] datetime NOT NULL,
	[to_dt] datetime NOT NULL,
	-- お知らせを登録するとpush通知するためにt_push_msgを追加するため、そのIDを登録する。
	-- 登録する目的は、お知らせの開始日時を変更した場合にt_push_msg.push_send_reserve_dtも変更する必要があるため。
	-- また、お知らせを削除した場合も対応するpushデータも削除する必要がある。
	[push_msg_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([info_id])
);


CREATE TABLE [t_last_ref]
(
	[last_ref_id] int NOT NULL IDENTITY ,
	-- ・MA：食事アドバイス
	-- ・TM：タイムライン
	-- ・IF：お知らせ
	-- ・MV：動画
	-- ・CS：カウンセリング
	-- ・（まだある場合は三上まで連絡してください）
	[ref_kbn] nvarchar(2) NOT NULL,
	-- ＜使い方＞
	-- ・例えばタイムラインの新着を判定する場合は、以下のようにする。
	-- 　「t_last_ref.ref_dt < t_time_line.cre_dt」
	[ref_dt] datetime NOT NULL,
	[user_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([last_ref_id]),
	CONSTRAINT t_last_ref__user_id__ref_kbn UNIQUE ([ref_kbn], [user_id])
);


CREATE TABLE [t_meal]
(
	[meal_id] int NOT NULL IDENTITY ,
	-- BR：朝食
	-- LC：昼食
	-- DN：夕食
	-- KS：間食
	[time_kbn] char(2) NOT NULL,
	[eat_dt] datetime NOT NULL,
	[user_id] int NOT NULL,
	-- 1:食事していない、
	-- 0:食事している
	[ingestion_flg] int DEFAULT 0 NOT NULL,
	[user_meal_comment] text,
	[calorie] int DEFAULT 0 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([meal_id])
);


CREATE TABLE [t_meal_comment]
(
	[meal_comment_id] int NOT NULL IDENTITY ,
	[meal_comment] text,
	-- 0-未承認
	-- 1-承認済み
	-- 2-差し戻し
	[approval_sts] int DEFAULT 0 NOT NULL,
	[approval_dt] date,
	[admin_user_id] int,
	[user_id] int NOT NULL,
	-- 管理栄養士がコメントをした日時
	-- 承認されずに再度コメントしたした場合は更新した日時を入れる
	[comment_dt] datetime NOT NULL,
	-- 毎週月曜になるので注意すること
	[from_date] date NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([meal_comment_id]),
	CONSTRAINT t_meal_comment__user_id__from_date UNIQUE ([user_id], [from_date])
);


CREATE TABLE [t_point_hist]
(
	[point_hist_id] int NOT NULL IDENTITY ,
	[point] int,
	[user_id] int NOT NULL,
	[changeplan_type_id] int,
	-- ・CH：チェンジポイント
	-- ・WR：体重記録
	-- ・ER：食事記録
	-- ・PR：姿写真記録
	-- ・SR：歩数記録
	-- ・BF：体脂肪率
	-- ・MV：動画
	-- ・HK：振り返り
	-- ・GW：理想の体重
	-- 
	[point_kbn] nvarchar(2) NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([point_hist_id])
);


CREATE TABLE [t_push_msg]
(
	[push_msg_id] int NOT NULL IDENTITY ,
	-- send_all_flgが1の場合のみnullになる。
	[user_id] int,
	-- BOHC_画面定義書_BtoC_スマホ画面.xlsxの「別紙２」を参照のこと
	[push_msg_type] nvarchar(2) NOT NULL,
	[push_msg] nvarchar(500) NOT NULL,
	-- 送信予約したい場合にだけ追加する。
	-- 2015/1/12時点では、「お知らせ通知」でのみ使用する予定。
	[push_send_reserve_dt] datetime,
	-- 0：未送信
	-- 1：送信済
	[push_send_flg] int DEFAULT 0 NOT NULL,
	-- push送信flgをonにした日時
	-- 
	[push_send_dt] datetime,
	-- ※現状は常に0が入る。将来の拡張のために定義しておく
	-- 0:未開封
	-- 1:開封
	[open_flg] int NOT NULL,
	-- このflgがonのときは、t_user全員に通知する。
	-- (ただし、del_flg=1 のユーザは除外する)
	-- このTBLのデータが無駄に増えないようにするのが目的。
	[send_all_flg] int DEFAULT 0,
	-- お知らせをタップしたら遷移する画面のURL。
	-- 「http://<host>/～」
	-- ではなく
	-- 「/～」のように相対パスで指定すること。
	-- アプリを起動すれば良いだけの場合は、指定不要。
	[link_url] nvarchar(256),
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([push_msg_id])
);


CREATE TABLE [t_reserve]
(
	[reserve_id] int NOT NULL IDENTITY ,
	[user_id] int,
	-- 予約を希望する場合に使用する
	[request_flg] int DEFAULT 0 NOT NULL,
	[admin_user_id] int,
	[reserve_date] date NOT NULL,
	[reserve_time] time NOT NULL,
	-- V-CUBEに予約した後の予約識別子が発行されると予測して入れている。12/14mikami
	-- API仕様は、2015/1/早々に来るらしいのでそこで確定する。
	[vcube_reserve_id] nvarchar(128),
	-- TV会議のURL。
	-- ユーザにメールで送信する。
	[vcube_reserve_url] nvarchar(256),
	[vcube_account_id] int,
	-- 0:休み
	-- 1:空き
	-- 2:予約済み
	[work_sts] int DEFAULT 0 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([reserve_id])
);


CREATE TABLE [t_tel_counseling]
(
	[tel_counseling_id] int NOT NULL IDENTITY ,
	[user_id] int NOT NULL,
	[admin_user_id] int NOT NULL,
	[tel_counseling_date] date NOT NULL,
	-- １~
	-- 
	[tel_counseling_count] int DEFAULT 1 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([tel_counseling_id])
);


CREATE TABLE [t_time_line]
(
	[time_line_id] int NOT NULL IDENTITY ,
	[admin_user_id] int NOT NULL,
	[stamp_id] int,
	[tl_message] nvarchar(500),
	[user_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([time_line_id])
);


CREATE TABLE [t_tmp_user]
(
	[tmp_user_id] int NOT NULL IDENTITY ,
	[email] nvarchar(128) NOT NULL,
	-- ・UUIDで作成
	[onetime_key] nvarchar(40) NOT NULL UNIQUE,
	-- ・この日時＋有効期限（システムプロパティで登録）が現在日時以降であればOK
	[tmp_regist_dt] datetime NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([tmp_user_id])
);


CREATE TABLE [t_user]
(
	[user_id] int NOT NULL IDENTITY ,
	-- 暗号化
	[password] nvarchar(256) NOT NULL,
	[email] nvarchar(128) NOT NULL,
	[first_name_kanji] nvarchar(30) NOT NULL,
	[last_name_kanji] nvarchar(30) NOT NULL,
	[first_name_kana] nvarchar(30) NOT NULL,
	[last_name_kana] nvarchar(30) NOT NULL,
	[sex] int DEFAULT 0 NOT NULL,
	[nick_name] nvarchar(30) NOT NULL,
	[birthday] date NOT NULL,
	[zip] nvarchar(7) NOT NULL,
	[prefecture] nvarchar(5) NOT NULL,
	[address1] nvarchar(25) NOT NULL,
	[address2] nvarchar(70) NOT NULL,
	[phone_number] nvarchar(13) NOT NULL,
	-- BOHCの既存DBにあったので入れてあるが、本システムでは使用しない。
	[mobile_number] nvarchar(13),
	-- GMOから呼び出される「リンク決済結果受け取り」のPOSTパラメータの内容全てをjson形式で格納する
	[payment_result] text,
	-- CD:クレジットカード
	-- PE:Pay-easy
	[payment_kbn] nvarchar(2),
	-- GMOから支払いが正常に行われたことが報告された時点の日時をセットする
	[payment_dt] datetime,
	-- 決済画面を表示するタイミングで生成する
	[order_num] nvarchar(80),
	[start_rec_date] date,
	[target_weight ] decimal(4,1),
	[first_weight ] decimal(4,1),
	[target_point] int,
	-- このカラムは、BtoBの方式を踏襲するために追加した。
	-- ＜BtoBの仕様＞
	-- ・端末側ではログインが成功した後にUUIDを生成する。
	-- ・これをHTTPヘッダに「Authentication-Token」という識別子でセットする。
	-- ・UUIDの生成方法は、BtoBのHPActivityBC505.javaを参照のこと
	[auth_token] nvarchar(256),
	-- 「xxxxxxxxx.jpg」のようなファイル名が入る.
	-- ※画像ファイルは、推測しずらい名称にすること
	-- 
	[user_img_path] nvarchar(256),
	-- 1～？
	[background_img_no] int DEFAULT 1 NOT NULL,
	[height] decimal(4,1),
	[admin_user_id] int,
	-- push通知に使用するデバイストークン
	[device_token] nchar(256),
	-- 1: Android
	-- 2: IOS
	[device_type] int DEFAULT 0 NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([user_id])
);


CREATE TABLE [t_user_cancel_hist]
(
	[user_cancel_hist_id] int NOT NULL IDENTITY ,
	[cancel_dt] datetime NOT NULL,
	[user_id] int,
	-- 暗号化
	[password] nvarchar(256),
	[email] nvarchar(128),
	[last_name_kanji] nvarchar(30),
	[first_name_kanji] nvarchar(30),
	[first_name_kana] nvarchar(30),
	[last_name_kana] nvarchar(30),
	[sex] int,
	[nick_name] nvarchar(30),
	[birthday] date,
	[login_id] nvarchar(30),
	[zip] nvarchar(7),
	[prefecture] nvarchar(5),
	[address1] nvarchar(25),
	[address2] nvarchar(70),
	[phone_number] nvarchar(13),
	-- BOHCの既存DBにあったので入れてあるが、本システムでは使用しない。
	[mobile_number] nvarchar(13),
	-- CD:クレジットカード
	-- PE:Pay-easy
	[payment_kbn] nvarchar(2),
	-- GMOから支払いが正常に行われたことが報告された時点の日時をセットする
	[payment_dt] datetime,
	-- 決済画面を表示するタイミングで生成する
	[order_num] nvarchar(80),
	[start_rec_date] date,
	[target_weight ] decimal(4,1),
	[first_weight ] decimal(4,1),
	[target_point] int,
	-- このカラムは、BtoBの方式を踏襲するために追加した。
	-- ＜BtoBの仕様＞
	-- ・端末側ではログインが成功した後にUUIDを生成する。
	-- ・これをHTTPヘッダに「Authentication-Token」という識別子でセットする。
	-- ・UUIDの生成方法は、BtoBのHPActivityBC505.javaを参照のこと
	[auth_token] nvarchar(256),
	-- 「xxxxxxxxx.jpg」のようなファイル名が入る.
	-- ※画像ファイルは、推測しずらい名称にすること
	-- 
	[user_img_path] nvarchar(256),
	-- 1～？
	[background_img_no] int,
	[height] decimal(4,1),
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([user_cancel_hist_id])
);


CREATE TABLE [t_user_photo]
(
	[user_photo_id] int NOT NULL IDENTITY ,
	-- 「xxxxxxxxx.jpg」のようなファイル名が入る.
	-- ※画像ファイルは、推測しずらい名称にすること
	-- 
	[photo_face_file] nvarchar(128),
	-- 「xxxxxxxxx.jpg」のようなファイル名が入る.
	-- ※画像ファイルは、推測しずらい名称にすること
	-- 
	[photo_body_file] nvarchar(128),
	-- 「xxxxxxxxx.jpg」のようなファイル名が入る.
	-- ※画像ファイルは、推測しずらい名称にすること
	-- 
	[photo_etc_file] nvarchar(128),
	[shoot_dt] datetime NOT NULL,
	[user_id] int NOT NULL,
	[user_comment] text,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([user_photo_id])
);


CREATE TABLE [t_user_sheet]
(
	[user_sheet_id] int NOT NULL IDENTITY ,
	[sheet_reg_dt] datetime NOT NULL,
	[sheet_title] nvarchar(128) NOT NULL,
	[sheet_text] text,
	[user_id] int NOT NULL,
	[admin_user_id] int NOT NULL,
	[cre_dt] datetime NOT NULL,
	-- 初期値には登録日を入れる
	[upd_dt] datetime NOT NULL,
	[cre_user_id] int DEFAULT 0 NOT NULL,
	[upd_user_id] int DEFAULT 0 NOT NULL,
	-- 0: off, 1:on
	[del_flg] int DEFAULT 0 NOT NULL,
	PRIMARY KEY ([user_sheet_id])
);



/* Create Foreign Keys */

ALTER TABLE [t_counseling]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [t_reserve]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [t_evaluate]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [t_meal_comment]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [t_user]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [t_tel_counseling]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [t_time_line]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [t_user_sheet]
	ADD FOREIGN KEY ([admin_user_id])
	REFERENCES [m_admin_user] ([admin_user_id])
;


ALTER TABLE [m_changplan_s_group]
	ADD FOREIGN KEY ([changeplan_m_group_id])
	REFERENCES [m_changeplan_m_group] ([changeplan_m_group_id])
;


ALTER TABLE [t_point_hist]
	ADD FOREIGN KEY ([changeplan_type_id])
	REFERENCES [m_changeplan_type] ([changeplan_type_id])
;


ALTER TABLE [t_change_plan]
	ADD FOREIGN KEY ([changeplan_type_id])
	REFERENCES [m_changeplan_type] ([changeplan_type_id])
;


ALTER TABLE [t_change_plan_hist]
	ADD FOREIGN KEY ([changeplan_type_id])
	REFERENCES [m_changeplan_type] ([changeplan_type_id])
;


ALTER TABLE [m_changeplan_type]
	ADD FOREIGN KEY ([changplan_s_group_id])
	REFERENCES [m_changplan_s_group] ([changplan_s_group_id])
;


ALTER TABLE [t_hurikaeri_item]
	ADD FOREIGN KEY ([hurikaeri_item_name_id])
	REFERENCES [m_hurikaeri_item] ([hurikaeri_item_name_id])
;


ALTER TABLE [t_time_line]
	ADD FOREIGN KEY ([stamp_id])
	REFERENCES [m_stamp] ([stamp_id])
;


ALTER TABLE [t_reserve]
	ADD FOREIGN KEY ([vcube_account_id])
	REFERENCES [m_vcube_account] ([vcube_account_id])
;


ALTER TABLE [t_change_plan_comp]
	ADD FOREIGN KEY ([change_plan_id])
	REFERENCES [t_change_plan] ([change_plan_id])
;


ALTER TABLE [t_exam_kbn_hist]
	ADD FOREIGN KEY ([exam_id])
	REFERENCES [t_exam] ([exam_id])
;


ALTER TABLE [m_fixed_phrase]
	ADD FOREIGN KEY ([fixed_phrase_type_id])
	REFERENCES [t_fixed_phrase_type] ([fixed_phrase_type_id])
;


ALTER TABLE [t_hurikaeri_item]
	ADD FOREIGN KEY ([hurikaeri_id])
	REFERENCES [t_hurikaeri] ([hurikaeri_id])
;


ALTER TABLE [t_img]
	ADD FOREIGN KEY ([meal_id])
	REFERENCES [t_meal] ([meal_id])
;


ALTER TABLE [t_info]
	ADD FOREIGN KEY ([push_msg_id])
	REFERENCES [t_push_msg] ([push_msg_id])
;


ALTER TABLE [t_tel_counseling]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_reserve]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_last_ref]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_user_photo]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_counseling]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_enquete_ans]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_change_plan_hist]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_exam]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_time_line]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_meal_comment]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_evaluate]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_user_sheet]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_point_hist]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_meal]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_push_msg]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_forget_pwd]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_change_plan]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_hurikaeri]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;


ALTER TABLE [t_day_record]
	ADD FOREIGN KEY ([user_id])
	REFERENCES [t_user] ([user_id])
;