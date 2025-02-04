package string;

import java.util.HashMap;
import java.util.Scanner;

public class RemoveDuplicateCharacters {

        /*
        # 중복문자제거

        - 설명
        소문자로 된 한개의 문자열이 입력되면 중복된 문자를 제거하고 출력하는 프로그램을 작성하세요.
        중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지합니다.

        - 입력
        첫 줄에 길이가 100을 넘지 않는 한 개의 문자열이 주어집니다.

        - 출력
        첫 줄에 중복문자가 제거된 문자열을 출력합니다.
     */

       /*
        # 풀이 방법들
        1.indexOf()를 사용하여 가장 처음 발견된 문자열의 위치를 이용하여 찾는 방법
        2.순서가 존재하는 LinkedHashMap 을 사용하는 방법

        # 내가 선택한 방법
        how: 1번 방법 반복문을 1번만 사용해도 충분하다.
        why: linkedHashMap이 중복되지 않은 데이터를 순차적으로 저장하여 좋은것 같지만 저장과 출력 반복문을 총 2번 사용해야 함.

        # 풀이 전략
        1.indexOf()는 발견된 첫 번째 문자의 index를 리턴한다.
          만약 aaa라는 문자열에 indexOf()를 사용한다면 첫번째 a의 위치인 0만 리턴하게된다는 것이다.
        2.indexOf()가 발견된 문자의 첫 번째 위치만 리턴한다는 부분을 이용하여
        문자를 하나씩 순회하며 현재 순회하고있는 문자의 index와 indexOf()의 위치값이 일치하지 않는다면 지나치면 된다.
     */

  public String solution(String str){
    String answer = "";

    // indexOf는 가장 처음 발견된 문자열의 위치를 리턴한다.
    // 현재 순회하고 있는 본인의 인덱스 값과 indexOf()가 리턴한 값이 같다면 처음 등장한 문자. 아니라면 제거

    for(int i = 0; i < str.length(); i++){
      if(i == str.indexOf(str.charAt(i))){
        answer += str.charAt(i);
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    RemoveDuplicateCharacters removeDuplicateCharacters = new RemoveDuplicateCharacters();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    System.out.println(removeDuplicateCharacters.solution(str));
  }
}
