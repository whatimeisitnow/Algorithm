package com.sujin.chapter5.problem24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        //dfs(x, y) x가 y자리 일때

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb.toString());

    }

    private static void dfs(int x, int y) {
        // x는 숫자, y는 자리수
        if(y == N){
            if(isPrime(x)){
                sb.append(x).append("\n");
                return;}
        }
        for(int i = 1; i <=9; i++){
            if(i % 2 != 0 && isPrime(x * 10 + i)){
                dfs(x * 10 + i, y + 1);
            }
        }
    }

    private static boolean isPrime(int x) {
        for(int i = 2; i <= x/2; i++){
            if(x % i == 0)return false;
        }
        return true;
    }
}
