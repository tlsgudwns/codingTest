import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static int minus;
    public static int zero;
    public static int plus;
    public static int[][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        paper = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        partition(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }

    public static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (paper[row][col] == 1) {
                plus++;
            } else if (paper[row][col] == 0) {
                zero++;
            } else {
                minus++;
            }
            return;
        }

        int newSize = size / 3;
        partition(row, col, newSize);
        partition(row + newSize, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize * 2, col, newSize);
        partition(row, col + newSize * 2, newSize);
        partition(row + newSize, col + newSize * 2, newSize);
        partition(row + newSize * 2, col + newSize, newSize);
        partition(row + newSize * 2, col + newSize * 2, newSize);
    }

    public static boolean check(int row, int col, int size) {
        int num = paper[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (num != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    
}