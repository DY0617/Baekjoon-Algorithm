import java.util.*;

public class Main {
    public static ArrayList<Integer> primeNumbers = new ArrayList<>();
    public static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        sc.close();
        prime(N);
        int count = 0;
        int end = 0;
        int sum = 0;
        for (int start = 0; start < primeNumbers.size(); start++) {
            while (end < primeNumbers.size() && sum < N) {
                sum+=primeNumbers.get(end);
                end++;
            }
            if(sum==N)
                count++;
            sum-=primeNumbers.get(start);
        }
        System.out.println(count);
    }

    public static void prime(int k) {
        boolean[] isNotPrime = new boolean[k + 1];

        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i * i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= N; j += i)
                    isNotPrime[j] = true;
            }
        }

        for (int i = 2; i < isNotPrime.length; i++) {
            if (!isNotPrime[i]) {
                primeNumbers.add(i);
            }
        }
    }
}
