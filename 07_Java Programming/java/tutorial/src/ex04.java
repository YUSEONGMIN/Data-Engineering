public class ex04 {
    public static void main(String[] args) {
        // for (int i=0; i<10; i++) {
        //     System.out.println(i);
        // }

        // int i = 0;
        // while(i<10) {
        //     System.out.println(i);
        //     i++; // i = i+1, i += 1
        // }

        // for (int i=0; i<10; i++) {
        //     System.out.println(i);
        // }
        // System.out.println(i); // i cannot be resolved to a variableJava

        // int i = 0;
        // while(i<10) {
        //     System.out.println(i);
        //     i++; // i = i+1, i += 1
        // }
        // System.out.println(i);

        int[] score = {10, 20, 30, 40, 50};
        // for (int i: score) {
        //     if (i >= 40) {
        //         break;
        //     }
        //     System.out.println(i);
        // }

        // 10, 20, 30, 50
        for (int i: score) {
            if (i == 40) {
                continue;
            }
            System.out.println(i);
        }

    }
}
