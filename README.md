# fisher
基于Spring cloud Oauth2和Element-UI-Admin的后台权限管理框架
- 感兴趣可以加QQ群：591363691

# About

此项目是 Spring cloud Oauth2 构建的后台管理系统

- fisher-center Eureka服务注册中心,该工程已经删除
  注册中心已替换成Nacos
- fisher-common 公共模块
- fisher-auth  oauth2 认证服务器 提供token
- fisher-back 后台管理模块
- fisher-starter 自定义封装各种starer 目前封装了日志处理
- fisher-gateway 统一入口，提供动态路由 同时也是oauth2的资源服务器


# 说明
![index](https://github.com/YuKongEr/panda/blob/master/imgs/code.png)

>  如果对您对此项目有兴趣，可以点 "Star" 支持一下 谢谢！ ^_^

>  或者您可以 "follow" 一下

>  开发环境 macOS 10.12.4 

>  如有问题请直接在 Issues 中提，或者您发现问题并有非常好的解决方案，欢迎 PR 👍

>  传送门：[前端项目地址](https://github.com/fanxinglong/fisher-admin) 

## 技术栈
Spirng cloud

## 项目运行


```
git clone https://github.com/fanxinglong/fisher-admin

先配置数据库，然后reids，需要启动rabbitmq

启动顺序：
fisher-server
fisher-auth
fisher-back
fisher-gateway

前端启动参照前端项目

```

# 功能列表

- [x] 登陆/注销 -- 完成
- [x] 权限管理 -- 完成
- [x] 数据展示 -- 完成
- [x] 日志展示 -- 完成
- [x] 管理用户 -- 完成
- [x] 管理员设置 -- 完成
- [x] 图表📈 -- 完成
- [x] 富文本编辑器 -- 完成

