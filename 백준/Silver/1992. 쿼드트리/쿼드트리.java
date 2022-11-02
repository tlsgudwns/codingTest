import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    //public static int N;
    public static int[][] board;

    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String item = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = item.charAt(j) - '0';
            }
        }

        partition(0, 0, N);

        System.out.println(sb);

    }

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            sb.append(board[row][col]);
            return;
        }

        int newSize = size / 2;

        sb.append('(');

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);

        sb.append(')');
    }

    public static boolean check(int row, int col, int size) {
        int a = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (a != board[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}