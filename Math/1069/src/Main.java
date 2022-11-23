import java.util.*;
import java.io.*;

public class Main {

    static int x,y,d,t;
    static double distance;
    static double a,b,c;

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        x=Integer.parseInt(st.nextToken());
        y=Integer.parseInt(st.nextToken());
        d=Integer.parseInt(st.nextToken());
        t=Integer.parseInt(st.nextToken());

        distance=Math.sqrt(Math.pow(x,2)+Math.pow(y,2));

        a=distance;

        if(distance>=d){
            int epoch=(int)distance/d;
            b=(t*epoch)+(distance-(d*epoch));
            c=t*(epoch+1);
        }
        else{
            b=t+(d-distance);
            c=t*2;
        }

        System.out.println(Math.min(a,Math.min(b,c)));

    }
}
