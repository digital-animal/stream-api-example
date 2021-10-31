package com.zahid.filter;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.zahid.customer.Customer;

public class FilterExample {
    public static void main(String[] args) {
        System.out.println("# numbers");
        List<Integer> numbers = Arrays.asList(97, 4, 89, 9, 79, 2, 67, 3, 59, 5, 47, 7, 37, 8, 29, 1, 19, 6, 0);
        System.out.println(numbers);
        System.out.println();

        // predicate 1: isEven
        System.out.println("# predicate 1.1: isEven");
        Predicate<Integer> isEven = n -> n % 2 == 0;
        List<Integer> evenNumbers = numbers.stream().filter(isEven).collect(Collectors.toList());
        System.out.println(evenNumbers);
        System.out.println("# predicate 1.2: !isEven");
        List<Integer> oddNumbers = numbers.stream().filter(isEven.negate()).collect(Collectors.toList());
        System.out.println(oddNumbers);
        System.out.println();

        // predicate 2: isLessThanTen
        System.out.println("# predicate 2.1: isLessThanTen");
        Predicate<Integer> isLessThanTen = n -> n < 10;;
        List<Integer> numbersLT10 = numbers.stream().filter(isLessThanTen).collect(Collectors.toList());
        System.out.println(numbersLT10);
        System.out.println("# predicate 2.2: !isLessThanTen");
        List<Integer> numbersGT10 = numbers.stream().filter(isLessThanTen.negate()).collect(Collectors.toList());
        System.out.println(numbersGT10);
        System.out.println();

        // predicate 3: isPrime
        System.out.println("# predicate 3.1: isPrime");
        Predicate<Integer> isPrime = (n) -> {
            if(n == 0 || n == 1) return false;
            int limit = (int) Math.sqrt(n);
            for(int i=2; i<=limit; i++) {
                if(n % i == 0) return false;
            }
            return true;
        };
        List<Integer> primeNumbers = numbers.stream().filter(isPrime).collect(Collectors.toList());
        System.out.println(primeNumbers);
        System.out.println("# predicate 3.2: !isPrime");
        List<Integer> nonPrimeNumbers = numbers.stream().filter(isPrime.negate()).collect(Collectors.toList());
        System.out.println(nonPrimeNumbers);
        System.out.println();

        System.out.println("# chaining multiple predicates: primeGT20LT50");
        List<Integer> primeGT20LT50 = numbers.stream()
            .filter(n ->  20 < n && n < 50)
            .filter(isPrime)
            .collect(Collectors.toList());
        System.out.println(primeGT20LT50);
        System.out.println();

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
            

        // predicate 4.1: isAgeGT25
        System.out.println("# predicate 4.1: isAgeGT25");
        Predicate<Customer> isAgeGT25 = (customer) -> customer.getAge() > 25;
        List<Customer> olderCustomerList = customerList.stream().filter(isAgeGT25).collect(Collectors.toList()); 
        System.out.println(olderCustomerList);
        System.out.println("# predicate 4.2: !isAgeGT25");
        List<Customer> youngerCustomerList = customerList.stream().filter(isAgeGT25.negate()).collect(Collectors.toList()); 
        System.out.println(youngerCustomerList);
        System.out.println();

        // filtering out customer object
        System.out.println("# filtering out customer object ");
        Customer customer1 = customerList.stream()
            .filter(customer -> customer.getName().equals("David"))
            .findAny()
            .orElse(null);
        System.out.println(customer1);
        Customer customer2 = customerList.stream()
            .filter(customer -> customer.getName().equals("Dan"))
            .findAny()
            .orElse(null);
        System.out.println(customer2);

    }
}
