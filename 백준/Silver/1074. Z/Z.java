import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

    public static int cnt;
    public static int r;
    public static int c;
    public static boolean find;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        r = Integer.valueOf(st.nextToken());
        c = Integer.valueOf(st.nextToken());

        cnt = 0;
        int n = 1;
        for (int i = 0; i < N; i++) {
            n *= 2;
        }

        //board = new int[n][n];

        partition2(0, 0, n);

        System.out.println(cnt);
    }

//    public static void partition(int row, int col, int size) {
//        if (find) {
//            return;
//        }
//
//        if (size == 1) {
//            cnt++;
//            if (row == r && col == c) {
//                find = true;
//            }
//            return;
//        }
//        int newSize = size / 2;
//        partition(row, col, newSize);
//        partition(row, col + newSize, newSize);
//        partition(row + newSize, col , newSize);
//        partition(row + newSize, col + newSize, newSize);
//    }

    public static void partition2(int row, int col, int size) {
        int newSize = size / 2;
        int rowNext = row;
        int colNext = col;
        if (row + size > r && col + size <= c) {
            cnt += size * size;
            colNext = col + size;
        } else if (row + size <= r && col + size > c) {
            cnt += 2 * size * size;
            rowNext = row + size;
        } else if (row + size <= r && col + size <= c) {
            cnt += 3 * size * size;
            colNext = col + size;
            rowNext = row + size;
        }

        if (size == 1) {
            return;
        }

        partition2(rowNext, colNext, newSize);
    }

}
