import java.util.*;
public class Main {

    public static int[] arr;
    public static int max=-1000000000;
    public static int min=1000000000;
    public static int[] operation= new int[4];
    public static int opNum;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        StringBuilder sb=new StringBuilder();
        int N=sc.nextInt();
        arr= new int[N];
        opNum=N-1;
        for(int i=0;i<N;i++)
            arr[i]=sc.nextInt();
        for(int i=0;i<4;i++)
            operation[i] = sc.nextInt();
        sc.close();
        dfs(0,0,0,0,arr[0]);
        sb.append(max).append("\n").append(min);
        System.out.println(sb);

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
            if(plus<operation[0]){
                dfs(plus+1,minus,mul,div,num+arr[i+1]);
            }
            if(minus<operation[1]){
                dfs(plus,minus+1,mul,div,num-arr[i+1]);
            }
            if(mul<operation[2]){
                dfs(plus,minus,mul+1,div,num*arr[i+1]);
            }
            if(plus<operation[3]){
                dfs(plus,minus,mul,div+1,num/arr[i+1]);
            }
        }
    }

}
