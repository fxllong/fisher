package com.fisher.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fisher.back.model.dto.SysResourceTree;
import com.fisher.back.model.entity.SysResource;

import java.util.List;
import java.util.Set;

/**
 * @description: 系统资源服务类
 */
public interface SysResourceService extends IService<SysResource> {



    /**
     * 根据角色codes查询菜单树形
     * @param roleCodes
     * @return
     */
    List<SysResourceTree> getMenuTreeByRoleCodes(List<String> roleCodes);

    /**
     * 根据角色codes查询菜单列表
     * @param roleCodes
     * @return
     */
    Set<SysResource> getSysResourceRoleCodes(List<String> roleCodes);

    /**
     * 查询所有的资源
     * @return
     */
    List<SysResourceTree> getAllResourceTree();

    /**
     * 删除资源以及子资源
     * @param id
     * @return
     */
    Boolean deleteResource(Integer id);

    /**
     * 根据角色code查询资源信息
     * @param roleCode
     * @return
     */
    List<SysResource>findResourceByRoleCode(String roleCode);

    List<String> findPermission(List<String> roles);

}
