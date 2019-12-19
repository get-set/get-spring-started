package com.getset.relationaldataaccess;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Customer {
    private Long id;
    private String firstName, lastName;
}
