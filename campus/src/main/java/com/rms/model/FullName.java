package com.rms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 1912dec16 Java Fullstack Batch
 * <br>
 * <br>
 * The FullName class was created to handle a sonarlint issue with our Campus model class.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullName {

    private String name;

    private String abbrName;
}