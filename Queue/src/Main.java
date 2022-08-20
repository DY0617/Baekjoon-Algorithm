import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine(), "[],");
            ArrayDeque<Integer> deque = new ArrayDeque<>();

            for (int j = 0; j < N; j++)
                deque.add(Integer.valueOf(st.nextToken()));

            boolean direction = true;
            boolean err=false;

            for (char command : p.toCharArray()) {

                if (command == 'R') {
                    direction = !direction;
                }
                else if(command=='D'){

                    if(direction){
                        if(deque.pollFirst()==null){
                            sb.append("error").append("\n");
                            err=true;
                            break;
                        }
                    }
                    else{
                        if(deque.pollLast()==null){
                            sb.append("error").append("\n");
                            err=true;
                            break;
                        }
                    }

                }

            }//command

            if(!err){
                sb.append("[");

                if(deque.size()>0){

                    if(direction){

                        sb.append(deque.pollFirst());

                        while(!deque.isEmpty()){
                            sb.append(",").append(deque.pollFirst());
                        }

                    }
                    else{
                        sb.append(deque.pollFirst());

                        while(!deque.isEmpty()){
                            sb.append(",").append(deque.pollLast());
                        }
                    }

                }

                sb.append("]\n");
            }

        }//T

        System.out.println(sb);

        br.close();
    }
}
