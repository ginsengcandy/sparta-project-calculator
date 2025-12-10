package step3;

import java.util.InputMismatchException;

public enum Operators {
    //속성
    PLUS("+"), //4개의 연산만 가능하도록 설계
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String symbol;

    //생성자
    Operators(String symbol) {
        this.symbol = symbol;
    }

    //기능
        //getter
    public String getSymbol() {
        return symbol;
    }
        //setter는 생성 시 만든 값을 바꿀 수 없으므로 사용 x : private final String symbol;

    //Enum을 순회하면서 일치하는 값이 있는지 확인
        //부호 검사 및 String을 Enum으로 변환
        //Enum 클래스 자체에 속하는 기능이므로 인스턴스를 만들지 않고도 사용할 수 있도록 static으로 선언하는 것이 필요
    public static Operators testSymbol(String symbol) throws IllegalArgumentException {
            for (Operators op : values()) { //values() : Enum 클래스가 가지고 있는 모든 상수 값을 배열의 형태로 리턴
                if (op.getSymbol().equals(symbol)) {
                    return op;
                }
            } //for문이 다 끝날때까지 나오지 않으면
            throw new IllegalArgumentException(); //예외 전파
    }
}
