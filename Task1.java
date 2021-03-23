package lesson2;

public class Task1 {
    public static void main(String[] args) {
        int sum = 0;
        for (String str : args) {
            int i = Integer.valueOf(str);
            sum += i;
        }
        float result =(float)sum/args.length;
        System.out.println("Arithmetical mean = " + result);
    }
}
