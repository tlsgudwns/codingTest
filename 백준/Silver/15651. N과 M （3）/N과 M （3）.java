import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int n;
    public static int m;
    public static StringBuilder sb = new StringBuilder(); 
    public static int[] arr;
        
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        arr = new int[m];
        
        backTracking(0);
        System.out.println(sb);

    }


    public static void backTracking(int depth) {
        if (depth == m) {
            for (int item : arr) {
                sb.append(item).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[depth] = i + 1;
            backTracking(depth + 1);
        }
    }
}