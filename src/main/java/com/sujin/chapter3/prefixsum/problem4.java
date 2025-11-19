package com.sujin.chapter3.prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem4 {
    public static void main(String[] args) throws IOException {
        //BufferedReader 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n: 2차원 배열(nxn), m : 쿼리 갯수 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //배열 초기화
        long [][] sumarr = new long[n+1][n+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                sumarr[i][j] = 0L;
            }
        }

        //배열 입력받기
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                    sumarr[i][j] = sumarr[i][j-1] + sumarr[i-1][j] -sumarr[i-1][j-1] + Integer.parseInt(st.nextToken());
                }
            }


        //쿼리입력받고 값 출력
        for (int i = 0; i <m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(sumarr[x2][y2] -sumarr[x1-1][y2] - sumarr[x2][y1-1] + sumarr[x1-1][y1-1]);
        }



    }
}
