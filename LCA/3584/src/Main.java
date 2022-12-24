import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] tree;
    static int[] parent, depth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int a = 0; a < t; a++) {

            int n = Integer.parseInt(br.readLine());

            tree = new ArrayList[n + 1];
            parent = new int[n + 1];
            depth = new int[n + 1];

            for (int i = 1; i <= n; i++)
                tree[i] = new ArrayList<>();

            boolean[] rootCheck = new boolean[n + 1];
            Arrays.fill(rootCheck, true);

            for (int i = 0; i < n - 1; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                tree[from].add(to);
                rootCheck[to] = false;
            }

            int rootIdx = 0;
            for (int i = 1; i < n + 1; i++) {
                if (rootCheck[i]) {
                    rootIdx = i;
                    break;
                }
            }

            arrayFill(rootIdx, 1, 0);

            st = new StringTokenizer(br.readLine());
            int aa = Integer.parseInt(st.nextToken());
            int bb = Integer.parseInt(st.nextToken());

            System.out.println(LCA(aa, bb));


        }
    }

    static void arrayFill(int now, int nowDepth, int nowParents) {
        depth[now] = nowDepth;
        parent[now] = nowParents;
        for (int i = 0; i < tree[now].size(); i++) {
            int next = tree[now].get(i);
            arrayFill(next, nowDepth + 1, now);
        }
    }

    static int LCA(int a, int b) {
        int ah = depth[a];
        int bh = depth[b];

        while (ah > bh) {
            a = parent[a];
            ah--;
        }

        while (bh > ah) {
            b = parent[b];
            bh--;
        }

        while (a != b) {
            a = parent[a];
            b = parent[b];
        }

        return a;
    }

}
