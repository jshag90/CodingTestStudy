package com.ji.beakjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Fibonacci_1003_Final {
   private static int[] zeroCallArr;
   private static int[] onceCallArr;
   
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      int testCase = Integer.parseInt(br.readLine());
      
      for (int i = 0; i < testCase; i++) {
         int testNum = Integer.parseInt(br.readLine());
         
         zeroCallArr = new int[(testNum + 1)];
         onceCallArr = new int[(testNum + 1)];
         
         bw.write(excuteFibonacci(testNum) + "\n");
      }
      
      br.close();
      
      bw.flush();
      bw.close();
   }

   private static String excuteFibonacci(int testNum) {
       
      for (int i = 0; i <= testNum; i++) {
         
         if (i == 0) {
             zeroCallArr[i] = 1;
             onceCallArr[i] = 0;
          } else if (i == 1) {
             zeroCallArr[i] = 0;
             onceCallArr[i] = 1;
          } else {
             zeroCallArr[i] = zeroCallArr[(i - 1)] + zeroCallArr[(i - 2)];
             onceCallArr[i] = onceCallArr[(i - 1)] + onceCallArr[(i - 2)];
          }
      }
      
      return (zeroCallArr[testNum] + " " + onceCallArr[testNum]);
   }
}