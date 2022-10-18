import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
//        int n = 5;
//        int[] nums = {4, 1, 5, 2, 3};
       Arrays.sort(nums);
//        int m = 5;
//        int[] targets = {1, 3, 7, 9, 5};

        int m = sc.nextInt();
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }

        for (int i = 0; i < targets.length; i++) {
            int left = 0;
            int right = nums.length - 1;
            boolean isExist = false;

            if (nums[0] > targets[i] || nums[nums.length - 1] < targets[i]) {
                System.out.println(0);
                continue;
            }

            while (left <= right) {
                int mid = (left + right) / 2;

                if (targets[i] > nums[mid]) {
                    left = mid + 1;
                } else if (targets[i] < nums[mid]) {
                    right = mid - 1;
                } else {
                    System.out.println(1);
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                System.out.println(0);
            }
        }
    }
}