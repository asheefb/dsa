package dsa.main.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 90;
        int f1 = 0 , f2 = 1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ur choice");
        int choice = scanner.nextInt();

        switch (choice){
            case 1:
                usingLoop(n);
                break;

            case 2:
                List<Integer> result = usingRecursion(f1,f2,n);
                System.out.println("Using recursion : ");
                result.forEach(System.out::println);
                break;

            case 3:
                nthFibonacciUsingLoop(10);
                break;

            case 4:
                List<Integer> list = nthFibonacciUsingRecursion(f1, f2, 10);
                list.forEach(System.out::println);
                break;
        }
    }

    private static List<Integer> nthFibonacciUsingRecursion(int f1, int f2 ,int n) {

        List<Integer> list = new ArrayList<>();

        list.add(f1);

        if (n < 1){
            return list;
        }
        list.addAll(nthFibonacciUsingRecursion(f2,f1+f2,n-1));
        return list;
    }

    private static void nthFibonacciUsingLoop(int i) {
        int f1 = 0, f2 = 1;
        int count = 0;

        List<Integer> list = new ArrayList<>();
        list.add(f1);

       while (count != i){
           int f3 = f1+f2;
           f1 = f2;
           f2 = f3;
           list.add(f1);
           count++;
       }

       list.forEach(System.out::println);

    }

    private static List<Integer> usingRecursion(int f1 , int f2 , int n) {

        List<Integer> list = new ArrayList<>();

        if (f1 <= n)
            list.add(f1);
        else
            return list;

        int f3 = f1+f2;
        f1= f2 ;
        f2 = f3;

        list.addAll(usingRecursion(f1,f2,n));
       return list;
    }

    private static void usingLoop(int n) {
        int f1 = 0 , f2 = 1;

        List<Integer> list = new ArrayList<>();
        list.add(f1);

        while (f2 < n){
            int f3 = f1+f2;
            f1 = f2 ;
            f2 = f3;
            list.add(f1);
        }
        list.forEach(System.out::println);
    }
}
