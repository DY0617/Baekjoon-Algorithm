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


        int p123 = ccw(x1, y1, x2, y2, x3, y3);
        int p124 = ccw(x1, y1, x2, y2, x4, y4);
        int p341 = ccw(x3, y3, x4, y4, x1, y1);
        int p342 = ccw(x3, y3, x4, y4, x2, y2);
        int s12 = ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4);
        int s34 = ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2);


        if (s12 <= 0 && s34 < 0 || s12 < 0 && s34 <= 0) {

            answer = 1;
            System.out.println(answer);

            double x = (double) ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));
            double y = (double) ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / ((x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4));

            System.out.println(x + " " + y);
        } else if (s12 == 0 && s34 == 0) {
            if (p123 == 0 && p124 == 0 && p341 == 0 && p342 == 0) {
                int n = isCrossed();
                if (n > 0) {
                    answer = 1;
                    System.out.println(answer);
                } else
                    System.out.println(0);

                if (n == 2) {
                    if (x1 == x3 && y1 == y3 || x1 == x4 && y1 == y4)
                        System.out.println(x1 + " " + y1);
                    else if (x2 == x3 && y2 == y3 || x2 == x4 && y2 == y4)
                        System.out.println(x2 + " " + y2);
                }
            }
        } else {
            answer=1;
            System.out.println(answer);
            if (x1 == x3 && y1 == y3 || x1 == x4 && y1 == y4)
                System.out.println(x1 + " " + y1);
            else if (x2 == x3 && y2 == y3 || x2 == x4 && y2 == y4)
                System.out.println(x2 + " " + y2);
        }
        else
            System.out.println(answer);

        br.close();


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

    public static int isCrossed() {
        int A, B, C, D;
        if (x1 == x2) {
            A = (int) Math.min(y1, y2);
            B = (int) Math.max(y1, y2);
            C = (int) Math.min(y3, y4);
            D = (int) Math.max(y3, y4);
        } else {
            A = (int) Math.min(x1, x2);
            B = (int) Math.max(x1, x2);
            C = (int) Math.min(x3, x4);
            D = (int) Math.max(x3, x4);
        }

        if (A == D || B == C)
            return 2;
        else if (A < D && C < B)
            return 1;
        else
            return 0;
    }
}
