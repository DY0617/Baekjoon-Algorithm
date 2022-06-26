import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M, S, E;
    static int[] arr;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        dp = new boolean[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;//i~i는 자기 자신 = 팰린드롬
            if (arr[i] == arr[i - 1]) {
                //바로 뒤와 같으면 길이2짜리 팰린드롬
                dp[i - 1][i] = true;
            }
        }

        for (int i = 2; i < N; i++) {//i+1~n-1길이
            for (int j = 1; j <= N - i; j++) {
                if (arr[j] == arr[j + i] && dp[j + 1][j + i - 1]) {
                    //처음==끝 && 처음+1~ == 끝-1~
                    dp[j][j + i] = true;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            if (dp[S][E])
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();


    }
}
