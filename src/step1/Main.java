package step1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 2개의 양의 정수와 부호 입력받기
        while(true){
            System.out.print("[1/2] 0 또는 양의 정수를 입력하세요 : ");
            int num1 = scanner.nextInt();
            System.out.print("[2/2] 0 또는 양의 정수를 입력하세요 : ");
            int num2 = scanner.nextInt();
            System.out.print("연산 부호를 입력하세요 (+, -, *, / 중 택1) : ");
            char op =  scanner.next().charAt(0);
            //입력받은 정수와 부호로 간단한 계산하기
            int result;
            switch(op) {
                case '+':
                    result =  num1 + num2;
                    System.out.println("연산 결과 : " + result);
                    break;
                case '-':
                    result =  num1 - num2;
                    System.out.println("연산 결과 : " + result);
                    break;
                case '*':
                    result =  num1 * num2;
                    System.out.println("연산 결과 : " + result);
                    break;
                case '/':
                    if(num2 == 0) {
                        System.out.println("0으로 나눌 수 없습니다.");
                        break;
                    }
                    result = num1 / num2;
                    System.out.println("연산 결과 : " + result);
                    break;
                default:
                    System.out.println("올바른 문자를 입력하세요.");
                    break;
            }
            System.out.print("다시 계산하시겠습니까? 'exit' 를 입력하여 종료 : ");
            String response = scanner.next();
            if(response.equals("exit")){
                System.out.println("계산기가 종료되었습니다.");
                break;
            }
        }
    } //main함수 종료
} //main 클래스 종료
