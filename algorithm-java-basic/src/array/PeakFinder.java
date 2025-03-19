package array;

import java.util.Arrays;
import java.util.Scanner;

public class PeakFinder {
    /*
        # 봉우리

        - 설명
        지도 정보가 N*N 격자판에 주어집니다. 각 격자에는 그 지역의 높이가 쓰여있습니다.
        각 격자판의 숫자 중 자신의 상하좌우 숫자보다 큰 숫자는 봉우리 지역입니다. 봉우리 지역이 몇 개 있는 지 알아내는 프로그램을 작성하세요.
        격자의 가장자리는 0으로 초기화 되었다고 가정한다.
        만약 N=5 이고, 격자판의 숫자가 다음과 같다면 봉우리의 개수는 10개입니다.

        - 입력
        첫 줄에 자연수 N이 주어진다.(2<=N<=50)
        두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

        - 출력
        봉우리의 개수를 출력하세요.


        # 풀이방법
        1.격자구성은 (N+2) * (N+2) 로 구성한다.
        2.1부터 N까지 반복하며 입력값들을 받는다.
        ex) n = 5, 입력값 5,3,7,2,3 일 경우. for(int i = 1; i <= n; i++)
        arr[0] = 0; // 기본값 초기화
        arr[1] = 5; // 할당
        arr[2] = 3; // 할당
        arr[3] = 7; // 할당
        arr[4] = 2; // 할당
        arr[5] = 3; // 할당
        arr[6] = 0; // 기본값 초기화
        (가장자리는 0으로 초기화/자바 int 기본값 0 할당되어있으므로 따로 안해줘도 된다.)
        3.배열을 순회하며 상,하,좌,우의 값들과 비교하여 봉우리 개수를 체크한다.
     */

    public int solution(int n, int[][] arr){
        int answer = 0;

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                // 상
                boolean up = arr[i][j] > arr[i-1][j];
                // 하
                boolean down = arr[i][j] > arr[i+1][j];
                // 좌
                boolean left = arr[i][j] > arr[i][j-1];
                // 우
                boolean right = arr[i][j] > arr[i][j+1];
                if(up && down && left && right ){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        PeakFinder pf = new PeakFinder();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+2][n+2];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
//        System.out.println(Arrays.toString(arr[0]));
//        System.out.println(Arrays.toString(arr[1]));
//        System.out.println(Arrays.toString(arr[2]));
//        System.out.println(Arrays.toString(arr[3]));
//        System.out.println(Arrays.toString(arr[4]));
//        System.out.println(Arrays.toString(arr[5]));
//        System.out.println(Arrays.toString(arr[6]));

        System.out.println(pf.solution(n, arr));
    }
}