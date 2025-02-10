package string;

import java.util.Scanner;

public class CompressString {

       /*
        # 문자열 압축

        - 설명
        알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는
        문자 바로 오른쪽에 반복 횟수를  표기하는 방법으로 문자열을 압축하는 프로그램을 작성하시오.
        단 반복횟수가 1인 경우 생략합니다.

        - 입력
        첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.

        - 출력
        첫 줄에 압축된 문자열을 출력한다.
     */

       /*
        # 풀이 방법들
        1.반복문으로 current,next 문자를 비교해 연속으로 반복되는지 체크하는 방법
        2.lt와 rt 포인터를 사용해 풀이하는 방법

        # 내가 선택한 방법
        how: 1번 방법
        why: 2번 방법 사용시 생각보다 풀이하기 위해 생각해야 할 부분들이 많다... 마지막 문자 처리가 조금 까다로워진다.

        # 풀이 전략
        1.currentCh와 nextCh를 분리하여 앞뒤 문자를 검사한다.
        2.같다면 count를 증가시키고, 다르다면 answer에 추가해준다.
        3.이때 count의 기본값은 1이다. 문자 1개는 무시하고, 2개 등장 시 count++ 했을때 2가 되려면 초기값이 1이 되어야 한다.
      */


    // 방법1
    public String solution1(String str){
        String answer = "";

        // 현재 문자가 몇번 반복되는지 카운트 할 변수 선언
        // count의 초기값은 1로 한다. 문자 2개 등장시 count++ 했을때 2가 되려면 초기값이 1이 되어야 한다.
        int count = 1;

        // 반복문을 str.length()-1 만큼 반복하니 맨 마지막 문자가 1개인 경우를 체크하지 못함.
        // 해결방법 조건에 입력값이 영어 대문자만 허용됨으로 버려질 특수문자 1개를 맨 마지막에 붙여주는 방법
        str = str + "$";

        // 문자열의 길이만큼 반복문을 반복한다.
        for(int i = 0; i < str.length()-1; i++){
            // 현재의 문자와 다음문자를 비교하여 반복되는 문자인지 확인한다.
            char currentCh = str.charAt(i);
            char nextCh = str.charAt(i+1);

            if(currentCh == nextCh){
                // 같다면 count 증가
                count++;
            }else{
                // 같지 않다면 현재 문자를 담아준다.
                // 이때 count가 1이라면 count를 포함하지 않는다.
                answer += currentCh;
                if(count > 1){
                    answer += count;
                }

                count = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CompressString compressString = new CompressString();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        System.out.println(compressString.solution1(str));
    }
}
