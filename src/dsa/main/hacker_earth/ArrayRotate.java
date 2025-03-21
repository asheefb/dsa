package dsa.main.hacker_earth;

import java.util.*;

class ArrayRotate {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] ar = new int[n];

        for (int i=0 ;i<ar.length;i++){
            ar[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < n) {
                int temp = ar[j];
                ar[j] = ar[n - 1];
                ar[n - 1] = temp;
                j++;
            }
        }
        for (int i : ar) {
            System.out.print(i + " ");
        }
    }
}

