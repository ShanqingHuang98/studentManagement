#学生管理系统设计概要

## url/账号/密码
url ```jdbc:mysql://localhost:3306/studb ```
账号```root```
密码```123456```

## 功能设计

### 系统登录
用户注册，登录和密码修改
### 基本信息记录
包括 姓名、学号（用学号记录年纪信息）、专业、班级、院系。
### 学生成绩
包括各科成绩：高等数学、英语、数据结构、计算机组成原理、面向对象程序设计
系统可以完成对各类信息的添加、修改、删除等功能。
成绩的统计
可以计算班级平均成绩，最高，最低成绩，每位同学的总成绩、排名等
成绩信息查询
在系统中既有单条件查询也有多条件查询，可以精确查询和模糊查询。按照班级、成绩范围、科目等查询。
### 系统管理
（1） 管理员
增删改查权限
（2）教师
增改查权限
（3）学生
增查权限


## 库表设计
表1 学生基本信息 （information）
表2 学生成绩（grades）
表3 账户密码（account）
表4 日志（log）


## 安全保障
1主2备

## 数据查找
精确查询
模糊查询
范围查询






