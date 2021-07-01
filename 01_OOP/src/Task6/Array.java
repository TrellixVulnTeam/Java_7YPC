package Task6;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Random;

public class Array implements IMath, ISort{
    private IntSummaryStatistics stat;
    private int [] array;
    private static int Random(int min, int max){
        Random random = new Random();
        return random.nextInt((max-min)+1)+min;
    }

    public Array() {
        array = new int[10];
        for(int i = 0; i<10;i++){
            array[i]= Random(-100, 100);
        }
        stat = Arrays.stream(array).summaryStatistics();

    }


    @Override
    public int Max() {
        return stat.getMax();
    }

    @Override
    public int Min() {
        return stat.getMin();
    }

    @Override
    public double Avg() {
        return stat.getAverage();
    }

    @Override
    public void SortAsc() {
        Arrays.sort(array);
        for(int i = 0; i <  array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }

    @Override
    public void SortDesc() {
        int last = array.length - 1;
        int middle = array.length / 2;
        for (int i = 0; i <= middle; i++) {
            int temp = array[i];
            array[i] = array[last - i];
            array[last - i] = temp;
        }
        for(int i = 0; i <  array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}
