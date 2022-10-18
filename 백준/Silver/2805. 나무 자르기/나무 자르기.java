import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long target = sc.nextLong();
        int[] treesHeight = new int[n];

        for (int i = 0; i < n; i++) {
            treesHeight[i] = sc.nextInt();
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, treesHeight[i]);
        }

        int left = 0;
        int right = max;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2; //미드는 자르는 높이
            long total = 0;

            for (int i = 0; i < treesHeight.length; i++) {
                total += Math.max(0, treesHeight[i] - mid);
            }

            if (total < target) {
                right = mid - 1;
            } else {
                if (answer < mid) {
                    answer = mid;
                }
                left = mid + 1;
            }

        }

        System.out.println(answer);

    }
}

