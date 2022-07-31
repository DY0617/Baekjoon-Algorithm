import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        arr=new int[M];
        st=new StringTokenizer(br.readLine());
        int sum=0;
        for(int i=0;i<N;i++){
            sum+=Integer.parseInt(st.nextToken())%M;
            arr[sum%M]++;
        }

        long ans=arr[0];
        for(int i=0;i<M;i++){
            int n=arr[i];
            ans+=(long)n*(n-1)/2;
        }


        System.out.println(ans);
        br.close();
    }
}
