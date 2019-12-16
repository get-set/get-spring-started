package com.getset.demo.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Quote {
    private String type;
    private Value value;
}
