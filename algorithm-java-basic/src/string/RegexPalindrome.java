package string;

import java.util.Scanner;

public class RegexPalindrome {

       /*
        # 회문 문자열

        - 설명
        앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 팰린드롬이라고 합니다.
        문자열이 입력되면 해당 문자열이 팰린드롬이면 'YES', 아니면 'NO'를 출력하는 프로그램을 작성하세요.
        단 회문을 검사할 떄 알파벳만 가지고 회문을 검사하며, 대소문자를 구분하지 않습니다.
        알파벳 이외의 문자들을 무시합니다.

        - 입력
        첫 줄에 길이 100을 넘지 않는 공백이 없는 문자열이 주어집니다.

        - 출력
        첫 줄에 회문 문자열인지의 결과를 YES 또는 NO로 출력합니다.
     */

       /*
        # 풀이 방법들
        1.알파벳이 아닌 문자들을 replaceAll()의 정규식을 이용하여 제거한다.
     */

  public String solution(String str){
    String answer = "NO";
    // 대소문자 구분이 없으므로 대문자로 전부 변경
    // replaceAll의 정규식을 이용하여 A-Z가 아닌 것들은 모두 제거한다.
    str = str.toUpperCase().replaceAll("[^A-Z]", "");
    // 뒤집은 문자열을 생성한다.
    String tmp = new StringBuilder(str).reverse().toString();

    // 문자열 원본과, 뒤집은 문자열을 비교한다.
    if(str.equals(tmp)){
      answer = "YES";
    }

    return answer;
  }

  public static void main(String[] args) {
    RegexPalindrome regexPalindrome = new RegexPalindrome();
    Scanner sc = new Scanner(System.in);
    // next() 는 띄어쓰기 뒷 부분을 읽지 않는다.
    // nextLine()은 개행되기 전까지 읽어들인다.
    String str = sc.nextLine();

    System.out.println(regexPalindrome.solution(str));
  }


}
