class Solution {
    public int[] solution(int[] array, int[][] command) {
        int[] answer = new int[command.length];
        int[] arrayDup; //= array.clone();

        for (int i = 0; i < command.length; i++) {
            arrayDup = array.clone();
            int[] arrNew = new int[command[i][1] - command[i][0] + 1];
            for (int j = command[i][0]; j <= command[i][1]; j++) {
                arrNew[j - command[i][0]] = array[j - 1];
            }
            arrNew = sort(arrNew);
            answer[i] = arrNew[command[i][2] - 1];
        }
        return answer;
    }
    
    //sort함수 따로만들기
    public static int[] sort(int[] arrNew) {
        int tmp;
        for (int i = arrNew.length - 2; i >= 0; i--) {
            for (int j = i ; j < arrNew.length - 1; j++) {
                if (arrNew[j] > arrNew[j + 1]) {
                    tmp = arrNew[j];
                    arrNew[j] = arrNew[j + 1];
                    arrNew[j + 1] = tmp;
                } else {
                    break;
                }
            }
        }
        return arrNew;
    }
    
}