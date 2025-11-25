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

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

//        System.out.println(N);
//        System.out.println(M);

        // N 이상 M이하 숫자 구하기
        // M - N  + 1 크기의 배열(arr)선언
        int [] arr = new int[M];

        // 배열에 숫자 N 부터 M까지 넣기
        int num = 1;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num;
            num ++;
        }

//        System.out.println(Arrays.toString(arr));

        // 배열 전체 돌면서
        // 2부터 M/2까지 배수 있으면 0으로 바꿈

        if(arr[0] == 1){
            arr[0] = 0;
        }

        for(int i=1; i<M /2 ; i++){
            if(arr[i] == 0) continue;
            for(int j = i + 1; j<M; j++){
                if(arr[j] % arr[i] == 0){
                    arr[j] = 0;
                }
            }
        }

//        System.out.println(Arrays.toString(arr));

        for(int number : arr){
            if (number != 0) {
                System.out.println(number);
            }
        }


    }
}
