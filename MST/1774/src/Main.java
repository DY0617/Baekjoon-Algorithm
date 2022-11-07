import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException{

        class Node{
            int a,b;
            Node(int a,int b){
                this.a=a;
                this.b=b;
            }
        }

        class NodeW implements Comparable<NodeW>{
            int start,end;
            double cost;
            NodeW(int a,int b,double c){
                start=a;
                end=b;
                cost=c;
            }

            public int compareTo(NodeW node){
                if(this.cost-node.cost>=0){
                    return 1;
                }
                else
                    return -1;
            }

        }

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        ArrayList<Node> graph=new ArrayList<>();
        ArrayList<Node> already=new ArrayList<>();

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            graph.add(new Node(a,b));
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            already.add(new Node(a,b));
        }

        ArrayList<NodeW> mst=new ArrayList<>();

        for(int i=0;i<n;i++){
            Node node1=graph.get(i);
            for(int j=i+1;j<n;j++){
                Node node2=graph.get(j);
                mst.add(new NodeW(i+1,j+1,Math.sqrt(Math.pow(node1.a-node2.a,2)+Math.pow(node1.b-node2.b,2))));
            }
        }

        Collections.sort(mst);

        parent=new int[n+1];
        for(int i=1;i<=n;i++){
            parent[i]=i;
        }

        for(int i=1;i<=m;i++){
            Node node=already.get(i-1);
            int x=find(node.a);
            int y=find(node.b);
            parent[y]=x;
        }


        double total=0;

        for(int i=1;i<=n;i++){
            NodeW node=mst.get(i-1);
            int x=find(node.start);
            int y=find(node.end);


            if(x!=y){
                parent[y]=x;
                total+=node.cost;
            }
        }

        bw.write(String.valueOf(total));

        bw.flush();
        bw.close();
        br.close();



    }

    static int find(int x){
        if(parent[x]==x)
            return x;
        return parent[x]=find(parent[x]);
    }



}
