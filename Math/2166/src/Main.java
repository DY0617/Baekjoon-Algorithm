import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        long[][] arr=new long[n+1][2];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            arr[i][0]=Long.parseLong(st.nextToken());
            arr[i][1]=Long.parseLong(st.nextToken());
        }

        arr[n]=arr[0].clone();

        long n1=0L;
        long n2=0L;

        for(int i=0;i<n;i++){
            n1+=arr[i][0]*arr[i+1][1];
            n2+=arr[i+1][0]*arr[i][1];
        }

        System.out.println(String.format("%.1f",Math.abs(n1-n2)/2D));

        br.close();
    }
}
