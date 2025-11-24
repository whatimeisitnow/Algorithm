package com.sujin.chapter5.problem29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N : 자연수 개수
        int N = Integer.parseInt(br.readLine());

        // N개의 정수를 담는 정수 배열 arr 선언 및 초기화
        int [] arr =  new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 정렬(이진트리 쓰려면 정렬되어 있어야 함)
        Arrays.sort(arr);

        // M : 찾아야 할 숫자 개수
        int M = Integer.parseInt(br.readLine());

        // 찾아야 할 숫자 목록들을 배열에 담기 arrTarget
        int [] arrTarget  = new int[M];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
        }

        // 이진트리를 이용해서 존재 유무 찾기
        for (int i = 0; i < M; i++) {
            int left = 0;
            int right = N - 1;
            int mid = (N-1)/2;
            boolean flag = false;
            while (left < right){
                if(arr[i] ==  arr[mid]){
                    flag = true;
                }
                if (arr[i] > arrTarget[mid]){
                    left = mid + 1;
                    mid = (left + right)/2;
                } else if (arr[i] < arrTarget[mid]){
                    right = mid - 1;
                    mid = (left + right)/2;
                }
            }

            if (flag == true){
                System.out.println(1);
            }
            else{
                System.out.println(0);
            }
        }
    }
}
