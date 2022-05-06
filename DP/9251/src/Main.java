import java.util.*;
import java.io.*;

public class Main {
    static String a, b;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = st.nextToken();
        st = new StringTokenizer(br.readLine());
        b = st.nextToken();
        br.close();

        char[] str1 = new char[a.length()];
        char[] str2 = new char[b.length()];
        for (int i = 0; i < str1.length; i++) {
            str1[i] = a.charAt(i);
        }
        for (int i = 0; i < str2.length; i++) {
            str2[i] = b.charAt(i);
        }

        arr = new int[str1.length+1][str2.length+1];


        for (int j = 1; j <= str1.length; j++) {
            for (int k = 1; k <= str2.length; k++) {
                if (str1[j-1] == str2[k-1]) {
                    arr[j][k]=arr[j-1][k-1]+1;
                }
                else{
                    arr[j][k]=Math.max(arr[j-1][k],arr[j][k-1]);
                }
            }
        }



        System.out.println(arr[str1.length][str2.length]);
        br.close();

    }
}
