import java.util.*;
import java.io.*;

class Main {
    static int[][] arr;
    static int N;
    static int M;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static boolean visit[][][];
    static Queue<location> q = new LinkedList<>();
    ;

    public static class location {
        int x, y, count;
        boolean canbreak;

        public location(int x, int y, int count, boolean canbreak) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.canbreak = canbreak;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        visit = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "");
            String str = st.nextToken();
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        bfs(0, 0);


    }

    public static void bfs(int x, int y) {
        q.add(new location(x, y, 1, false));

        while (!q.isEmpty()) {
            location l = q.poll();
            if (l.x == N - 1 && l.y == M - 1) {
                System.out.println(l.count);
                return;
            }
            for (int i = 0; i < 4; i++) {
                if(notException(l.x+dx[i],l.y+dy[i])){
                    if(arr[l.x+dx[i]][l.y+dy[i]]==0){
                        if(!l.canbreak&&!visit[l.x+dx[i]][l.y+dy[i]][0]){
                            q.add(new location(l.x+dx[i],l.y+dy[i],l.count+1,false));
                            visit[l.x+dx[i]][l.y+dy[i]][0]=true;
                        }
                        else if(l.canbreak&&!visit[l.x+dx[i]][l.y+dy[i]][1]){
                            q.add(new location(l.x+dx[i],l.y+dy[i],l.count+1,true));
                            visit[l.x+dx[i]][l.y+dy[i]][1]=true;
                        }
                    }
                    else if(arr[l.x+dx[i]][l.y+dy[i]]==1){
                        if(!l.canbreak){
                            q.add(new location(l.x+dx[i],l.y+dy[i],l.count+1,true));
                            visit[l.x+dx[i]][l.y+dy[i]][1]=true;
                        }
                    }
                }
            }
        }
        System.out.println(-1);


    }

    public static boolean notException(int x, int y) {
        if (x >= 0 && x < N && y >= 0 && y < M)
            return true;
        return false;
    }
}
