package com.young.springbootkafka.util;


import com.young.springbootkafka.pojo.TreeNodeDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeUtils
 *
 * @author yangbing
 * @date 2020/11/3 2:41 下午
 */
public class TreeUtils {

    /**
     * 使用递归方法建树
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNodeDTO> List<T> buildByRecursive(List<T> treeNodes, Object root) {
        List<T> trees = new ArrayList<>();
        for (T treeNode : treeNodes) {
            if (root.equals(treeNode.getParent())) {
                trees.add(findChildren(treeNode, treeNodes));
            }
        }
        return trees;
    }

    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNodeDTO> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getCode().equals(it.getParent())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
}
