package fraction;
import java.util.Scanner;

/**
 * The FractionCalculator<p>
 * Write a FractionCalculator class (containing a main method) that does calculations with Fractions.<p>
 * The first thing this program does is print a zero (indicating the current contents of the calculator), and a prompt. 
 * It then accepts commands from the user, and after each command, prints the result, and a new prompt. 
 * It should accept exactly the following commands, and nothing else:<p>
 * a To take the absolute value of the number currently displayed.<p>
 * c To clear (reset to zero) the calculator.<p>
 * i To invert the number currently displayed.<p>
 * s n To discard the number currently displayed and replace it with n.<p>
 * q To quit the program.<p>
 * + n To add n to the number currently displayed.<p>
 * - n To subtract n from the number currently displayed.<p>
 * * n To multiply the number currently displayed by n.<p>
 * / n To divide the number currently displayed by n.<p>
 * @author Shuting Sun
 *
 */
public class FractionCalculator {
	/** Create a Fraction object, and set it to 0. */
	Fraction myFraction= new Fraction(0);
	 /** Used for getting input from the user. */
	Scanner scanner = new Scanner(System.in);
	 
	 /**
     * The main method just creates a FractionCalculator object and calls
     * its <code>run</code> method.
     * @param args Not used.
     */
	public static void main(String args[]){
		new FractionCalculator().run();
	}
	/**
     * Prints a welcome method, then calls methods to perform each
     * of the following actions:
     * <ol>
     *   <li>Initiate a Fraction object,</li>
     *   <li>Prompt the instructions,</li>
     *   <li>Control the calculation.</li>
     * </ol>
     */
	void run(){
		initiate();
		prompt();
		while(scanner.hasNext()){
			String a = readInput();
			dealWithInstructions(a);
			prompt();
		}	
	}
	/**
     * Initiate a Fraction object.
     */
	void initiate(){
		System.out.println(myFraction);
	}
	
	/**
     * Prompt the instructions.
     */
	void prompt(){
		System.out.println("a: To take the absolute value of the number currently displayed.");
		System.out.println("c: To clear (reset to zero) the calculator.");
		System.out.println("i: To invert the number currently displayed.");
		System.out.println("n: To negate the number currently displayed."); // I added negate anyway.
		System.out.println("q: To quit the program.");
		System.out.println("s n: To discard the number currently displayed and replace it with n.");
		System.out.println("+ n: To add n to the number currently displayed.");
		System.out.println("- n: To subtract n from the number currently displayed.");
		System.out.println("* n: To multiply the number currently displayed by n.");
		System.out.println("/ n: To divide the number currently displayed by n.");
		System.out.println("Enter your instructions: ");
	}
	
	/**
     * Read users' input.
     * @return Net instructions of users' input.
     */
	String readInput(){		
		String  instruction = scanner.nextLine();
		instruction = instruction.toLowerCase().trim(); // "Wash" the input.
		instruction = instruction.replaceAll("\\s+", ""); // Remove all the white space in the string.
		//System.out.println(instruction);
		return instruction;
	}
	
	/**
     * Make calculation.
     * @param instruction The instructions from user,
     *  which have removed all spaces and all the characters are lower cases.
     */	
	
	void dealWithInstructions(String instruction){
		if (instruction.equals("a")) // absolute
			myFraction = myFraction.abs();
		
		else if (instruction.equals("c")) // clear
			myFraction= new Fraction(0);
		
		else if (instruction.equals("i")){ // inverse
			try{
				myFraction.inverse();
			}catch(ArithmeticException ex){
				myArithmeticException();
				return;
			}
			myFraction = myFraction.inverse();
		}
		
		else if (instruction.equals("n")) // negate
			myFraction = myFraction.negate();
		
		else if (instruction.equals("q")) // quit
			System.exit(0);
			
		else if (instruction.substring(0, 1).equals("s")){ // discard the current number and replace it with n
			int position = instruction.indexOf("s");
			String myNumber = instruction.substring(position + 1);
			try{
				new Fraction(myNumber);
			}catch(ArithmeticException ex){
				myArithmeticException();
				return;
			}catch(NumberFormatException ex){
				myNumberFormatException();
				return;
			}catch(IndexOutOfBoundsException ex){
				myIndexOutOfBoundsException();
				return;
			}
			myFraction = new Fraction(myNumber);	
		}
		
		else if (instruction.substring(0, 1).equals("+")){ // add n
			int position = instruction.indexOf("+");
			String myNumber = instruction.substring(position + 1);
			try{
				new Fraction(myNumber);
			}catch(ArithmeticException ex){
				myArithmeticException();
				return;
			}catch(NumberFormatException ex){
				myNumberFormatException();
				return;
			}catch(IndexOutOfBoundsException ex){
				myIndexOutOfBoundsException();
				return;
			}
			myFraction = myFraction.add(new Fraction(myNumber));
		}
		
		else if (instruction.substring(0, 1).equals("-")){ // subtract n
			int position = instruction.indexOf("-");
			String myNumber = instruction.substring(position + 1);
			try{
				new Fraction(myNumber);
			}catch(ArithmeticException ex){
				myArithmeticException();
				return;
			}catch(NumberFormatException ex){
				myNumberFormatException();
				return;
			}catch(IndexOutOfBoundsException ex){
				myIndexOutOfBoundsException();
				return;
			}
			myFraction = myFraction.subtract(new Fraction(myNumber));
		}
		
		else if (instruction.substring(0, 1).equals("*")){ // multiply n
			int position = instruction.indexOf("*");
			String myNumber = instruction.substring(position + 1);
			try{
				new Fraction(myNumber);
			}catch(ArithmeticException ex){
				myArithmeticException();
				return;
			}catch(NumberFormatException ex){
				myNumberFormatException();
				return;
			}catch(ArrayIndexOutOfBoundsException ex){
				myIndexOutOfBoundsException();
				return;
			}
			myFraction = myFraction.multiply(new Fraction(myNumber));
		}
		
		else if (instruction.substring(0, 1).equals("/")){ // divide n
			int position = instruction.indexOf("/");
			String myNumber = instruction.substring(position + 1);
			try{
				new Fraction(myNumber);
			}catch(ArithmeticException ex){
				myArithmeticException();
				return;
			}catch(NumberFormatException ex){
				myNumberFormatException();
				return;
			}catch(IndexOutOfBoundsException ex){
				myIndexOutOfBoundsException();
				return;
			}
			try{
			myFraction = myFraction.divide(new Fraction(myNumber));
			}catch(ArithmeticException ex){
				myArithmeticException();
				return;
			}catch(NumberFormatException ex){
				myNumberFormatException();
				return;
			}catch(IndexOutOfBoundsException ex){
				myIndexOutOfBoundsException();
				return;
			}
		}
		
		System.out.println("Current result: " + myFraction);
		System.out.println();
	}
	/**
     * Print a message about the ArithmeticException.<p> 
     * Input like "10/0" could cause the exception.<p>
     */	
	void myArithmeticException(){
		System.out.println("Divide by zero!");
		System.out.println();
	}
	/**
     * Print a message about the NumberFormatException.<p>
     * Input like "abc123" could cause the exception.<p>
     */	
	void myNumberFormatException(){
		System.out.println("The format of the input is not proper!");
		System.out.println();
	}
	/**
     * Print a message about the ArrayIndexOutOfBoundsException.<p>
     * Input like "///" could cause the exception.<p>
     */	
	void myIndexOutOfBoundsException(){
		System.out.println("The input is not proper!");
		System.out.println();
	}
}
