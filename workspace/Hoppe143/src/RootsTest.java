
public class RootsTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        System.out.println("Square root test");
//        System.out.println("The square root of 4 is " + Roots.sqrt(4));
//        System.out.println();
//        System.out.println("Cube root test");
//        System.out.println("The cube root of 8 is " + Roots.cbrt(8));
//        for (int i = 0; i <= 20; i++){
//            System.out.println("Test Value " + i + " " + Roots.sqrt(i) + " " + Roots.cbrt(i));
//        }
        double count = 1;
        boolean run = true;
        while (run) {
            try {
                System.out.println();
                System.out.println(count);
                System.out.println(Roots.sqrt(count));
            } catch (NonConvergenceException e) {
                System.out.println("sqrt function does not converge in under 100 cycles for " + count);
                run = false;
            }
            count*=10;
        }
        
        run = true;
        count = -1;
        while (run) {
            try {
                System.out.println(Roots.cbrt(count));
            } catch (NonConvergenceException e) {
                run = false;
                System.out.println("cbrt function does not converge in under 100 cycles for " + count);
            }
            count*=10;
        }
        
        System.out.println("Done");
    }

}
