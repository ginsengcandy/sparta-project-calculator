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
        Calculator<Double> doubleCalculator = new Calculator<>(); //무한루프 종료 이후에 메서드 활용할 수 있도록
        while (true) {
            try {
                System.out.print("[1/2] 첫 번째 숫자를 입력하세요 : ");
                Double num1 = scanner.nextDouble(); //이젠 Double로 받음
                System.out.print("[2/2] 두 번째 숫자를 입력하세요 : ");
                Double num2 = scanner.nextDouble(); //이젠 Double로 받음
                System.out.print("연산 부호를 입력하세요 (+, -, *, / 중 택1) : ");
                //기존에는 scanner.next.charAt(0);를 통해 문자 하나만 가져오도록 했으나,
                //String으로 받음으로서 "+-", "/.;" 등과 같이 첫글자만 올바른 입력까지도 걸러내도록 함.
                String opInput = scanner.next(); //Sting을 enum으로 바꿔줘야 함
                Operators op = Operators.testSymbol(opInput); //Operators 타입 변수 op에 저장 완료
                //계산기 객체 생성 후 계산 시작
                doubleCalculator.calculate(num1, num2, op); //연산 수행 & 출력
            } catch (InputMismatchException e) {
                System.out.println("인수를 잘못 입력했습니다.");
                scanner.nextLine(); //버퍼 비워주기
            } catch (IllegalArgumentException e){
                System.out.println("잘못된 연산자입니다.");
                scanner.nextLine(); //버퍼 비워주기
            }// catch문 종료
            System.out.print("계속하겠습니까? (종료는 'exit' 입력) : ");
            String answer = scanner.next();
            if (answer.equals("exit")) {
                break;
            } //if문 종료
        } //무한루프 종료
        doubleCalculator.showBiggerItem();
    }//메인함수 종료
}
