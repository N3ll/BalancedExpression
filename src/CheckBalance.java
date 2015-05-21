public class CheckBalance {

	public static void main(String[] args) {

		String expression1 = "{1+2-[(3+1)-4]-2}";
		if (isBalanced(expression1)) {
			System.out.format("The expression %s is balanced" + "\n",
					expression1);
		} else {
			System.out.format("The expression %s is NOT balanced" + "\n",
					expression1);
		}

		String expression2 = "({1+2-[(3+1)-4]-2}";
		if (isBalanced(expression2)) {
			System.out.format("The expression %s is balanced" + "\n",
					expression2);
		} else {
			System.out.format("The expression %s is NOT balanced" + "\n",
					expression2);
		}

		String expression3 = "{1+2-[(3+1)-4]-2}]";
		if (isBalanced(expression3)) {
			System.out.format("The expression %s is balanced" + "\n",
					expression3);
		} else {
			System.out.format("The expression %s is NOT balanced" + "\n",
					expression3);
		}
		
		String expression4 = "{{1+2-[(3+1)-4]-2}]";
		if (isBalanced(expression3)) {
			System.out.format("The expression %s is balanced" + "\n",
					expression4);
		} else {
			System.out.format("The expression %s is NOT balanced" + "\n",
					expression4);
		}
	}

	public static boolean isBalanced(String expression) {
		StackADT<Character> openDelimiters = new ArrayStack<Character>();
		boolean balanced = true;
		char nextChar = ' ';

		for (int i = 0; i < expression.length(); i++) {
			nextChar = expression.charAt(i);

			switch (nextChar) {
			case '(':
			case '[':
			case '{':
				openDelimiters.push(nextChar);
				break;
			case ')':
			case ']':
			case '}':
				if (openDelimiters.isEmpty()) {
					balanced = false;
				} else {
					char opening = openDelimiters.pop();
					balanced = isPaired(opening, nextChar);
				}
			default:
				break;
			}
		}
		if (!(openDelimiters.isEmpty()))
			balanced = false;
		return balanced;
	}

	private static boolean isPaired(char open, char close) {
		return (open == '(' && close == ')') || (open == '[' && close == ']')
				|| (open == '{' && close == '}');
	}

}
