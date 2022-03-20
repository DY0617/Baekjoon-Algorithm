import java.util.*;
public class Main {


    public static void main(String[] args) {
        int[][] arr;
        int N;
        int count=0;
        int finish=0;
        Scanner sc=new Scanner(System.in);
        N=sc.nextInt();
        arr=new int[N][2];


        for(int i=0;i<N;i++){
            arr[i][0]=sc.nextInt();
            arr[i][1]=sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {

                // 종료시간이 같을 경우 시작시간이 빠른순으로 정렬해야한다.
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }

        });

        for(int i=0;i<N;i++){
            if(finish<=arr[i][0]){
                finish=arr[i][1];
                count++;
            }
        }

        System.out.println(count);

    }


}
