import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {


        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int x = find(b);
            int y = find(c);

            if (a == 0) {
                if (x != y) {
                    parent[y] = x;
                }
            } else {
                boolean answer = x == y;
                if (!answer)
                    bw.write("NO\n");
                else
                    bw.write("YES\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
