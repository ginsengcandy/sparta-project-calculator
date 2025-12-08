package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //스캐너 준비
        Scanner sc =  new Scanner(System.in);
        //무한반복문 생성
            //입력을 받을 때마다 exit인지 검사. 조건이 참이면 프로그램 즉시 종료
        while (true) { //여기 안에서 입력-검사, 저장, 연산, 출력이 모두 이루어짐
            //0. 변수 선언
            String input;
            int num1 = 0;
            int num2 = 0;
            char op;
            // 1. 입력-검사(1/3)
            System.out.print("(1차) 0 또는 양의 정수를 입력하세요 : ");
            input = sc.nextLine(); //문자열로 입력받되
            if (input.equals("exit")) { //exit이면 종료하고
                System.out.println("계산을 종료합니다.");
                break;
            } else {
                while (true) {
                    try { //exit이 아니면
                        num1 = Integer.parseInt(input); //정수로 변환을 시도하되 성공하면 num1에 저장하고
                        /*test 커맨드*/
                        System.out.println("정수 변환 직후 num1값 = " + num1);
                        break; //1차 break문을 탈출하여 두 번째 정수를 입력받을 준비를 한다
                    } catch (NumberFormatException e) {
                        System.out.println("유효한 숫자를 입력하세요."); //잘못된 값을 입력하면 다시 input 받는 단계로 되돌아감
                        break;
                    } //catch문 종료
                }
                //입력 무한루프 종료
            } // else문 종료
            System.out.println("입력문 종료 후 입력된 num1 값 = " + num1);
        } //전체 무한루프 종료
    } //main함수 종료
} //main 클래스 종료
