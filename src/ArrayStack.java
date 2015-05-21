public class ArrayStack<T> implements StackADT<T> {

	private T[] stack;
	private int top;
	private static final int DEFAULT_CAPACITY = 25;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[capacity];
		stack = temp;
		this.top = 0;
	}

	@Override
	public void push(T newEntry) {
		expandCapacity();
		stack[top] = newEntry;
		top++;
	}

	private void expandCapacity() {
		if (top == stack.length) {
			@SuppressWarnings("unchecked")
			T[] temp = (T[]) new Object[2 * stack.length];
			for (int i = 0; i < stack.length; i++) {
				temp[i] = stack[i];
			}
			stack = temp;
		}
	}

	@Override
	public T pop() {
		if (isEmpty())
			return null;

		T temp = stack[top - 1];
		top--;
		return temp;
	}

	@Override
	public T peek() {
		if (isEmpty())
			return null;
		return stack[top - 1];
	}

	@Override
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public void clear() {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Object[DEFAULT_CAPACITY];
		stack = temp;
		top = 0;
	}
}
