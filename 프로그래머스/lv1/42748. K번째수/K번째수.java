import java.util.Arrays;

class Solution {
   public int[] solution(int[] array, int[][] command) {
        int[] answer = new int[command.length];

        for (int i = 0; i < command.length; i++) {
            int b = command[i][1];
            int a = command[i][0];
            int[] arr = new int[b - a + 1];

            for (int j = a; j <= b; j++) {
                arr[j - a] = array[j - 1];
            }

            Arrays.sort(arr);
            answer[i] = arr[command[i][2] - 1];
            
        }

        return answer;
    }
    
}