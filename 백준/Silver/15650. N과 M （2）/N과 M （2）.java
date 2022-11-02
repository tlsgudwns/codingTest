import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int m;
    public static int n;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        
        arr = new int[m];
        
        
        //백트래킹
        //남은 넣어야할 자리(m - depth) 보다 넣을수있는 수들의 개수 n - 가 작을때 바로 리턴
        backTracking(0, 0);
        System.out.println(sb);
    }

    public static void backTracking(int depth, int start) {
        if (depth == m) { //수열을 다뽑았을경우
            for (int item : arr) {
                sb.append(item).append(' ');
            }
            sb.append('\n');
            return;
        }

        if (m - depth > n - start) {
            return;
        }

        for (int i = start; i < n; i++) {
            arr[depth] = i + 1;
            backTracking(depth + 1, i + 1);
        }
        
    }
}