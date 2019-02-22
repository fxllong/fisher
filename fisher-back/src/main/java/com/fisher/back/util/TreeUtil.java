package com.fisher.back.util;

import com.fisher.back.model.dto.SysResourceTree;
import com.fisher.back.model.entity.SysResource;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 树形工具类
 */
public class TreeUtil {

    /**
     * 数组转树形结构
     * @param sysResources
     * @param root
     * @return
     */
    public static List<SysResourceTree> list2Tree(List<SysResource> sysResources, Integer root){
        // 普通对象转树节点
        List<SysResourceTree> resourceList = buildTree(sysResources);
        List<SysResourceTree> trees = new ArrayList<>();
        for (SysResourceTree tree: resourceList) {
            if( root.equals(tree.getParentId())) {
                trees.add(tree);
            }

            for (SysResourceTree t : resourceList) {
                if (tree.getId().equals(t.getParentId())) {
                    if (tree.getChildren() == null) {
                        tree.setChildren(new ArrayList<SysResourceTree>());
                    }
                    tree.addChildren(t);
                }
            }
        }
        return trees;
    }

    /**
     * 对象转树节点
     * @param sysResources
     * @return
     */
    public static List<SysResourceTree> buildTree(List<SysResource> sysResources){
        List<SysResourceTree> trees = new ArrayList<>();
        sysResources.forEach( resource->{
            SysResourceTree tree = new SysResourceTree();
            BeanUtils.copyProperties(resource, tree);
            trees.add(tree);
        });
        return trees;
    }
}
