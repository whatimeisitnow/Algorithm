package com.sujin.chapter5.problem23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //N : 노드 개수, M:엣지 개수
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //인접리스트, 방문그래프 선언
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        //인접리스트의 ArrayList초기화
        for(int i = 0; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 그래프 데이터 저장
        for (int i = 0; i < M;  i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        // 연결요소 개수 초기화
        int cnt = 0;

        // 연결요소 개수 구하기(노드 개수만큼 반복)
        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                dfs(i);
                cnt ++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int node) {
        //방문한 노드면 멈추기
        if (visited[node]) return;
        //방문했다고 표시하기
        visited[node] = true;
        for(int next: graph[node]){
            if(!visited[next]){
                dfs(next);
            }
        }
    }
}
