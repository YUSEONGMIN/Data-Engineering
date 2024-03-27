public class Exception1 {
    public static void main(String[] args) {
        int a, b, c;
        try {
            a = 10;
            b = 5;
            // b = 0;
            c = a/b; // 0으로 나눌시 오류 발생
            System.err.println("c: " + c);

        } catch(ArithmeticException e) {
            String msg = e.getMessage();
            System.err.println("오류 발생: " + msg);
        } catch(Exception e) {
            System.err.println("Exception 오류 발생");
        } finally {
            System.err.println("오류발생 관계없이 실행");
        }
    }
}
