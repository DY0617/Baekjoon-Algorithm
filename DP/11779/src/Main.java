import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int finish;
    static ArrayList<Node>[] graph;
    static int[] dist,visit;

    static class Node implements Comparable<Node> {
        public int loc, cost;

        Node(int loc, int cost) {
            this.loc = loc;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        graph=new ArrayList[n+1];
        dist=new int[n+1];
        visit=new int[n+1];

        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }

        for(int i=1;i<=n;i++){
            dist[i]=Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[start].add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine(), " ");
        int first=Integer.parseInt(st.nextToken());
        finish=Integer.parseInt(st.nextToken());

        dijkstra(first);

        StringBuilder sb=new StringBuilder();
        sb.append(dist[finish]).append("\n");

        int count=1;

        Stack<Integer> stack=new Stack<>();
        stack.push(finish);
        while(visit[finish]!=0){
            count++;
            stack.push(visit[finish]);
            finish=visit[finish];
        }

        sb.append(count+"\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()+" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if(now.loc==finish)
                break;

            if (now.cost > dist[now.loc]) continue;

            int len = graph[now.loc].size();

            for (int i = 0; i < len; i++) {
                Node next = graph[now.loc].get(i);
                if (dist[next.loc] > now.cost + next.cost) {
                    dist[next.loc] = now.cost + next.cost;
                    visit[next.loc]=now.loc;
                    pq.add(new Node(next.loc, dist[next.loc]));
                }
            }
        }
    }
}
