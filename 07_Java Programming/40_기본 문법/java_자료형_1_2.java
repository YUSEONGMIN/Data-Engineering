import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class java_자료형_1_2 {
    
    public static void main(String[] args) throws Exception {
        // 변수 선언 (정수)
        // int x = 50;
        // long x1 = 50L; // long은 뒤에 L 붙이기

        // // 변수 재정의 (파이썬과 같음)
        // x = 40;

        // 변수 선언 (실수)
        // double y = 3.14;
        // float y1 = 3.14f; // float는 뒤에 f 붙이기

        // 정수 -> 실수
        // double y = (double)x;

        // // 실수 -> 정수
        // int z = (int)y;

        // // bool
        boolean x = true;

        // // string
        // String y = "Hello World";

        // bool -> int
        // 삼항 다항식
        int x1 = x ? 1 : 0;
        System.out.println(x1);

        // string -> int
        String y = "10";
        int y1 = Integer.parseInt(y);
        System.out.println(y1);

        // // 실행을 하지 않아도 경고
        // For input string: "aa"
        // String z = "aa";
        // int z1 = Integer.parseInt(z);

        // array -> int[]
        // array는 크기를 미리 정의
        int[] arr1 = { 1, 2, 3, 4, 5, 6, 7 }; // 5개를 미리 선언한 것과 같음
        System.out.println(Arrays.toString(arr1));

        // for(int i=0; i<5; i++) {
        // System.out.println(arr1[i]);
        // }

        // for(int i=0; i<arr1.length; i++) {
        // System.out.println(arr1[i]);
        // }

        // 리스트는 값 추가 가능
        List<Integer> lst1 = new ArrayList<>();
        lst1.add(1);
        lst1.add(2);

        // Map (파이썬 딕셔너리)
        // Map<String, String> dic = new HashMap<>();
        // dic.put("name", "홍길동");
        // dic.put("age", "11"); // 11 숫자는 안됨 -> String 선언

        Map<String, Object> dic = new HashMap<>();
        dic.put("name", "홍길동");
        dic.put("age", 11); // Object는 다 가능

        // System.out.println("Hello, World!");
        // System.out.println(x);
        // System.out.println(y);
        // System.out.println(x1);
        // System.out.println(y1);
        // System.out.println(x*y);
        // System.out.println(x1);
        // System.out.println(y1);
        // System.out.println(arr1[0]); // 파이썬과 같음
        // System.out.println(lst1.get(0)); // 리스트는 get 이용
        System.out.println(dic.get("name"));
        System.out.println(dic.get("age"));

    }
}
