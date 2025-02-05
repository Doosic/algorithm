package string;

import java.util.Scanner;

public class ExtractNumbers {

       /*
        # 숫자만 추출

        - 설명
        문자와 숫자가 섞여있는 문자열이 주어지면 그 중 숫자만 추출하여 그 순서대로 자연수를 만듭니다.
        만약 "tge0a1h205er"에서 숫자만 추출하면 0,1,2,0,5이고 이것을 자연수를 만들면 1205이 됩니다.
        추출하여 만들어지는 자연수는 100,000,000을 넘지 않습니다.

        - 입력
        첫 줄에 숫자가 섞인 문자열이 주어집니다. 문자열의 길이는 100을 넘지 않습니다.

        - 출력
        첫 줄에 자연수를 출력합니다.
     */

       /*
        # 풀이 방법들
        1.replaceAll() 을 이용하여 숫자가 아닌 문자들을 제거후 타입 캐스팅
        2.반복문을 돌며 일일히 숫자인 값들을 추출한 후에 타입 캐스팅(아스키코드, 48~57)

        # 내가 선택한 방법
        how: 1번 방법
        why: 가장 간단하기 떄문.

        # 풀이 전략
        1.입력받은 문자열을 replaceAll()을 이용하여 숫자만 남겨준다.
        2.정수형 타입으로 타입캐스팅.
     */

  public int solution(String str){
    int answer = 0;

    str = str.replaceAll("[^0-9]", "");
    answer = Integer.parseInt(str);

    return answer;
  }

  public static void main(String[] args) {
    ExtractNumbers extractNumbers = new ExtractNumbers();
    Scanner sc = new Scanner(System.in);
    String str = sc.nextLine();

    System.out.println(extractNumbers.solution(str));
  }
}
