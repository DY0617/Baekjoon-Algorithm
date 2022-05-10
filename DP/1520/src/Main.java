import java.util.*;
import java.io.*;

public class Main {
    static int m, n;
    static int[][] visit, arr, dp;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        visit = new int[m][n];
        arr = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        arrive(0, 0);

        System.out.println(count);

    }

    static void arrive(int row, int col) {

        visit[row][col] = 1;

        if (row == m - 1 && col == n - 1) {
            count++;
        } else {
            if (row > 0) {
                if (visit[row - 1][col] == 0) {
                    if (arr[row - 1][col] < arr[row][col]) {
                        arrive(row - 1, col);
                    }
                }
            }
            if (row < m - 1) {
                if (visit[row + 1][col] == 0) {
                    if (arr[row + 1][col] < arr[row][col]) {
                        arrive(row + 1, col);
                    }
                }
            }
            if (col > 0) {
                if (visit[row][col - 1] == 0) {
                    if (arr[row][col - 1] < arr[row][col]) {
                        arrive(row, col - 1);
                    }
                }
            }
            if (col < n - 1) {
                if (visit[row][col + 1] == 0) {
                    if (arr[row][col + 1] < arr[row][col]) {
                        arrive(row, col + 1);
                    }
                }
            }

        }

        visit[row][col] = 0;
    }
}
