import java.util.ArrayList;
import java.util.Scanner;

class Main {
    static boolean prime[];
    static ArrayList<Integer> prime_numbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        prime = new boolean[n + 1];

        prime[0] = true;
        prime[1] = true;

        if (n == 1) {
            System.out.println(0);
            return;
        } else if (n == 2) {
            System.out.println(1);
            return;
        } else if (n == 3) {
            System.out.println(1);
            return;
        }

        for (int i = 2; i * i <= n; i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = true;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (!prime[i]) {
                prime_numbers.add(i);
            }
        }

        int p1 = 0;
        int p2 = 0;
        int sum = prime_numbers.get(0);
        int cnt = 0;


        while (true) {
            if (sum > n) {
                sum -= prime_numbers.get(p1++);
            } else if (sum < n) {
                p2++;
                if (p2 == prime_numbers.size()) {
                    break;
                }
                sum += prime_numbers.get(p2);
            } else {
                cnt++;

                sum -= prime_numbers.get(p1++);
                p2++;
                if (p2 == prime_numbers.size()) {
                    break;
                }
                sum += prime_numbers.get(p2);
            }
        }

        System.out.println(cnt);
    }
}