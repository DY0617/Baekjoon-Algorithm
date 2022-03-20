import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Tomato {
    int x;
    int y;
    int time;

    public Tomato(int x, int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;
    }
}

public class Main {

    static int N, M;			// 가로, 세로 길이
    static int maxTime;			// 토마토가 전부 익는 데에 걸리는 최대 일수
    static int[][] grid;			// 토마토 정보를 담은 이차원배열
    static Queue<Tomato> tomatos;		// 익은 토마토를 담는 배열
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maxTime = Integer.MIN_VALUE;
        grid = new int[N][M];
        tomatos = new LinkedList<>();

        // grid에 토마토 정보 담기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int time = Integer.parseInt(st.nextToken());
                grid[i][j] = time;

                // 익은 토마토인 경우 토마토 배열에 추가하기
                if (time == 1)
                    tomatos.add(new Tomato(i, j, time));
            }
        }

        // 하나씩 탐색
        bfs();

        // 덜 익은 토마토가 있는지 체크하기
        boolean isUnripeTomato = false;
        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) { 		// 덜 익은 토마토가 있는 경우
                    isUnripeTomato = true;
                    break loop; 		// 이중 for문을 빠져나오기
                }
            }
        }


        // tomato가 있는 위치부터 1로 계산되기 때문에 하나 감소 시켜준다.
        System.out.println(isUnripeTomato ? -1 : maxTime - 1);

    }

    private static void bfs() {

        // 익은 토마토가 없어질 때까지 반복
        while (!tomatos.isEmpty()) {

            Tomato tomato = tomatos.poll();
            maxTime = Math.max(maxTime, tomato.time);

            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];

                // 1. 범위를 벗어나지 않고, 2. 익지 않은 토마토가 있으면
                if (isValid(nx, ny) && grid[nx][ny] == 0) {
                    grid[nx][ny] = 1; // 익은 표시 해주고
                    tomatos.add(new Tomato(nx, ny, tomato.time + 1));
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

}