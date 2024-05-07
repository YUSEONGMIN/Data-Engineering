package Exception;

public class Custom_Exception {
    public static void hello(String msg) throws YesException, NoException {
        if ("Yes".equals(msg)) {
            throw new YesException();
        } else if ("No".equals(msg)) {
            throw new NoException();
        } else {
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        try {
            hello("hi");
            // hello("Yes");
            hello("No");
        } catch (YesException e) {
            System.out.println("Error Yes");
        } catch (NoException e) {
            System.out.println("Error No");
        }
    }
}