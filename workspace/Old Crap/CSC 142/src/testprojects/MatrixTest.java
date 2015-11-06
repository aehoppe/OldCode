package testprojects;

import java.util.Random;

public class MatrixTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Matrix m = new Matrix();
        Random r = new Random(10);
        int i, j;
        for(i = 0; i < Matrix.ROW; i++){
            for(j = 0; j < Matrix.COL; j++){
                m.setValue(i, j, r.nextInt());
            }
        }
        System.out.println(m);

    }

}
