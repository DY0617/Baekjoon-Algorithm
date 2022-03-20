import java.util.*;

public class Main {
    public static int[] arr;
    public static int max = 0;
    public static int N;
    public static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        sc.close();
        chooseMax();
        System.out.println(max);
    }

    public static void chooseMax() {

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    int num = arr[i] + arr[j] + arr[k];
                    if (num <= M)
                        max = Math.max(max, num);
                }
            }
        }
    }


}
