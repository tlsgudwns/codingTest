import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.valueOf(st.nextToken());
//        int[] arr = new int[n]
        int[] arr = new int[Integer.valueOf(st.nextToken())];
        int target = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;
        int answer = Integer.MAX_VALUE;
        int sum = arr[0];

        while (p2 < arr.length) {
            if (sum >= target) {
                answer = p2 - p1 + 1 < answer ? p2 - p1 + 1 : answer;
                sum = sum - arr[p1++];
            } else {
                if (p2 == arr.length - 1) {
                    break;
                }
                p2++;
                sum = sum + arr[p2]; //p2가 가리키고있는 직전까지가 sum의 범위
            }
        }

//        while (sum >= target) {
//            answer = p2 - p1 < answer ? p2 - p1 : answer;
//            sum = sum - arr[p1++];
//        }

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        System.out.println(answer);
    }
}