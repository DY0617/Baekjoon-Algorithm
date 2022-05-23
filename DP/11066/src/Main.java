import java.util.*;
import java.io.*;

public class Main {
    static int t,k;
    static int[] arr,sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        t= Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr=new int[k+1];
            sum=new int[k+1];
            dp=new int[k+1][k+1];
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=k;j++){
                arr[j]=Integer.parseInt(st.nextToken());
                sum[j]=arr[j]+sum[j-1];
            }

            for (int n = 1; n <= k; n++) {
                for (int from = 1; from + n <= k; from++) {
                    int to = from + n;
                    dp[from][to] = Integer.MAX_VALUE;
                    for (int divide = from; divide < to; divide++) {
                        dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                    }
                }
            }

            StringBuilder sb=new StringBuilder();
            System.out.println(dp[1][k]);

        }
        bw.flush();
        bw.close();
        br.close();
    }
}
