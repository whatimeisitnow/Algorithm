package com.sujin.chapter3.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//problem03
public class prefixsum1 {
    public static void main(String[] args) throws IOException {
        // BufferedReader 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 공백 단위로 나누기 위한 StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());       //숫자 개수
        int m = Integer.parseInt(st.nextToken());      // 쿼리 개수


        // 배열 입력 받기
        Long[] arr = new Long[n + 1];   //숫자 개수(n)개
        arr[0] = 0L;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = (long) Integer.parseInt(st.nextToken()); //숫자 n개를 크기가 n인 arr배열에 저장
        }

        //합 배열 생성
        Long[] sumArr = new Long[n + 1];     //합 배열도 원래 배열이랑 크기가 같으니깐+ 처음 0으로 초기화 값
        sumArr[0] = 0L;
        for (int i = 1; i <= n; i++) {
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        //생성된 합배열 확인
//        System.out.println("합 배열" +Arrays.toString(sumArr));

        // 쿼리 입력 받기고 값 출력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[end] - sumArr[first - 1]);
        }
        br.close();  // BufferedReader 닫기


    }
}