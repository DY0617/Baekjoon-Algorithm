import java.util.*;
import java.io.*;

public class Main {


    static class Node implements Comparable<Node> {
        int to;
        int from;
        int value;

        public Node(int to, int from, int value) {
            this.to = to;
            this.from = from;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }

    }

    static int[][] arr;
    static boolean landCheck[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int n, m;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int land = 2;
        landCheck = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1 && !landCheck[i][j]) {
                    islandIndexing(j, i, land);
                    land++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 0)
                    makeBridge(j, i, arr[i][j]);
            }
        }

        land--;
        parent = new int[land];

        for (int i = 1; i < land; i++) {
            parent[i] = i;
        }

        int answer = 0;

        int size = pq.size();
        for (int i = 0; i < size; i++) {
            Node node = pq.poll();
            int x = find(node.from);
            int y = find(node.to);
            if (x != y) {
                answer += node.value;
                if (y > x)
                    parent[y] = x;
                else
                    parent[x] = y;
            }
        }

        int rx = parent[1];
        for (int i = 2; i < land; i++) {
            if (rx != find(parent[i])) {
                answer = 0;
            }
        }


        if (answer == 0) {
            bw.write(String.valueOf(-1));
        } else
            bw.write(String.valueOf(answer));


        br.close();
        bw.flush();
        bw.close();


    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }


    static void islandIndexing(int x, int y, int idx) {
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{x, y});
        arr[y][x] = idx;
        landCheck[y][x] = true;

        while (!q.isEmpty()) {
            int[] p = q.poll();
            int px = p[0];
            int py = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1 || landCheck[ny][nx]) continue;

                if (arr[ny][nx] == 1) {
                    arr[ny][nx] = idx;
                    landCheck[ny][nx] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }


    }


    static void makeBridge(int x, int y, int idx) {
        Queue<int[]> q = new LinkedList<>();
        landCheck = new boolean[n][m];
        for (int d = 0; d < 4; d++) {
            q.add(new int[]{x, y, 0});
            landCheck[y][x] = true;

            while (!q.isEmpty()) {
                int[] p = q.poll();
                int px = p[0];
                int py = p[1];
                int move = p[2];

                int nx = px + dx[d];
                int ny = py + dy[d];

                if (nx < 0 || ny < 0 || nx > m - 1 || ny > n - 1 || landCheck[ny][nx]) continue;

                if (arr[ny][nx] != idx) {
                    if (arr[ny][nx] != 0) {
                        int from = idx - 1;
                        int to = arr[ny][nx] - 1;
                        int bridgeLen = move;
                        if (bridgeLen > 1) {
                            pq.add(new Node(from, to, bridgeLen));
                            break;
                        }
                    } else {
                        landCheck[ny][nx] = true;
                        q.add(new int[]{nx, ny, move + 1});
                    }
                }
            }
            q.clear();
        }
    }
}
