import java.util.*;
import java.io.*;


public class Main {

    public static int[] parent;

    public static void main(String[] args) throws IOException{

        class Node{
            double a,b;

            Node(double a,double b){
                this.a=a;
                this.b=b;
            }
        }

        class NodeW implements Comparable<NodeW>{
            int a,b;
            double c;

            NodeW(int a,int b,double cost){
                this.a=a;
                this.b=b;
                c=cost;
            }

            public int compareTo(NodeW n){
                if(this.c-n.c>=0){
                    return 1;
                }
                else
                    return -1;
            }
        }

        ArrayList<NodeW> graph=new ArrayList<>();


        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());

        Node[] coordinate=new Node[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            double a=Double.parseDouble(st.nextToken());
            double b=Double.parseDouble(st.nextToken());
            coordinate[i]=new Node(a,b);
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                double weight=Math.sqrt(Math.pow(coordinate[i].a-coordinate[j].a,2)+Math.pow(coordinate[i].b-coordinate[j].b,2));
                graph.add(new NodeW(i+1,j+1,weight));
            }
        }

        Collections.sort(graph);

        parent=new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i]=i;
        }

        double total=0;

        for(int i=1;i<=graph.size();i++){
            NodeW node=graph.get(i-1);
            int x=find(node.a);
            int y=find(node.b);
            if(x!=y){
                total+=node.c;
                parent[y]=x;
            }
        }

        bw.write(String.valueOf(total));
        bw.flush();
        bw.close();
        br.close();

    }

    public static int find(int x){
        if(parent[x]==x)
            return x;
        return parent[x]=find(parent[x]);
    }
}
