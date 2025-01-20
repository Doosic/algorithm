package string;

import java.util.Scanner;

public class ConvertCase {

  /*
      # 대소문자 변환

      - 설명
      대문자와 소문자가 같이 존재하는 문자열을 입력받아 대문자는 소문자로 소문자는 대문자로 변환하여 출력하는 프로그램을 작성하세요.

      - 입력 첫 줄에 문자열이 입력된다. 문자열의 길이는 100을 넘지 않는다.
      문자열은 영어 알파벳으로만 구성되어 있다.

      - 출력
      첫 줄에는 대문자는 소문자로, 소문자는 대문자로 변환된 문자열을 출력한다.
   */

    /*
      # 풀이 방법들
      1.solution 내에서 인자값을 한 단어씩 꺼내 대소문자를 판별(아스키코드 32). 이후 upperCase or rowerCase하여 반대로 변환한다.
      2.Character 클래스에 isLowerCase() 라는 함수를 이용한다. 해당 문자가 소문자인지 판별하는 함수이다.

      # 내가 선택한 방법
      how: 1번 방법
      why: 다른 방법이 생각나지 않음, 2번 방법은 추후에 알게되었다.

      # 풀이 전략
      1.함수 내 전달받은 매개변수를 toCharArray() 함수를 통해 char[] 로 변환한다.
      2.문자들을 하나씩 꺼내, 아스키코드 값으로 소문자 범위인지, 대문자 범위인지 판별한다.
      3.소문자라면 대문자로, 대문자라변 소문자로 변환하여 answer 값에 더해 출력

      * ASCII 코드
      a ~ z (97 ~ 122)
      A ~ Z (65 ~ 90)
   */

  public static void main(String[] args) {
    ConvertCase convertCase = new ConvertCase();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    System.out.println(convertCase.solution(str));
  }

  public String solution(String str){
    String answer = "";

    for (char c : str.toCharArray()){

      // char 은 메모리상에 정수형으로 저장이 되기 때문에 int로 형변환을 해주지 않아도 된다고 한다.

      if(c >= 65 && c <= 90){
        // cNum을 숫자로 계산하여 문자에 저장할 때는 형변환이 필요하다.
        answer += (char) (c + 32);
      }else{
        answer += (char) (c - 32);
      }
    }

    return answer;
  }
}
