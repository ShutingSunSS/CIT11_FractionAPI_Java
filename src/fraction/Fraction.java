package fraction;

/**
 * The task is to implement a Fraction API (Application Programmer's Interface) 
 * and write a small program that uses it.<p>
 * @author Shuting Sun
 *
 */
public class Fraction implements Comparable<Object>{
// Lots of short methods.
	private int n;
	private int d; // The denominator may not be zero.
	 
    /**
     * Constructor one: Constructs a Fraction object, given two integers.
     * @param numerator The numerator of the fraction.
     * @param denominator The denominator of the fraction.
     */
	 public Fraction(int numerator, int denominator) {
		// The denominator may not be zero.   
		 int gcd = GCD(numerator, denominator);
		  if (denominator == 0){
	        	throw new ArithmeticException("Denominator: zero.");
	        }
	        if (denominator < 0){
	        	n = -(numerator/gcd); // set instance variables
	        	d = -(denominator/gcd);
	        }
	        else{
	        	n = numerator/gcd;
	        	d = denominator/gcd;
	        }
	}
	    /**
	     * Constructor two: Constructs a Fraction object, given a whole number.
	     * @param wholeNumber A whole number which will be the numerator of the fraction.
	     */
	 public Fraction(int wholeNumber) {
			   this(wholeNumber, 1); // Call one constructor from another.
		    }
	   /**
	     * Constructor three: Constructs a Fraction object, given a string.
	     * @param fraction A String which could be convert to a fraction.
	     */
	 public Fraction(String fraction){ 
		 // The parameter is a String containing either a whole number, 
		 // such as "5" or " -3", or a fraction, such as "8/ -12". 
		 // Allow blanks around (but not within) integers.
		fraction = fraction.replaceAll("\\s+", "");
		if (fraction.contains("/")){  
				n = Integer.parseInt(fraction.split("/")[0].trim());// Numerator
				d = Integer.parseInt(fraction.split("/")[1].trim()); // Denominator
		        int gcd = GCD(n, d);
		        if (d == 0){
		        	throw new ArithmeticException("Denominator: zero.");
		        	//System.out.println("Divide by zero!");
		         }else if (d < 0){
			    	n = -(n/gcd);
			    	d = -(d/gcd);
			     }else{
			    	n = n/gcd;
			    	d = d/gcd;
			     }
		  }else{
			 int wholeNumber;
		    	wholeNumber = Integer.parseInt(fraction);
		    	n = wholeNumber;
		    	d = 1;
			 } 	
		   }	    
	 
    /**
     * Returns the Greatest Common Divisor (GCD) of any two given number.
     * @param a A integer.
     * @param b Another integer.
     * @return The Greatest Common Divisor (GCD) of the two given integer.
     */
    private static int GCD(int a, int b){
    	 a = Math.abs(a);
    	 b = Math.abs(b);
    	 while(a != 0 && b != 0){
    		 int temp = b; // temp = 12, temp = 8, temp = 4
    		 b = a % b; // b = 8, b = 4, b = 0
    		 a = temp; // a = 12, a = 8, a = 4
    	 }
    	 return a + b;
     }
 
    /**
     * Returns a new Fraction that is the sum of this and that: a/b + c/d is (ad + bc)/bd
     * @param f A Fraction object.
     * @return a New Fraction that is the sum of this and that: a/b + c/d is (ad + bc)/bd
     */
    public Fraction add(Fraction f){
    	return new Fraction(this.n * f.d + this.d * f.n, this.d * f.d);
    }
    
    /**
    * Returns a new Fraction that is the difference of this minus that: a/b - c/d is (ad - bc)/bd
    * @param f A Fraction object.
    * @return a new Fraction that is the difference of this minus that: a/b - c/d is (ad - bc)/bd
    */ 
    public Fraction subtract(Fraction f){
    	return new Fraction(this.n * f.d - this.d * f.n, this.d * f.d);
    }
    
    /**
     * Returns a new Fraction that is the product of this and that: (a/b) * (c/d) is (a*c)/(b*d)
     * @param f A Fraction object.
     * @return a new Fraction that is the product of this and that: (a/b) * (c/d) is (a*c)/(b*d)
     */
    public Fraction multiply(Fraction f){
    	return new Fraction(this.n * f.n , this.d * f.d);
    }
    
