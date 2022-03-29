import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        for (start = 0; start < n; start++) {
            while (sum < m && end < n) {
                sum = sum + arr[end];
                end++;
            }
            if (sum == m) {
                cnt++;
            }
            sum = sum - arr[start];
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}
