import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] indegree;
    static ArrayList<ArrayList<Integer>> edge= new ArrayList<>();
    static PriorityQueue<Integer> q;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        indegree=new int[n+1];

        for(int i=0;i<=n;i++){
            edge.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            edge.get(start).add(end);
            indegree[end]++;
        }

        q=new PriorityQueue<>();

        for(int i=1;i<=n;i++){
            if(indegree[i]==0)
                q.add(i);
        }

        StringBuilder sb=new StringBuilder();

        while(!q.isEmpty()){
            int num=q.poll();

           sb.append(num+" ");


            for(int j=0;j<edge.get(num).size();j++){
                int next=edge.get(num).get(j);
                indegree[next]--;
                if(indegree[next]==0)
                    q.add(next);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }
}
