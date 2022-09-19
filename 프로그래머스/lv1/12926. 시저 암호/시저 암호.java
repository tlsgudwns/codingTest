class Solution {
    public String solution(String s, int n) {
        String answer = "";
            char[] arr = s.toCharArray();
            int rotate = ('Z' + 1) - 'A';

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 'A' && arr[i] <= 'Z') {
                    arr[i] =(char)(((arr[i]+n)>'Z') ? arr[i]+n-rotate : arr[i]+n);
                } else if (arr[i] >= 'a' && arr[i] <= 'z') {
                    arr[i] = (char)(((arr[i]+n)>'z') ? arr[i]+n-rotate : arr[i]+n);
                }
            }

            for (int i = 0; i < arr.length; i++) {
                answer += arr[i];
            }

            return answer;
    }
}