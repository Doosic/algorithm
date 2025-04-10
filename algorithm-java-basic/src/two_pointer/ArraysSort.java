package two_pointer;

import java.util.Arrays;
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
            2.제일 작은 값을 LP 에 배치한다.(LP는 0번 위치를 가르킨다.)
            3.그 다음 작은 값을 두 번째에 배치한다.(LP는 1번 위치를 가르킨다.)
            .....
     */

    public int[] solution(int[] arr1, int[] arr2){
        int[] answer = new int[arr1.length + arr2.length];
        int count = 0;

        for(int i = 0; i < arr1.length; i++){
            answer[i] = arr1[count++];
        }
        for(int i = count; i < answer.length; i++){
            answer[i] = arr2[i-count];
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
