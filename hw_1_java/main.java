import java.util.Scanner;
import java.util.Arrays;

class FirstTask{
    public static void main(String[] args)
    {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter amount of members in the array: ");
        int arSize = console.nextInt(); 
        int a,b;

        if(arSize <= 0){
            System.out.println("Array size must be positive.");
            return;
        }

        System.out.print("Enter the random number generation limits [a,b]\n");
        System.out.print("a: ");
        a = console.nextInt();
        System.out.print("b: ");
        b = console.nextInt();


        int[] rand_array = new int[arSize];
        set_array(rand_array, arSize,a,b);

        System.out.println("Unsorted array: " + Arrays.toString(rand_array));

        sort_bubble(rand_array, arSize);

        System.out.println("Sorted array: " + Arrays.toString(rand_array));

        System.out.println("Max element of the array: " + aMax(rand_array));

        System.out.println("Min element of the array: " + aMin(rand_array,arSize));

        System.out.println("Mean of the array: " + aMean(rand_array));

        console.close();
    }

    static int aMax(int[] array){
        int max = array[0];
        for(int num : array){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    static int aMin(int[] array, int arSize){
        int min = array[0];
        for(int num : array){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    static double aMean(int[] array){
        int sum = 0;
        for(int num : array){
            sum += num;
        }
        return (double) sum / array.length;
    }

    static double aMax(double[] array){
        double max = array[0];
        for(double num : array){
            if(num > max){
                max = num;
            }
        }
        return max;
    }

    static double aMin(double[] array){
        double min = array[0];
        for(double num : array){
            if(num < min){
                min = num;
            }
        }
        return min;
    }

    static double aMean(double[] array){
        double sum = 0;
        for (double elem : array)
        {
            sum += elem;
        }

        return sum / array.length;
    }

    static void sort_bubble(int[] array, int arSize){
        for (int i = 0; i < arSize-1;++i)
        {
            for (int j = 0; j < arSize-1-i; ++j)
            {
                if (array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    static void sort_bubble(double[] array, int arSize){
        for (int i = 0; i < arSize-1;++i)
        {
            for (int j = 0; j < arSize-1-i; ++j)
            {
                if (array[j] > array[j+1]){
                    double temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }

    static int[] set_array(int[] array,int arSize, int a,int b){
        for (int i = 0; i < arSize; ++i)
        {
            array[i] =(int) (a + (b-a)*Math.random());
        }
        return array;
    }

    static double[] set_array(double[] array,int arSize, int a, int b){
        for (int i = 0; i < arSize; ++i)
        {
            array[i] = a + (b - a) * Math.random();
        }
        return array;
    }

}