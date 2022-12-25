import java.io.*;
import java.util.*;

public class Main {

    static final int log=17;

    static int n,m;
    static int[] depth;
    static int[][] parent;
    static ArrayList<Integer>[] tree;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());

        depth=new int[n+1];
        parent=new int[n+1][log];
        tree=new ArrayList[n+1];

        for(int i=1;i<=n;i++)
            tree[i]=new ArrayList<>();


        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            tree[from].add(to);
            tree[to].add(from);
        }

        dfs(1,1,0);

        fillParent();

        m=Integer.parseInt(br.readLine());

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int input=lca(a,b);
            sb.append(input).append("\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int now,int nowDepth,int nowParent){
        depth[now]=nowDepth;
        parent[now][0]=nowParent;

        for(int next : tree[now]){
            if(next!=nowParent){
                dfs(next,nowDepth+1,now);
            }
        }
    }

    static void fillParent(){
        for (int i = 1; i < log; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j][i] = parent[ parent[j][i - 1] ][i - 1];
            }
        }
    }

    private static int lca(int a, int b) {
        if (depth[a] < depth[b]) { // 깊이가 낮은 쪽을 기준으로 맞춘다.
            int temp = a;
            a = b;
            b = temp;
        }

        //더 깊은 a를 2승씩 점프하며 두 노드의 depth를 맞춘 후, 맞춘 depth의 조상 노드로 대체한다.
        for (int i = log - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[a] - depth[b]) {
                a = parent[a][i]; // a를 2^i 번 째 조상 노드로 대체한다.
            }
        }

        // depth 맞춘 후 대체한 조상 노드가 b와 같다면. 즉, a의 조상노드가 b라면 종료한다.
        if (a == b) return a;

        // 이제 두 노드는 같은 depth를 가지기 때문에
        // 같이 2승씩 점프시키며 공통부모 바로 아래까지 올린다.
        for (int i = log - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }

        return parent[a][0];
    }



}
