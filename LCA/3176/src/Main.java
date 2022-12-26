import java.io.*;
import java.util.*;

// 3176 도로 네트워크
public class Main {

    static int N, K;	// N : 정점수, K : 2의 지수
    static int M;		// M : 쿼리 수 (문제에서 K)

    // LCA 관련 변수
    static int[] depth;
    static int[][] parent; // parent[K][V] 정점 V의 2^K번째 조상 정점 번호
    // parent[K][V] = parent[K-1][parent[K-1][V]];
    // TREE 변수
    static ArrayList[] tree;

    // 도로 네트워크 추가변수
    static int[][] minDist;	// minDist[K][V]  정점 V의 2^K번째 조상까지의 최소거리 도로
    static int[][] maxDist; // maxDist[K][V]  정점 V의 2^K번째 조상까지의 최대거리 도로

    static int min,max;

    static class edge{
        int target,cost;

        public edge(int target, int cost) {
            this.target = target;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // 1. 입력 & 변수 준비
        N = Integer.parseInt(br.readLine());

        // 2^K > N인 K 찾기
        K = 0;
        for (int i = 1; i <= N; i *= 2) {
            K++;
        }

        // LCA 관련 변수 초기화
        depth = new int[N + 1];
        parent = new int[K][N + 1];

        // 도로 네트워크 변수 초기화
        minDist = new int[K][N + 1];
        maxDist = new int[K][N + 1];

        // TREE 변수 초기화
        tree = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<edge>();
        }

        int a,b,c;
        for (int i = 1; i <= N-1; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            // 양방향 간선
            tree[a].add(new edge(b, c));
            tree[b].add(new edge(a, c));
        }

        // 2. DEPTH 확인
        dfs(1, 1);

        // 3. 2^N 까지 parent 채우기
        fillParent();

        // 4. LCA 진행
        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            lca(a, b);
            sb.append(min+" "+max+"\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    // DEPTH 확인 DFS
    static void dfs(int id, int cnt) {
        // 1. depth를 기록
        depth[id] = cnt;

        // 2. 자식들의 depth를 기록
        int len = tree[id].size();
        for (int i = 0; i < len; i++) {
            edge next = (edge) tree[id].get(i);
            // 아직 깊이를 모르면 → 미방문 노드
            if (depth[next.target] == 0) {
                dfs(next.target, cnt+1);
                parent[0][next.target] = id;		// 첫번째 부모를 기록

                minDist[0][next.target] = next.cost; // 현재 cost로 갱신
                maxDist[0][next.target] = next.cost; // 현재 cost로 갱신

            }
        }
        return;
    }

    // 부모 채우기
    static void fillParent() {
        for (int i = 1; i<K; i++) {
            for (int j = 1; j<=N; j++) {
                parent[i][j] = parent[i-1][parent[i-1][j]];

                // 도로네트워크 추가
                minDist[i][j] = Math.min( minDist[i-1][j], minDist[i-1][parent[i-1][j]]);
                maxDist[i][j] = Math.max( maxDist[i-1][j], maxDist[i-1][parent[i-1][j]]);
            }
        }
    }

    // 최소공통조상
    static void lca(int a, int b) {
        // 1. depth[a] >= depth[b] 이도록 조정하기
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        min = Integer.MAX_VALUE;
        max = -1;

        // 2. 더 깊은 a를 2^K승 점프하여 depth를 맞추기
        for (int i = K-1; i>=0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                min = Math.min(min, minDist[i][a]);
                max = Math.max(max, maxDist[i][a]);

                a = parent[i][a];
            }
        }

        // 3. depth를 맞췄는데 같다면 종료
        if (a == b) return;

        // 4. a-b는 같은 depth이므로 2^K승 점프하며 공통부모 바로 아래까지 올리기
        for (int i = K-1; i >= 0; i--) {
            if (parent[i][a] != parent[i][b]) {
                min = Math.min(min, Math.min(minDist[i][a], minDist[i][b]));
                max = Math.max(max, Math.max(maxDist[i][a], maxDist[i][b]));

                a = parent[i][a];
                b = parent[i][b];
            }
        }

        min = Math.min(min, Math.min(minDist[0][a], minDist[0][b]));
        max = Math.max(max, Math.max(maxDist[0][a], maxDist[0][b]));

        return;
    }
}