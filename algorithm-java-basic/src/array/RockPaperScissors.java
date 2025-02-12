package array;

import java.util.Scanner;

public class RockPaperScissors {

    /*
        # 가위바위보

        - 설명
        A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
        가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하겠습니다
        두 사람의 각 회의 가위, 바위, 보 정보가 주어지면 각 회를 누가 이겼는지 출력하는 프로그램을 작성하세요

        - 입력
        첫 번째 줄에 게임 횟수인 자연수 N(1<=N<=100)이 주어집니다.
        두 번째 줄에는 A가 낸 가위, 바위, 보 정보가 N개 주어집니다.
        세 번째 줄에는 B가 낸 가위, 바위, 보 정보가 N개 주어집니다.

        - 출력
        각 줄에 각 회의 승자를 출력합니다. 비겼을 경우는 D를 출력합니다.
     */

    public String[] solution(int n, int[] aNums, int[] bNums){
        String[] answer = new String[n];

        // 승자를 가려주는 함수에 반복문을 통해 값을 차례로 넘겨준다.
        for(int i = 0; i < n; i++){
            // answer에 모든 값들 담아준다.
            answer[i] = determineWinner(aNums[i], bNums[i]);
        }

        return answer;
    }

    // A와 B 둘 중 승자를 가려주는 함수. 비겼을때는 D
    private static String determineWinner(int a, int b){
        String winner = "";
        // 비긴 경우는 D
        if(a == b){
            winner = "D";
            // A가 가위일 때 이길 수 있는 경우는 B가 보자기일때
        }else if(a == 1 && b == 3){
            winner = "A";
            // A가 바위일 때 이길 수 있는 경우는 B가 가위일때
        }else if(a == 2 && b == 1){
            winner = "A";
            // A가 보자기일 때 이길 수 있는 경우는 B가 주먹일때
        }else if(a == 3 && b == 2){
            winner = "A";
            // 그 외의 경우들은 모두 B가 승리한다
        }else{
            winner = "B";
        }

        return winner;
    }

    public static void main(String[] args) {
        RockPaperScissors rockPaperScissors = new RockPaperScissors();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] aNums = new int[n];
        int[] bNums = new int[n];

        // A의 값을 받는다
        for(int i = 0; i < n; i++){
            aNums[i] = sc.nextInt();
        }
        // B의 값을 받는다
        for(int i = 0; i < n; i++){
            bNums[i] = sc.nextInt();
        }

        for(String x : rockPaperScissors.solution(n, aNums, bNums)){
            System.out.println(x);
        }
    }
}
