package array;

import java.util.ArrayList;
import java.util.Scanner;

public class LargeNumberPrinter {
    
    /*
        # 큰 수 출력하기

        - 설명
        N개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.(첫 번째 수는 무조건 출력한다)

        - 입력
        첫 줄에 자연수 N이 주어지고, 그 다음 줄에 N개의 정수가 입력된다.

        - 출력
        자신의 바로 앞 수보다 큰 수만 한줄로 출력한다.
     */

    public ArrayList<Integer> solution(int n, int[] nums){
        ArrayList<Integer> answer = new ArrayList<>();
        // 첫 번째 수는 무조건 출력한다.
        answer.add(nums[0]);

        // 첫 번째 수는 담겨있고, 다음수를 i+1로 비교한다면 indexOutOfBounce 예외가 발생하기에
        // 앞의값을 i-1로 비교하고, 다음 수를 i로 비교한다.
        for (int i = 1; i < n; i++){
            // 앞의 값과, 뒤의 값의 비교
            if(nums[i-1] < nums[i]){
                // 자신의 앞 수보다 크다면 담아준다.
                answer.add(nums[i]);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        LargeNumberPrinter largeNumberPrinter = new LargeNumberPrinter();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        for (int x : largeNumberPrinter.solution(n, nums)){
            System.out.print(x + " ");
        }
    }
}
