package collections;

import java.util.Arrays;
import java.util.Scanner;

public class MyStack {

	int[] numbers;
	int position;
	int size;
	
	public MyStack(int size) {		
		this.numbers =  new int[size];
	}
	
	private void push(int number){		
		if(position<size-1){
			position++;
			numbers[position]=number;
		}else{
			System.out.println("Stack is full");
		}
	}
	
	private void pop(){
		if(position>=0){
			System.out.println(numbers[position]);
			numbers[position] = 0;
			position--;			
		}else{			
			System.out.println("Stack is empty.");
		}
	}
	
	private void peek(){
		if(position>=0){
			System.out.println(numbers[position]);			
		}else{			
			System.out.println("Stack is empty.");
		}
	}
	
	private void print(){
		if(position>=0){
			int[] subArray = Arrays.copyOfRange(numbers, 0, position+1);
			System.out.println(Arrays.toString(subArray));
		}else{
			System.out.println("Stack is empty");
		}
	}
	
	public static void main(String[] args) {		
		MyStack myStack;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of stack:");
		int size = sc.nextInt();
		if(size <= 0){
			System.out.println("Invalid input");
			sc.close();			
		}else{
			myStack = new MyStack(size);	
			myStack.size=size;
			myStack.position=-1;
			
			while(true){
				System.out.println("\n\nSelect an option\n1. Push\n2. Pop\n3. Peek\n4. Print\n5. Exit");
				int selection = sc.nextInt();
				
				boolean isExit = false;
				switch(selection) {
					case 1:
						System.out.println("Enter a number to add");
						int newNumber = sc.nextInt();
						myStack.push(newNumber);
						break;
					case 2:					
						myStack.pop();
						break;
					case 3:
						myStack.peek();
						break;
					case 4:
						myStack.print();
						break;
					case 5:
						isExit = true;
						sc.close();
						break;
					default:
						System.out.println("Invalid option!!");
						
				}
				
				if(isExit){
					break;
				}
			}
		}
	}
	
}
