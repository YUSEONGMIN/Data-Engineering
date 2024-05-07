import java.util.Random;

public class ex02 {
    public static void main(String[] args) {
        // System.out.println("Hello World");
        // System.out.println(30*30);

        /*
            * %s: 문자열
            * %d: 정수
            * %f: 실수
            * \n: 줄바꿈
            */

        // System.out.printf("저의 이름 %s입니다. \n나이는 %d살,\n키는 %f cm 입니다.", "홍길동", 20, 180.5f);
        // String name = "홍길동";
        // int age = 20;

        // String str = String.format("저의 이름 %s입니다. \n나이는 %d살,\n키는 %f cm 입니다.", name, age, 180.5f);
        // System.out.println(str);

        // System.out.println(Math.max(10, 30));
        // System.out.println(Math.min(10, 30));
        // System.out.println(Math.abs(-30));

        // System.out.println(Math.ceil(10.2));
        // System.out.println(Math.floor(10.9));
        // System.out.println(Math.round(10.4));
        
        Random rand = new Random();
        // 0 ~ 9 사이의 랜덤한 정수를 하나 추출
        int r1 = rand.nextInt(10);
        System.out.println(r1);

        // 10 ~ 19 사이의 랜덤한 정수를 하나 추출
        // .nextInt(10, 20) 또는 r1 + 10
    } 
}
