import java.util.*;

public class Main {
    public static boolean[] visit;
    public static int[][] edge;
    public static int[] arr;
    public static int N;
    public static int M;
    public static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N=sc.nextInt();
        arr=new int[N];
        edge=new int[N][N];
        visit=new boolean[N];

        M=sc.nextInt();


        int V=sc.nextInt();
        for(int i=0;i<M;i++){
            int a=sc.nextInt()-1;
            int b=sc.nextInt()-1;
            edge[a][b]=1;
            edge[b][a]=1;
        }

        dfs(V-1);
        for(int i=0;i<N;i++)
            visit[i]=false;

        bfs(V-1);
        System.out.println(sb);

    }

    public static void dfs(int depth){
        visit[depth]=true;
        sb.append(depth+1).append(" ");
        for(int i=0;i<N;i++){
            if(edge[depth][i]==1&&visit[i]==false){
                dfs(i);
            }
        }

    }

    public static void bfs(int V){
        sb.append("\n");
        Queue<Integer> q=new LinkedList<Integer>();
        q.offer(V);
        visit[V]=true;
        sb.append(V+1).append(" ");
        while(!q.isEmpty()){
            int temp=q.poll();

            for(int i=0;i<N;i++){
                if(edge[temp][i]==1&&visit[i]==false){
                    q.offer(i);
                    visit[i]=true;
                    sb.append(i+1).append(" ");
                }
            }
        }
    }


}
