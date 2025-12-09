package step2;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Calculator {
    private int result;
    private ArrayList<Integer> results;//연산 결과를 저장하는 ArrayList

    //생성자
    Calculator() {
        results = new ArrayList<Integer>();
    }

    //1. 0 이상의 정수 2개와 부호 1개를 받아 연산 결과를 출력하는 메서드
    public int calculate(int num1, int num2, char op) throws  InputMismatchException {
        // 2개의 양의 정수와 부호 입력받기
        try {
            switch (op) {
                case '+':
                    result = num1 + num2;
                    results.add(result);
                    break;
                case '-':
                    result = num1 - num2;
                    results.add(result);
                    break;
                case '*':
                    result = num1 * num2;
                    results.add(result);
                    break;
                case '/':
                    if (num2 == 0) throw new ArithmeticException();
                    result = num1 / num2;
                    results.add(result);
                    break;
                default:
                    System.out.println("입력이 잘못되었습니다. 연산을 수행할 수 없습니다.");
                    break;
            }
        } catch (ArithmeticException e) {
            System.out.println("0으로 나눌 수 없습니다.");
        }
        return result;
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
            for (int item : results) {
                System.out.print(item + " ");
            }
            System.out.println("\b]\n"); //리스트를 더 깔끔하게 출력
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }

    public void setItem(int index, int new_value) {
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
        } catch (IndexOutOfBoundsException e) {
            System.out.println("삭제할 항목이 없습니다.");
        }
    }
}
