import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        int x1,x2,x3,x4,y1,y2,y3,y4;
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        x1=Integer.parseInt(st.nextToken());
        y1=Integer.parseInt(st.nextToken());
        x2=Integer.parseInt(st.nextToken());
        y2=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        x3=Integer.parseInt(st.nextToken());
        y3=Integer.parseInt(st.nextToken());
        x4=Integer.parseInt(st.nextToken());
        y4=Integer.parseInt(st.nextToken());

        int answer=0;

        if(ccw(x1,y1,x2,y2,x3,y3)*ccw(x1,y1,x2,y2,x4,y4)<0&&ccw(x3,y3,x4,y4,x1,y1)*ccw(x3,y3,x4,y4,x2,y2)<0)
            answer=1;

        System.out.println(answer);

    }

    static int ccw(long x1,long y1,long x2, long y2, long x3, long y3){
        return x1*y2+x2*y3+x3*y1-y1*x2-y2*x3-y3*x1 > 0 ? 1 : -1;
    }
}
