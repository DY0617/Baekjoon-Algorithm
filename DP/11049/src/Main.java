import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] arr, dp;


    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][2];
        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<n;i++){
            dp[i][i+1]=arr[i][0]*arr[i][1]*arr[i+1][1];
        }

        for(int i=2;i<=n;i++){
            for(int j=1;j+i<=n;j++){
                int k=i+j;
                dp[j][k]=Integer.MAX_VALUE;
                for(int q=j;q<k;q++){
                    dp[j][k]=Math.min(dp[j][k],dp[j][q]+dp[q+1][k]+(arr[j][0]*arr[q][1]*arr[k][1]));
                }
            }
        }

        System.out.println(dp[0][n]);
    }
}
