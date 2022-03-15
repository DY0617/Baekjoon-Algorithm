import java.util.*;

public class baekjoon_1330 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j=sc.nextInt();

        sc.close();

        if(i>j)
            System.out.println(">");
        else if(i<j)
            System.out.println("<");
        else
            System.out.println("==");

    }
}
