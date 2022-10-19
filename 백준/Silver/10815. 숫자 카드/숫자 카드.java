import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 카드 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] targets = new int[m]; //찾으려는 카드배열


        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st2.nextToken());
        }




        for (int i = 0; i < targets.length; i++) {
            if (binarySearch(cards, targets[i])) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            }
        }
//        for (int i = 0; i < m; i++) {
//            int num = Integer.parseInt(st2.nextToken());
//            if (binarySearch(cards, num)) {
//                sb.append(1).append(" ");
//            } else {
//                sb.append(0).append(" ");
//            }
//        }


        System.out.println(sb);


    }

    public static boolean binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (target > arr[mid]) {
                left = mid + 1;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}