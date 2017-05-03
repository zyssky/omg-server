环境搭建：
jdk mysql tomcat

工具：
eclipse（for jee），如果用Myeclipse的话应该有自带tomcat

数据库：
user：zyssky
password：123456
Database：omg_db
(要自己新建用户以及数据库，并将数据库omg_db授权给用户zyssky)

依赖管理工具：
maven（eclipse或Myeclipse都会有）

项目架构（已经在依赖管理配好，不用自己设置）：
数据库方面（orm）：hibernate 
设计（restful）：Jersey
单元测试：junit

注意：
在开始开发时，要确保成功连接数据库，
1，开启后台服务
2，跑通项目里在test包里的单元测试

任务：
本人负责跟Android端交互的restful设计及相关数据库

其他人负责后台管理页面：
1，现在不使用spring
2，无论使用单纯jsp还是servlet或者结合使用或者其他，能跑就行
3，不会开发的看有关java web，servlet，jsp，hibernate，的相关教学视频（慕课网，极客学院，网易云课堂。。。）