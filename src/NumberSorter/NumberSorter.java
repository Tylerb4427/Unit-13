package NumberSorter;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter {
    //instance variables and other methods not shown

    private static int getNumDigits(int number) {
        int count = 0;
        for(int i=0;i<20;i++)
            if(number<Math.pow(10,i))
                return i;
        return 0;
    }

    public static int[] getSortedDigitArray(int number) {
        int[] sorted = new int[getNumDigits(number)];
        for(int i=1;i<sorted.length;i++)
            sorted[i-1]=(number%(int)Math.pow(10,sorted.length-i+1))/(int)Math.pow(10,sorted.length-i);
        sorted[sorted.length-1]=number%10;
        Arrays.sort(sorted);
        return sorted;
    }
}
