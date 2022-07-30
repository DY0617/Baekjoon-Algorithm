import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        arr=new int[N];

        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            arr[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=2;i<arr[N-1];i++){
            int a=arr[0]%i;
            boolean flag=true;

            for(int j=1;j<N;j++){
                if(a!=arr[j]%i) {
                    flag=false;
                    break;
                }
            }

            if(flag)
                sb.append(a+" ");

        }

        System.out.println(sb.toString());
        br.close();
    }
}
