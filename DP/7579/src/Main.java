import java.util.*;
import java.io.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static int[][] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr=new int[N][2];
        dp=new int[10001];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i][0]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dp,-1);

        for(int i=0;i<N;i++){
            int cost=arr[i][1];

            for(int j=10000;j>=cost;j--){
                if(dp[j-cost]!=-1){
                    if(dp[j-cost]+arr[i][0]>dp[j]){
                        dp[j]=dp[j-cost]+arr[i][0];
                    }
                }
            }

            if(dp[cost]<arr[i][0])
                dp[cost]=arr[i][0];

        }

        for(int i=0;i<=10000;i++){
            if(dp[i]>=M){
                System.out.println(i);
                break;
            }
        }


    }
}
