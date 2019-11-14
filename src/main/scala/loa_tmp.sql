-- 2018-08-29 16:04:39.220285
drop table if exists loa_tmp.ti_loa_cam_acc_se_rewardrecord_temp;
create table loa_tmp.ti_loa_cam_acc_se_rewardrecord_temp(
 `reward_record_id` int comment '奖励记录id',
 `activity_id` int comment '活动id',
 `user_id` int comment '用户id',
 `invest_amount` decimal comment '投资金额',
 `reward_amount` decimal comment '奖励金额',
 `service_id` int comment '服务id',
 `soruce_name` string comment '源名字',
 `source_name` int comment '源id',
 `create_time` timestamp comment '添加时间',
 `system_time` timestamp comment '系统时间',
 `is_del` tinyint comment '是否删除',
 `update_time` timestamp comment '更新时间',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '手动奖励发放记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;


-- 2018-08-29 16:04:39.211284
drop table if exists loa_tmp.ti_loa_evt_acc_se_apploginlog_temp;
create table loa_tmp.ti_loa_evt_acc_se_apploginlog_temp(
 `id` int comment '主键自增',
 `user_id` int comment '用户id',
 `user_name` string comment '用户名',
 `device_token` string comment '客户端传的唯一标识',
 `os` string comment '客户端操作系统',
 `if_login_success` int comment '登录是否成功',
 `desc` string comment '描述',
 `version` int comment '版本号',
 `create_time` timestamp comment '创建时间',
 `update_time` timestamp comment '更新时间',
 `login_type_id` int comment '用户登录类型，0默认输密码，1，注册登录，2自动登录',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment 'app登录记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.213284
drop table if exists loa_tmp.ti_loa_per_acc_se_appregister_temp;
create table loa_tmp.ti_loa_per_acc_se_appregister_temp(
 `id` int comment '主键自增',
 `user_id` int comment '用户id',
 `user_name` string comment '用户名',
 `inviter` string comment '邀请人',
 `register_type` int comment '移动端注册类型',
 `create_time` timestamp comment '创建时间',
 `update_time` timestamp comment '更新时间',
 `os` string comment '客户端操作系统',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '移动端注册表'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.214284
drop table if exists loa_tmp.ti_loa_evt_acc_se_appwithdraws_temp;
create table loa_tmp.ti_loa_evt_acc_se_appwithdraws_temp(
 `id` int comment '主键自增',
 `order_id` int comment '订单号',
 `user_id` int comment '用户id',
 `user_name` string comment '用户名',
 `os` int comment '客户端操作系统',
 `withdraw_amount` decimal comment '提现金额',
 `poundage` decimal comment '手续费',
 `state` int comment '提现状态',
 `state_desc` string comment '状态描述',
 `create_time` timestamp comment '创建时间',
 `update_time` timestamp comment '更新时间',
 `unionpay_id` string comment '银行联行号',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '移动端提现表'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;



-- 2018-08-29 16:04:39.145280
drop table if exists loa_tmp.ti_loa_evt_acc_se_packaccount_log_temp;
create table loa_tmp.ti_loa_evt_acc_se_packaccount_log_temp(
 `id` int,
 `from_finance_acctno` int comment '资金从哪个后台帐户来',
 `to_finance_acctno` int comment '资金到哪个后台帐户去',
 `amount` decimal(34,16) comment '多少钱，可以为正负数',
 `create_time` timestamp comment '创建时间，自动更新',
 `log_type_id` int comment '这笔资金流动类型',
 `remark` string comment '备注信息',
 `front_user_id` string comment '前台账户userid',
 `flow_type_id` int comment '前后台账户的流动类型3--后台对后台2--后台流向前台1--前台流向后台',
 `balance` decimal(34,16) comment '资金变动后，帐户余额',
 `backend_acctno` int comment '这条记录是属于哪个后台帐户的',
 `bank_trans_type` string comment '银行交易类型',
 `bank_trans_desc` string comment '银行交易描述',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '理财包后台帐户资金记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.149280
drop table if exists loa_tmp.ti_loa_evt_acc_se_fundioflow_temp;
create table loa_tmp.ti_loa_evt_acc_se_fundioflow_temp(
 `io` int,
 `id` int,
 `action_sn` int,
 `uid` string,
 `trans_uid` string,
 `fund` decimal comment '额度',
 `trantm` timestamp,
 `res_fund` decimal comment '流动的资金',
 `reason` int,
 `detail` string,
 `bid_id` int,
 `bid_name` string,
 `bid_borrower_id` string,
 `from_user_id` int comment '用户idg_1:20sys:30repurchase:40p_sys:50',
 `to_user_id` int comment '用户idg_1:20sys:30repurchase:40p_sys:50',
 `bank_trans_time` timestamp comment '线下充值（银行发生时间）',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '前台账户资金流水明细'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.153281
drop table if exists loa_tmp.ti_loa_evt_acc_se_assetbuy_temp;
create table loa_tmp.ti_loa_evt_acc_se_assetbuy_temp(
 `action_sn` int,
 `asset_id` int,
 `tranam` decimal comment '投资金额',
 `deal_money` decimal comment '有效金额，成交金额',
 `quota` decimal,
 `principal` decimal comment '待收本金',
 `interest` decimal comment '待收利息',
 `reward` decimal comment '待收奖励',
 `saler` string comment '从谁那儿买的',
 `bid_id` int,
 `buyer` string comment '购买人',
 `trantm` timestamp comment '操作时间',
 `fn_if_package` int comment '是否属于理财包',
 `current_level_id` int comment '当前vip等级',
 `plus_rate` decimal comment '贴息奖励',
 `buyer_id` int comment '购买人g_1:20sys:30repurchase:40p_sys:50',
 `saler_id` int comment '从谁那儿买的g_1:20sys:30repurchase:40p_sys:50',
 `auth_code` string comment '第三方授权码',
 `if_experience_bid` int comment '体验标标识',
 `update_time` timestamp comment '数据仓库专用更新时间',
 `vip_level_type` int comment '标的投资时vip等级类型0老的vip1新的vip',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '债转执行订单记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.157281
drop table if exists loa_tmp.ti_loa_evt_acc_se_autoassetrecord_temp;
create table loa_tmp.ti_loa_evt_acc_se_autoassetrecord_temp(
 `id` int comment '主键',
 `trans_fee` string comment '向卖出方收取的手续费',
 `product_id` string comment '卖出方原标的号',
 `tranam` string comment '成交价格，买入方实际付出金额',
 `transfam` string comment '卖出的债权金额',
 `org_order_id` string comment '卖出方投标的原订单号',
 `acctno` string comment '买入方账号',
 `for_acctno` string comment '卖出方账号',
 `org_tranam` string comment '卖出方投标的原订单总金额',
 `cont_order_id` string comment '买入方自动债权转让签约订单号',
 `order_id` string comment '由p2p生成，必须保证唯一',
 `pack_id` int comment '理财包id',
 `auth_code` string comment '授权码',
 `state` int comment '0--待处理1--处理成功',
 `batch_id` int comment '批次号',
 `create_time` timestamp comment '数据仓库专用创建时间',
 `update_time` timestamp comment '数据仓库更新时间',
 `transfer_package_log_id` int comment '复投二级债权记录表id',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '自动资产转让记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.159281
drop table if exists loa_tmp.ti_loa_evt_acc_se_autoinvestrecord_temp;
create table loa_tmp.ti_loa_evt_acc_se_autoinvestrecord_temp(
 `id` int comment '主键',
 `channel` string comment '000001手机app000002网页000003微信000004柜面',
 `trantm` string comment '交易时间',
 `acctno` string comment '存管平台分配的账号',
 `product_id` string comment '标的号',
 `cont_order_id` string comment '自动投标签约订单号',
 `trans_fee` string comment '投标需付的手续费',
 `acq_res` string,
 `tranam` string comment '投标金额',
 `order_id` string comment '由p2p生成，必须保证唯一',
 `frz_flag` string comment '0-不冻结1-冻结',
 `seq_no` string comment '定长6位',
 `trandt` string comment '交易日期',
 `package_id` int comment '理财包id',
 `state` int comment '处理状态',
 `auth_code` string comment '发送成功返回的授权码,取消债权的时候使用',
 `reinvest_log_id` int comment '复投logid',
 `create_time` timestamp comment '数据仓库专用创建时间',
 `update_time` timestamp comment '数据仓库创建时间',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '自动投资记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.161281
drop table if exists loa_tmp.ti_loa_evt_acc_se_withdraws_temp;
create table loa_tmp.ti_loa_evt_acc_se_withdraws_temp(
 `action_sn` int,
 `cash_type` int comment '提现类型',
 `apply_money` decimal(34,16) comment '提现金额',
 `money_can_use` decimal(34,16) comment '申请时刻的可用资金',
 `cash_fee` decimal(34,16) comment '提现手续费',
 `cash_net_fee` decimal(34,16),
 `real_trans_fee` decimal(34,16),
 `money_from_recharge` decimal(34,16) comment '取现时冻结资金的来源于充值帐户的数目',
 `money_from_income` decimal(34,16) comment '取现时冻结资金的来源于income帐户的数目',
 `money_from_principal` decimal(34,16) comment '取现时冻结资金的来源于principal帐户的数目',
 `money_from_repayment` decimal(34,16) comment '取现时冻结资金的来源于repayment帐户的数目',
 `money_from_loan` decimal(34,16) comment '取现时冻结资金的来源于loan帐户的数目',
 `money_from_loan_networth` decimal(34,16),
 `cash_card` int,
 `to_user` string,
 `trantm` timestamp,
 `str_user_id` string,
 `user_is_trustee` int,
 `trans_audit1` timestamp,
 `audit1_user_id` string,
 `trans_audit2` timestamp,
 `audit2_user_id` string,
 `trans_cancel` timestamp,
 `trans_fail` timestamp,
 `user_id` int comment '用户idg_1:20sys:30repurchse:40p_sys:50',
 `to_user_num` int comment '用户idg_1:20sys:30repurchse:40p_sys:50',
 `last_state_id` int,
 `decimal_money` decimal(34,16) comment '厘帐户，仅用于记录各帐户的分后位',
 `bid_id` int comment '借款人提现标的标',
 `fund_type_id` int comment '1、本金2、咨询费',
 `source_type_id` int comment '2、lobe后台1、app信贷端',
 `is_large` int comment '0:普通1:大额',
 `update_time` timestamp comment '数据仓库专用更新时间',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '提现表：记录用户的提现记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.165281
drop table if exists loa_tmp.ti_loa_evt_acc_se_packinvest_temp;
create table loa_tmp.ti_loa_evt_acc_se_packinvest_temp(
 `id` int,
 `str_user_id` string comment '这笔投资是谁发起的',
 `tranam` decimal comment '投资了多少钱',
 `create_time` timestamp comment '投资时间',
 `packid` int comment '这笔投资，属于哪个理财包',
 `trans_type` int comment '投资类型',
 `deal_amount` decimal comment '实际生效的金额',
 `action_sn` int comment '关联fundio的actionsn',
 `user_name` string comment '投资人的登陆姓名',
 `if_super_full_package` int comment '是否为超级用户进行的满包',
 `money_from_recharge` decimal comment '从充值账户投资的金额',
 `money_from_principal` decimal comment '从本金账户投资的金额',
 `money_from_income` decimal comment '从收益账户投资的金额',
 `money_from_repayment` decimal comment '从还款账户投资的金额',
 `money_from_loan` decimal comment '从借款账户投资的金额',
 `money_from_loan_netvalue` decimal comment '从净值标借款账户投资的金额',
 `voucher_money` decimal comment '代金券金额',
 `user_id` int comment '这笔投资是谁发起的_用户id,g_1:20,sys:30,repurchase:40p_sys:50',
 `money_from_decimal` decimal comment '从厘账户投资的金额',
 `expect_reward` decimal comment '预期奖励',
 `coupon_type` int comment '代金券类型，默认0:表示未使用代金券1、满减券2、加息券',
 `update_time` timestamp comment '数据仓库专用更新时间',
 `if_asset_package` int comment '0:正常荷包1:债转荷包',
 `if_hidden` int comment '是否隐藏0,1',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '理财包投资记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.168282
drop table if exists loa_tmp.ti_loa_evt_acc_se_income_temp;
create table loa_tmp.ti_loa_evt_acc_se_income_temp(
 `repay_action_sn` int,
 `str_user_id` string comment '收款用户id',
 `transq` int comment '投资编号',
 `bid_id` int comment '标号',
 `issue` int comment '期数',
 `interest` decimal comment '利息收益金额',
 `reward` decimal comment '奖励',
 `principal` decimal comment '本金',
 `overdue_day` int comment '逾期天数',
 `overdue_interest` decimal comment '逾期利息',
 `liquidated_damages` decimal comment '提前还款违约金',
 `interest_fee` decimal comment '利息手续费',
 `trantm` timestamp comment '收款时间',
 `type_id` int comment '收益类型0本金利息逾期罚息违约金1奖励',
 `package_id` int,
 `user_id` int comment '用户编号数字型g_1=20sys=30repurchase=40p_sys:50',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '回款记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.171282
drop table if exists loa_tmp.ti_loa_evt_acc_se_invest_temp;
create table loa_tmp.ti_loa_evt_acc_se_invest_temp(
 `action_sn` int,
 `bid_id` int,
 `tranam` decimal(34,16) comment '投资金额',
 `if_auto` int comment '投标方式：1手动，2自动',
 `deal_money` decimal(34,16) comment '有效金额，成交金额',
 `expect_interest` decimal(34,16),
 `expect_reward` decimal(34,16),
 `money_from_recharge` decimal(34,16) comment '从充值账户投资的金额',
 `money_from_principal` decimal(34,16) comment '从本金账户投资的金额',
 `money_from_income` decimal(34,16) comment '从收益账户投资的金额',
 `money_from_repayment` decimal(34,16) comment '从还款账户投资的金额',
 `money_from_loan` decimal(34,16) comment '从借款账户投资的金额',
 `money_from_loan_netvalue` decimal(34,16) comment '从净值标借款账户投资的金额',
 `jobid` int,
 `str_user_id` string,
 `user_if_vip` int,
 `trantm` timestamp,
 `finance_package_id` int comment '理财包的id',
 `if_finance_package` int comment '是否为理财包内投资',
 `fn_str_user_id` string comment '出借人id',
 `fn_user_name` string comment '出借人name',
 `fn_invest_time` timestamp comment '投资时间',
 `fn_acctno` int comment '对应后台帐户id',
 `type_id` int comment '复投类型：0普通用户投资,1普通用户理财包投标,2超级用户前台满标,3超级用户后台满标,4普通用户后台复投',
 `current_vip_level` int comment '当前vip等级',
 `expect_plus_rate` decimal(34,16) comment '预期贴息奖励',
 `voucher_money` decimal(34,16) comment '代金券金额',
 `user_id` int comment '用户编号数字型g_1=20sys=30repurchase=40p_sys:50',
 `money_from_decimal` decimal(34,16) comment '从厘账户投资的金额',
 `auth_code` string comment '第三方授权码',
 `coupon_type_id` int comment '代金券类型，默认0:表示未使用代金券1、满减券2、加息券',
 `update_time` timestamp comment '数据仓库专用更新时间',
 `vip_level_type_id` int comment '标的投资时vip等级类型0老的vip1新的vip',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '投资帐户明细表：记录用户的每一笔投资'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.172282
drop table if exists loa_tmp.ti_loa_evt_acc_se_investorder_temp;
create table loa_tmp.ti_loa_evt_acc_se_investorder_temp(
 `id` int comment '主键',
 `order_id` int comment '订单号',
 `bid_id` int comment '标的id',
 `tranam` decimal(34,16) comment '投资金额',
 `if_auto` int comment '投标方式：1手动，2自动',
 `deal_money` decimal(34,16) comment '有效金额，成交金额',
 `expect_interest` decimal(34,16) comment '预期利息',
 `expect_reward` decimal(34,16) comment '预期奖励',
 `money_from_recharge` decimal(34,16) comment '从充值账户投资的金额',
 `money_from_principal` decimal(34,16) comment '从本金账户投资的金额',
 `money_from_income` decimal(34,16) comment '从收益账户投资的金额',
 `money_from_repayment` decimal(34,16) comment '从还款账户投资的金额',
 `money_from_loan` decimal(34,16) comment '从借款账户投资的金额',
 `money_from_loan_netvalue` decimal(34,16) comment '从净值标借款账户投资的金额',
 `jobid` int comment '任务id',
 `str_user_id` string comment '用户id',
 `user_if_vip` int comment '是否vip',
 `trantm_apply` timestamp comment '请求时间',
 `update_time` timestamp comment '更新时间',
 `current_vip_level` int comment '当前vip等级',
 `expect_plus_rate` decimal(34,16) comment '预期贴息奖励',
 `voucher_am` decimal(34,16) comment '代金券金额',
 `user_id` int comment '用户编号数字型g_1=20sys=30repurchase=40p_sys:50',
 `money_from_decimal` decimal(34,16) comment '从厘账户投资的金额',
 `auth_code` string comment '第三方授权码',
 `remarks` string comment '操作备注',
 `transt` int comment '投资状态',
 `transt_type` int comment '投资类型',
 `trandt` string comment '交易日期',
 `trantm` string comment '交易时间',
 `seq_no` string comment '交易码',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '投资帐户明细表：记录用户的每一笔投资'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.175282
drop table if exists loa_tmp.ti_loa_evt_acc_se_qrcodepay_temp;
create table loa_tmp.ti_loa_evt_acc_se_qrcodepay_temp(
 `id` int,
 `transq` string comment '交易序列号',
 `c2b_code` string comment 'c2b码',
 `tranam` decimal(34,16) comment '交易金额',
 `money_from_recharge` decimal(34,16) comment '从充值账户投资的金额',
 `money_from_principal` decimal(34,16) comment '从本金账户投资的金额',
 `money_from_income` decimal(34,16) comment '从收益账户投资的金额',
 `money_from_repayment` decimal(34,16) comment '从还款账户投资的金额',
 `money_from_loan` decimal(34,16) comment '从借款账户投资的金额',
 `money_from_loan_netvalue` decimal(34,16) comment '从净值标借款账户投资的金额',
 `money_from_decimal` decimal(34,16) comment '从厘账户投资的金额',
 `user_id` int comment '用户id',
 `bank_acctno` string comment '电子账号',
 `user_name` string comment '用户名',
 `real_name` string comment '真实姓名',
 `mercat_id` string comment '商户代码',
 `mercat_name` string comment '商户名称',
 `mercat_code` string comment '商户类别',
 `trans_state_id` int comment '支付状态',
 `create_time` timestamp comment '创建时间',
 `update_time` timestamp comment '更改时间',
 `comment` string comment '备注',
 `voucher_no` string comment '付款凭证号',
 `trans_type` int comment '付款类型',
 `retry_cnt` int comment '重试次数',
 `version` int comment '版本号',
 `terminal_id` string comment '终端号',
 `terminal_type` int comment '终端类别',
 `remarks` string comment '交易信息',
 `req_type` string comment '交易类型',
 `orig_req_type` string comment '原交易类型',
 `order_id` string comment '订单号',
 `coupon_info` string comment '优惠信息',
 `coupon_before_transam` decimal(34,16) comment '优惠前价格',
 `coupon_after_transam` decimal(34,16) comment '优惠后价格',
 `device_id` string comment '设备标识',
 `device_type` string comment '设备类型',
 `mobile` string comment '银行预留手机号',
 `acctno_hash` string comment '应用供方账户id',
 `source_ip` string comment 'ip',
 `device_gps` string comment '设备gps位置',
 `device_simno` string comment '设备sim卡号码',
 `project_type` string comment '项目类型',
 `spnsr_id` string comment '出资方',
 `offst_am` decimal(34,16) comment '抵消交易金额',
 `project_id` string comment '项目编号',
 `project_desc` string comment '项目简称',
 `add_info` string comment '附加信息',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '扫码支付明细'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.177282
drop table if exists loa_tmp.ti_loa_evt_acc_se_recharge_temp;
create table loa_tmp.ti_loa_evt_acc_se_recharge_temp(
 `action_sn` int,
 `recharge_type` int comment '充值方式，1第三方支付，2银行转账，3后台充值',
 `third_org` int comment '第三方支付公司id',
 `from_bank` int comment '充值来源名称，转账银行id',
 `bankno` string comment '转账银行卡号',
 `card_user_name` string comment '持卡人姓名',
 `tranam` decimal comment '充值金额，单位：元',
 `picture` string,
 `card_bank_company` int comment '公司银行名称',
 `card_id_company` string comment '公司银行卡号',
 `card_owner_company` string comment '公司持卡人姓名',
 `str_user_id` string comment '用户id',
 `remarks` string comment '备注',
 `trantm` timestamp comment '操作时间',
 `audit_user_id` string comment '审核人id',
 `audit_op` string comment '审核操作人id',
 `audit_remarks` string comment '审核备注',
 `audit_time` timestamp comment '审核时间',
 `user_id` int comment '用户编号数字型g_1=20sys=30repurchase=40p_sys:50',
 `last_state` int,
 `certificate_path` string comment '转账凭证路径',
 `bank_branch` string comment '银行支行',
 `unique_code` string comment '银行唯一3码',
 `deal_time` timestamp comment '处理时间',
 `update_time` timestamp comment '数据仓库修改时间',
 `pre_recharge_state` int comment '提前还款红包充值审核状态，0未审核，1已审核',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '充值帐户明细表：存储用户充值的每一笔记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.178282
drop table if exists loa_tmp.ti_loa_evt_acc_se_repay_temp;
create table loa_tmp.ti_loa_evt_acc_se_repay_temp(
 `action_sn` int,
 `bid_id` int,
 `repay_issue` int comment '第几期还款',
 `interest` decimal comment '还款利息',
 `reward` decimal comment '还款奖励',
 `principal` decimal comment '还款本金',
 `overdue_day` int comment '逾期天数',
 `overdue_interest` decimal comment '逾期利息',
 `liquidated_damages` decimal comment '提前还款违约金',
 `pay_sum` decimal comment '付款总额；即各投资者收到的钱的总额。它与借款人所付还款（本金＋利息）之间的差额是计算误差，误差由平台帐户填，计入fundio',
 `if_auto` int comment '0手动还款1自动还款',
 `ontime` int comment '0按时1逾期-1提前',
 `ts_repay_due` timestamp,
 `repay_type` int comment '还款类型0还款1还奖励',
 `str_user_id` string,
 `op_id` string,
 `user_if_trustee` int,
 `repay_mode` int,
 `ts_repay` timestamp,
 `op_memo` string,
 `user_id` int comment '用户编号数字型g_1=20sys=30repurchase=40p_sys:50',
 `op_id_num` int comment '操作用户编号数字型g_1=20sys=30repurchase=40p_sys:50',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '还款记录表'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.185283
drop table if exists loa_tmp.ti_loa_evt_acc_se_packbidjoin_temp;
create table loa_tmp.ti_loa_evt_acc_se_packbidjoin_temp(
 id int,
 packid int comment '理财包id',
 bid_id int comment '标id',
 join_type int comment '加入类型',
 join_time timestamp comment '加入时间',
 join_issue int comment '加入期数',
 if_first_match int comment '是否为首次标匹给理财包0非第一次1第一次',
markdel int comment '删除标记字段0有效1已失效'                      ,
join_money decimal comment '加入理财包的金额'                       ,
asset_id int comment '资产id'                                     ,
str_user_id string comment '转让人的userid'                         ,
last_packid int comment '上一个理财包id'                             ,
expect_principal int comment '预计待收本金'                       ,
expect_interest int comment '预计待收利息'                           ,
user_id int comment '用户id g_1:20 sys:30 repuchase:40 p_sys:50'     ,
update_time timestamp comment '数据仓库专用更新时间'               ,
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '理财包标的或债权加入记录'
row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;



-- 2018-08-29 16:04:39.111278
drop table if exists loa_tmp.ti_loa_evt_acc_se_loginlog_temp;
create table loa_tmp.ti_loa_evt_acc_se_loginlog_temp(
 `id` int comment '日志id',
 `user_id` int comment '用户id',
 `login_user_name` string comment '登陆用户名',
 `email` string comment '用户电子邮箱',
 `login_state_id` tinyint comment '1成功2用户名错误3邮箱错误4密码错误5验证码错误6账号被锁定7其他原因8app手势密码9业务用户不能登录',
 `client_ip` string comment '登陆ip地址',
 `login_time` timestamp comment '登陆时间',
 `income_sum` decimal comment '待收总额',
 `acctno_balance` decimal comment '可用余额',
 `login_type_id` tinyint comment '登录方式(0-web1-app2-轻应用)',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '登录日志表'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.113278
drop table if exists loa_tmp.ti_loa_evt_acc_se_integralexchange_temp;
create table loa_tmp.ti_loa_evt_acc_se_integralexchange_temp(
 `id` int comment '记录ｉｄ',
 `user_id` int comment '用户id',
 `exchange_type_id` tinyint comment '兑换类型1：积分兑换现金红包',
 `expend_integral` int comment '消耗积分',
 `exchange_amount` int comment '兑换数量',
 `exchange_fee` int comment '兑换金额（分）',
 `exchange_time` timestamp comment '兑换时间',
 `exchange_time_str` string comment '兑换时间（年月日）',
 `exchange_details` string comment '兑换明细',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '积分兑换记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.115279
drop table if exists loa_tmp.ti_loa_evt_acc_se_integralchange_temp;
create table loa_tmp.ti_loa_evt_acc_se_integralchange_temp(
 `id` int comment '积分快照',
 `user_id` int comment '用户id',
 `integral_change_type_id` int comment '1-初始化,2-收获利息,3-登录,4-兑换,5-积分清零',
 `current_integral` bigint comment '当前积分',
 `integral` bigint comment '积分',
 `exchange` string comment '兑换',
 `change_time` timestamp comment '交易时间',
 `remarks` string comment '备注',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '积分值变更记录'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.116279
drop table if exists loa_tmp.ti_loa_eve_acc_se_growthchange_temp;
create table loa_tmp.ti_loa_eve_acc_se_growthchange_temp(
 `id` int comment '成长值快照id',
 `user_id` int comment '用户id',
 `growth_change_type_id` int comment '类型(1-收获利息,2-完整填写个人信息)',
 `current_growth` bigint comment '当前成长值',
 `growth` bigint comment '成长值',
 `change_time` timestamp comment '时间',
 `remarks` string comment '备注',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '成长值变更记录表'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
-- 2018-08-29 16:04:39.119279
drop table if exists loa_tmp.ti_loa_evt_acc_se_userlevelchange_temp;
create table loa_tmp.ti_loa_evt_acc_se_userlevelchange_temp(
 `id` int,
 `user_id` int,
 `action_sn` int,
 `level_change_type_id` int comment '类型(1-购买,2-领取,3-升级,4-降级,5-到期)',
 `duration` int comment '会员期限（年）',
 `price` decimal,
 `level` int,
 `current_growth` bigint,
 `current_asset` decimal,
 `start_time` timestamp,
 `expire_time` timestamp comment '会员到期日',
 `change_time` timestamp comment '变更时间',
 `remarks` string comment '备注',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '会员等级变更记录表'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;


-- 2018-08-29 16:04:39.224285
drop table if exists loa_tmp.ti_loa_cam_acc_se_advertiseuser_behavior_temp;
create table loa_tmp.ti_loa_cam_acc_se_advertiseuser_behavior_temp(
 `advertise_user_id` int comment '广告用户id',
 `user_id` int comment '用户id',
 `advertise_id` int comment '广告id',
 `create_time` timestamp comment '添加时间',
 `action_type_id` tinyint comment '操作类型',
 `money` decimal comment 'actiontype=3为充值金额=4出借金额',
 `query_word` string comment '搜索词',
 `if_check` tinyint comment '出借是否已审核',
 `invest_id` int comment '出借id',
 `source_info` string comment '来源信息',
 `theme_name` string comment '模板名称',
 `update_time` timestamp comment '更新时间',
 `register_jump` tinyint comment '注册后跳转具体结果页1第一种页面2第二种页面',
bdw_insert_time timestamp comment '数据插入时间',bdw_statis_time timestamp comment '账期时间',bdw_statis_hour string comment '作业小时',bdw_statis_minute string comment '作业分钟')
 comment '广告用户行为表'
 row format delimited fields terminated by '\t' lines terminated by '\n' stored as orcfile;
