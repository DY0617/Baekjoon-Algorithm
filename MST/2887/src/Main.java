import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {

        class Node {
            int x, y, z, index;

            Node(int a, int b, int c, int index) {
                x = a;
                y = b;
                z = c;
                this.index = index;
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
            planet.add(new Node(a, b, c, i + 1));
        }

        ArrayList<Node> sortX = new ArrayList<Node>(planet);
        Collections.sort(sortX, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.x - o2.x;
            }
        });
        ArrayList<Node> sortY = new ArrayList<Node>(planet);
        Collections.sort(sortY, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.y - o2.y;
            }
        });
        ArrayList<Node> sortZ = new ArrayList<Node>(planet);
        Collections.sort(sortZ, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.z - o2.z;
            }
        });


        PriorityQueue<NodeW> pq = new PriorityQueue<>();

        for (int i = 0; i < n - 1; i++) {
            Node p1 = sortX.get(i);
            Node p2 = sortX.get(i + 1);
            pq.add(new NodeW(p1.index, p2.index, Math.min(Math.abs(p1.x - p2.x), Math.min(Math.abs(p1.y - p2.y), Math.abs(p1.z - p2.z)))));
            p1 = sortY.get(i);
            p2 = sortY.get(i + 1);
            pq.add(new NodeW(p1.index, p2.index, Math.min(Math.abs(p1.x - p2.x), Math.min(Math.abs(p1.y - p2.y), Math.abs(p1.z - p2.z)))));
            p1 = sortZ.get(i);
            p2 = sortZ.get(i + 1);
            pq.add(new NodeW(p1.index, p2.index, Math.min(Math.abs(p1.x - p2.x), Math.min(Math.abs(p1.y - p2.y), Math.abs(p1.z - p2.z)))));
        }

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int answer = 0;

        int size = pq.size();

        for (int i = 0; i < size; i++) {
            NodeW node = pq.poll();
            int x = find(node.start);
            int y = find(node.end);
            if (x != y) {
                if (x > y)
                    parent[x] = y;
                else
                    parent[y] = x;
                answer += node.cost;
            }
        }

        bw.write(String.valueOf(answer));

        br.close();
        bw.flush();
        bw.close();

    }

    public static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }
}
