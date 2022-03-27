import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N,E;
    public static int a,b,c;
    public static ArrayList[] arr;
    public static int[] distance;
    public static int v1,v2;

    public static class Edge implements Comparable<Edge>{
        int id,cost;

        public Edge(int id, int cost){
            this.id=id;
            this.cost=cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }



    }

    public static void main(String[] args) throws IOException{
        br=new BufferedReader(new InputStreamReader(System.in));
        bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        E=Integer.parseInt(st.nextToken());
        distance=new int[N+1];
        arr=new ArrayList[N+1];

        for(int i=1;i<N+1;i++){
            distance[i]=Integer.MAX_VALUE;
            arr[i]=new ArrayList<Edge>;
        }

        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());

            c=Integer.parseInt(st.nextToken());
            arr[a].add(new Edge(b,c));
        }

        st=new StringTokenizer(br.readLine());
        v1=Integer.parseInt(st.nextToken());
        v2=Integer.parseInt(st.nextToken());



    }


    public static void dijkstra(){
        PriorityQueue<Edge> pq=new PriorityQueue<Edge>;
        pq.add(new Edge(1,0));

        while(!pq.isEmpty()){
            Edge now=pq.poll();
        }
    }
}
