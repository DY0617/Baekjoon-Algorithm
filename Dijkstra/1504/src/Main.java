import java.util.*;
import java.io.*;

public class Main {

    public static BufferedReader br;
    public static BufferedWriter bw;
    public static int N, E;
    public static int a, b, c;
    public static ArrayList[] arr;
    public static int[] distance;
    public static int v1, v2;
    public static boolean arrive;

    public static class Edge implements Comparable<Edge> {
        int id, cost;

        public Edge(int id, int cost) {
            this.id = id;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }


    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        arr = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
            arr[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr[a].add(new Edge(b, c));
            arr[b].add(new Edge(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());


        dijkstra(1);

        int v1Dis = distance[v1];
        int v2Dis = distance[v2];


        //v1과 v2 거리
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        dijkstraBreak(v1, v2);

        if (!arrive) {
            System.out.println(-1);
            System.exit(0);
        }
        arrive = false;

        int v1Tov2 = distance[v2];


        //v2에서 도착지
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }


        dijkstraBreak(v2, N);
        if (!arrive) {
            v1Dis = Integer.MAX_VALUE;
        } else {
            v1Dis = v1Dis + v1Tov2 + distance[N];
        }
        arrive = false;


        //v1에서 도착지
        for (int i = 1; i < N + 1; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        dijkstraBreak(v1, N);


        if (!arrive) {
            v2Dis = Integer.MAX_VALUE;
        } else {
            v2Dis = v2Dis + v1Tov2 + distance[N];
        }


        StringBuilder sb = new StringBuilder();


        if(v1Dis==Integer.MAX_VALUE&&v2Dis==Integer.MAX_VALUE){
            sb.append(-1);
        }
        else if (v1Dis > v2Dis) {
            sb.append(v2Dis);
        } else
            sb.append(v1Dis);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }


    public static void dijkstra(int a) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(a, 0));
        distance[a] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.cost > distance[now.id]) continue;
            int len = arr[now.id].size();
            for (int i = 0; i < len; i++) {
                Edge next = (Edge) arr[now.id].get(i);
                if (distance[next.id] > now.cost + next.cost) {
                    distance[next.id] = now.cost + next.cost;
                    pq.add(new Edge(next.id, distance[next.id]));
                }
            }
        }
    }

    public static void dijkstraBreak(int a, int b) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
        pq.add(new Edge(a, 0));
        distance[a] = 0;

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.id == b) {
                arrive = true;
                break;
            }


            if (now.cost > distance[now.id]) continue;
            int len = arr[now.id].size();
            for (int i = 0; i < len; i++) {
                Edge next = (Edge) arr[now.id].get(i);
                if (distance[next.id] > now.cost + next.cost) {
                    distance[next.id] = now.cost + next.cost;
                    pq.add(new Edge(next.id, distance[next.id]));
                }
            }
        }
    }
}
