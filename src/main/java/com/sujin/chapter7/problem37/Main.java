package com.sujin.chapter7.problem37;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //에라토스테네스로 소수 구하기

        // 입력받기
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int M=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());

//        System.out.println(N);
//        System.out.println(M);

        // N까지 넣을 수 있는 배열 생성
        int [] arr=new int[N + 1];

        // 2부터 N까지 배열 채우기
        // 1은 소수 아니니깐 그냥 0으로 초기화 될 수 있도록 2부터 반복
        for(int i = 2; i<=N; i++){
            arr[i] = i;
        }

//        System.out.println(Arrays.toString(arr));

        //제곱근까지만 반복
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (arr[i] == 0) continue;

            for (int j = i + i; j <= N; j= j + i) {
                arr[j] = 0;
            }
        }

//        System.out.println(Arrays.toString(arr));

        for (int i = M; i <= N; i++) {
            if(arr[i] != 0){
                System.out.println(arr[i]);
            }
        }
    }
}
