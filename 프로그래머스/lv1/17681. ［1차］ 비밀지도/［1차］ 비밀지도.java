import java.util.Arrays;

class Solution {
    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        char[] str = new char[n];
        boolean[][] map = new boolean[n][n];
        int row = 0;
        int col = n-1;
        for (int item : arr1) {
            while (item != 0) {
                if (item % 2 == 1) {
                    map[row][col] = true;
                }
                item /= 2;
                col--;
            }
            col = n-1;
            row++;
        }

        col = n-1;
        row = 0;

        for (int item : arr2) {
            while (item != 0) {
                if (item % 2 == 1) {
                    map[row][col] = true;
                }
                item /= 2;
                col--;
            }
            col = n-1;
            row++;
        }
        int idx = 0;
        int idx2 = 0;
        for (boolean[] a : map) {
            for (boolean s : a) {
                if (s == true) {
                    str[idx] = '#';
                } else {
                    str[idx] = ' ';
                }
                idx++;
            }
            answer[idx2++] = String.valueOf(str);
            idx = 0;
        }


        return answer;
    }
}