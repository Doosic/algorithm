package string;

import java.util.Scanner;

public class FindCharacter {

      /*
      # 문자 찾기

      - 설명
      한 개의 문자열을 입력받고, 특정 문자를 입력받아 해당 특정문자가 입력받은 문자열에 몇 개 존재하는지 알아내는 프로그램을 작성하시오.
      대소문자를 구분하지 않고, 문자열의 길이는 100을 넘지않는다.

      - 입력
      첫 줄에 문자열이 주어지고, 두 번째 줄에 문자가 주어진다.
      문자열은 영어 알파벳으로만 구성되어 있다.

      - 출력
      첫 줄에 해당 문자의 개수를 출력한다.
   */

  /*
      # 풀이 방법들
      1.solution 함수 내에서 전달받은 매개변수들을 upperCase or rowerCase하여 비교
      2.스케너에서 입력받을 때 모두 upperCase or rowerCase하여 비교

      # 내가 선택한 방법
      how: 1번 방법
      why: solution 이라는 이름에 걸맞게 해당 함수에서 문제를 처리하기 위해서

      - 풀이 전략
      1.solution 함수 내 전달받은 문자열,문자 값을 대문자 또는 소문자로 변환.
      2.toCharArray() 함수를 통해 문자열을 char[] 로 변환
      3.forEach문을 통해 한 문자씩 비교
   */

    public static void main(String[] args) {
        FindCharacter findCharacter = new FindCharacter();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);

        System.out.println(findCharacter.solution(str, c));
    }

    public int solution(String str, char t){
        int answer = 0;

        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        for (char c : str.toCharArray()){
            if(c == t){
                answer ++;
            }
        }
        return answer;
    }
}
