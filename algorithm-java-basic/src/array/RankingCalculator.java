package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class RankingCalculator {
    /*
        # 등수 구하기

        N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
        같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
        즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

        - 입력
        첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.

        - 출력
        입력된 순서대로 등수를 출력한다.
     */

  /*
      - 고민
      나보다 더 큰 수들을 체크하여 내가 몇등인지 알아내는 풀이방법.
      2중 for문을 사용하여 자신의 점수보다 높은 점수가 나올 때 count를 더해준다.
      5명이 참가했을 경우 동일한 점수인 학생들 즉, 1등이 3명이라면 2등은 존재하지 않고, 바로 4등, 5등이 나와야한다.
      때문에 자기 자신일때와 같은 값을 가진 값들은 count를 더하지 않는다.

   */

  public ArrayList<Integer> solution(int n, int[] arr) {
    ArrayList<Integer> answer = new ArrayList<>();
    int count = 1;

    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(arr[i] < arr[j]){
          count++;
        }
      }
      answer.add(count);
      count = 1;
    }
    return answer;
  }

  public static void main(String[] args) {
    RankingCalculator rankingCalculator = new RankingCalculator();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    for(int x : rankingCalculator.solution(n, arr)){
      System.out.print(x + " ");
    }
  }
}
