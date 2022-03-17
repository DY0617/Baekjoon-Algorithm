import java.util.*;

public class Main {

    public static boolean[] visit;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.close();

        arr = new int[M];
        visit = new boolean[N];

        dfs(0,N,M,0);
        System.out.println(sb);

    }

    public static void dfs(int count, int N, int M, int depth) {
        if (depth == M) {
            for (int num : arr) {
                sb.append(num).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = count; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                arr[depth]=i+1;
                dfs(i+1,N,M,depth+1);
                visit[i]=false;
            }

        }

    }
}
