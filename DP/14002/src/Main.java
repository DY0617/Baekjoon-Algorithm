import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int[] arr;
    public static int[] dp;
    public static ArrayList<Integer> list=new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }

        int value=ans;
        for(int i=N-1;i>=0;i--){
            if(dp[i]==value){
                list.add(arr[i]);
                value--;
            }
        }
        Collections.sort(list);
        StringBuilder sb=new StringBuilder();
        sb.append(ans).append("\n");
        for(int i=0;i<list.size();i++){
            sb.append(list.get(i)).append(" ");
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
