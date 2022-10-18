import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int n = Integer.parseInt(s);
        int[] nums = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st2.nextToken());
        }

        StringBuilder sb = new StringBuilder();



        Arrays.sort(nums);

        for (int i = 0; i < targets.length; i++) { //upperbound와 lowerbound 둘다 구하고 빼면 그 카드의 개수일것
            int lo = 0;
            int hi = nums.length;

            while (lo < hi) { //upper
                int mid = (lo + hi) / 2;
                if (targets[i] >= nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int upperbound = lo;

            lo = 0;
            hi = nums.length;

            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (targets[i] > nums[mid]) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int lowerbound = lo;


            sb.append(upperbound - lowerbound).append(' ');
        }

        System.out.println(sb);
        
    }
}