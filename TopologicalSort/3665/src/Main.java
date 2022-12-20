import java.util.*;
import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;

        int apoch= Integer.parseInt(br.readLine());

        for(int a=0;a<apoch;a++){
            int n= Integer.parseInt(br.readLine());
            int[] indegree=new int[n+1];
            int[] arr=new int[n+1];

            st=new StringTokenizer(br.readLine());

            for(int i=1;i<=n;i++)
                arr[i]= Integer.parseInt(st.nextToken());

            ArrayList<Integer>[] list = new ArrayList[n+1];
            for(int i=1;i<=n;i++)
                list[i] = new ArrayList<>();

            for(int i=1;i<=n;i++) {
                int from = arr[i];
                for(int j=i+1;j<=n;j++) {
                    list[from].add(arr[j]);
                    indegree[arr[j]]++;
                }
            }


            int m=Integer.parseInt(br.readLine());

            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine());

                int start=Integer.parseInt(st.nextToken());
                int end=Integer.parseInt(st.nextToken());


                if(list[start].contains(end)){
                    list[start].remove((Integer) end);
                    list[end].add(start);
                    indegree[start]++;
                    indegree[end]--;
                }
                else{
                    list[end].remove((Integer) start);
                    list[start].add(end);
                    indegree[start]--;
                    indegree[end]++;
                }

            }

            sb=new StringBuilder();

            Queue<Integer> q=new LinkedList<>();

            int count=0;

            for(int i=1;i<=n;i++){
                if(indegree[i]==0){
                    count++;
                    q.add(i);
                }
            }


            if(count>1){
                System.out.println("?");
                continue;
            }



            boolean isTrue=false;

            for(int i=1;i<=n;i++){
                if(q.isEmpty()){
                    System.out.println("IMPOSSIBLE");
                    isTrue=true;
                    break;
                }

                int next=q.poll();
                sb.append(next+" ");
                for(int j=0;j<list[next].size();j++){
                    int num=list[next].get(j);
                    indegree[num]--;
                    if(indegree[num]==0)
                        q.add(num);
                }
            }

            if(isTrue)
                continue;

            System.out.println(sb.toString());

        }

        br.close();

    }
}
