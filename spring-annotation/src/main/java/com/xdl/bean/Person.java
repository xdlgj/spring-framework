package com.xdl.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Value("xdl")
    private String name;
    @Value("#{30-10}")
    private Integer age;
    @Value("${person.nickName}")
    private String nickName;
}
