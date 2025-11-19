package com.sujin.chapter3.problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); //출력 성능 향상용

        // 공백 단위로 나누기 위한 StringTokenizer 사용
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       //숫자 개수
        int L = Integer.parseInt(st.nextToken());      // 슬라이딩 윈도우 크기

        Deque<Node> q = new ArrayDeque<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            while(!q.isEmpty() && q.peekLast().value > num){
                q.removeLast();
            }

            q.addLast(new Node(i, num));

//            while(i - q.peekFirst().index >= L){
//                q.removeFirst();
//            }

            if(i - q.peekFirst().index >= L){
                q.removeFirst();
            }

            sb.append(q.peekFirst().value).append(" ");

        }

        System.out.println(sb);
    }
    static class Node{
        public int index;
        public int value;
        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }
}
