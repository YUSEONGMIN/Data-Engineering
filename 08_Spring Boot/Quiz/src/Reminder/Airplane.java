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

public class Airplane implements Abstract {
    public int health = 30;
    public String name;

    public Airplane(String name) {
        this.name = name;
    }

    public boolean dodge(boolean isAtk) {
        if (isAtk == false) {
            System.out.printf(this.name + " 회피성공\n");
            return true;
        } else {
            // System.out.printf(this.name+" 회피실패\t");
            return false;
        }
    }

    @Override
    public boolean atk() {
        double succes = Math.random();
        System.out.printf(this.name + " 공격 / 확률: " + Math.round(succes * 100) / 100.0 + "\n");
        if (succes >= 0.5) {
            System.out.printf(this.name + " 공격성공(+4)\t");
            this.health += 4;
            if (this.health >= 30) {
                this.health = 30;
            }
            return true;
        }
        System.out.printf(this.name + " 공격실패\t");
        return false;
    }

    @Override
    public boolean def(boolean isDodge) throws Exception {
        System.out.printf(this.name + " 체력감소(-10)\n");
        this.health -= 10;
        if (this.health <= 0) {
            System.err.printf(this.name + " 체력: " + this.health + "\t");
            System.err.printf(this.name + " 패배. 게임종료");
            throw new Exception();
        }
        return true;
    }
}
