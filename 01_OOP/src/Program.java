import javax.swing.plaf.IconUIResource;
import java.util.*;

public class Program {
    public static void main(String [] args){
//        Scanner in = new Scanner(System.in);
//
//        System.out.println("Enter array size:");
//        int n = in.nextInt();
//
//        int a = 32;
//        long z = 45;
//        char ch = '2';
//        String name = "Anton";
//
//        //int n = 10;
//        int [] array = new int[n];
//        for (int i = 0; i<n;i++){
//            array[i]= Random(5, 77);
//        }
//
//        for(int item:array){
//            System.out.printf("%d\t", item);
//        }
//
//        System.out.println(name);


        Task11();

//        Book book = new Book("Azbooka", "I am", 2021, "I am", "All", 0);
//        Car car = new Car("Tesla", "Tesla", 2021, 0.2f);
//
//        System.out.println(car.toString());
//        System.out.println(book.toString());

    }

    public static int Random(int min, int max){
        Random random = new Random();
        return random.nextInt((max-min)+1)+min;
    }

    public static void Task1(){
        System.out.println("“Your time is limited,");
        System.out.println("\tso don’t waste it");
        System.out.println("\t\tliving someone else’s life”");
        System.out.println("\t\t\tSteve Jobs");
    }

    public static void Task2(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter digit:");
        int first = in.nextInt();
        System.out.println("Enter %:");
        int second = in.nextInt();

        System.out.println("RES -> " + (first*second)/100);
    }

    public static void Task3(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first digit:");
        String first = in.nextLine();
        System.out.println("Enter second digit:");
        String second = in.nextLine();
        System.out.println("Enter three digit:");
        String three = in.nextLine();

        try{
            System.out.println(Integer.parseInt(first + second + three));
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
    }

    public static void Task4(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter 6x digit:");
        int digit = in.nextInt();

        char[] digits1 = ("" + digit).toCharArray();

        int first = 0;
        int six = 5;

        int two = 1;
        int five =4;

        char temp = digits1[first];
        digits1[first] = digits1[six];
        digits1[six] = temp;

        char temp2 = digits1[two];
        digits1[two] = digits1[five];
        digits1[five] = temp2;


        try{
            String str = String.valueOf(digits1);
            System.out.println(Integer.parseInt(str));
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }

    }

    public static void Task5(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter months number:");
        int month = in.nextInt();

        switch (month){
            case 1:
            case 2:
            case 12:
                System.out.println("Winter");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Autumn");
                break;
            default:
                System.out.println("Error");
                break;
        }
    }

    public static void Task6(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter meters:");
        int meters = in.nextInt();


        System.out.println("Type: \t 1-Miles \t 2-Duim \t 3-Uard");
        int type = in.nextInt();

        switch (type){
            case 1:
                System.out.println(meters/1609);
                break;
            case 2:
                System.out.println(meters*39.37);
                break;
            case 3:
                System.out.println(meters*1.094);
                break;
        }
    }

    public static void Task7(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter first digit:");
        int first = in.nextInt();

        System.out.println("Enter second digit:");
        int second = in.nextInt();

        if(first<second){
            for (int i = first; i<second; i++)
                if(i%2!=0) System.out.println(i);
        }
        else{
            int tmp = first;
            first= second;
            second = tmp;
            for (int i = first; i<second; i++)
                if(i%2!=0) System.out.println(i);
        }
    }

    public static void Task8(){
        Scanner in = new Scanner(System.in);

        for (int i=0; i<2; i++){
            System.out.println("Enter digit:");
            int first = in.nextInt();

            for (int y = 1; y<=10; y++){
                int res = first*y;
                System.out.println(first + "*"+ y + " = " + res);
            }

        }
    }

    public static void Task9(){
        int [] array = new int[10];

        for (int i = 0; i<10;i++){
            array[i]= Random(-100, 100);
        }

        for(int item:array){
            System.out.printf("%d\t", item);
        }

        IntSummaryStatistics stat = Arrays.stream(array).summaryStatistics();

        System.out.println("Max : " + stat.getMax());
        System.out.println("Min : " + stat.getMin());

        int minuscout =0;
        int pluscount =0;
        int zerocount =0;
        for(int item:array){
            if(item<0) minuscout++;
            else pluscount++;
            if(item ==0 ) zerocount ++;
        }
        System.out.println("Minus count : " + minuscout);
        System.out.println("Plus count : " + pluscount);
        System.out.println("Zero count : " + zerocount);
    }

    public static void Task10(){
        ArrayList<Integer> plus_array = new ArrayList<Integer>();
        ArrayList<Integer> minus_array = new ArrayList<Integer>();
        ArrayList<Integer> c_array = new ArrayList<Integer>();
        ArrayList<Integer> nc_array = new ArrayList<Integer>();


        Integer [] array = new Integer[10];

        for (int i = 0; i<10;i++){
            array[i]= Random(-100, 100);
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(array));
        //arrayList.add(7);
        //array = arrayList.toArray(array);

        for(int item:arrayList){
            if(item<0) minus_array.add(item);
            else plus_array.add(item);
            if(item%2!=0 ) nc_array.add(item);
            else c_array.add(item);
        }


        for(int item:minus_array){
            System.out.printf("%d\t", item);
        }
        System.out.printf("\n");
        for(int item:plus_array){
            System.out.printf("%d\t", item);
        }
        System.out.printf("\n");
        for(int item:nc_array){
            System.out.printf("%d\t", item);
        }
        System.out.printf("\n");
        for(int item:c_array){
            System.out.printf("%d\t", item);
        }
    }

    public static void Task11(){
        Scanner in = new Scanner(System.in);

        System.out.println("Enter symvol:");
        String symvol = in.nextLine();

        System.out.println("Enter size:");
        int n = in.nextInt();

        System.out.println("Enter arrow 1-DOWN  //  2-RIGHT :");
        int arrow = in.nextInt();



        switch (arrow){
            case 1:
                for(int i = 0; i<=n; i++){
                    System.out.println(symvol);
                }
                break;
            case 2:
                for(int i = 0; i<=n; i++){
                    System.out.printf(symvol);
                }
                break;
        }

    }

    public static void Task12(){
        Integer [] arr = new Integer[10];

        for (int i = 0; i<10;i++){
            arr[i]= Random(-100, 100);
        }

        //Integer [] arr = {13, 7, 6, 45, 21, 9, 101, 102};


        Arrays.sort(arr, Collections.reverseOrder());
        for(int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.print("\n");

        Arrays.sort(arr);
        for(int i = 0; i <  arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }
}
