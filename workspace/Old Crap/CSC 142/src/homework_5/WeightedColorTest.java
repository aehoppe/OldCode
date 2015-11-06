package homework_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;

public class WeightedColorTest {

    public static void main(String[] args) throws FileNotFoundException{
        // TODO Auto-generated method stub
        WColorSet w = new WColorSet(new File("colors2.txt"));
        System.out.println(w.getNonDecSeq());
    }

}
