public class ex05 {
    public static void main(String[] args) {
        // 2단부터 9단까지 출력. 단 포맷은 
        /*
         * 2 * 1 = 2
         * 2 * 2 = 4
         */
        
        // for (int j=1; j<10; j++) {
        //     for (int i=2; i<10; i++) {
        //         System.out.printf("%d * %d = %d\t", i, j, i*j);
        //         if (i == 9) {
        //             System.out.println(' ');
        //         }
        //     }
        // }

        // // While 문 사용해보기
        // int i = 1;
        // int j = 1;
        // while (i++ < 9) {
        //     j = 1;
        //     while (j < 10) {
        //         System.out.printf("%d * %d = %d\n", i, j, i*j);
        //         j++;
        //     }
        //     System.out.println();
        // }

        /*
         * 문제: 짝수 구구단 (2,4,6,8) 구현 -> 2 * 1 = 2
         * 필요한 변수:
         * - 변수명: 값 정의
         * 함수
         * if 문은 짝수 필터링
         * - for 문 사용 이유
         */

        // for (int i=2; i<10; i++) {
        //     // 검증
        //     if (i%2 != 0) {
        //         continue;
        //     }
        //     // 비즈니스
        //     for (int j=1; j<10; j++) {
        //         System.out.printf("%d * %d = %d\n", i, j, i*j);
        //     }
        //     System.out.printf("-----%d단-----\n",i);
        // }
        // // 검증용과 비즈니스용을 따로 만들어두면 모듈화하기 쉬움
        // // 실무는 조건이 자주 바뀌어서 if 문 안에 for 문을 넣으면 번거로움
        
        // ex05 x = new ex05(); // static을 안쓸 경우
        // x.getName1();
        // getName1();
        // String str = getName3();
        // System.out.println(str);

        // gugu(1);
        // gugudan_small(20);
        gugudan(15, 0);
}


        // 함수
        // public 일반 함수
        // 자바 private == 파이썬 .__함수__
        // 결과 void(= None) 또는 String 등, 함수명(타입, argument)
        public static void getName1() { // static은 자원을 소모함 (최소한으로 사용)
            System.out.println("홍길동");
        }

        public static void getName2(String name) {
            System.out.println(name);
        }

        public static String getName3() {
            return "홍길동";
        }

        public static String getName4(String name) {
            return name;
        }

        /*
         * 문제: 짝수 구구단 프린트
         * 
         * 1. 검증
         * 2-1. 최소한의 변수값 수정을 통해서 홀수 구구단 프린트
         * 2-2. 짝수: 결과값 * 2
         *      홀수: 결과값 * 3
         */

        public static void gugu(Integer num) { // 0: 짝수만, 1: 홀수만
            for(int i=2; i<10; i++) {
                if(i % 2 != num) {
                    continue;
                }
    
                for(int j=1; j<10; j++) {
                    System.out.printf("%d * %d = %d\n", i, j, i*j);
                }
            }
        }

        // 구구단 하나만 print
        public static void gugudan_small(int i, int isEven) {
            for(int j=1; j<10; j++) {
                if (isEven==0) {
                    System.out.printf("%d * %d = %d\n", i, j, i*j*2);
                } else if (isEven==1) {
                    System.out.printf("%d * %d = %d\n", i, j, i*j*3);
                } else if (isEven==2) {
                    System.out.printf("%d * %d = %d\n", i, j, i*j);
                }
            }
        }

        // 짝수/홀수 판단
        public static void gugudan(int num, int isEven) {
            for (int i=2; i<num+1; i++) {
                if (isEven==0 && i%2 == 0) {
                    gugudan_small(i, isEven); System.out.println();
                } else if (isEven==1 && i%2 != 0) {
                    gugudan_small(i, isEven); System.out.println();
                } else if (isEven==2) {
                    gugudan_small(i, isEven); System.out.println();
                }
            }
        }

    }
