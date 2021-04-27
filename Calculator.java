import java.util.Scanner;
class Calculator {
    public int calculate(String s) {
        int[] stack = new int[2];
        int ops = 0;
        int top_stack = 0;
        int mult = 0;
        int num = 0;
        char arr[] = s.toCharArray();
        for(int i = 0;i<arr.length;i++) {
            if(arr[i] == ' ')
                continue;
            if(Character.isDigit(arr[i])) {
                num = num*10 + Character.getNumericValue(arr[i]);
                if(i==arr.length-1||Character.isDigit(arr[i+1])==false) {
                    if(mult==1) {
                        stack[top_stack-1] = stack[top_stack-1]*num;
                    }
                    else if(mult==-1) {
                        stack[top_stack-1] = stack[top_stack-1]/num;
                    }
                    else
                        stack[top_stack++] = num;
                    mult = 0;
                    num = 0;
                }
            }
            else if(arr[i]=='+') {
                if(ops!=0) {
                    stack[0] = stack[0]+ ops*stack[1];
                    top_stack--;
                }
                ops = 1;
            }
            else if(arr[i]=='-') {
                if(ops!=0) {
                    stack[0] = stack[0]+ ops*stack[1];
                    top_stack--;
                }
                ops = -1;
            }
            else if(arr[i]=='*') {
                mult = 1;
            }
            else
                mult = -1;
        }
        if(ops!=0) {
            stack[0] = stack[0]+ ops*stack[1];
            top_stack--;
        }
        return stack[0];
        
    }
    public static void main(String[] args){
	Calculator obj = new Calculator();
	System.out.println("Enter string");
	Scanner sc = new Scanner(System.in);
	String s = sc.next();
	System.out.println("Answer: " + obj.calculate(s));
    }
}