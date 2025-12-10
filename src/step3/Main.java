package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

//양의 정수만 받을 수 있었지만, 이제부터는 실수도 받을 수 있게 수정한다.(제네릭)
    //ArithmeticCalculator 클래스의 연산 메서드(calculate)가
    //피연산자를 여러 타입으로 받을 수 있도록 기능을 확장

//결과가 저장되어 있는 컬렉션을 조회하고, 특정 값보다 큰 결과 값을 출력할 수 있도록 한다.
    //단, 해당 메서드를 구현할 때 Lambda & Stream을 활용하여 구현합니다.

//Enum 타입을 활용하여 연산자 타입에 대한 정보를 관리하고 이를 사칙연산 계산기 ArithmeticCalculator 클래스에 활용 해봅니다.

public class Main {
    public static void main(String[] args) {
        System.out.println("계산기 시작");
        Scanner scanner = new Scanner(System.in);
        Calculator calc1 = new Calculator();
        while (true) {
            try {
                System.out.print("[1/2] 첫 번째 숫자를 입력하세요 : ");
                int num1 = scanner.nextInt();
                System.out.print("[2/2] 두 번째 숫자를 입력하세요 : ");
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
//      calc1.getItem(1);
//      calc1.getItem(2);
//      calc1.getItem();
//      calc1.setItem(0, 100);
//      calc1.getItem(0);
    }
}
