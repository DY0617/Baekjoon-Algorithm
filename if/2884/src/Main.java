import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int H=sc.nextInt();
        int M=sc.nextInt();

        sc.close();

        if(M>=45){
            M=M-45;
        }
        else if(H==0){
            H=23;
            M+=15;
        }
        else{
            H--;
            M+=15;
        }

        System.out.println(H+" "+M);
    }
}
