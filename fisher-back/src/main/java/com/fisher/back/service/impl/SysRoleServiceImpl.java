package com.fisher.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fisher.back.mapper.SysRoleMapper;
import com.fisher.back.mapper.SysRoleResourceMapper;
import com.fisher.back.model.dto.SysRoleDTO;
import com.fisher.back.model.entity.SysRole;
import com.fisher.back.model.entity.SysRoleResource;
import com.fisher.back.model.query.SysRoleQuery;
import com.fisher.back.service.SysRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;



@Service
public class SysRoleServiceImpl  extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;
    @Autowired
    private SysRoleResourceMapper sysRoleResourceMapper;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean save(SysRoleDTO sysRoleDTO) {
        // 1、先存role信息
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleDTO, sysRole);
        sysRoleMapper.insert(sysRole);
        Integer roleId = sysRole.getRoleId();
        sysRoleDTO.setRoleId(roleId);
        // 2、然后绑定role与resource信息 存入数据库
        bindRoleWithResource(sysRoleDTO);
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateById(SysRoleDTO sysRoleDTO) {
        // 1、先删除原来绑定的资源信息
        deleteBindRoleWithResource(sysRoleDTO.getRoleId());
        // 2、更新角色信息
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRoleDTO, sysRole);
        sysRoleMapper.updateById(sysRole);
        // 3、重新绑定角色与资源的关系
        bindRoleWithResource(sysRoleDTO);
        return Boolean.TRUE;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteById(Integer roleId) {
        // 1、删除角色信息
        sysRoleMapper.deleteById(roleId);
        // 2、先删除原来绑定的资源信息
        deleteBindRoleWithResource(roleId);
        return Boolean.TRUE;
    }

    @Override
    public SysRoleDTO getRoleInfoWithResourceById(Integer roleId) {
        SysRole sysRole = sysRoleMapper.selectById(roleId);
        SysRoleDTO sysRoleDTO = new SysRoleDTO();
        BeanUtils.copyProperties(sysRole, sysRoleDTO);

        QueryWrapper<SysRoleResource> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(SysRoleResource::getRoleId, roleId);
        List<SysRoleResource> roleResources = sysRoleResourceMapper.selectList(queryWrapper);
        List<Integer> resourceIds = roleResources.stream()
                .map(SysRoleResource::getResourceId)
                .collect(Collectors.toList());
        sysRoleDTO.setSysResourceIds(resourceIds);
        return sysRoleDTO;
    }

    @Override
    public SysRoleQuery pageByQuery(SysRoleQuery query) {
        query.setDesc("create_time", "modify_time");
        sysRoleMapper.pageByQuery(query);
        return query;
    }

    @Override
    public List<SysRole> listSysRole() {
        return sysRoleMapper.selectList(new QueryWrapper<>());
    }

    /**
     * 绑定角色与资源信息
     * @param sysRoleDTO
     */
    private void bindRoleWithResource(SysRoleDTO sysRoleDTO) {
        sysRoleDTO.getSysResourceIds().forEach(resourceId -> {
            SysRoleResource sysRoleResource = new SysRoleResource();
            sysRoleResource.setResourceId(resourceId);
            sysRoleResource.setRoleId(sysRoleDTO.getRoleId());
            sysRoleResourceMapper.insert(sysRoleResource);
        });
    }

    /**
     * 删除角色与绑定资源信息
     * @param roleId
     */
    private void deleteBindRoleWithResource(Integer roleId) {
        QueryWrapper<SysRoleResource> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(SysRoleResource::getRoleId, roleId);
        sysRoleResourceMapper.delete(wrapper);
    }
}
