package array;

import java.util.Arrays;
import java.util.Scanner;

public class Mentoring {
    /*
        # 멘토링

        - 설명
        현수네 반 선생님은 반 학생들의 수학점수를 향상시키기 이해 멘토링 시스템을 만들려고 합니다.
        멘토링은 멘토(도와주는 학생)와 멘티(도움을 받는 학생)가 한 짝이 되어 멘토가 멘티의 수학공부를 도와주는 것입니다.
        선생님은 M범의 수학테스트 등수를 가지고 멘토와 멘티를 정합니다.
        만약 A학생이 멘토이고, B학생이 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야 합니다.
        M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들 수 있는 경우가 총 몇 가지 인지 출력하는 프로그램을 작성하세요.

        - 입력
        첫 번째 줄에 반 학생 수 N과 M이 주어진다.
        두 번째 줄부터 M개의 줄에 걸쳐 수학테스트 결과가 학생번호로 주어진다. 학생번호가 제일 앞에서부터 1등, 2등, ...N등 순으로 표현된다.
        만약 한 줄에 N=4이고, 테스트 결과가 3 4 1 2 로 입력되었다면 3번 학생이 1등, 4번 학생이 2등, 1번 학생이 3등, 2번 학생이 4등을 의미합니다.

        - 출력
        첫 번째 줄에 짝을 만들 수 있는 총 경우를 출력합니다.

        - 풀이(짝을 만들 수 있는 총 경우의 수)
        1.반 학생끼리의 비교 1번 학생과 ?번 학생의 비교
            i, j의 비교
        2.1번(i)과 ?번(j)를 비교할 때 각 시험회차마다 1번이 더 큰지 확인한다.
     */

    public int solution(int n, int m, int[][] arr){
        int answer = 0;

        // 학생 i와 학생 j를 비교
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                // 각 시험 회차
                int count = 0;
                for(int k = 0; k < m; k++){
                    int student1 = 0;
                    int student2 = 0;
                    // 각 시험 회차(K)에서 i의 등수와 j의 등수를 확인
                    // 시험 점수로 줄을 세웠을 때 i는 몇번째 순서(l)에 있는가?
                    // 순서가 낮을 수록 상위 득점자(순서가 곧 등수)
                    for(int l = 0; l < n; l++){
                        if(arr[k][l] == i){
                            student1 = l;
                        }
                        if(arr[k][l] == j){
                            student2 = l;
                        }
                    }

                    // 등수가 높을수록 값이 작다
                    if(student1 < student2){
                        count++;
                    }
                }

                // 시험회차(M)와 count(등수가 높았던 차수체크값)가 같다면 멘토가 될 수 있으므로 추가
                if(count == m){
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Mentoring mentoring = new Mentoring();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(mentoring.solution(n, m, arr));
    }
}
