package com.zahid.flatmap;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import com.zahid.student.Student;

public class FlatMapExample {
    public static void main(String[] args) {
        System.out.println("# ========================= One Dimensional Array ===============================");
        int[] numbers = {4, 9, 2, 3, 5, 7, 8, 1, 6, 0};

        System.out.println("# printing using IntStream");
        Stream<int[]> numberArrayStream = Stream.of(numbers);
        IntStream intStream = numberArrayStream.flatMapToInt(n -> Arrays.stream(n)); // returns IntStream
        intStream.forEach(x -> System.out.print(x + " "));
        System.out.println();
        System.out.println();
        
        System.out.println("# sum of IntStream");
        int evenSum = Stream.of(numbers).flatMapToInt(n -> Arrays.stream(n)).sum();
        System.out.println(evenSum);
        System.out.println();
        
        System.out.println("# applying filter to IntStream");
        int[] evenNumbers = Stream.of(numbers).flatMapToInt(n -> Arrays.stream(n)).filter(x -> x % 2 == 0).toArray();
        for(int num: evenNumbers) System.out.print(num + " ");
        System.out.println();

        System.out.println("# ========================= Two Dimensional Array ===============================");
        Integer[][] matrix = {
            {4, 9, 2},
            {3, 5, 7},
            {8, 1, 6}
        };
        // System.out.println(matrix);

        System.out.println("# iterating using simple for each");
        for(Integer[] row: matrix) {
            for(Integer num: row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
        
        // matrix.forEach(n -> System.out.print(n + " ")); // does not work in 2d array
        
        Stream<Integer[]> matrixStream = Arrays.stream(matrix); // yet it is stream of array, not flat.. so forEach() fails
        // System.out.println(matrixStream);
        // matrixStream.forEach(n -> System.out.print(n + " ")); // does not work
        
        System.out.println("# iterating using forEach after flatMap conversion");
        Stream<Integer> flatMatrixStream = matrixStream.flatMap(mat -> Arrays.stream(mat)); // flat.. so forEach() works
        // System.out.println(flatMatrixStream);
        flatMatrixStream.forEach(n -> System.out.print(n + " ")); // does work
        System.out.println();
        System.out.println();
        
        System.out.println("# array to flat map conversion");
        List<Integer> flatMatrix = Arrays.stream(matrix)
        .flatMap(mat -> Arrays.stream(mat))
        .map(x -> x*x)
        .collect(Collectors.toList());
        System.out.println(flatMatrix);
        System.out.println();
        
        System.out.println("# forEach on flat map");
        flatMatrix.forEach(n -> System.out.print(n + " ")); // does work
        System.out.println();
        System.out.println();

        System.out.println("# ========================= Student Class ===============================");
        System.out.println("# student list");
        List<Student> studentList = Arrays.asList(
            new Student("Alex", "CSE", Arrays.asList("CSE107", "CSE203", "CSE205", "CSE214", "CSE315")),
            new Student("Lee", "CSE", Arrays.asList("CSE203", "CSE204", "CSE208", "CSE214", "CSE309")),
            new Student("Cooper", "ECE", Arrays.asList("CSE204", "CSE208", "CSE214", "CSE309", "CSE311")),
            new Student("David", "EEE", Arrays.asList("EEE263", "PHY107", "CSE205", "EEE269", "MATH241")),
            new Student("David", "MATH", Arrays.asList("MATH141", "PHY205", "CHEM105", "HUM371", "MATH245"))
        );
        // System.out.println(studentList);
        // System.out.println();

        studentList.forEach(student -> System.out.println(student));
        System.out.println();

        System.out.println("# filtering out all distinct courses");
        List<String> registeredCourseList = studentList.stream()
            .map(student -> student.getCourseList())
            .flatMap(courseList -> courseList.stream())
            .distinct()
            .collect(Collectors.toList());
        System.out.println(registeredCourseList);
        // registeredCourseList.forEach(System.out::println);

        System.out.println("# filtering out all distinct departments");
        List<String> departmentList = studentList.stream()
            .map(student -> student.getDepartment())
            .distinct()
            .collect(Collectors.toList());
        System.out.println(departmentList);
       
    }
}
