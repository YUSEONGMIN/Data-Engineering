public class func {
    public static void main(String[] args) {
        getFnc2("길동", 20); System.out.println();
        getFnc2("승동", null); System.out.println();
        
        System.out.println(getFnc3());
        System.out.println(getFnc4("길동", 20));
    }


    // input X / output X
    public static void getFnc1() {
        System.out.println("Hello World");
    }

    // input O / output X
    public static void getFnc2(String name, Integer age) {
        if (name == "길동") {
            name = "임당";
        }
        System.out.printf("내 이름은 %s, 나이는 %d", name, age);
    }

    // input X / output O
    public static String getFnc3() {
        String name = "길동";
        Integer age = 20;
        return String.format("내 이름은 %s, 나이는 %d", name, age);
    }

    // input O / output O
    public static String getFnc4(String name, int age) {
        if (name == "길동") {
            name = "임당";
        }
        return String.format("내 이름은 %s, 나이는 %d", name, age);
    }
}