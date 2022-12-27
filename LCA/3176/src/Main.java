import java.util.*;
import java.io.*;

public class Main {

    static final int log=17;

    static int n,k;
    static ArrayList<Node>[] list;
    static int[] depth;
    static int[][] parent,minDp,maxDp;
    static int min,max;

    static class Node{
        int location,weight;
        Node(int a,int b){
            location=a;
            weight=b;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        n=Integer.parseInt(br.readLine());

        list=new ArrayList[n+1];
        depth=new int[n+1];
        parent=new int[n+1][log];
        minDp=new int[n+1][log];
        maxDp=new int[n+1][log];


        for(int i=1;i<=n;i++)
            list[i]=new ArrayList<>();

        for(int i=0;i<n-1;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            list[from].add(new Node(to,weight));
            list[to].add(new Node(from,weight));
        }

        dfs(1,1,0);
        fillParent();

        k=Integer.parseInt(br.readLine());

        for(int i=0;i<k;i++){
            st=new StringTokenizer(br.readLine());

            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            LCA(a,b);

            sb.append(min+" "+max+"\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }


    static void dfs(int now,int nowDepth,int nowParent){
        depth[now]=nowDepth;
        parent[now][0]=nowParent;

        for(int i=0;i<list[now].size();i++){
            int next=list[now].get(i).location;
            if(next!=nowParent){
                dfs(next,nowDepth+1,now);
                minDp[next][0]=list[now].get(i).weight;
                maxDp[next][0]=list[now].get(i).weight;
            }
        }

    }

    static void fillParent(){
        for (int i = 1; i < log; i++) {
            for (int j = 1; j <= n; j++) {
                parent[j][i] = parent[ parent[j][i - 1] ][i - 1];
                minDp[j][i]=Math.min(minDp[j][i-1],minDp[parent[j][i-1]][i-1]);
                maxDp[j][i]=Math.max(maxDp[j][i-1],maxDp[parent[j][i-1]][i-1]);
            }
        }
    }

    static void LCA(int a, int b){

        if(depth[a]<depth[b]){
            int temp=a;
            a=b;
            b=temp;
        }


        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;



        for(int i=log-1;i>=0;i--){
            if(Math.pow(2,i)<=depth[a]-depth[b]){
                max=Math.max(maxDp[a][i],max);
                min=Math.min(minDp[a][i],min);

                a=parent[a][i];
            }
        }

        if(a==b) return;

        for (int i = log-1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                min = Math.min(min, Math.min(minDp[a][i], minDp[b][i]));
                max = Math.max(max, Math.max(maxDp[a][i], maxDp[b][i]));

                a = parent[a][i];
                b = parent[b][i];
            }
        }

        min = Math.min(min, Math.min(minDp[a][0], minDp[b][0]));
        max = Math.max(max, Math.max(maxDp[a][0], maxDp[b][0]));



    }
}
