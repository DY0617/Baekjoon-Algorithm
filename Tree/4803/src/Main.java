import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Integer>[] graph;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i=1;i>0;i++) {

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            graph=new ArrayList[N];

            for(int j=0;j<M;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }

        }

    }

}
