import java.util.*;
import java.io.*;

public class Main {
    static int T;
    static int A, B;
    static Queue<Integer> queue;
    static int[] time;
    static int[] parents;
    static char[] register;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            time = new int[10000];
            parents = new int[10000];
            register = new char[10000];
            bfs();
            Stack<Character> stack = new Stack<>();
            int index = B;
            while (index != A){
                stack.push(register[index]);
                index=parents[index];
            }
            StringBuilder sb=new StringBuilder();
            while(!stack.isEmpty())
                sb.append(stack.pop());
            bw.write(sb.toString()+"\n");

        }
        bw.flush();
        bw.close();
        br.close();


    }

    public static void bfs() {
        queue = new LinkedList<>();
        queue.add(A);
        time[A] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (now == B) return;

            int next = now * 2 % 10000;
            if (time[next] == 0) {
                queue.add(next);
                time[next] = time[now] + 1;
                parents[next] = now;
                register[next] = 'D';
            }

            next = now - 1;
            if (next == -1) next = 9999;

            if (time[next] == 0) {
                queue.add(next);
                time[next] = time[now] + 1;
                parents[next] = now;
                register[next] = 'S';
            }

            next = now * 10 % 10000 + now / 1000;
            if (time[next] == 0) {
                queue.add(next);
                time[next] = time[now] + 1;
                parents[next] = now;
                register[next] = 'L';
            }

            next = now / 10 + now % 10 * 1000;
            if (time[next] == 0) {
                queue.add(next);
                time[next] = time[now] + 1;
                parents[next] = now;
                register[next] = 'R';
            }
        }
    }
}
