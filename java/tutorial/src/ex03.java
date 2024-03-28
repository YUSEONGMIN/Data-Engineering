// import java.util.Scanner;

public class ex03 {
    public static void main(String[] args) {
        // if(true) {
        //     // 참인 경우
        //     System.out.println("참 True");
        // } else {
        //     System.out.println("거짓 False"); // if(true)이면 else 조건이 절대 실행 안된다고 경고
        // }

        // int i = 10;

        // if(i < 10) {
        //     // 참인 경우
        //     System.out.println("참 True");
        // } else {
        //     System.out.println("거짓 False");
        // }

        // // 1 if True else 0
        // boolean isMarried = true; // 변수가 bool 타입이면 변수명은 보통 is___로 시작
        // // String str = isMarried ? "Yes" : "No";

        // if (isMarried) {
        //     System.out.println("Yes");
        // } else {
        //     System.out.println("No");
        // }

        // boolean isMarried = true;
        // boolean isOld = false;
        // int i = 10;
        // String str;

        // if (isMarried && isOld) { // 첫번째 조건은 가장 좁은 조건. 만약 isMarried || isOld 이면 가장 넓은 조건이라 안좋은 코드
        //     str = "1";
        // } else if (isMarried || isOld) {
        //     str = "2";
        // } else if (!isMarried) {
        //     str = "3";
        // } else {
        //     str = "4";
        // }

        // if (i < 100) {
        //     str = "1";
        // } else if (i < 50) {
        //     str = "2";
        // } else if (i > 200) {
        //     str = "3";
        // } else {
        //     str = "4";
        // }

        // System.out.println(str);

        int month = 3;
        // String monthString = "";

        // Scanner sc = new Scanner(System.in);
        // int month = sc.nextInt();
        String monthString;

        // switch (month) {
        //     case 1: monthString = "January";
        //         break;
        //     case 2: monthString = "Feb";
        //         break;
        //     case 3: monthString = "Mar";
        //         break;
        //     default: monthString = "Invalid month";
        //         break;
        // }
        // System.out.println(monthString);

        if (month == 1) {
            monthString = "Jan";
        } else if (month == 2) {
            monthString = "Feb";
        } else if (month == 3) {
            monthString = "Mar";
        } else {
            monthString = "Invalid month";
        }
        System.out.println(monthString);

    }
}
