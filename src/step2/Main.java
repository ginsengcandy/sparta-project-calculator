package step2;

public class Main {
    public static void main(String[] args) {
        System.out.println("계산기 시작");
        Calculator calc1 = new Calculator();
        calc1.calculate();
        calc1.getItem(0); //단일 계산결과 조회
        calc1.getItem(); //저장된 모든 계산결과 조회
    }
}