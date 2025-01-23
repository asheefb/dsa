package dsa.main.basic;

import java.util.ArrayList;
import java.util.List;

public class FibonacciNumber {

    public static void main(String[] args) {
        int n = 90;
        int f1 = 0 , f2 = 1;

        usingLoop(n);

        List<Integer> result = usingRecursion(f1,f2,n);

        System.out.println("Using recursion : ");
        result.forEach(System.out::println);
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
