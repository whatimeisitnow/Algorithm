package com.sujin.chapter8.problem50;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        // N: 원소 개수, M: 질의 개수
        int n =  Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        //집합 표현 1차원 int배열로 할거야
        arr =new int [n + 1];

        // 1부터 N까지 들어가 있는 배열 만들기(인덱스랑 보기 편하게 0번째에는 0넣기)
        for(int i = 0; i <= n; i++){
            arr[i] = i;
        }

//        System.out.println(Arrays.toString(arr));

        // 질의 개수만큼 반복
        for(int i = 0; i <m; i++){
            st =new StringTokenizer(br.readLine());
            int q =  Integer.parseInt(st.nextToken());
            int a =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());

//            // q, a, b를 배열에 담기
//            int [] query = new int [3];
//            query[0] = q;
//            query[1] = a;
//            query[2] = b;

            // 합집합 연산
            if (q == 0){
                union(a, b);
            }
            // 포함관계인지 확인
            else if (q == 1){
                if(find(a) == find(b)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }

        }
    }
    //대표 노드 찾기
    private static int find(int x) {
        //배열만큼 반복
        while(true){
            // index == value : 루트노드
            if(arr[x] == x){
                return arr[x];
            }
            return arr[x] = find(arr[x]);
        }
    }

    // 합집합 연산하기
    private static void union(int x, int y) {
        // y의 대표노드를 x의 대표노드랑 연결
        arr[find(y)] = arr[find(x)];
    }
}
