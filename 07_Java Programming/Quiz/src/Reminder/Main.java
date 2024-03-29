package Reminder;

/*
# 사용해야할 기술들
- 객체지향 프로그래밍
- 예외처리
# 문제
- 추상화
    - 함수 공격
    - 함수 수비
- 클래스
    - 비행기
        - 함수 회피 > 공격을 받을 시 50% 확률로 회비하기
            - 회피 실패시 수비함수 실행 및 리턴값으로 false
            - 회피 성공시 리턴값으로 true
        - 함수 공격 > 상대 비행기 공격
            - 공격 성공시(회피 리턴이 true), 체력 4만큼 증가
                - 체력이 30이상이면, 증가하지 않음
        - 함수 수비 > 공격을 받을 시 10만큼 체력 감소
            - 회비를 하지 못할 시 수비함수 실행
            - 체력이 0 이하로 내려가면, 오류 발생
- main 함수
    - 2개의 서로다른 비행기 생성
    - for문을 이용해서 각 비행기별로 한번씩 공격을 진행
        - 하나의 비행기가 체력이 0이 될때까지 진행
 */
public class Main {
    public static void main(String[] args) {
        // A1이 B1 공격 -> 회피 성공/실패 (50%). 회피 성공시 return true
        Airplane A1 = new Airplane("A1");
        Airplane B1 = new Airplane("B1");

        for (int i = 0; i < 20; i++) {
            System.out.println("==========================================");
            System.out.printf("%s 체력: %d\t", A1.name, A1.health);
            System.out.printf("%s 체력: %d\n", B1.name, B1.health);
            // 50% 확률로 성공|실패 -> 성공시 체력 +4 (최대 30)
            // return: true이면 A1 공격 성공이므로 B1 회피실패
            boolean b1 = B1.dodge(A1.atk());
            // 회피 실패시 false 반환 -> 수비함수 실행
            try {
                if (b1 == false) {
                    B1.def(b1);
                }
            } catch (Exception e) {
                break;
            }
            System.out.println("==========================================");
            System.out.printf("%s 체력: %d\t", A1.name, A1.health);
            System.out.printf("%s 체력: %d\n", B1.name, B1.health);
            boolean a1 = A1.dodge(B1.atk());
            try {
                if (a1 == false) {
                    A1.def(a1);
                }
            } catch (Exception e) {
                break;
            }
        }
    }
}
