import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        void insert(int n) {
            if (n < this.num) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    static void postOrder(Node node) {
        if (node == null)
            return;


        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        Node node = new Node(Integer.parseInt(br.readLine()));

        String str;
        while (true) {
            str = br.readLine();
            if ( str == null || str.equals("") ) {
                break;
            }
            node.insert(Integer.parseInt(str));
        }

        postOrder(node);

        br.close();

    }
}
