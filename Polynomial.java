package PrePractice;

public class Polynomial {

double [] array;

public Polynomial(){
	array = new double[]{0};
} 
public Polynomial(double[] newarray) {
    this.array = new double[newarray.length];
    for (int i = 0; i < newarray.length; i++) {   
        array[i] = newarray[i];
    }
}
public Polynomial add(Polynomial other) {
    int maxLength = Math.max(this.array.length, other.array.length);
    
     double[] result = new double[maxLength];
    
     for (int i = 0; i < maxLength; i++) {
        double thisCoeff = 0;
        double otherCoeff = 0;

         if (i < this.array.length) {
            thisCoeff = this.array[i];
        }

         if (i < other.array.length) {
            otherCoeff = other.array[i];
        }

         result[i] = thisCoeff + otherCoeff;
    }
    
     return new Polynomial(result);
}		
public double evaluate(double x) {
    double result = 0;
    int y = 0;   
    for (int i = 0; i < array.length; i++) {
        result += array[i] * Math.pow(x, y);
        y++;  
    }
    return result;
}
public boolean hasRoot(double x){
	return evaluate(x)==0;
}}

