##MySQL 数据库分库分表

###主从方案
1.一主一从
2.互为主从
3.一主多从
4.级联主从：M-S-3S 一主一从（从有多个级联）

###分库分表
1.垂直拆分
2.水平拆分（存在关联查询问题）

###Mycat之旅
0.原理

1.`逻辑库` 