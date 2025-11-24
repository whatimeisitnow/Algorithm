package com.sujin.chapter5.problem24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class subStack {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int curr = 2;
        stack.push(curr);
        while(!stack.isEmpty()){
            for(int i = 0; i <= 9; i ++){
                if(i % 2 != 0 && isPrime(i)){
                    curr = curr*10 + i;
                    stack.pop();
                    stack.push(curr);
                }
            }
        }
        System.out.println(stack.pop());

    }

    private static boolean isPrime(int x) {
        for(int i = 2; i <= x/2; i++){
            if(x % i == 0)return false;
        }
        return true;
    }

}
