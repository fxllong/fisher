package com.fisher.log.controller;

import com.fisher.common.annotation.SysLog;
import com.fisher.common.constants.FisherServiceNameConstants;
import com.fisher.common.util.ApiResult;
import com.fisher.log.model.query.SysLogQuery;
import com.fisher.log.service.SysLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/log")
@Api(value = "日志controller", tags = {"系统日志操作接口"})
public class SysLogController {

    private static final String MODULE_NAME = "系统日志模块";

    @Autowired
    private SysLogService sysLogService;

    @SysLog(serviceId = FisherServiceNameConstants.FISHER_LOG_SERVICE, moduleName = MODULE_NAME, actionName = "日志信息分页查询")
    @ApiOperation(value = "日志信息分页查询", notes = "日志信息分页查询", httpMethod = "GET")
    @ApiImplicitParam(name = "sysLogQuery", value = "日志信息查询类", required = false, dataType = "SysLogQuery")
    @GetMapping("/page")
    public ApiResult<SysLogQuery> pageByQuery(SysLogQuery sysLogQuery){
        return new ApiResult<>(sysLogService.pageByQuery(sysLogQuery));
    }

}