package step2;
import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    int num1, num2;
    char op;
    ArrayList<Integer> results;//연산 결과를 저장하는 ArrayList

    //생성자
    Calculator() {
        results = new ArrayList<Integer>();
    }

    //1. 0 이상의 정수 2개와 부호 1개를 받아 연산 결과를 출력하는 메서드
    public void calculate() {
        // 2개의 양의 정수와 부호 입력받기
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("[1/2] 0 또는 양의 정수를 입력하세요 : ");
            num1 = scanner.nextInt();
            System.out.print("[2/2] 0 또는 양의 정수를 입력하세요 : ");
            num2 = scanner.nextInt();
            System.out.print("연산 부호를 입력하세요 (+, -, *, / 중 택1) : ");
            op =  scanner.next().charAt(0);
            try {
                int result;
                switch (op) {
                    case '+':
                        result = num1 + num2;
                        System.out.println(num1 + " + " + num2 + " = " + result);
                        results.add(result);
                        break;
                    case '-':
                        result = num1 - num2;
                        System.out.println(num1 + " - " + num2 + " = " + result);
                        results.add(result);
                        break;
                    case '*':
                        result = num1 * num2;
                        System.out.println(num1 + " * " + num2 + " = " + result);
                        results.add(result);
                        break;
                    case '/':
                        if (num2 == 0) throw new ArithmeticException();
                        result = num1 / num2;
                        System.out.println(num1 + " / " + num2 + " = " + result);
                        results.add(result);
                        break;
                    default:
                        System.out.println("입력이 잘못되었습니다. 연산을 수행할 수 없습니다.");
                        break;
                }
            } catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.");
            }
            System.out.print("아무 키나 누른 뒤 Enter를 눌러 계속하세요 \n (종료 : exit 입력) : ");
            Scanner sc = new Scanner(System.in);
            String response = sc.next();
            if (response.equals("exit")) {
                System.out.println("계산기가 종료되었습니다.");
                break;
            }
        }
    }

    public void getItem(int index){
        try {
            if(results.isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            System.out.println((index+1) + "번째 결과 조회 : " + results.get(index));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }

    public void getItem(){
        try {
            if(results.isEmpty()){
                throw new IndexOutOfBoundsException();
            }
            System.out.print("전체 연산 결과 조회 : ");
            for(int item : results){
                System.out.print(item + ", ");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("저장된 연산 결과가 없습니다.");
        }
    }
}
