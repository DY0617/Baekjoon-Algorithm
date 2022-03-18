import java.util.*;

public class Main {

    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        arr = new int[M];
        dfs(0,N, M, 0);

        System.out.println(sb);

    }

    public static void dfs(int count, int N, int M, int depth) {
        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = count; i < N; i++) {
            arr[depth] = i + 1;
            dfs(i,N, M, depth + 1);
        }

    }

}
