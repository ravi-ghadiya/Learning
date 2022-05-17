package com.practice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        List<Integer> list = new ArrayList<Integer>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++){
            int x = sc.nextInt();
            list.add(x);
        }

        Scanner sc1 = new Scanner(System.in);
        int query = sc1.nextInt();

        for(int i=0; i<query; i++){
            Scanner sc2 = new Scanner(System.in);
            String operation = sc2.nextLine();

            if (operation.equalsIgnoreCase("Insert")) {
                Scanner scanner = new Scanner(System.in);
                int[] arr = new int[2];
                for(int j=0; j<2; j++){
                    arr[j] = scanner.nextInt();
                }
                list.add(arr[0], arr[1]);
            }

            if (operation.equalsIgnoreCase("Delete")){
                int pos = sc.nextInt();
                list.remove(pos);
            }

        }

        for (int i = 0; i < list.size(); i++) {

            // Print all elements of List
            System.out.println(list.get(i));
        }

    }
}