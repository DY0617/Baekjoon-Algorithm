import java.util.*;
import java.io.*;

public class Main {
    static int t,k;
    static int[] arr,sum;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        t= Integer.parseInt(st.nextToken());
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            arr=new int[k+1];
            sum=new int[k+1];
            dp=new int[k+1][k+1];
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<k;j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
        }
    }
}
