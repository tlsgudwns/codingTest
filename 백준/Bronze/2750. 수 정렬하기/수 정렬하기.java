import java.util.Scanner;

class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int tmp;
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
       
        for (int i = n-2; i>=0 ; i--) {
            for (int j = i; j<=n-2; j++) {
                if (arr[j] > arr[j+1]) {
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                } else { break; }
            }
        }
        
        for (int i = 0; i < arr.length ; i++) {
            System.out.println(arr[i]);
        }
        
        
    }
}