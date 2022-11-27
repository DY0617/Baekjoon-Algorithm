import java.util.*;
import java.io.*;

public class Main {

    static int n,k;
    static int[][] dp;
    private static final int MOD = 1_000_000_003;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        k=Integer.parseInt(br.readLine());

        dp=new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            dp[i][1]=i;
            dp[i][0]=1;
        }

        for(int i = 3; i <= n; i++){
            // n개의 수 중 n/2개 보다 더 많이 고르는 경우는 0가지이다.
            // 그렇기 때문에 j의 범위를 다음과 같이 설정한다.
            for(int j = 2; j <= (i + 1) / 2; j++){
                // i번째 색을 선택하지 않은 경우 + i번째 색을 선택한 경우
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        System.out.println((dp[n - 3][k - 1] + dp[n - 1][k]) % MOD + "\n");

    }
}
