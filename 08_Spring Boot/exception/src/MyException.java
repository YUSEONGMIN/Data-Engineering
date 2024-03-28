public class MyException {
    public static void sayNick (String nick) throws FoolException {
        if ("바보".equals(nick)) {
            throw new FoolException();
        }
        System.err.println("당신의 별명은 " + nick);
    }

    public static void main(String[] args) {
        try {
            sayNick("코딩");
            sayNick("바보"); // 오류 발생. 아래 스킵
            sayNick("토끼");
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println("오류 발생");
        }
    }
}