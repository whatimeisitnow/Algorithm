package com.sujin.chapter5.problem26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visitedDfs;
    static boolean[] visitedBfs;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N : 노드 개수, M : 엣지 개수, V : 탐색 시작 노드 번호
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        //그래프. 방문리스트 선언
        graph = new ArrayList[N + 1];
        visitedDfs = new boolean[N + 1];
        visitedBfs = new boolean[N + 1];

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 엣지 수만큼 반복해서 그래프에 정보 담기
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        // 오름차순 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        // 시작점에서 dfs, bfs 실행
        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb.toString());

        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb.toString());
        br.close();
    }
    private static void dfs(int node) {
        if (visitedDfs[node]) return;
        visitedDfs[node] = true;
        sb.append(node).append(" ");

//        if(allvisited()) {
//            return;
//        }

        for(int next: graph[node]) {
            if(!visitedDfs[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visitedBfs[node] = true;
        while(!q.isEmpty()) {
            node = q.poll();
            sb.append(node).append(" ");    //방문했으면 큐에서 빼고 sb에 넣어둠

            for(int next: graph[node]) {
                if(!visitedBfs[next]) {
                    visitedBfs[next] = true;
                    q.add(next);
                }
            }
        }
    }

    private static boolean allvisited() {
        for(int i = 1; i < visitedDfs.length; i++) {       // visited.length == N + 1 상태임 => N까지 검사할거면 (=)포함하면 안됨
            if(!visitedDfs[i]) {
                return false;
            }
        }
        return true;
    }

}
