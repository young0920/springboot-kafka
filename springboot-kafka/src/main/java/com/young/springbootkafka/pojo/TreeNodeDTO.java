package com.young.springbootkafka.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * TreeNodeDTO
 *
 * @author yangbing
 * @date 2020/12/17 上午9:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreeNodeDTO implements Serializable {

    private static final long serialVersionUID = -1857618971573337860L;

    private String code;

    private String label;

    private String parent;

    private List<TreeNodeDTO> children;

    public void add(TreeNodeDTO tree) {
        children.add(tree);
    }
}
