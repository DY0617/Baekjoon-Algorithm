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

        Arrays.sort(line,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0] - o2[0];
            }
        });
    }
}
