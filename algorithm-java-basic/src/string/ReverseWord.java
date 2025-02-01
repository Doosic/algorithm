package string;

import java.util.ArrayList;
import java.util.Scanner;

public class ReverseWord {

     /*
        # 단어 뒤집기

        - 설명
        N개의 단어가 주어지면 각 단어를 뒤집어 출력하는 프로그램을 작성하세요.

        - 입력
        첫 줄에 자연수 N(3<=N<=20)이 주어집니다.
        두 번째 줄부터 N개의 단어가 각 줄에 하나씩 주어집니다. 단어는 영어 알파벳으로만 구성되어 있습니다.

        - 출력
        N개의 단어를 입력된 순서대로 한 줄에 하나씩 뒤집어서 출력합니다.
     */

     /*
        # 풀이 방법들
        1.StringBuilder 클래스의 reverse()를 사용하는 방법
        2.char[] 로 변환하여 문자의 시작과 끝을 한칸씩 좁혀가며 교체하는 방법

        # 내가 선택한 방법
        how: 1번 방법
        why: 1번 방법이 풀이하기 간단하기 때문이다.

        # 풀이 전략
        1.함수 내 전달받은 String[] 의 값들을 하나씩 꺼내어준다.
        2.StringBuilder를 이용하여 하나씩 뒤집어준다.
        3.String[]에 뒤집은 단어를 하나씩 저장한다.
        4.출력해준다!
     */

  /*
      # String과 StringBuilder의 차이점
      String은 불변값이다. 그렇기에 문자열을 더 이상 변경할 수 없다.
      String a = "문자1"; a += "문자2"; 언뜻 보기에는 문자1에 문자2를 더해 새로운 문자를 추가할 수 있는 것 처럼 보인다.
      그러나 내부적으로는 "문자1"을 담았던 객체는 버려지고, "문자1문자2"가 합해진 새로운 객체를 만들어 할당한다.
      "문자1"은 다른 곳에서 사용하지 않는다면 가비지 컬렉션에 대상이 되어 메모리에서 제거된다.

      StringBuilder는 처음에 만들어진 객체 1개를 계속해서 변환한다. 새로운 객체를 더 생성하지도 않으며, 메모리를 추가적으로 계속해서
      사용하게 될 일이 없는 것이다. 그렇기에 String에 많은 작업이 일어날 때는 StringBuilder를 사용하는게 좋다.
   */

  public static void main(String[] args) {
    ReverseWord reverseWord = new ReverseWord();
    Scanner sc = new Scanner(System.in);
    // 자연수 N을 받는다
    int n = sc.nextInt();
    // N개의 단어를 받을 변수를 선언한다.
    String[] str = new String[n];
    // N개의 단어를 입력받는다.
    for(int i = 0; i < n; i++){
      str[i] = sc.next();
    }

    // N개의 단어를 뒤집어서 출력한다.
    System.out.println("===== solution1 =====");
    for(String reversStr : reverseWord.solution(n, str)){
      System.out.println(reversStr);
    }

    System.out.println("===== solution2 =====");
    for(String reversStr : reverseWord.solution2(n, str)){
      System.out.println(reversStr);
    }
  }

  // 단어의 전체를 뒤집는 경우
  public String[] solution(int n, String[] str) {
    String[] answer = new String[n];
    for(int i = 0; i < n; i++){
      // 임시로 사용할 변수에 뒤집어진 단어를 넣어준다.
      String tmp = new StringBuilder(str[i])
          .reverse()
          .toString();
      // 뒤집어진 단어를 저장한다.
      answer[i] = tmp;
    }
    return answer;
  }

  // 단어의 앞 뒤를 변경하여 뒤집는 경우
  public String[] solution2(int n, String[] str) {
    String[] answer = new String[n];

    for(int i = 0; i < n; i++){
      // 각 단어를 문자 배열로 변환
      char[] s = str[i].toCharArray();

      // 왼쪽과 오른쪽을 가르키는 포인터를 선언
      int lt = 0;
      int rt = str[i].length()-1;

      // 문자의 시작과 끝을 한칸씩 좁혀가며 자리교환
      while (lt < rt){
        char tmp = s[lt];
        s[lt] = s[rt];
        s[rt] = tmp;
        lt ++;
        rt --;
      }

      // 문자형 배열을 문자열로 변환하여 answer에 저장
      String tmp = String.valueOf(s);
      answer[i] = tmp;
    }

    return answer;
  }
}
