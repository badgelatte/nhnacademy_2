package module_10.binaryOp;

interface BinaryOp{
	int apply(int left, int right);
	default void method(int i, int j) {
		System.out.println(i + " & " + j);
	};
}

class Adder implements BinaryOp {
	public int apply(int left, int right){
		return right + left;
	}
}

class Multiplier implements BinaryOp {
	public int apply (int left, int right) {
		return left * right;
	}
}

class Test_BinaryOp {
	public static void main(String[] args) {
		BinaryOp binder1 = new Adder();
		BinaryOp binder2 = new Multiplier();

		int i = 1, j = 2;

		System.out.println(binder1.apply(i, j));
		System.out.println(binder2.apply(i, j));
		binder1.method(i,j);
	}
}