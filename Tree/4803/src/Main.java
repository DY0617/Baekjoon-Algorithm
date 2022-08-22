import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i=1;i>0;i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if(N==0&&M==0)
                break;

            graph=new ArrayList[N+1];
            visited= new boolean[N + 1];

            for(int j=1;j<=N;j++)
                graph[j]=new ArrayList<>();

            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

            int ans=0;

            for (int j = 1; j <= N; j++) {
                if (!visited[j]) {
                    visited[j] = true;
                    if (dfs(-1, j)) ans++;
                }
            }

            sb.append("Case ").append(i).append(": ");
            if (ans == 0) {
                sb.append("No trees.\n");
            } else if (ans == 1) {
                sb.append("There is one tree.\n");
            } else {
                sb.append("A forest of ").append(ans).append(" trees.\n");
            }



        }

        System.out.println(sb);
        br.close();

    }

    public static boolean dfs(int root, int num) {
        for (int i : graph[num]) {
            if (i == root) continue;
            if (visited[i]) return false;
            visited[i] = true;
            if (!dfs(num, i)) return false;
        }
        return true;
    }

}
