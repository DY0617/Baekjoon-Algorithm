import java.util.*;
import java.io.*;

public class Main {

    static int max=0;
    static int N;

    static class Node{
        int child;
        int edge;

        Node(int a,int b){
            child=a;
            edge=b;
        }
    }

    static ArrayList<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{



        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        graph=new ArrayList[N+1];
        visited=new boolean[N+1];

        for(int i=1;i<=N;i++){
            graph[i]=new ArrayList<>();
        }



        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int parents=Integer.parseInt(st.nextToken());
            int child=Integer.parseInt(st.nextToken());
            int edge=Integer.parseInt(st.nextToken());
            graph[parents].add(new Node(child,edge));
            graph[child].add(new Node(parents,edge));
        }

        dfs(1,0);


    }


    public static void dfs(int loc, int sum){

        if(visited[loc]) {
            if (sum > max) {
                max = sum;
                return;
            }
        }



    }


}
