import java.util.*;
import java.io.*;

public class Main {
    static int N, K;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        sc.close();

        bfs();

        Stack<Integer> stack=new Stack<>();
        stack.push(K);
        int value=K;
        while(value!=N){
            stack.push(parent[value]);
            value=parent[value];
        }

        StringBuilder sb=new StringBuilder();
        sb.append(time[K]-1).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(N);
        time[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == K)
                return;

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0)
                    next = now + 1;

                else if (i == 1)
                    next = now - 1;

                else
                    next = now * 2;

                if (next < 0 || next > 100000) continue;
                if(time[next]==0){
                    time[next]=time[now]+1;
                    queue.add(next);
                    parent[next]=now;
                }
            }
        }
    }
}
