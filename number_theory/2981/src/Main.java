import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int gcd = arr[1] - arr[0];

        for (int i = 2; i < N; i++) {
            int a=gcd;
            int b = arr[i] - arr[i - 1];
            while (b != 0) {
                int r = a % b;
                a = b;
                b = r;
            }
            gcd=a;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();

        // 최대공약수의 약수들 찾기 (제곱근까지만 탐색)
        for(int i = 2; i <= Math.sqrt(gcd); i++) {

            // 제곱근이 gcdVal의 약수라면 중복추가를 방지하기 위해 한 번만 추가
            if(i * i == gcd) {
                list.add(i);
            }
            // i가 최대공약수의 약수라면 i와 나눈 몫 추가
            else if(gcd % i == 0) {
                list.add(i);
                list.add(gcd / i);
            }
        }

        // 정렬
        Collections.sort(list);

        for(int val : list) {
            sb.append(val).append(' ');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
