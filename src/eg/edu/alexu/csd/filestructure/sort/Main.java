package eg.edu.alexu.csd.filestructure.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        BubbleSort<Integer> bs = new BubbleSort<>(a);
        bs.sort();
        bs.print();
        System.out.println("hello world");

    }

}
