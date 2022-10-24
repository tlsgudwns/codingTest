import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] cArr = s.toCharArray();
        String answer = "";
        Arrays.sort(cArr);
        int sum = 0;
        if (cArr[0] != '0') {
            answer = "-1";
        } else {
            for (int i = 0; i < cArr.length; i++) {
                sum += Integer.valueOf(cArr[i]);
            }

            if (sum % 3 != 0) {
                answer = "-1";
            } else {
                char[] cArrReverse = new char[cArr.length];
                for (int i = 0; i < cArr.length; i++) {
                    cArrReverse[i] = cArr[cArr.length - 1 - i];
                }
                answer = String.valueOf(cArrReverse);
            }
        }
        System.out.println(answer);
    }
}