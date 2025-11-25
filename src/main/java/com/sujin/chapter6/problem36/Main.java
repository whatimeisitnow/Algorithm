package com.sujin.chapter6.problem36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        // 문자열로 수식 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String formula = br.readLine();
//        System.out.println(formula);

        // 한 글자 단위로 쪼개서 배열(arr)에 넣기
        StringTokenizer st = new StringTokenizer(formula);
        String [] arr =  st.nextToken().split("-");

//        System.out.println(Arrays.toString(arr));

        // 양수로만 만들었기 때문에 첫번째 뭉탱이 값은 무조건 양수
        //이후 "-"기준으로 쪼갠걸 다 계산후 빼주기만 하면됨. 첫번째는 정수로 미리 만들어둠
        String [] positive = arr[0].split("\\+");
        int first = Arrays.stream(positive).mapToInt(Integer::parseInt).sum();
//        System.out.println(first);

        // arr의 2번째부터 다시 + 기준으로 쪼개고 숫자로 바꿔서 더하기 연산 해서 하나의 숫자로 만듦
        for(int i=1; i<arr.length; i++){
            String [] num = arr[i].split("\\+");
            int sum = Arrays.stream(num).mapToInt(Integer::parseInt).sum();
//            System.out.println(sum);
            first -= sum;
        }

        System.out.println(first);

    }
}