    /**
     * Returns a new Fraction that is the quotient of dividing this by that: (a/b) / (c/d) is (a*d)/(b*c)
     * @param f A Fraction object.
     * @return a new Fraction that is the quotient of dividing this by that: (a/b) / (c/d) is (a*d)/(b*c)
     */
    public Fraction divide(Fraction f){
    	if(f.n == 0 || f.d == 0){
    		throw new ArithmeticException("Denominator: zero.");
    	}else{
    	return new Fraction(this.n * f.d , this.d * f.n);
    	}
    }
    
    /**
     * Returns a new Fraction that is the absolute value of this fraction.
     * @return a new Fraction that is the absolute value of this fraction.
     */
    public Fraction abs(){
    	return new Fraction(Math.abs(this.n), Math.abs(this.d));
    }
    
    /**
     * Returns a new Fraction that has the same numeric value of this fraction, but the opposite sign.
     * @return a new Fraction that has the same numeric value of this fraction, but the opposite sign.
     */
    public Fraction negate(){
    	return new Fraction(-this.n, this.d);
    }
    
    /**
     * Returns the inverse of a/b is b/a.
     * @return the inverse of a/b is b/a.
     */
    public Fraction inverse(){ 
    	if(this.n == 0){
    		throw new ArithmeticException("Denominator: zero.");
    	}else{
    	return new Fraction(this.d, this.n);
    	}
    }
    
    /**
     * Returns true if o is a Fraction equal to this, and false in all other cases.
     * @param o An Object, which could be Fraction or Integer or other types.
     * @return true if o is a Fraction equal to this, and false in all other cases.
     */
    @Override
    public boolean equals (Object o){
    	if (o instanceof Fraction){
    		Fraction f = (Fraction)o;
    		if (this.n == f.n && this.d == f.d){ // Compare the numerator and denominator.
    			return true;
    		}else 
    			return false;
    	}
    	else if (o instanceof Integer){
    		int i = (Integer)o;
    		Fraction f = new Fraction(i);
    		if (this.n == f.n && this.d == f.d){ 
    			return true;
    		}else 
    			return false;
    	}
    	else
    		return false;
    }
    /**
     * If o is a Fraction or an int, this method returns:
     * A negative int if this is less than o.
     * Zero if this is equal to o.
     * A positive int if this is greater than o.
     * If o is neither a Fraction nor an int, this method throws a ClassCastException. 
     * This method is not used by your calculator, but is included for completeness.
     * @param o An Object, which could be Fraction or Integer or other types.
     * @return If o is a Fraction or an int, this method returns:
     * A negative int if this is less than o.
     * Zero if this is equal to o.
     * A positive int if this is greater than o.
     * If o is neither a Fraction nor an int, this method throws a ClassCastException. 
     * This method is not used by your calculator, but is included for completeness.
     */
    @Override
    public int compareTo (Object o){
    	if (o instanceof Fraction){
    		Fraction f = (Fraction)o;
    		Fraction newf = this.subtract(f);
    		return newf.n;		
    		}
    	else if (o instanceof Integer){
    		int i = (Integer)o;
    		Fraction f = new Fraction(i);
    		Fraction newf = this.subtract(f);
    		return newf.n;
    		}
    	else{
    		throw new ClassCastException();
    	}
    }
    /**
     * Returns a String of the form n/d, where n is the numerator and d is the denominator.
     * However, if d is 1, just return n (as a String). 
     * The returned String should not contain any blanks.
     * If the fraction represents a negative number, a minus sign should precede the n.
     * This should be one of the first methods you write, because it will help you in debugging.
     * @return If o is a Fraction or an int, this method returns:
     * Returns a String of the form n/d, where n is the numerator and d is the denominator.
     * However, if d is 1, just return n (as a String). 
     * The returned String should not contain any blanks.
     * If the fraction represents a negative number, a minus sign should precede the n.
     * This should be one of the first methods you write, because it will help you in debugging.
     */
    @Override
    public String toString(){
    	if (this.d == 1){
    		return Integer.toString(this.n);
    	}else{
    		return (this.n + "/" + this.d);
    	}
    }
}