package com.zahid.customer;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private int age;

    @Override
    public String toString() {
        return name + "(" + age + ")";
    } 
}
