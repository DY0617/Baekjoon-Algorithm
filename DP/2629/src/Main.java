import java.util.*;
import java.io.*;

public class Main {

    static int N1,N2,max=15000,question;//N1=추의 개수
    static int[] arr;
    static boolean[][] dp;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer st=new StringTokenizer(br.readLine());
        N1= Integer.parseInt(st.nextToken());
        arr=new int[N1+1];
        dp=new boolean[31][max+1];

        st=new StringTokenizer(br.readLine());

        for(int i=1;i<=N1;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        find_dp(0,0);

        StringBuilder sb= new StringBuilder();
        N2= Integer.parseInt(br.readLine());
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<N2; i++) {
            question= Integer.parseInt(st.nextToken());
            if(question>15000)  sb.append("N ");
            else sb.append(dp[N1][question]?"Y ":"N ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

    public static void find_dp(int idx, int weight) {
        if(dp[idx][weight]) return;
        dp[idx][weight]=true;
        if(idx==N1) return;

        find_dp(idx+1, weight+arr[idx+1]);
        find_dp(idx+1, weight);
        find_dp(idx+1, Math.abs(weight-arr[idx+1]));
    }

}
