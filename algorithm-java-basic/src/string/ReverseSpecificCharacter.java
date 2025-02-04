package string;

import java.util.Scanner;

public class ReverseSpecificCharacter {

      /*
        # 특정 문자 뒤집기

        - 설명
        영어 알파벳과 특수문자로 구성된 문자열이 주어지면 영어 알파벳만 뒤집고,
        특수문자는 자기 자리에 그대로 있는 문자열을 만들어 출력하는 프로그램을 작성하세요.

        문자를 대조하다가 알파벳끼리 만났을 때 교체해야한다.

        - 입력
        첫 줄에 길이가 100을 넘지 않는 한 개의 문자열이 주어집니다.

        - 출력
        첫 줄에 알파벳만 뒤집힌 문자열을 출력합니다.
     */

  public String solution(String str){
    String answer = "";

    char[] chars = str.toCharArray();

    int lt = 0;
    int rt = chars.length-1;

    while (lt < rt){
      // lt가 알파벳이 아닐 때 lt 1증가
      if(!Character.isAlphabetic(chars[lt])){
        lt++;
        // rt가 알파벳이 아닐 때 rt 1감소
      }else if(!Character.isAlphabetic(chars[rt])){
        rt--;
        // 알파벳끼리 만났을 때 자리 변경
      }else{
        char tmp = chars[lt];
        chars[lt] = chars[rt];
        chars[rt] = tmp;
        lt++;
        rt--;
      }
    }

    answer = String.valueOf(chars);
    return answer;
  }

  public static void main(String[] args) {
    ReverseSpecificCharacter reverseSpecificCharacter = new ReverseSpecificCharacter();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    System.out.println(reverseSpecificCharacter.solution(str));
  }
}
