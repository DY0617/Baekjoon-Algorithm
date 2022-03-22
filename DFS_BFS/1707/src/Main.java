import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static int V, E;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] s = br.readLine().split(" ");
            V = Integer.parseInt(s[0]);
            E = Integer.parseInt(s[1]);

            color = new int[V];
            graph = new ArrayList<>();

            for (int j = 0; j < V; j++)
                graph.add(new ArrayList<>());

            for (int e = 0; e < E; e++) {
                s = br.readLine().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);

                graph.get(b - 1).add(a - 1);
                graph.get(a - 1).add(b - 1);
            }

            for (int j = 0; j < V; j++) {
                if (color[j] == 0) {
                    color[j] = 1;
                    bfs( j);
                }
            }
            bw.write(check(V) + "\n");
        }
        bw.flush();
    }

    public static void bfs( int start) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while (!q.isEmpty()) {
            int v = q.poll();
            int c = color[v];

            for (int i = 0; i < graph.get(v).size(); i++) {

                int v2 = graph.get(v).get(i);

                if (color[v2] == 0) {
                    if (c == 1)
                        color[v2] = -1;
                    else if (c == -1)
                        color[v2] = 1;

                    q.offer(v2);
                }
            }
        }
    }

    public static String check(int V) {

        for (int n = 0; n < V; n++) {
            for (int m = 0; m < graph.get(n).size(); m++) {
                if (color[n] == color[graph.get(n).get(m)]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
}