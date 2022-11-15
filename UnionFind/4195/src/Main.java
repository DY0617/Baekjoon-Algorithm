import java.util.*;
import java.io.*;

public class Main {

    static int[] parent,level;
    static int n,f;
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        n= Integer.parseInt(br.readLine());

        for(int q=0;q<n;q++){
            f=Integer.parseInt(br.readLine());

            parent=new int[f*2];
            level=new int[f*2];
            for (int i = 0; i < f * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            int count=0;
            HashMap<String,Integer> map=new HashMap<>();


            for (int i = 0; i < f; i++) {
                st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if (!map.containsKey(a)) {
                    map.put(a, count++);
                }

                if (!map.containsKey(b)) {
                    map.put(b, count++);
                }

                sb.append(union(map.get(a), map.get(b)) + "\n");
            }



        }
        System.out.println(sb);
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);

        // 항상 x < y인 값이 들어온다고 가정
        if (x != y) {
            parent[y] = x;
            level[x] += level[y]; // y에 있던 층의 개수를 더해 줌.

        }

        return level[x];
    }
}
