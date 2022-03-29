import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a=0;
        int b=0;


        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int left = 0;
        int right = n - 1;
        int max = 2000000000;

        while (left < right) {
            int sum = arr[left] + arr[right];

            // 두 용액 갱신
            if (Math.abs(sum) < max) {
                a = arr[left];
                b = arr[right];
                max = Math.abs(sum);
            }

            if (sum > 0)
                right--;
            else
                left++;
        }

        StringBuilder sb=new StringBuilder();
        sb.append(a+" "+b);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }


}