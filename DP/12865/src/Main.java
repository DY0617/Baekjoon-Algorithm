import java.util.*;
import java.io.*;

public class Main {

    static int N, K, W, V;
    static Integer[][] dp;
    static int max=0;
    static Node[] bag;

    static class Node{
        int weight, value;
        Node(int weight, int value){
            this.weight=weight;
            this.value=value;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp=new Integer[N][K+1];
        bag=new Node[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());
            bag[i]=new Node(W,V);
        }

        System.out.println(knapsack(N - 1, K));

    }

    static int knapsack(int i, int k) {
        // i가 0미만, 즉 범위 밖이 된다면
        if (i < 0)
            return 0;

        // 탐색하지 않은 위치라면?
        if (dp[i][k] == null) {

            // 현재 물건(i)을 추가로 못담는 경우 (이전 i값 탐색)
            if(bag[i].weight > k) {
                dp[i][k] = knapsack(i - 1, k);
            }
            // 현재 물건(i)을 담을 수 있는 경우
            else if (bag[i].weight <= k) {
                // 이전 i값과 이전 i값에 대한 k-W[i]의 값 + 현재 가치(V[i])중 큰 값을 저장
                dp[i][k] = Math.max(knapsack(i - 1, k), knapsack(i - 1, k - bag[i].weight) + bag[i].value);
            }
        }
        return dp[i][k];
    }
}
