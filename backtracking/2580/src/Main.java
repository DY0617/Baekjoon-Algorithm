import java.util.*;

public class Main {

    public static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                arr[i][j] = sc.nextInt();
        sc.close();
        dfs(0,0);

    }

    public static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row+1, 0);
            return;
        }
        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(row, col, i)) {
                    arr[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            arr[row][col]=0;
            return;
            
        }
        dfs(row,col+1);

    }


    public static boolean check(int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == num)
                return false;
        }
        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == num)
                return false;
        }

        int sqr_row = row / 3 * 3;
        int sqr_col = col / 3 * 3;

        for (int i = sqr_row; i < sqr_row + 3; i++)
            for (int j = sqr_col; j < sqr_col + 3; j++)
                if (arr[i][j] == num)
                    return false;

        return true;
    }

}
