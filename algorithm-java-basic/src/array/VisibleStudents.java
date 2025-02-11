package array;

import java.util.Scanner;

public class VisibleStudents {

    /*
        # 보이는 학생

        - 설명
        선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로 주어질 때, 맨 앞에 서 있는
        선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요. (앞에 서 있는 사람들보다 크면 보이고, 작거나 같으면 보이지 않습니다.)

        - 입력
        첫 줄에 정수 N(5<=N<=100,000)이 입력된다. 그 다음줄에 N명의 학생의 키가 앞에서부터 순서대로 주어진다.

        - 출력
        선생님이 볼 수 있는 최대학생수를 출력한다.
     */
    /*
        # 풀이 방법
        1.반복문을 돌때 나온 가장 큰 키를 가진 학생의 키를 변수에 담아준다.
        2.다음 나오는 학생이 더 큰 키를 가졌다면(같거나 작으면 안된다.) 카운팅한다.
     */

    public int solution(int n, int[] nums){
        int answer = 0;
        int maxHeight = 0;

        for (int i = 0; i < n; i++){
            if(maxHeight < nums[i]){
                maxHeight = nums[i];
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        VisibleStudents vis = new VisibleStudents();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(vis.solution(n, nums));
    }
}
