# Ncoas1.0尝试说明


## 修改了三个模块作为示例
- 认证中心：fisher-auth-service
- 后台管理：fisher-back-service
- 网关服务：fisher-gateway-service

## 项目运行说明
```
1. Ncaos1.0服务端启动 直接替换
2. Nacos客户端最低版本为0.9，由于Spring cloud alibaba的nacos-client为0.6.2
   所以用0.9替换0.6.2
3. 由于1.0RC 默认是mixed模式启动 需要先去控制台创建服务，所以启动前必须创建服务，跟以前不太一样
4. 由于还是RC版本，以及Spirng cloud alibaba目前还没更新，所以暂时不打算master更新，这里只作为示例
   目前只修改三个模块，VUE前台启动不变，其他模块如果想使用Nacos1.0可以参考着几个模块修改
5. 后续发布了GA版本以及Spring cloud alibaba更新了之后master也会随之更新
```

