import java.util.*;
import java.io.*;


public class Main {


    static class Edge implements Comparable<Edge> {
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


    public static int n, m, t;
    public static int s, g, h;
    public static int a, b, d;
    public static ArrayList<Edge>[] arr;
    public static int[] shortestDistance;
    public static int[] Distance;
    public static int[] destination;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), " ");
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n + 1];
            shortestDistance = new int[n + 1];
            destination = new int[t];
            Distance = new int[n + 1];

            for (int k = 1; k < n + 1; k++) {
                arr[k]=new ArrayList<>();
                shortestDistance[k] = 50000000;
                Distance[k] = 50000000;
            }

            for (int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                arr[a].add(new Edge(b, d));
                arr[b].add(new Edge(a, d));
            }

            for (int j = 0; j < t; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                destination[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(destination);


            dijkstra(s);

            dijkstraBreak(g, h);
            int gToh = shortestDistance[g] + Distance[h];
            int hTog = shortestDistance[h] + Distance[h];
            int gTofinal;
            int hTofinal;
            StringBuilder sb=new StringBuilder();

            for (int j = 0; j < t; j++) {
                for (int k = 1; k < n + 1; k++) {
                    Distance[k] = 50000000;
                }
                dijkstraBreak(h, destination[j]);
                gTofinal = gToh + Distance[destination[j]];

                for (int k = 1; k < n + 1; k++) {
                    Distance[k] = 50000000;
                }
                dijkstraBreak(g, destination[j]);
                hTofinal = hTog + Distance[destination[j]];

                int total = 0;
                if (gTofinal > hTofinal)
                    total = hTofinal;
                else
                    total = gTofinal;

                if(shortestDistance[destination[j]]==total){
                    sb.append(destination[j]+" ");
                }
            }
            sb.append("\n");

            bw.write(sb.toString());

        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        shortestDistance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();

            if (now.cost > shortestDistance[now.id]) continue;

            int len = arr[now.id].size();

            for (int i = 0; i < len; i++) {
                Edge next = arr[now.id].get(i);
                if (shortestDistance[next.id] > now.cost + next.cost) {
                    shortestDistance[next.id] = now.cost + next.cost;
                    pq.add(new Edge(next.id, shortestDistance[next.id]));
                }
            }
        }
    }

    public static void dijkstraBreak(int start, int arrive) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        Distance[start] = 0;
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            if (now.id == arrive)
                break;

            if (now.cost > Distance[now.id]) continue;

            int len = arr[now.id].size();

            for (int i = 0; i < len; i++) {
                Edge next = arr[now.id].get(i);
                if (Distance[next.id] > now.cost + next.cost) {
                    Distance[next.id] = now.cost + next.cost;
                    pq.add(new Edge(next.id, Distance[next.id]));
                }
            }
        }
    }
}
