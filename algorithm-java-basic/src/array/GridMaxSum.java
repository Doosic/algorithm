package array;

import java.util.Scanner;

public class GridMaxSum {
    /*
        # 격자판 최대합

        - 설명
        5*5 격자판에 숫자가 적혀있다.
        N*N 격자판이 주어지면 각 행의 합, 각열의 합, 두 대각선의 합 중 가장 큰 합을 출력한다.

        - 입력
        첫 줄에 자연수 N이 주어진다.(2<=N<=50)
        두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.

        - 출력
        최대합을 출력한다.


        # 풀이방법
        1.각 열,행,대각선의 max 값을 저장하는 변수를 만든다.
        2.반복문을 각각의 max 값을 저장
        3.열, 행, 대각선의 max 값들 중 가장 큰 값을 리턴
     */

    public int solution(int n, int[][] arr){
        int answer = 0;

        int column = 0;
        int row = 0;
        int cross = 0;
        int reverseCross = 0;
        for(int i =  0; i < n; i++){
            // 임시저장 변수는 반복문이 반복될 때 마다 초기화
            int tmpColumn = 0;
            int tmpRow = 0;
            for(int j = 0; j < n; j++){
                // 열의 합
                tmpColumn += arr[i][j];
                // 행의 합
                tmpRow += arr[j][i];
            }

            // 열과 행에 가장 큰 값을 저장
            column = Math.max(tmpColumn, column);
            row = Math.max(tmpRow, row);
            // 대각선
            cross += arr[i][i];
            reverseCross += arr[(n-i)-1][(n-i)-1];
        }

        int columnRowLine = Math.max(column, row);
        int crossLine = Math.max(cross, reverseCross);
        answer = Math.max(columnRowLine, crossLine);
        return answer;
    }

    public static void main(String[] args) {
        GridMaxSum gridMaxSum = new GridMaxSum();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(gridMaxSum.solution(n, arr));
    }
}
