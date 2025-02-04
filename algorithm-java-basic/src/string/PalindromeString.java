package string;

import java.util.Scanner;

public class PalindromeString {

     /*
        # 회문 문자열

        - 설명
        앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
        문자열이 입력되면 해당 문자열이 회문 문자열이면 'YES', 회문 문자열이 아니면 'NO'를 출력하는 프로그램을 작성하세요.
        단 회문을 검사할 떄 대소문자를 구분하지 않습니다.

        - 입력
        첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

        - 출력
        첫 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
     */

       /*
        # 풀이 방법들
        1.문자열의 앞뒤를 한칸씩 좁혀가며 검사하는 방법(전부 대문자로 변경)

        # 내가 선택한 방법
        how:
        why:

        # 풀이 전략
        1.반복문은 문자열 길이의 반절만큼만 반복한다.(홀수이든 짝수이든 관계없다. 홀수라면 가운데 문자는 회문인지 검사할 필요가 없다)
        2.하나씩 검사하다가 앞 뒤가 같지않다면 "NO"를 리턴하고 반복문을 종료한다.
     */

  public String solution(String str){
    // NO가 아니라면 YES밖에 없기에 기본값은 YES로 만들어준다.
    String answer = "YES";
    // 문자열 길이를 변수에 담아둔다. 반복문과 오른쪽값 포인터 역할로 사용된다.
    int len = str.length();
    // 대소문자는 구분하지 않음으로 모두 같게 만들어준다.
    str = str.toUpperCase();
    // 반복문은 길이의 반절만큼만 반복한다. 길이가 홀수여도 가운데 문자는 검사할 필요가 없다.
    for(int i = 0; i < len/2; i++){
      if(str.charAt(i) != str.charAt(len-i-1)){
        // 아닌 값이 나올 경우 즉시 NO를 리턴한다.
        return "NO";
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    PalindromeString palindromeString = new PalindromeString();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    System.out.println(palindromeString.solution(str));
  }
}
