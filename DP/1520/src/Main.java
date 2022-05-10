import java.util.*;
import java.io.*;

public class Main {
    static int m,n;
    static int[][] visit,arr,dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        m=Integer.parseInt(st.nextToken());
        n=Integer.parseInt(st.nextToken());
        visit=new int[m][n];
        arr=new int[m][n];
        dp=new int[m][n];

    }
}
