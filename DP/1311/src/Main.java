import java.util.*;
import java.io.*;

public class Main {

    static final int INF = 99999999;
    static int n;
    static int[][] dp,cost;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[n][1 << n];

        bw.write(DP(0, 0) + "\n");

        bw.flush();
        bw.close();
        br.close();

    }


    static int DP(int now, int flag) {
        if (now == n)
            return 0;
        if (dp[now][flag] != 0)
            return dp[now][flag];

        int result = INF;
        for (int i = 0; i < n; i++) {
            if ((flag & (1 << i)) == 0)
                result = Math.min(result, cost[now][i] + DP(now + 1, flag | (1 << i)));
        }
        dp[now][flag] = result;
        return dp[now][flag];
    }
}
