public class Throw { // 에러를 외부에서 처리
    // catch는 내부에서 직접 처리
    public static void isError1(int i) throws Exception {
        int result = 10/i;
        System.out.println("result: " + result);
    }

    public static void isError2(int i) {
        try {
            int result = 10/i;
            System.out.println("result: " + result);
        } catch (Exception e) {
            // handle exception
            System.out.println("isError2 > Exception >" + e);
        } 
    }

    public static void main(String[] args) {
        // isError1(2); // throws를 쓰려면 try catch 구문을 사용할 것
        try {
            System.out.println("=== isError1 ===");
            isError1(2);

            System.out.println("=== isError2 ===");
            isError2(2);

            // 에러 발생
            System.out.println("=== isError1 ===");
            isError1(0); // throws Exception 발동 -> 아래 작동 X
            
            System.out.println("=== isError2 ===");
            isError2(0); // 이걸 isError1 보다 먼저 한다면 모두 출력
        } catch (Exception e) {
            // handle exception
            System.out.println("main > Exception > " + e);
        }

    }
}
