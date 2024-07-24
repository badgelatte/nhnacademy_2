package module_10;

public interface BinaryOp{
	int apply(int right, int left);
}

class Adder implements BinaryOp {
	public int apply(int right, int left){
		return right + left;
	}
}