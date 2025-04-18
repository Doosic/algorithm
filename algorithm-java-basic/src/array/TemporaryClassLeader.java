package array;

import java.util.Arrays;
import java.util.Scanner;

public class TemporaryClassLeader {
    /*
        # 임시반장정하기

        - 설명
        김갑동 선생님은 올해 6학년 1반 담임을 맡게 되었다.
        김갑동 선생님은 우선 임시로 반장을 정하고 학생들이 서로 친숙해진 후에 정식으로 선거를 통해 반장을 선출하려고한다.
        그는 자기반 학생 중에서 1학년부터 5학년까지 지내오면서 한번이라도 같은 반이었던 사람이 가장 많은 학생을 임시 반장으로 정하려 한다.
        그래서 김갑동 선생님은 각 학생들이 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 표를 만들었다.
        예를 들어 학생 수가 5명일 때의 표를 살펴보자.

        위 경우에 4번 학생을 보면 3번 학생과 2학년 때 같은 반이었고, 3번 학생 및 5번 학생과 3학년 때 같은 반이었으며,
        2번 학생과는 4학년 때 같은 반이었음을 알 수 있다. 그러므로 이 학급에서 4번 학생과 한번이라도
        같은 반이었던 사람은 2번 학생, 3번 학생과 5번 학생으로 모두 3명이다.
        이 예에서 4번 학생이 전체 학생 중에서 같은 반이었던 학생 수가 제일 많으므로 임시 반장이 된다.
        각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.

        !!! 중요
        같은 반이 한번 되었던 학생은 체크하지 않는다.
        같은 반이 되었던 학생의 수를 세는 것이기 때문에 같은 학생을 2번 체크하면 안됨

        - 입력
        첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
        둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
        주어지는 정수는 모두 1 이상 9 이하의 정수이다.

        - 출력
        첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
        단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.


        # 문제풀이 고민
        - 브르투포스로 풀이
        - 1번 학생과, 2번학생 비교, 1번과 3번 비교....
        - 2번화 1번 비교, 2번과 3번 비교.....
        - 이때 같은반이 되었던 학생 수를 체크해야 하기 때문에 같은반이 한번 되었던 학생은 제외한다.
     */

    /*
        입력값
        5
        2 3 1 7 3
        4 1 9 6 8
        5 5 2 4 4
        6 5 2 6 7
        8 4 2 2 2
     */
    public int solution(int n, int[][] arr){
        int answer = 0;
        // tmp 값은 반복문 바깥에 선언한다. 안쪽에 선언시 반복문이 초기화 될 때 함께 0으로 초기화되기 때문
        int tmpCnt = 0;
        int cnt = 0;

        // 학생1~N명
        for(int i = 1; i <= n; i++){
            // 학생 1~N명
            for(int j = 1; j <= n; j++){
                // 학년 1~5학년
                for(int k = 1; k <= 5; k++){
                    // 1번 학생 1학년~5학년
                    // N번 학생 1학년~5학년 비교
                    if(arr[i][k] == arr[j][k]){
                        cnt++;
                        // 같은반이 되었던 학생 수를 체크하는 것이기 때문에
                        // 이미 함깨했던 학생 즉, 중복된 학생은 제외
                        break;
                    }
                }
            }

            if(cnt > tmpCnt){
                answer = i;
                tmpCnt = cnt;
            }
            cnt = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        TemporaryClassLeader t = new TemporaryClassLeader();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n+1][6];

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        /*
            * 입력된 값
            [0, 0, 0, 0, 0, 0]
            [0, 2, 3, 1, 7, 3]
            [0, 4, 1, 9, 6, 8]
            [0, 5, 5, 2, 4, 4]
            [0, 6, 5, 2, 6, 7]
            [0, 8, 4, 2, 2, 2]
         */

        System.out.println(t.solution(n, arr));
    }
}
