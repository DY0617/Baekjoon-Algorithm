import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[] house;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        house=new int[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            house[i]=Integer.parseInt(st.nextToken());
        }

        Arrays.sort(house);
    }
}
