import java.util.*;
import java.io.*;

public class Main {
    public static int N;
    public static int C;
    public static int idx=0;
    public static int cnt=0;
    public static int[] arr;
    public static ArrayList<Integer> aSum,bSum;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        C=Integer.parseInt(st.nextToken());
        arr=new int[N];
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        aSum=new ArrayList<>();
        bSum=new ArrayList<>();

        findA(0, 0);
        findB(N / 2, 0);

        Collections.sort(bSum);
        for (int i = 0; i < aSum.size(); i++) {
            System.out.println(aSum.get(i));
        }
        System.out.println("---------------");
        for (int i = 0; i < bSum.size(); i++) {
            System.out.println(bSum.get(i));
        }

        for (int i = 0; i < aSum.size(); i++) {
            idx = -1;
            System.out.println("i= "+i);
            binarySearch(0, bSum.size() - 1, aSum.get(i));
            System.out.println("idx = "+idx+"\n");
            cnt += idx + 1;
        }
        System.out.println(cnt);

    }

    static void findA(int k, int sum) {
        if (sum > C)
            return;
        if (k == N / 2) {
            aSum.add(sum);
            return;
        }
        findA(k + 1, sum);
        findA(k + 1, sum + arr[k]);
    }

    static void findB(int k, int sum) {
        if (sum > C)
            return;
        if (k == N) {
            bSum.add(sum);
            return;
        }
        findB(k + 1, sum);
        findB(k + 1, sum + arr[k]);
    }

    static void binarySearch(int l, int r, int value) {
        while (l <= r) {
            int mid = (l + r) / 2;
            System.out.println(l+" "+mid+" "+r);
            if (bSum.get(mid) + value <= C) {
                idx = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
            System.out.println(l+" "+mid+" "+r+" "+idx);
            System.out.println("-----------------");
        }
    }

}
