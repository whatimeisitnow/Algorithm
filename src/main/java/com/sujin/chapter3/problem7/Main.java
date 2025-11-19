package com.sujin.chapter3.problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N : 재료 개수
        int N = Integer.parseInt(br.readLine());

        // M: 갑옷이 완성되는 번호의 합
        int M = Integer.parseInt(br.readLine());

        // 재료를 담을 배열 arr
        int [] arr  = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //arr 배열을 오름차순으로 변경
        Arrays.sort(arr);

//        System.out.println(Arrays.toString(arr));

        // i -> 맨 앞, j -> 맨 뒤 하나씩 움직이면서 M과 같아질때까지 반복
        // cnt : 갑옷 갯수
        int cnt = 0;
        for (int k = 0; k < N; k++ ){
            int i = 0;
            int j = N - 1;
            while(i <j){
                // i 혹은 j가 K까지  다가가면 반복 종료
                if(i == k){

                }
            }
        }


    }
}
