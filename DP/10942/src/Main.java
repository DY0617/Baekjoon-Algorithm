import java.util.*;
import java.io.*;

public class Main {

    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static int N,M;
    static int[] arr;
    static int[][] quest,dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        arr=new int[N+1];
        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        M=Integer.parseInt(st.nextToken());
        quest=new int[M][2];
        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            quest[i][0]=Integer.parseInt(st.nextToken());
            quest[i][1]=Integer.parseInt(st.nextToken());
        }

        
    }
}
