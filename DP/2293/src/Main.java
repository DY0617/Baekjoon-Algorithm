import java.util.*;
import java.io.*;

public class Main {
    static int n,k;
    static int[] arr,dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());

        arr=new int[n+1];
        dp=new int[k+1];


        for(int i=1;i<=n;i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }

        dp[0]=1;

        for (int i = 1; i <= n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = dp[j] + dp[j - arr[i]];
            }
        }


        System.out.println(dp[k]);
    }
}
