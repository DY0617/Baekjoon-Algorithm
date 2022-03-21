import java.util.*;
import java.io.*;

// 2026

class Main {
    static int K;
    static int N;
    static int F;
    static boolean isStudent = false;
    static int[][] map;
    static int count;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;


    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int[] indegree = new int[N];
        visited = new boolean[N];


        for (int i = 0; i < F; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;

            map[v1][v2] = map[v2][v1] = 1;
            indegree[v1]++;
            indegree[v2]++;
        }



        for(int i=0; i<N; i++) {
            // 본인 포함 k명이 되지 않으면 애초에 볼 필요가 없음
            if(indegree[i] < K-1) continue;
            if(isStudent) break;

            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }


        if (!isStudent) {
            System.out.print(-1);
        } else
            System.out.println(sb);
    }

    static void dfs(int index, int depth) {
        if (isStudent) return;
        if (depth == K) {
            print();
            isStudent = true;
            return;
        }
        for (int i = index+1; i < N; i++) {
            if (map[index][i] == 1 && isFriend(i)) {
                visited[i] = true;
                dfs(i, depth+1);
                visited[i] = false;
            }
        }
    }

    static boolean isFriend(int target) {
        for (int i = 0; i < N; i++) {
            if (visited[i] && map[target][i] != 1)
                return false;
        }
        return true;
    }

    static void print() {
        for (int i = 0; i < N ; i++) {
            if (visited[i]) {
                sb.append(i+1).append("\n");
            }
        }
    }
}