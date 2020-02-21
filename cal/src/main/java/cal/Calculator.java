package cal;
class Calculator {
	int a,b;
	Calculator(int a,int b){
		this.a=a;
		this.b=b;
	}
	int add() {
		return a+b;
	}
	int subtract() {
		return a-b;
	}
	int multiply() {
		return a*b;
	}
	int divide() {
		return a/b;
	}
}		
import java.util.Scanner;

	public class Main{
		public static void main(String args[]) {
			Scanner sr=new Scanner(System.in);
			System.out.print("Enter a");
			int a=sr.nextInt();
			System.out.print("Enter b");
			int b=sr.nextInt();
			System.out.print("Enter the operation (+,-,*,/):");
			String op=sr.next();
			int c=0;
			Calculator obj=new Calculator(a,b);
			switch(op) {
			case "+": c=obj.add();
			          break;
			case "-": c=obj.subtract();
			          break;
			case "*": c=obj.multiply();
			          break;
			case "/": c=obj.divide();
			          break;
			default:  System.out.println("Invalid");
			}
		}
	}

