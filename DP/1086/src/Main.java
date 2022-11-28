import java.io.*;
import java.util.*;


public class Main {

    static int N,K;
    static long[] fibo;
    static char[][] arr;
    static long p;
    static long q;


    static long GCD(long a, long b) {
        if(a<b){
            long tmp = a;
            a = b;
            b = tmp;
        }
        while(b!=0){
            long tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        arr=new char[N][];

        for(int i=0;i<N;i++){
            arr[i]=br.readLine().toCharArray();
        }

        K=Integer.parseInt(br.readLine());

        fibo=new long[N+1];

        fibo[1] = 1L;
        for (int i = 2; i <= N; i++) {
            fibo[i] = (long)i * fibo[i - 1];
        }
        dp = new long[K][1 << N];
        dpMod = new int[K][N];
        for (int k = 0; k < K; k++) {
            Arrays.fill(dp[k], -1);
            Arrays.fill(dpMod[k], -1);
        }

        p = memoi(0, 0, 0);
        q = fibo[N];
        if (p == 0) {
            q = 1;
        } else {
            long gcd = GCD(p, q);
            p /= gcd;
            q /= gcd;
        }

        System.out.println(p + "/" + q);
    }

    static int dpMod[][];

    public static int getMod(int mod,int n) {
        if
        (dpMod[mod][n]!=-1) {
            return dpMod[mod][n];
        }
        int cur = mod;
        for (int j = 0; j < arr[n].length; j++) {
            cur = cur*10;
            cur = (cur +arr[n][j] - '0')% K;
        }

        return dpMod[mod][n] =cur;
    }

    public static long memoi(int mod, int cnt, int flag) {
        if (dp[mod][flag] != -1) {
            return dp[mod][flag];
        }
        if (cnt == N) {
            return dp[mod][flag] = mod == 0 ? 1L : 0;
        }

        long sum = 0;
        for (int i = 0; i < N; i++) {
            if ((flag & (1 << i)) == (1 << i))
                continue;

            sum += memoi(getMod(mod, i),cnt+1,flag|(1<<i));
        }

        return dp[mod][flag] = sum;
    }

    static long dp[][];
}
