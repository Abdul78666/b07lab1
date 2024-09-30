package PrePractice;

public class Driver {
    public static void main(String[] args) {
        double[] a = {6, 0, 0, 5};
        int[] b = {6, 2, 4, 5};
        Polynomial i = new Polynomial(a, b);
        System.out.println("Polynomial p1: " + i);
        double[] x = {5,2, 7, 8};
        int[] y = {3,7,544, 42};
        Polynomial j = new Polynomial(x, y);
        System.out.println("Polynomial p2: " + j);
        Polynomial multiply = i.multiply(j);
        System.out.println("Sum (p1 + p2): " + multiply);
        Polynomial sum = i.add(j);
        System.out.println("Sum (p1 + p2): " + sum);
         System.out.println(i.hasRoot(0));
    }
}
