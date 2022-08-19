import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        Stack<Integer> stack=new Stack<>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N= Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){
            stack.push(Integer.parseInt(st.nextToken()));
        }

    }
}
