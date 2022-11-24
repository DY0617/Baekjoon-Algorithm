import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static ArrayList<Integer> xlist, ylist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());


        parent = new int[n + 1];

        for (int i = 1; i <= n; i++)
            parent[i] = i;

        xlist = new ArrayList<>();
        ylist = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xlist.add(Integer.parseInt(st.nextToken()));
            ylist.add(Integer.parseInt(st.nextToken()));
            xlist.add(Integer.parseInt(st.nextToken()));
            ylist.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (ccw(xlist.get(i * 2), ylist.get(i * 2),
                        xlist.get(i * 2 + 1), ylist.get(i * 2 + 1),
                        xlist.get(j * 2), ylist.get(j * 2)) *
                        ccw(xlist.get(i * 2), ylist.get(i * 2),
                                xlist.get(i * 2 + 1), ylist.get(i * 2 + 1),
                                xlist.get(j * 2 + 1), ylist.get(j * 2 + 1)) == 0 &&
                        ccw(xlist.get(j * 2), ylist.get(j * 2),
                                xlist.get(j * 2 + 1), ylist.get(j * 2 + 1),
                                xlist.get(i * 2), ylist.get(i * 2)) *
                                ccw(xlist.get(j * 2), ylist.get(j * 2),
                                        xlist.get(j * 2 + 1), ylist.get(j * 2 + 1),
                                        xlist.get(i * 2 + 1), ylist.get(i * 2 + 1)) == 0) {
                    if (Math.min(xlist.get(i * 2), xlist.get(i * 2 + 1)) <= Math.max(xlist.get(j * 2), xlist.get(j * 2 + 1)) &&
                            Math.min(xlist.get(j * 2), xlist.get(j * 2 + 1)) <= Math.max(xlist.get(i * 2), xlist.get(i * 2 + 1)) &&
                            Math.min(ylist.get(i * 2), ylist.get(i * 2 + 1)) <= Math.max(ylist.get(j * 2), ylist.get(j * 2 + 1)) &&
                            Math.min(ylist.get(j * 2), ylist.get(j * 2 + 1)) <= Math.max(ylist.get(i * 2), ylist.get(i * 2 + 1))) {
                    }


                    int x = find(i + 1);
                    int y = find(j + 1);

                    if (x != y) {

                        if (x < y)
                            parent[y] = x;
                        else
                            parent[x] = y;

                    }


                } else if (ccw(xlist.get(i * 2), ylist.get(i * 2), xlist.get(i * 2 + 1), ylist.get(i * 2 + 1), xlist.get(j * 2), ylist.get(j * 2)) *
                        ccw(xlist.get(i * 2), ylist.get(i * 2), xlist.get(i * 2 + 1), ylist.get(i * 2 + 1), xlist.get(j * 2 + 1), ylist.get(j * 2 + 1)) <= 0 &&
                        ccw(xlist.get(j * 2), ylist.get(j * 2), xlist.get(j * 2 + 1), ylist.get(j * 2 + 1), xlist.get(i * 2), ylist.get(i * 2)) *
                                ccw(xlist.get(j * 2), ylist.get(j * 2), xlist.get(j * 2 + 1), ylist.get(j * 2 + 1), xlist.get(i * 2 + 1), ylist.get(i * 2 + 1)) <= 0) {
                    int x = find(i + 1);
                    int y = find(j + 1);


                    if (x != y) {
                        if (x < y)
                            parent[y] = x;
                        else
                            parent[x] = y;

                    }
                }

            }

        }


        for (int i = 1; i <= n; i++) {
            parent[i] = find(parent[i]);
        }


        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[parent[i]]++;
        }

        int count = 0;
        int max = 0;

        for (int i = 0; i <= n; i++) {
            if (dp[i] > 0) {
                count++;
                max = Math.max(max, dp[i]);
            }
        }

        System.out.println(count + "\n" + max);

        br.close();


    }

    static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long num = x1 * y2 + x2 * y3 + x3 * y1 - x2 * y1 - x3 * y2 - x1 * y3;

        if (num > 0)
            return 1;
        else if (num == 0)
            return 0;
        else
            return -1;
    }

    static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }
}
