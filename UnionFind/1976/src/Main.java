import java.util.*;
import java.io.*;

public class Main {

    static int[] parent;
    static int[] path;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        parent=new int[n+1];

        path=new int[m];

        for(int i=1;i<=n;i++)
            parent[i]=i;

        StringTokenizer st;

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int a=Integer.parseInt(st.nextToken());
                if(a==1){
                    int x=find(i+1);
                    int y=find(j+1);
                    if(x!=y){
                        if(x<y)
                            parent[y]=x;
                        else
                            parent[x]=y;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        for(int i=0;i<m;i++){
            path[i]=Integer.parseInt(st.nextToken());
        }

        boolean ans=answer();

        if(!ans)
            bw.write("NO");
        else
            bw.write("YES");

        br.close();
        bw.flush();
        bw.close();

    }

    public static int find(int x){
        if(parent[x]==x)
            return x;
        return parent[x]=find(parent[x]);
    }

    public static boolean answer(){
        for(int i=0;i<path.length-1;i++){
            int x=find(path[i]);
            int y=find(path[i+1]);
            if(x!=y)
                return false;
        }
        return true;
    }
}
