import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

    public static int N;
    public static int cnt;
    public static int[] board;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.valueOf(br.readLine());
        cnt = 0;
        board = new int[N];

        backTracking(0);

        System.out.println(cnt);


    }

    public static void backTracking(int depth) {
        if (depth == N) {
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            board[depth] = i;
            if (isPromising(depth)) {
                backTracking(depth + 1);
            }
        }
    }
    public static boolean isPromising(int depth) {
        for (int i = 0; i < depth; i++) {
            if (board[depth] == board[i] || depth - i == Math.abs(board[depth] - board[i])) {
                return false;
            }
        }
        return true;
    }
}
