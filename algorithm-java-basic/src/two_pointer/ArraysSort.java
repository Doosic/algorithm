package two_pointer;

import java.util.Scanner;

public class ArraysSort {

    /*
        두 배열 합치기

        - 설명
        오름차순으로 정렬이 된 두배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.

        - 입력
        첫 번째 줄에 첫 번째 배열의 크기 N이 주어집니다.
        두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.
        세 번째 줄에 두 번째 배열의 크기 M이 주어집니다.
        네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.
        각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.

        - 출력
        오름차순으로 정렬된 배열을 출력한다.

        # 풀이방법
        - 2개의 배열을 한 배열로 합친 후, 자바 List 의 정렬 메서드 사용
        - TowPointer 알고리즘을 사용하여 정렬
            1.두 배열을 합친다.
            2.RP는 반복문을 탐색하며 제일 작은 값에 위치시키고, LP에 위치한 값과 자리를 교환한다.(LP는 0번 위치를 가르킨다.)
            3.RP는 LP와 같은 위치를 다시 바라보게한다.
            4.RP는 반복문을 탐색하며 제일 작은 값에 위치시키고, LP에 위치한 값과 자리를 교환한다.(LP는 1번 위치를 가르킨다.)
            5.RP는 LP와 같은 위치를 다시 바라보게한다.
            ..... 제일 작은 수들부터 앞에 위치시키는 방법.
     */

    public int[] solution(int[] arr1, int[] arr2){
        // 두개의 배열을 합쳐서 담아줄 배열을 만든다.
        int[] answer = new int[arr1.length + arr2.length];
        int count = 0;

        // 첫 번째 arr1 을 담아준다.
        for(int i = 0; i < arr1.length; i++){
            answer[i] = arr1[count++];
        }
        // 두 번째 arr2를 담아준다. 이때 첫번째 arr1가 먼저 담겨있으므로
        // count 변수를 사용해 그 다음 위치부터 값을 채워준다.
        for(int i = count; i < answer.length; i++){
            answer[i] = arr2[i-count];
        }

        int lp = 0;
        int rp = 0;

        for(int i = 0; i < answer.length; i++){
            // 비교를 위해 rp의 값으로 초기화한다.
            int num = answer[rp];
            for(int j = lp; j < answer.length; j++){
                // num보다 작은 값이 존재한다면 해당 위치를 rp에 저장, 값은 비교를 위해 num에 저장(제일 작은 수 찾기)
                if(answer[j] < num){
                    rp = j;
                    num = answer[j];
                }
            }
            // 제일 작은 값과 lp에 위치한 값의 자리교환
            int temp = answer[lp];
            answer[lp] = num;
            answer[rp] = temp;
            // lp는 다음 포인트(인덱스)를 가르킨다. 0, 1, 2, 3....
            lp++;
            // rp는 가장 작은 수를 바라보다가 다음 반복문에서는 다시 lp와 같은 위치를 바라보며 작은 값을 찾는다.
            rp = lp;
        }

        return answer;
    }

    public static void main(String[] args) {
        ArraysSort arraysSort = new ArraysSort();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] arr2 = new int[m];
        for(int i = 0; i < m; i++){
            arr2[i] = sc.nextInt();
        }

        int[] answer = arraysSort.solution(arr1, arr2);
        for(int i = 0; i < answer.length; i++){
            System.out.print(answer[i] + " ");
        }
    }
}
