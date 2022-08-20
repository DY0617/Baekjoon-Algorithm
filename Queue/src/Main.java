import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int T= Integer.parseInt(st.nextToken());

        for(int i=0;i<T;i++){
            st=new StringTokenizer(br.readLine());
            String p=st.nextToken();
            st=new StringTokenizer(br.readLine());
            int N= Integer.parseInt(st.nextToken());
            st=new StringTokenizer(br.readLine(),"[],");
            ArrayDeque<Integer> deque=new ArrayDeque<>();

            for(int j=0;j<N;j++)
                deque.add(Integer.valueOf(st.nextToken()));

            
        }
    }
}
