package string;

import java.util.Scanner;

public class CharacterDistance {

       /*
        # 가장 짧은 문자거리

        - 설명
        한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.

        - 입력
        첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
        문자열의 길이는 100을 넘지 않는다.

        - 출력
        첫 줄에 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
     */

       /*
        # 풀이 방법들
        1.왼쪽에서 오른쪽으로 최소 거리값 계산, 오른쪽에서 왼쪽으로 최소 거리값 계산(이때 더 작은 값으로 초기화)
        2.

        # 내가 선택한 방법
        how: 1번 방법
        why:

        # 풀이 전략
        1.왼쪽에서 오른쪽으로 최소 거리값을 계산한다. 이때 최초의 거리값은 최대길이보다 더 긴 값으로 초기화해둔다. pointer = 1000
        2.오른쪽에서 왼쪽으로 최소 거리값을 계산한다. 이때 이미 배열에 담겨있는 거리값과 비교하여 더 작은 값만을 담아준다.

      */

  public int[] solution(String str, char target){
    int[] answer = new int[str.length()];
    char[] chars = str.toCharArray();

    // 왼쪽에서 오른쪽으로 비교를 시작 할 때 최초 동일한 문자가 나오기 전까지는 떨어진 거리를 알 수 없기에
    // pointer은 1000의 값을 입력받는다. 문자열의 최대길이가 100을 넘지않기에 넉넉하게 1000으로 셋팅
    int pointer = 1000;
    // 문자의 개수만큼 반복
    for(int i = 0; i < chars.length; i++){
      // 문자 t와 일치하는 문자가 나온다면 pointer값을 0으로 초기화 후 answer에 담아준다.
      if(chars[i] == target){
        pointer = 0;
        // 문자 t와 일치하지 않는 문자가 나온다면 pointer에 값을 1씩 증가시켜준다.
        // 최초 등장때 0이고 1씩 늘어나며 거리가 늘어나는 것을 계산한다.
      }else{
        pointer ++;
      }
      answer[i] = pointer;
    }

    // 처음 반복문과 반대로 오른쪽에서 왼쪽으로 비교를해준다.
    // 왼쪽에서 오른쪽을 향할 떄 기준으로 거리값만 계산되었기 때문이다.
    // 반복문은 chars의 길이 -1까지 그리고 0번째 인덱스까지 검사해야함으로 0과 같을때까지 감소시켜준다.
    for(int i = chars.length-1; i >= 0; i--){
      // 동일한 값이 나오면 0으로 초기화 시켜준다.
      if(chars[i] == target){
        pointer = 0;
        // 동일하지 않은 값이 나온다면 거리가 늘어남에 따라 1씩 추가해준다.
      }else{
        pointer ++;
      }
      // 이때 이미 t기준 오른쪽에 있는 문자와의 거리값이 계산되어있으므로
      // t기준 왼쪽에 있는 문자와의 거리값을 계산해야한다.
      // 최소값 계산이므로 현재 answer에 담겨있는 값이 더 클 경우에는 pointer의 값을 answer에 담아줘 현재 인덱스를 최소값으로 초기화시켜준다.
      if(answer[i] > pointer){
        answer[i] = pointer;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    CharacterDistance characterDistance = new CharacterDistance();
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    char t = sc.next().charAt(0);

    for(int x : characterDistance.solution(str, t)){
      System.out.print(x + " ");
    }
  }
}
