package com.zahid.filter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.zahid.customer.Customer;

public class FilterMapExample {
    public static void main(String[] args) {
        System.out.println("# customerList");
        List<Customer> customerList = Arrays.asList(
            new Customer("Alex", 20),
            new Customer("Lee", 22),
            new Customer("Cooper", 28),
            new Customer("David", 31),
            new Customer("John", 26),
            new Customer("Jane", 23),
            new Customer("Shaun", 19),
            new Customer("Smith", 25)
        );
        System.out.println(customerList);
        System.out.println();

        System.out.println("# filtering one customer object");
        String customerName = customerList.stream()
            .filter(customer -> customer.getName().equals("Jane"))
            .map(Customer::getName)
            .findAny()
            .orElse(null);
        System.out.println(customerName);
        System.out.println();

        System.out.println("# customer name list with map");
        List<String> customerNameList = customerList.stream()
            .map(customer -> customer.getName())
            .collect(Collectors.toList());
        System.out.println(customerNameList);
        // customerNameList.forEach(name -> System.out.println(name));
        customerNameList.forEach(System.out::println);
    }
}
