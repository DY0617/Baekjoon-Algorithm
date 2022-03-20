import java.util.*;

public class Main {
    public static int[][] arr;
    public static int N;
    public static int min=Integer.MAX_VALUE;
    public static boolean visit[];
    public static int[] start;
    public static int[] link;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        arr=new int[N][N];
        visit=new boolean[N];
        start=new int[N];
        link=new int[N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        sc.close();
        chooseMin(0,0);

        System.out.println(min);
    }

    public static void chooseMin(int index,int count){
        if(count==N/2){
            int snum=0;
            int lnum=0;
            for(int i=0;i<N;i++){
                if(visit[i]){
                    start[snum]=i;
                    snum++;
                }
                else{
                    link[lnum]=i;
                    lnum++;
                }
            }
            snum=0;
            lnum=0;

            for(int i=0;i<N/2;i++){
                for(int j=0;j<N/2;j++){
                    if(i!=j){
                        snum+=arr[start[i]][start[j]];
                    }
                }
            }
            for(int i=0;i<N/2;i++){
                for(int j=0;j<N/2;j++){
                    if(i!=j){
                        lnum+=arr[link[i]][link[j]];
                    }
                }
            }
            int num= Math.abs(snum-lnum);
            min=Math.min(min,num);
            if(num==0) {
                System.out.println(0);
                System.exit(0);
            }
            return;
        }

        for(int i=index;i<N;i++){
            if(!visit[i]){
                visit[i]=true;
                chooseMin(i+1,count+1);
                visit[i]=false;
            }
        }

        return;
    }

}
