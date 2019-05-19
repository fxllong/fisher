# fisher
基于Spring cloud Alibaba,Oauth2,基于VUE的后台权限管理框架,集成了基于MQ的可靠消息的分布式事务解决方案。
- 感兴趣可以加QQ群：591363691
- 目前项目已经部署到k8s集群上，暂时只部署了3个微服务，由于怕有人乱删除数据，所以只开放了查看功能。
- 体验地址如下：http://39.98.217.217:8082 用户名:fisher 密码:fisher
# About

有关文档以及其他相关事宜可以以查看官网相关介绍
>  传送门：[fisher官方网站](https://fisher-allen.github.io/fisher-docs/#/) 

## 技术栈
此项目是 Spring cloud Oauth2 构建的后台管理系统，计划采用以下技术
- 注册中心：Nacos
- 服务网关：Spring cloud-Gateway
- 配置中心：Nacos
- 服务调用：Spring-cloud-open-Feign
- 负载均衡：Spring-cloud-loadbalancer
- 熔断降级：Sentinel
- 链路追踪：Skywalking
- 消息队列：RabbitMQ
- 权限认证：Spring secruity Oauth2
- 项目部署：Docker+Rancher+K8S

# 项目结构说明
- fisher-center Eureka服务注册中心,该工程已经删除
  注册中心已替换成Nacos
- fisher-common 公共模块
- fisher-auth  Oauth2 认证服务器 提供token
- fisher-back 后台管理模块
- fisher-transcation 基于mq最终一致性实现可靠消息的分布式事务方案
  - fisher-transaction-message 独立消息服务微服务
  - fisher-transaction-sample 基于支付宝转账的演示
  - fisher-transaction-web消息补偿管理后台
- fisher-monitor Spring boot admin监控以及Skywalking监控
- fisher-log 日志中心模块
- fisher-file 文件上传服务,这个服务可以暂时不起，因为前端还没有对接
- fisher-gen 代码生成模块
- fisher-starter 自定义封装各种starer 目前封装了日志处理
- fisher-gateway 后端统一入口，提供动态路由，oauth2的资源服务器

## 项目运行
```
git clone https://github.com/fanxinglong/fisher
先配置数据库，然后reids，需要启动rabbitmq,启动nacos,启动sentinel
启动顺序：最好按顺序启动，不按顺序启动，至少要把网关放到最后启动
注意：Nacos先修改配置连自己本地数据库，并把nacos的配置数据库导入到自己本地数据库
导入之后，检查nacos各个微服务相关配置的mysql，redis,rabbitmq配置是否正确
fisher-auth
fisher-back
fisher-log
fisher-gen
fisher-monitor
fisher-transcation
fisher-file 
fisher-gateway

前端启动参照前端项目
```

>  如果对您对此项目有兴趣，可以点 "Star" 支持一下 谢谢！ ^_^

>  或者您可以 "follow" 一下

>  开发环境 macOS 10.12.4 

>  如有问题请直接在 Issues 中提，或者您发现问题并有非常好的解决方案，欢迎 PR 👍

>  传送门：[前端项目地址](https://github.com/fanxinglong/fisher-admin) 

# 说明
![index](https://github.com/fanxinglong/fisher/blob/master/docs/fisher-ac.png)

### 基于BASE理论-MQ实现可靠消息最终一致性的分布式事务解决方案架构图
![index](https://github.com/fanxinglong/fisher/blob/master/docs/tsc.png)

![index](https://github.com/fanxinglong/fisher/blob/master/docs/msg.png)

![index](https://github.com/fanxinglong/fisher/blob/master/docs/sentinel_.png)

![index](https://github.com/fanxinglong/fisher/blob/master/docs/admin.png)

![index](https://github.com/fanxinglong/fisher/blob/master/docs/k8s.png)

![index](https://github.com/fanxinglong/fisher/blob/master/docs/skywalking.png)

![index](https://github.com/fanxinglong/fisher/blob/master/docs/skywalking1.png)

# 功能列表

- [x] 登录/注销 -- 完成
- [x] 权限管理 -- 完成
- [x] 消息管理 -- 完成
- [x] 日志展示 -- 完成
- [x] 管理用户 -- 完成
- [x] 管理员设置 -- 完成
- [x] 图表📈 -- 完成
- [x] 日志记录 -- 完成
- [x] 代码生成 -- 完成

# 捐赠

如果觉得本项目对您有帮助，您的鼓励是作者持续更新的动力，谢谢！

![zfb](https://github.com/fanxinglong/fisher/blob/master/docs/zfb.png) 
![wx](https://github.com/fanxinglong/fisher/blob/master/docs/wx.png) 
