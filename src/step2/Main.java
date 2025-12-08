package step2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("계산기 시작");
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("[1/2] 음이 아닌 정수를 입력하세요 : ");
            int num1 = scanner.nextInt();
            System.out.print("[2/2] 음이 아닌 정수를 입력하세요 : ");
            int num2 = scanner.nextInt();
            System.out.print("연산 부호를 입력하세요 (+, -, *, / 중 택1) : ");
            char op =  scanner.next().charAt(0);
            Calculator calc1 = new Calculator();
            int result1 = calc1.calculate(num1, num2, op);
            System.out.println("연산 결과 : " + result1);
            System.out.println("계속하겠습니까? : 종료는 'exit' 입력");
            String answer = scanner.next();
            if(answer.equals("exit")){
                break;
            }
        }
    }
}