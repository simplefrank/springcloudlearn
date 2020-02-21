package com.my.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author Administrator
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptNo;
    private String deptName;
    private String dbSource;

    public Dept(String deptName) {
        this.deptName = deptName;
    }
}
