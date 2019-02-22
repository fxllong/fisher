package com.fisher.back.controller;

import com.fisher.back.model.dto.SysRoleDTO;
import com.fisher.back.model.entity.SysRole;
import com.fisher.back.model.query.SysRoleQuery;
import com.fisher.back.service.SysRoleService;
import com.fisher.common.annotation.SysLog;
import com.fisher.common.constants.PandaServiceNameConstants;
import com.fisher.common.util.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yukong
 * @date 2018年11月01日15:15:54
 */
@RestController
@RequestMapping("/role")
@Api(value = "角色controller", tags = {"角色操作接口"})
public class SysRoleController {

    private static final String MODULE_NAME = "系统角色模块";


    @Autowired
    private SysRoleService sysRoleService;

    @SysLog(serviceId = PandaServiceNameConstants.PANDA_USER_SERVICE, moduleName = MODULE_NAME, actionName = "添加角色")
    @ApiOperation(value = "添加角色", notes = "角色信息", httpMethod = "POST")
    @ApiImplicitParam(name = "sysRoleDTO", value = "角色信息", required = true, dataType = "SysRoleDTO")
    @PostMapping
    public ApiResult<Boolean> save(@RequestBody SysRoleDTO sysRoleDTO){
        return new ApiResult<>(sysRoleService.save(sysRoleDTO));
    }

    @SysLog(serviceId = PandaServiceNameConstants.PANDA_USER_SERVICE, moduleName = MODULE_NAME, actionName = "修改角色")
    @ApiOperation(value = "修改角色", notes = "角色信息", httpMethod = "PUT")
    @ApiImplicitParam(name = "sysRoleDTO", value = "角色信息", required = true, dataType = "SysRoleDTO")
    @PutMapping
    public ApiResult<Boolean> update(@RequestBody SysRoleDTO sysRoleDTO){
        return new ApiResult<>(sysRoleService.updateById(sysRoleDTO));
    }

    @SysLog(serviceId = PandaServiceNameConstants.PANDA_USER_SERVICE, moduleName = MODULE_NAME, actionName = "删除角色")
    @ApiOperation(value = "删除角色", notes = "删除角色信息", httpMethod = "DELETE")
    @ApiImplicitParam(name = "id", value = "角色id", required = true, dataType = "integer")
    @DeleteMapping("/{id}")
    public ApiResult<Boolean> delete(@PathVariable("id") Integer id){
        return new ApiResult<>(sysRoleService.deleteById(id));
    }

 //   @SysLog(serviceId = PandaServiceNameConstants.PANDA_USER_SERVICE, moduleName = MODULE_NAME, actionName = "查询角色信息以及相关联的资源信息")
    @ApiOperation(value = "查询角色信息", notes = "查询角色信息以及相关联的资源信息", httpMethod = "GET")
    @ApiImplicitParam(name = "id", value = "角色id", required = true, dataType = "integer")
    @GetMapping("/{id}")
    public ApiResult<SysRoleDTO> getSysRoleInfo(@PathVariable("id") Integer id){
        return new ApiResult<>(sysRoleService.getRoleInfoWithResourceById(id));
    }

  //  @SysLog(serviceId = PandaServiceNameConstants.PANDA_USER_SERVICE, moduleName = MODULE_NAME, actionName = "角色信息分页查询")
    @ApiOperation(value = "角色信息分页查询", notes = "角色信息分页查询", httpMethod = "GET")
    @ApiImplicitParam(name = "sysRoleQuery", value = "角色信息查询类", required = false, dataType = "SysRoleQuery")
    @GetMapping("/page")
    public ApiResult<SysRoleQuery> pageByQuery(SysRoleQuery sysRoleQuery){
        return new ApiResult<>(sysRoleService.pageByQuery(sysRoleQuery));
    }

 //   @SysLog(serviceId = PandaServiceNameConstants.PANDA_USER_SERVICE, moduleName = MODULE_NAME, actionName = "查询所有角色信息")
    @ApiOperation(value = "查询所有角色信息", notes = "查询角色信息", httpMethod = "GET")
    @GetMapping
    public ApiResult<List<SysRole>> listRole(){
        return new ApiResult<>(sysRoleService.listSysRole());
    }
}
