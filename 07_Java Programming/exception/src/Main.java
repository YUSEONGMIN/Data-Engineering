public class Main {
    public static void main(String[] args) {
        int a, b, c;
        try {
            a = 10;
            b = 0;
            c = a/b; // 0으로 나눌시 오류 발생
            System.out.println("c: " + c);

        } catch(ArithmeticException e) {
            String msg = e.getMessage();
            System.out.println("오류 발생: " + msg);
        }
    }
}
