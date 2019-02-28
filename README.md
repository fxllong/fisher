# fisher
基于Spring cloud Oauth2和Element-UI-Admin的后台权限管理框架
- 感兴趣可以加QQ群：591363691

# About

此项目是 Spring cloud Oauth2 构建的后台管理系统，计划采用以下技术
- 注册中心：Nacos
- 服务网关：Spring cloud-Gateway
- 配置中心：Nacos
- 服务调用：Spring-cloud-open-Feign
- 负载均衡：Spring-cloud-loadbalancer
- 熔断降级：Sentinel
- 链路追踪：Skywalking
- 消息队列：RabbitMQ
- 权限认证：Spring secruity oauth2
- 部署：docker+rancher1.6

# 项目结构说明
- fisher-center Eureka服务注册中心,该工程已经删除
  注册中心已替换成Nacos
- fisher-common 公共模块
- fisher-auth  oauth2 认证服务器 提供token
- fisher-back 后台管理模块
- fisher-log 日志中心模块
- fisher-file 文件上传服务,这个服务可以暂时不起，因为前端还没有对接
- fisher-gen 代码生成模块
- fisher-starter 自定义封装各种starer 目前封装了日志处理
- fisher-gateway 后端统一入口，提供动态路由，oauth2的资源服务器


# 说明
![index](https://github.com/fanxinglong/fisher/blob/master/docs/code.png)

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

启动顺序：一定要按顺序启动
先启动Nacos
fisher-auth
fisher-back
fisher-log
fisher-gen
fisher-file 
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
- [x] 日志记录 -- 完成
- [x] 代码生成 -- 完成

