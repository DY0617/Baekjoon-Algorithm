import java.util.*;
import java.io.*;

public class Main {
    static int[][] line;
    static int[] cross;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        line = new int[N][2];
        cross = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            line[i][0] = a;
            line[i][1] = b;
        }

        Arrays.sort(line, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        for(int i=0;i<N;i++){
            max=Math.max(max,chooseMax(i));
        }

        StringBuilder sb=new StringBuilder();
        sb.append(N-max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();


    }

    static int chooseMax(int loc) {
        if (cross[loc] == 0) {
            cross[loc] = 1;
            for (int i = loc + 1; i < N; i++) {
                if (line[loc][1] < line[i][1]) {
                    cross[loc] = Math.max(cross[loc], chooseMax(i) + 1);
                }
            }
        }
        return cross[loc];
    }
}
