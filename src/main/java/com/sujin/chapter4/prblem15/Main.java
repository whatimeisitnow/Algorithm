package com.sujin.chapter4.prblem15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // N: 수의 개수
        int N = Integer.parseInt(br.readLine());
        // 정렬할 배열 arr 선언 및 초기화
        int [] arr =  new int[N];
        // 수 입력받아서 배열에 넣기
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
//        System.out.println(Arrays.toString(arr));
        // 버블 정렬
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
//        System.out.println(Arrays.toString(arr));
        for(int num : arr){
            System.out.println(num);
        }
    }
}
