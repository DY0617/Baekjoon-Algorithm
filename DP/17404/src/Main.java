import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static int[][] dp;
    static int[] visit;
    static ArrayList[] house;
    static int max=Integer.MAX_VALUE;


    static class Node implements Comparable<Node> {
        int color, idx;

        Node(int color, int idx) {
            this.color = color;
            this.idx = idx;
        }

        public int compareTo(Node o) {
            return this.color - o.color;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        dp = new int[n][3];
        house = new ArrayList[n];
        visit = new int[n];

        for (int i = 0; i < n; i++)
            house[i] = new ArrayList<Node>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            house[i].add(new Node(a, 1));
            house[i].add(new Node(b, 2));
            house[i].add(new Node(c, 3));
            Collections.sort(house[i]);
        }

        Node node = (Node) house[0].get(0);
        visit[0]=node.idx;
        dp[0][node.idx - 1] = node.color;
        dfs(1, node.idx-1);

        node = (Node) house[0].get(1);
        visit[0]=node.idx;
        dp[0][node.idx - 1] = node.color;
        dfs(1, node.idx-1);

        node = (Node) house[0].get(2);
        visit[0]=node.idx;
        dp[0][node.idx - 1] = node.color;
        dfs(1, node.idx-1);


        System.out.println(max);

        br.close();




    }

    static void dfs(int depth, int rgb) {


        if (depth == n) {

            max=Math.min(max,dp[depth-1][rgb]);
            return;
        }


        if (depth < n - 1) {


            ArrayList node=house[depth];

            for(int i=0;i<3;i++){
                Node next= (Node) node.get(i);

                if(visit[depth-1]!=next.idx){


                    visit[depth]=next.idx;
                    dp[depth][rgb]=next.color+dp[depth-1][rgb];
                    dfs(depth+1,rgb);

                }

            }



        }

        if(depth==n-1){


            ArrayList node=house[depth];

            for(int i=0;i<3;i++){
                Node next= (Node) node.get(i);

                if(visit[depth-1]!=next.idx&&visit[0]!=next.idx){
                    visit[depth]=next.idx;
                    dp[depth][rgb]=next.color+dp[depth-1][rgb];
                    dfs(depth+1,rgb);

                }

            }
        }



        visit[depth]=0;


    }

}
