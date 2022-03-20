import java.util.*;
public class Main {
    public static int[] arr;
    public static int N;
    public static int K;
    public static int count=0;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        K=sc.nextInt();
        arr=new int[N];
        for(int i=N-1;i>-1;i--){
            arr[i]=sc.nextInt();
        }
        greedy();
        System.out.println(count);

    }

    public static void greedy(){
        for(int i=0;i<N;i++){
            int h=K/arr[i];
            if(h>0) {
                K = K % arr[i];
                count += h;
            }
            if(K==0){
                System.out.println(count);
                System.exit(0);
            }
        }
    }

}
