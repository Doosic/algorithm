package array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class ReversedPrime {

    /*
        # 뒤집은 소수

        - 설명
        N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
        예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
        첫 자리부터의 연속된 0은 무시한다.

        - 입력
        첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
        각 자연수의 크기는 100,000를 넘지 않는다.

        - 출력
        첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
     */


  public boolean isPrime(int num){
    // 1은 제외
    if(num == 1){
      return false;
    }
    // 2부터 자기 자신 전까지 약수가 존재하는지 검사
    for(int i = 2; i < num; i++){
      if(num % i == 0){
        return false;
      }
    }
    return true;
  }
  /*
      * 숫자 뒤집기 공식 ex) 1230
      - res = res * 10 + t
        0 = 0 * 10 + 0
        3 = 0 * 10 + 3
        32 = 3 * 10 + 2
        321 = 32 * 10 + 1
   */
  public ArrayList<Integer> solution(int n, int[] arr){
    ArrayList<Integer> answer = new ArrayList<>();
    for(int i = 0; i < n; i++){
      int tmp = arr[i];
      int res = 0;
      // 숫자를 뒤집어준다.
      while (tmp > 0){
        int t = tmp % 10; // 1230 % 10 = 0
        res = res * 10 + t; // 0 * 0 + 0 = 0
        tmp = tmp/10; // 1230 / 10 = 123(다음 숫자)
      }
      // 소수인지 검사한 후 소수라면 담아준다.
      if(isPrime(res)){
        answer.add(res);
      }

    }

    return answer;
  }

  public static void main(String[] args) {
    ReversedPrime reversedPrime = new ReversedPrime();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }

    for(int x : reversedPrime.solution(n, arr)){
      System.out.print(x + " ");
    }

  }
}
