import java.util.*;

public class Main {

    public static StringBuilder sb=new StringBuilder();

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i= sc.nextInt();
        sc.close();
        int k= (int) (Math.pow(2,i)-1);
        sb.append(k);
        sb.append('\n');
        hanoi(1,2,3,i);
        System.out.println(sb);
    }

    public static void hanoi(int a, int b, int c, int num){
        if(num==0)
            return;
        hanoi(a,c,b,num-1);
        sb.append(a+" "+c+'\n');
        hanoi(b,a,c,num-1);
    }
}
