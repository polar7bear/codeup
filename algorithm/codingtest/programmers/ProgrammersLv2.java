package algorithm.codingtest.programmers;

import java.io.IOException;
import java.util.*;

public class ProgrammersLv2 {
    public String solution1(String s) {
        //최댓값과 최솟값
        String answer = "";
        StringTokenizer st = new StringTokenizer(s, " ");

        int[] arr = new int[st.countTokens()];

        for(int i = 0; i <arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = arr[0];
        int max = arr[0];

        for(int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        answer = min + " " + max;

        return answer;
    }

    public String solution2(String s) {
        //JadenCase 문자열 만들기
        String answer = "";
        String[] arr = s.split(" ");

        for(int i=0; i<arr.length; i++) {
            String now = arr[i];

            if(arr[i].length() == 0) {
                answer += " ";
            }
            else {
                answer += now.substring(0, 1).toUpperCase();
                answer += now.substring(1, now.length()).toLowerCase();
                answer += " ";
            }

        }

        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }

        return answer.substring(0, answer.length()-1);
    }

    public int solution3(int[] A, int[] B) {
        //각 배열에서 각 숫자를 뽑아 곱하는 것을 배열의 길이만큼(3번) 반복한다. 그리고 최적의 낮은 수를 출력해라
        //배열 하나에서는 가장 낮은 수를 선택하고 또 다른 배열에서는 가장 높은수를 선택하여 두 수를 곱하는것이 가장 최적의 해일것임.
        //가장 낮은 수를 선택하는 배열은 오름차순, 높은 수를 선택하는 배열은 내림차순을 해보자
        //예를 들어, 1 x 5, 4 x 4, 4 x 2 최적의 해는 29이다. 이것만 봐도 그리디 알고리즘 문제라는 것을 추측 해볼 수 있음.
        //그리고 한번씩만 뽑아 곱할 수 있음.
        int sum = 0;
        int min = B[0];

        //오름차순은 sort 메서드를 사용하자..
        Arrays.sort(A);

        //배열 b 내림차순 (버블정렬)
        //시간초과..
        //플랜 b로는 b도 a와 같이 오름차순 정렬하여 b의 마지막 요소부터 거꾸로 곱해주자 ps. 속도가 느린 버블정렬말고 비교적 빠른 선택, 삽입 정렬 등을 배워보자..
        /*for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length - i - 1; j++) {
                if (b[j] < b[j + 1]) {
                    min = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = min;
                }
            }
        }*/

        Arrays.sort(B);

        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length - 1 - i];
        }
        return sum;
    }

    boolean solution4(String s) {
        //올바른 괄호
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                stack.push(ch);   //만약 (가 나오면 스택에 push 한다
            } else if(i == 0 && ch == ')') {    // 첫 인덱스에 )가 들어오면 괄호가 닫힐 수 없으니 바로 false를 리턴
                return false;
            } else {            //)가 나오면 원래있던 (를 pop해준다.
                if(stack.empty()) return false;
                stack.pop();
            }
        }
        boolean answer = (stack.empty()) ? true : false;    // 만약 스택이 비어있다면 괄호가 올바르게 짝지어졌다는 것이다.
        return answer;
    }
}
