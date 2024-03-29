public class ex06 {
    public static void main(String[] args) {
        for (int i=2; i<10; i++) {
            for (int j=1; j<10; j++) {
                // System.out.printf("%d * %d = %d\n", i,j,i*j);
            }
            // System.out.println("----------------");
        }
        // gugu_Iseven(11,false);
        ex06 a = new ex06();
        a.gugu_new(3);
    }


    public static void gugu(int num) {
        for (int i=1; i<10; i++) {
            System.out.printf("%d * %d = %d\n", num,i,num*i);
        }
    }
    public void gugu_new(int num) {
        for (int i=1; i<10; i++) {
            System.out.printf("%d * %d = %d\n", num,i,num*i);
        }
    }

    public static void gugu_ver2(int num, boolean iseven) {
        for (int i=1; i<10; i++) {
            if (iseven == true) {
                System.out.printf("%d * %d = %d\n", num,i,num*i*2);
            } else if (iseven == false) {
                System.out.printf("%d * %d = %d\n", num,i,num*i*3);
            }
        } System.out.println("===============");
    }

    public static void gugu_Iseven(int num, boolean iseven) {
        for (int i=2; i<num+1; i++) {
            if (iseven == true && i%2 == 0) {
                gugu_ver2(i, iseven);
            } else if (iseven == false && i%2 != 0) {
                gugu_ver2(i, iseven);
            }
        }
    }
}