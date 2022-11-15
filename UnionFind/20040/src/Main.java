import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        parent=new int[n+1];
        for(int i=1;i<=n;i++)
            parent[i]=i;
        int m=Integer.parseInt(st.nextToken());
        int count=0;
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int x=find(1+Integer.parseInt(st.nextToken()));
            int y=find(1+Integer.parseInt(st.nextToken()));
            if(x!=y){
                if(x<y)
                    parent[y]=x;
                else
                    parent[x]=y;
            }
            else{
                count=i+1;
                break;
            }
        }


        bw.write(String.valueOf(count));
        br.close();
        bw.flush();
        bw.close();

    }

    static int find(int x){
        if(parent[x]==x)
            return x;
        return parent[x]=find(parent[x]);
    }
}
