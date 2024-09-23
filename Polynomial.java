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
public Polynomial add(Polynomial newArray) {
		int lengthArrayOne = this.array.length;
		int lengthArrayTwo = newArray.array.length;
 	    int max = Math.max(this.array.length, newArray.array.length);
 	    double[] result = new double[max];
	    
 	    for (int i = 0; i < Math.min(lengthArrayOne, lengthArrayTwo); i++) {
	        result[i] = this.array[i] + newArray.array[i];
	    }

 	    for (int i = lengthArrayTwo; i < lengthArrayOne; i++) {
	        result[i] = this.array[i];
	    }

 	    for (int i = lengthArrayOne; i < lengthArrayTwo; i++) {
	        result[i] = newArray.array[i];
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

