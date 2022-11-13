import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {

        class Node {
            int x, y, z;

            Node(int a, int b, int c) {
                x = a;
                y = b;
                z = c;
            }
        }

        class NodeW implements Comparable<NodeW> {
            int start, end, cost;

            NodeW(int start, int end, int cost) {
                this.start = start;
                this.end = end;
                this.cost = cost;
            }

            public int compareTo(NodeW o) {
                return this.cost - o.cost;
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Node> planet = new ArrayList<>();

        int n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            planet.add(new Node(a, b, c));
        }

        PriorityQueue<NodeW> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Node n1 = planet.get(i);
            for (int j = i + 1; j < n; j++) {
                Node n2 = planet.get(j);
                int cost = Math.min(Math.abs(n1.x - n2.x), Math.abs(n1.y - n2.y));
                cost = Math.min(cost, Math.abs(n1.z - n2.z));
                pq.add(new NodeW(i + 1, j + 1, cost));
            }
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int answer=0;

        int size=pq.size();

        for(int i=0;i<size;i++){
            NodeW node=pq.poll();
            int x=find(node.start);
            int y=find(node.end);
            if(x!=y){
                answer+=node.cost;
                parent[y]=x;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();

    }

    public static int find(int x){
        if(parent[x]==x)
            return x;
        return parent[x]=find(parent[x]);
    }
}
