import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());
        double r1 = Double.parseDouble(st.nextToken());
        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());
        double r2 = Double.parseDouble(st.nextToken());

        double dist=Math.sqrt(Math.pow(x1-x2,2)+Math.pow(y1-y2,2));
        double answer;

        if(r1+r2<=dist)
            answer=0;
        else if(Math.abs(r1-r2)>=dist){
            answer = Math.PI * Math.pow(Math.min(r1, r2), 2);
        }
        else{
            double theta1 = Math.acos((r1 * r1 + dist * dist - r2 * r2) / (2 * r1 * dist));
            double theta2 = Math.acos((r2 * r2 + dist * dist - r1 * r1) / (2 * r2 * dist));

            double S1 = (r1 * r1 * theta1) - (r1 * r1 * Math.sin(2 * theta1) / 2);
            double S2 = (r2 * r2 * theta2) - (r2 * r2 * Math.sin(2 * theta2) / 2);
            answer = S1 + S2;
        }

        bw.write(String.format("%.3f",answer));
        bw.flush();
        bw.close();
        br.close();
    }
}
