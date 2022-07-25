import java.util.*;
import java.io.*;

public class Main {

    static int N1,N2;//N1=추의 개수, N2=구슬의 개수
    static int[] arr1,arr2;
    static int[][] dp;
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer st=new StringTokenizer(br.readLine());
        N1= Integer.parseInt(st.nextToken());
        arr1=new int[N1];

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N1;i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        N2= Integer.parseInt(st.nextToken());
        arr2=new int[N2];

        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N2;i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }

    }
}
