import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int[] lis,lds;
    static int[] arr;
    static int max=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        arr=new int[N];
        lis=new int[N];
        lds=new int[N];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            arr[i]= Integer.parseInt(st.nextToken());
        }
        br.close();

        lis();

        lds();

        for(int i=0;i<N;i++){
            max= Math.max(lis[i]+lds[i]-1,max);
        }

        StringBuilder sb=new StringBuilder();
        sb.append(max);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void lis(){
        for(int i=0;i<N;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j]){
                    lis[i]=Math.max(lis[i],lis[j]+1);
                }
            }
        }
    }

    static void lds(){
        for(int i=N-1;i>=0;i--){
            lds[i]=1;
            for(int j=N-1;j>i;j--){
                if(arr[i]>arr[j]){
                    lds[i]=Math.max(lds[i],lds[j]+1);
                }
            }
        }
    }

}
