package array;

import java.util.Scanner;

public class PrimeNumber {
    
    /*
        # 소수

        - 설명
        자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.
        만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.

        - 입력
        첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.

        - 출력
        첫 줄에 소수의 개수를 출력합니다.
     */

  public int solution(int n){
    int answer = 0;
    // n+1을 하는 이유는 20이 입력되었을 경우 자기 자신까지 검사해야하기 때문이다.
    // int[20] 을 했을 경우 0~19까지의 index 번호가 생성된다. 그래서 n+1을 하여 0~20까지의 번호를 만들어준다.
    // 이후 '1과 자기자신을 제외'하기 때문에 index 0번,1번은 무시하고 2번부터 반복문을 시작한다.
    int[] ch = new int[n+1];
    // 2 ~ 20 index 까지 반복문 증가
    for(int i = 2; i <= n; i++){
      // 만약 0번이 들어있다면?
      // 1번은 약수가 존재한다고 체크해둔 index라서 무시
      if(ch[i]==0){
        // 0번인 경우 소수 등장, 1번인 경우 약수가 존재하는 수
        answer++;
        // j=j+i 인 이유: 2는 2의 배수만을 체크하면 되기 때문이다. 3은 3의 배수만을 체크해서 지우면 되기 때문이다.
        for(int j = i; j <= n; j=j+i){
          // 약수가 존재한다면 해당 index를 1로 초기화한다.
          ch[j] = 1;
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    PrimeNumber primeNumber = new PrimeNumber();
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    System.out.println(primeNumber.solution(n));
  }
}
