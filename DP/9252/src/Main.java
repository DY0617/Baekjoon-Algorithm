
import java.io.*;
import java.util.*;

public class Main {

    static char[] str1;
    static char[] str2;

    static int[][] dp;
    static int result;
    static ArrayList<String> arr = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str1 = br.readLine().toCharArray();
        str2 = br.readLine().toCharArray();


        result = LCS(str1.length - 1, str2.length - 1);


        sb.append(result).append("\n");
        getLCSToString(str1, str1.length, str2.length);


        System.out.println(sb);

    }

    static int LCS(int x, int y) {


        int n1 = str1.length;
        int n2 = str2.length;

        dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n1][n2];
    }

    static void getLCSToString(char[] str, int i, int j) {
        Stack<Character> st = new Stack<>();
        while (i > 0 && j > 0) {

            if (i == 0 || j == 0) break;

            if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                st.push(str[i - 1]);
                i--;
                j--;
            }


        }
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }


    }
}
