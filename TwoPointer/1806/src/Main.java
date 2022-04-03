import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        int N=Integer.parseInt(st.nextToken());
        int S=Integer.parseInt(st.nextToken());
        int[] arr=new int[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        int start;
        int end=0;
        int len=N+1;
        int sum=0;
        for(start=0;start<N;start++){
            while(end<N&&sum<S){
                sum+=arr[end];
                end++;
            }
            if(sum>=S&&len>(end-start)){
                len=end-start;
            }
            sum=sum-arr[start];
        }
        StringBuilder sb=new StringBuilder();
        if(len==N+1)
            len=0;
        sb.append(len);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
