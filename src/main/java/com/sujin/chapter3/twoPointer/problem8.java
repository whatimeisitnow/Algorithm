package com.sujin.chapter3.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N 입력받기
        int n = Integer.parseInt(br.readLine());

        //배열 입력받기(n만큼)
        Long [] arr = new Long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        //투포인터 쓰려면 정렬(오름차순)되어있어야 함.
        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

        int cnt = 0;
        for (int k = 0; k < n; k ++){
            int i = 0;
            int j = n -  1;
            while(i < j){
                //i 또는 j가 k와 겹치면 건너띔
                if (i == k) { // 왼쪽 포인터가 k 자기 자신일 경우
                    i++;
                    continue;
                }
                if (j == k) { // 오른쪽 포인터가 k 자기 자신일 경우
                    j--;
                    continue;
                }
                if((arr[i] + arr[j]) == arr[k]){
                    cnt++; break;
                } else if ((arr[i] + arr[j]) > arr[k]) {
                    j--;
                } else {
                    i++;
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
