package LeetCode;

public class BooleanExpr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean result = parseBoolExpr("&(|(f))");
		System.out.println("Result " + result);
	}
    public static boolean parseBoolExpr(String expression) {
    if (expression.equals("t")) return true;
    if (expression.equals("f")) return false;
    char[] arr = expression.toCharArray();
    char op = arr[0];
    System.out.println("OP "+op); //first array index
    boolean result = op != '|';
    int count = 0;
    for (int i = 1, pre = 2; i < arr.length; i++) {
      char c = arr[i];
      if (c == '(') count++;
      if (c == ')') count--;
      
      System.out.println("Each c of array "+ c);
      if (c == ',' && count == 1 || c == ')' && count == 0) {
        boolean next = parseBoolExpr(expression.substring(pre, i));
        System.out.println(" Pre " + pre + " nex bool "+next );
        pre = i + 1;
        if (op == '|') result |= next;
        else if (op == '&') result &= next;
        else result = !next;
      }
      
     
    }
    return result;
    }
}
