package string;

import java.util.Scanner;

public class ExtractWord {

    /*
        # 문장 속 단어

        - 설명
        한 개의 문장이 주어지면 그 문자 속에서 가장 긴 단어를 출력하는 프로그램을 작성하세요.
        문장속의 각 단어는 공백으로 구분됩니다.

        - 입력
        첫 줄에 길이가 100을 넘지 않는 한 개의 문장이 주어집니다. 문장은 영어 알파벳으로만 구성되어 있습니다.

        - 출력
        첫 줄에 가장 긴 단어를 출력한다. 가장 길이가 긴 단어가 여러개일 경우 문장속에서 가자 앞쪽에 위치한
        단어를 답으로 합니다.
     */

     /*
        # 풀이 방법들
        1.받은 문자열을 공백을 기준으로 분리하여 각 단어들의 길이를 확인 후 가장 긴 단어 출력
        2.indexOf() 를 사용하는 방법

        # 내가 선택한 방법
        how: 1번 방법
        why: 1번 방법이 이해하기 쉬움...

        # 풀이 전략
        1.함수 내 전달받은 매개변수를 split 함수로 공백을 기준으로 분리한다.
        2.반복문을 돌며 answer 보다 더 큰 word 값이 존재할 때만 answer 에 값을 담아준다.(같은 길이는 X)
        3.answer 출력
     */


    public static void main(String[] args) {
        ExtractWord extractWord = new ExtractWord();

        Scanner sc = new Scanner(System.in);
        // 문자열 입력
        String str = sc.nextLine();

        System.out.println(extractWord.solution(str));
    }

    public String solution(String str) {
        // 공백을 기준으로 문자열의 문자를 분리
        String[] words = str.split(" ");

        String answer = "";
        // 문자열의 길이값 만큼 반복문
        for (String word : words) {
            // answer에 담긴 값 보다 더 큰 값이 나온다면 교체
            // 같은 길이일 경우 기존게 남아있게 됨으로 가장 첫번째에 나온 값이 남아있게 된다.
            if(word.length() > answer.length()){
                answer = word;
            }
        }
        // 가장 긴 값이 담겨있게된다
        return answer;
    }


}
