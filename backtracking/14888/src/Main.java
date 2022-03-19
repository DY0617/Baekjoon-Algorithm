import java.util.*;
public class Main {

    public static int[] arr;
    public static int max=0;
    public static int min=0;
    public static int[] operation= new int[4];
    public static int opNum;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt();
        arr= new int[N];
        opNum=N-1;
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        for(int i=0;i<4;i++)
            operation[i] = sc.nextInt();
        sc.close();
        dfs(0,0,0,0,0);

    }

    public static void dfs(int plus,int minus, int mul, int div,int num){
        if(opNum==(plus+minus+mul+div)){
            if(num>max)
                max=num;
            if(num<min)
                min=num;
            return;
        }

        for(int i=0;i<opNum;i++){
            
        }
    }

}
