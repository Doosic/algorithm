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

        - 입력
        첫째 줄에는 반의 학생 수를 나타내는 정수가 주어진다. 학생 수는 3 이상 1000 이하이다.
        둘째 줄부터는 1번 학생부터 차례대로 각 줄마다 1학년부터 5학년까지 몇 반에 속했었는지를 나타내는 5개의 정수가 빈칸 하나를 사이에 두고 주어진다.
        주어지는 정수는 모두 1 이상 9 이하의 정수이다.

        - 출력
        첫 줄에 임시 반장으로 정해진 학생의 번호를 출력한다.
        단, 임시 반장이 될 수 있는 학생이 여러 명인 경우에는 그 중 가장 작은 번호만 출력한다.


        # 문제풀이 고민
        - 각 column 별로 가장 많이 등장한 반을 체크해둔다.
        - 많이 등장했던 반에 일치하는 학생들을 찾는다.
        - 변수에 많이 일치하는 학생들을 순서대로 저장해둔다.
        - 더 많이 일치하는 학생이 나올수록 변수에 값을 변경한다. 동일한 등장횟수는 무시.
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
    public int solution(int n, int[][] arr, int maxGrade, int maxClass){
        int answer = 0;

        // 학년별로 반마다 몇명이 속했었는지 체크한다. 1~5학년, 1~9반
        // class는 index를 동일하게 사용하기 위해 +1을 해줬다. 0번 인덱스는 사용하지 않는 것으로.
        int[][] classStudents = new int[maxGrade][maxClass+1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < maxGrade; j++){
                classStudents[i][arr[j][i]]++;
            }
        }
        /*
            0번 인덱스는 사용안함
            1학년 [0, 0, 1, 0, 1, 1, 1, 0, 1, 0]
            2학년 [0, 1, 0, 1, 1, 2, 0, 0, 0, 0]
            3학년 [0, 1, 3, 0, 0, 0, 0, 0, 0, 1]
            4학년 [0, 0, 1, 0, 1, 0, 2, 1, 0, 0]
            5학년 [0, 0, 1, 1, 1, 0, 0, 1, 1, 0]
         */

        // 학년마다 가장 많이 속했던 반을 추출한다.
        // index가 학년이되고, 그 안의 숫자가 가장 많이 속했던 반이 되어야함
        int[] studentsNums = new int[maxGrade]; // 0~4

        for(int i = 0; i < maxGrade; i++){
            int tmpNum = 0;
            for(int j = 1; j < maxClass+1; j++){
                if(classStudents[i][j] > 1 && classStudents[i][j] > tmpNum){
                    tmpNum = classStudents[i][j];
                    studentsNums[i] = j;
                }
            }
        }

        // 1학년 0반
        // 2학년 5반
        // 3학년 2반
        // 4학년 6반
        // 5학년 0반
        // [0, 5, 2, 6, 0]

        // 학생별로 일치하는 반이 많은 학생을 찾는다.
        int maxCount = 0;
        for(int i = 0; i < n; i++){
            int tmpCount = 0;
            for(int j = 0; j < maxGrade; j++){
                if(arr[i][j] == studentsNums[j]){
                    tmpCount++;
                }
            }
            if(tmpCount > maxCount){
                answer = i+1;
                maxCount = tmpCount;
            }
            tmpCount = 0;
        }

        // 겹치는 학생이 없을 경우에는 1번 학생이 무조건 임시반장이 된다.
        if(answer <= 0){
            answer = 1;
        }

        return answer;
    }

    public static void main(String[] args) {
        TemporaryClassLeader t = new TemporaryClassLeader();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int maxGrade = 5;
        int maxClass = 9;
        int[][] arr = new int[n][maxGrade];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(t.solution(n, arr, maxGrade, maxClass));
    }
}
