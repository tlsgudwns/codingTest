import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());
        int target = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;
        int sum = arr[0];
        int minLen = Integer.MAX_VALUE;
        while (p2 < arr.length - 1) {
            if (sum < target) {
                p2++;
                sum += arr[p2];
            } else if (sum >= target) {
                minLen = p2 - p1 + 1 < minLen ? p2 - p1 + 1 : minLen;
                sum -= arr[p1++];
            }
        }


       System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
    }
}