package step1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 2개의 양의 정수와 부호 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.print("[1/2] 0 또는 양의 정수를 입력하세요 : ");
        int a = scanner.nextInt();
        System.out.print("[2/2] 0 또는 양의 정수를 입력하세요 : ");
        int b = scanner.nextInt();
        System.out.print("연산 부호를 입력하세요 (+, -, *, / 중 택1) : ");
        char op =  scanner.next().charAt(0);

        //입력받은 정수와 부호로 간단한 계산하기
        int result;
        switch(op) {
            case '+':
                result =  a + b;
                System.out.println("연산 결과 : " + result);
                break;
            case '-':
                result =  a - b;
                System.out.println("연산 결과 : " + result);
                break;
            case  '*':
                result =  a * b;
                System.out.println("연산 결과 : " + result);
                break;
            case '/':
                if(b == 0) {
                    System.out.println("0으로 나눌 수 없습니다.");
                    break;
                }
                result =   a / b;
                System.out.println("연산 결과 : " + result);
                break;
            default:
                System.out.println("올바른 문자를 입력하세요.");
                break;
        }
    } //main함수 종료
} //main 클래스 종료
