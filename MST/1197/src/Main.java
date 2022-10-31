import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        class Node implements Comparable<Node>{
            int a,b,cost;
            Node(int a, int b, int cost){
                this.a=a;
                this.b=b;
                this.cost=cost;
            }

            public int compareTo(Node n){
                return this.cost-n.cost;
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int weight=0;

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<Node> graph = new ArrayList<>();



        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.add(new Node(a,b,c));
        }

        Collections.sort(graph);

        parent=new int[v+1];

        for(int i=1;i<=v;i++)
            parent[i]=i;

        for(int i=0;i<e;i++){
            Node node=graph.get(i);
            if (!isSameParent(node.a, node.b)) {
                union(node.a, node.b);
                weight += node.cost;
            }
        }

        bw.write(weight + "\n");

        br.close();
        bw.flush();
        bw.close();

    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}
