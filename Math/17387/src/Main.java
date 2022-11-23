import java.io.*;
import java.util.*;

public class Main {

    static long x1, x2, x3, x4, y1, y2, y3, y4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x1 = Long.parseLong(st.nextToken());
        y1 = Long.parseLong(st.nextToken());
        x2 = Long.parseLong(st.nextToken());
        y2 = Long.parseLong(st.nextToken());
        st = new StringTokenizer(br.readLine());
        x3 = Long.parseLong(st.nextToken());
        y3 = Long.parseLong(st.nextToken());
        x4 = Long.parseLong(st.nextToken());
        y4 = Long.parseLong(st.nextToken());


        int answer = 0;


        if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) == 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) == 0) {
            if (Math.min(x1, x2) <= Math.max(x3, x4) &&
                    Math.min(x3, x4) <= Math.max(x1, x2) &&
                    Math.min(y3, y4) <= Math.max(y1, y2) &&
                    Math.min(y1, y2) <= Math.max(y3, y4)) {
                answer = 1;
            }
        }
        else if (ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) <= 0 && ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) <= 0) {
                answer = 1;
        }

        System.out.println(answer);
    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long a = x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3;
        if (a > 0)
            return 1;
        else if (a == 0)
            return 0;
        else
            return -1;
    }
}
