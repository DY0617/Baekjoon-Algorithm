import java.util.*;

public class Main {

    public static int[] arr;
    public static int max=Integer.MIN_VALUE;
    public static int min=Integer.MAX_VALUE;
    public static int[] operation = new int[4];
    public static int opNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        arr = new int[N];
        opNum = N - 1;
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < 4; i++)
            operation[i] = sc.nextInt();
        sc.close();
        dfs(0, arr[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);

    }

    public static void dfs(int index, int num) {
        if (opNum == index) {
            max=Math.max(num,max);
            min=Math.min(num,min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if(operation[i]>0){
                operation[i]--;
                if (i == 0)
                    dfs(index+1,num+arr[index+1]);
                if (i == 1)
                    dfs(index+1,num-arr[index+1]);
                if (i == 2)
                    dfs(index+1,num*arr[index+1]);
                if (i == 3)
                    dfs(index+1,num/arr[index+1]);
                operation[i]++;
            }

        }
    }

}
