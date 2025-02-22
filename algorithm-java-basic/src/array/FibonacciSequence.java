package array;

import java.util.Scanner;

public class FibonacciSequence {

    /*
        # 피보나치 수열

        - 설명
        1) 피보나치 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.
        2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.

       - 입력
       첫 줄에 총 항수 N(3<=N<=45)이 입력된다.

       - 출력
       첫 줄에 피보나치 수열을 출력합니다.


       # 풀이 방법들
        1.N이 3보다 크다는 것을 이용. 현재 인덱스의 값을 구하기 위한 공식: (현재 인덱스 - 2) + (현재 인덱스 - 1)

        # 내가 선택한 방법
        how: 1번 방법
        why: 간편하다.

        # 풀이 전략
        1.N이 3보다 크다는 것을 이용.
        2.처음 두 숫자는 1부터 시작한다.
        3.answer에 0번,1번 index는 1로 초기화
        4.(현재 인덱스 - 2) + (현재 인덱스 - 1)
     */

  int[] solution(int n){
    int[] answer = new int[n];

    // 지정된 숫자가 없기에 처음 등장하는 두 숫자는 1부터 시작한다.
    // 총 항수 N은 3과 같거나 크다. 그러므로 answer에 0,1 index는 1로 초기화한다.
    answer[0] = 1;
    answer[1] = 1;

    // 반복문은 n번 반복한다
    for (int i = 2; i < n; i++){
      // 2번 인덱스의 값 = 0번 + 1번의 합
      // 3번 인덱스의 값 = 1번 + 2번의 합
      // 4번 인덱스의 값 = 2번 + 3번의 합
      // 현재 인덱스의 값을 구하기 위한 공식: (현재 인덱스 - 2) + (현재 인덱스 - 1)
      answer[i] = answer[i-2] + answer[i-1];
    }

    return answer;
  }

  // 배열을 쓰지 않고 하는 방법
  void solutionNotArray(int n){
    int a=1, b=1, c;
    System.out.print(a+" "+b+" "); // 1 1
    for(int i = 2; i < n; i++){
      c=a+b;
      System.out.print(c+" ");
      // c를 구한 후 ex) 1(a) + 1(b) = 2(c)
      // a를 b로 만든다. 1(a) = 1(b)
      // b를 c로 만든다. 1(b) = 2(c)
      // 위와 같이 반복하여 다음 숫자로 이동 가능
      a=b;
      b=c;
    }
  }

  public static void main(String[] args) {
    FibonacciSequence fibonacciSequence = new FibonacciSequence();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    fibonacciSequence.solutionNotArray(n);
//    for(int x : fibonacciSequence.solution(n)){
//      System.out.print(x + " ");
//    }
  }
}
