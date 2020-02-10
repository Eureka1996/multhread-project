package com.wufuqiang.multhread.entries;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ author wufuqiang
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BatchEntry {
    private String name;
    private int age;
}
