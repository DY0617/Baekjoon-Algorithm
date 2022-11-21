import java.util.*;
import java.io.*;

public class Main {

    static int[] size;
    static ArrayList[] graph;
    static int[][] dp;
    static boolean[] visit;
    static PriorityQueue<Integer> pq;

    public static void main(String[] args) throws IOException{


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n=Integer.parseInt(br.readLine());

        graph=new ArrayList[n+1];
        size=new int[n+1];
        dp=new int[n+1][2];
        visit=new boolean[n+1];
        pq=new PriorityQueue<Integer>();

        for(int i=1;i<=n;i++)
            graph[i]=new ArrayList<>();

        st=new StringTokenizer(br.readLine());

        for(int i=1;i<=n;i++){
            size[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        if(dp[1][1]>dp[1][0]){
            System.out.println(dp[1][1]);
            trace(1,1);
        }
        else {
            System.out.println(dp[1][0]);
            trace(1,0);
        }

        while(!pq.isEmpty())
            System.out.print(pq.poll()+" ");


    }

    static void dfs(int num){

        dp[num][0]=0;
        dp[num][1]=size[num];

        if(graph[num].size()==0) return;

        visit[num]=true;

        for(int i=0;i<graph[num].size();i++){
            int child= (int) graph[num].get(i);
            if(!visit[child]){
                dfs(child);

                if(dp[child][0]>dp[child][1]){
                    dp[num][0]+=dp[child][0];
                }
                else
                    dp[num][0]+=dp[child][1];

                dp[num][1]+=dp[child][0];
            }
        }
        visit[num]=false;

    }

    static void trace(int num, int attend){
        visit[num]=true;
        if(attend==1){
            pq.add(num);
            for(int i=0;i<graph[num].size();i++){
                int next= (int) graph[num].get(i);
                if(!visit[next]){
                    trace(next,0);
                }
            }
        }
        else{
            for(int i=0; i<graph[num].size(); i++) {
                int next = (int) graph[num].get(i);
                if(!visit[next]) {
                    if(dp[next][1] > dp[next][0]) {
                        trace(next, 1);
                    }else {
                        trace(next, 0);
                    }
                }
            }
        }
        visit[num]=false;
    }
}
