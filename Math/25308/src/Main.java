import java.io.*;
import java.util.*;

public class Main {

    static int[] arr=new int[8];
    static int[] seq=new int[8];
    static boolean[] visit=new boolean[8];
    static int count=0;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0;i<8;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        seq[0]=arr[0];
        visit[0]=true;

        find(1);

        System.out.println(count*8);


    }

    static void find(int depth){
        if(depth==8){
            if(isConvex(0)&&isConvex(1))
                count++;
            return;
        }
        for(int i=1;i<8;i++){
            if(visit[i])continue;
            seq[depth]=arr[i];
            if(depth<2||isConvex(depth)){
                visit[i]=true;
                find(depth+1);
                visit[i]=false;
            }
        }
    }

    static boolean isConvex(int curr) {
        int before = (curr + 8 - 2) % 8;
        int middle = (curr + 8 - 1) % 8;
        int next = curr % 8;
        double line = Math.sqrt(2) * seq[before] * seq[next] / (seq[before] + seq[next]);
        return seq[middle] > line;
    }
}
