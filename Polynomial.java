package PrePractice;

import java.util.Arrays;

public class Polynomial {

    private double[] array;
    private int[] anotherArray;

    public Polynomial() {
        array = new double[]{0};
        anotherArray = new int[]{0};
    }

    public Polynomial(double[] newarray, int[] newArrayTwo) {
        this.array = new double[newarray.length];
        for (int i = 0; i < newarray.length; i++) {   
            array[i] = newarray[i];
        }
        this.anotherArray = new int[newArrayTwo.length];
        for (int i = 0; i < newArrayTwo.length; i++) {   
            anotherArray[i] = newArrayTwo[i];
        }
    }
    public Polynomial add(Polynomial newArray) {
        double[] result = new double[this.array.length + newArray.array.length];
        int[] resultExponents = new int[this.array.length + newArray.array.length];

        int resultSize = 0;

         for (int i = 0; i < this.array.length; i++) {
            result[resultSize] = this.array[i];
            resultExponents[resultSize] = this.anotherArray[i];
            resultSize++;
        }

         for (int i = 0; i < newArray.array.length; i++) {
            boolean found = false;
            for (int j = 0; j < resultSize; j++) {
                if (resultExponents[j] == newArray.anotherArray[i]) {
                    result[j] += newArray.array[i];
                    found = true;
                    break;
                }
            }
            if (!found) {
                result[resultSize] = newArray.array[i];
                resultExponents[resultSize] = newArray.anotherArray[i];
                resultSize++;
            }
        }

         double[] finalCoefficients = Arrays.copyOf(result, resultSize);
        int[] finalExponents = Arrays.copyOf(resultExponents, resultSize);

        return new Polynomial(finalCoefficients, finalExponents);
    }

    public Polynomial multiply(Polynomial arrayTwo) {
        int max = this.array.length * arrayTwo.array.length;
        double[] result = new double[max];
        int[] exponentResult = new int[max];

        int n = 0;

         for (int i = 0; i < this.array.length; i++) {
            for (int k = 0; k < arrayTwo.array.length; k++) {
                result[n] = this.array[i] * arrayTwo.array[k];
                exponentResult[n] = this.anotherArray[i] + arrayTwo.anotherArray[k];
                n++;
            }
        }

         for (int s = 0; s < n; s++) {
            for (int j = s + 1; j < n; j++) {
                if (exponentResult[s] == exponentResult[j] && exponentResult[s] != -1) {
                    result[s] += result[j];
                    result[j] = 0;
                    exponentResult[j] = -1;
                }
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] != 0) {
                num++;
            }
        }

        double[] newResult = new double[num];
        int[] newExponentResult = new int[n];

        int x = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] != 0) {
                newResult[x] = result[i];
                newExponentResult[x] = exponentResult[i];
                x++;
            }
        }

        return new Polynomial(newResult, newExponentResult);
    }

    public double evaluate(double x) {
        double result = 0;
        for (int i = 0; i < array.length; i++) {
            result += array[i] * Math.pow(x, anotherArray[i]);
        }
        return result;
    }

    public boolean hasRoot(double x) {
        return evaluate(x) == 0;
    }
}
