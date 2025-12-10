package step3;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Calculator<T extends Number> {
    //제네릭이지만 최소한 Number 클래스의 하위 클래스여야 값을 읽어올 수 있음
    private double result; //일단 값은 double로 출력
    private ArrayList<Double> results;//연산 결과를 저장하는 ArrayList

    //생성자
    Calculator() {
        results = new ArrayList<Double>();
    }

    //1. 0 이상의 정수 2개와 부호 1개를 받아 연산 결과를 출력하는 메서드
    //calculate는 String을 바로 받는 것이 아니라 Operator.testSymbol() 메서드를 거치고 필터링된 enum 타입을 전달받음
    public double calculate(T num1, T num2, Operators op) throws  InputMismatchException {

        //Number 타입임을 활용, 계산 가능한 형태로 변경
        double value1 = num1.doubleValue();
        double value2 = num2.doubleValue();
        double result;
        switch (op) {
            case PLUS:
                result = value1 + value2;
                results.add(result);
                return result;
            case MINUS:
                result = value1 - value2;
                results.add(result);
                return result;
            case MULTIPLY:
                result = value1 * value2;
                results.add(result);
                return result;
            case DIVIDE:
                if (value2 == 0.0)
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                result = value1 / value2;
                results.add(result);
                return result;
            default:
                throw new IllegalStateException("알 수 없는 연산자입니다");
        }
    }

    public void getItem(int index) {
        try {
            if (results.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            System.out.println((index + 1) + "번째 결과 조회 : " + results.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }

    public void getItem() {
        try {
            if (results.isEmpty()) {
                throw new IndexOutOfBoundsException();
            }
            System.out.print("전체 연산 결과 조회 : [");
            for (double item : results) {
                System.out.print(item + " ");
            }
            System.out.println("\b]\n"); //리스트를 더 깔끔하게 출력
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }

    public void setItem(int index, double new_value) {
        try {
        results.set(index, new_value);
        System.out.println((index + 1) + "번째 연산결과가 " + new_value + "으로 업데이트됐습니다.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }

    public void deleteFirstItem() {
        try {
        results.remove(0);
        System.out.println("첫번째 연산결과가 삭제되었습니다.");
        this.getItem(); //삭제 후 결과 출력(되려나?)
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 항목이 없습니다.");
        }
    }
}
