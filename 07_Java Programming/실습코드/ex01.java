import java.util.Arrays;
import java.util.HashSet;

public class ex01 {
    // main 함수는 보통 프로젝트 당 하나
    public static void main(String[] args) {
        // HashSet<String> set = new HashSet<>(Arrays.asList("H","e","l","l","o")); // 파이썬 __init__ = 자바 new
        // System.out.println(set); // 연산 빠름

        HashSet<Integer> s1 = new HashSet<>(Arrays.asList(1,2,3,4,5,6,7));
        HashSet<Integer> s2 = new HashSet<>(Arrays.asList(4,5,6,7,8,9,10));

        // intersection -> s1과 데이터가 같은 객체 # 파이썬 copy 개념
        HashSet<Integer> intersection =  new HashSet<>(s1);
        // retainAll 교집합 함수
        intersection.retainAll(s2);
        System.out.println(intersection);

        HashSet<Integer> union = new HashSet<>(s1);
        // addAll 합집합
        union.addAll(s2);
        System.out.println(union);
    }
}
