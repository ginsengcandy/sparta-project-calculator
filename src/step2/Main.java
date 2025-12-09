package step2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("계산기 시작");
        Scanner scanner = new Scanner(System.in);
        Calculator calc1 = new Calculator();
        while (true) {
            try {
                System.out.print("[1/2] 음이 아닌 정수를 입력하세요 : ");
                int num1 = scanner.nextInt();
                System.out.print("[2/2] 음이 아닌 정수를 입력하세요 : ");
                int num2 = scanner.nextInt();

                System.out.print("연산 부호를 입력하세요 (+, -, *, / 중 택1) : ");
                char op = scanner.next().charAt(0);

                int result1 = calc1.calculate(num1, num2, op); //연산 수행
                System.out.println("연산 결과 : " + result1);
            } catch (InputMismatchException e) {
                System.out.println("인수를 잘못 입력했습니다.");
                scanner.nextLine(); //버퍼 비워주기
            } // catch문 종료
            System.out.print("계속하겠습니까? (종료는 'exit' 입력) : ");
            String answer = scanner.next();
            if (answer.equals("exit")) {
                break;
            } //if문 종료
        } //무한루프 종료
        calc1.getItem(0);
        calc1.deleteFirstItem();
//            calc1.getItem(1);
//            calc1.getItem(2);
//        calc1.getItem();
//        calc1.setItem(0, 100);
//        calc1.getItem(0);
    }
}
