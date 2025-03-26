package mocks;

public class SimpleInterestImpl implements SimpleInterest {
	
	private Arithmetic arithmetic;
	
	public void Arithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}
	
	@Override
	public int compute(int prin,int rate,int time) {
		int prod = arithmetic.mul(prin,rate);
		prod = arithmetic.mul(prod,time);
		return arithmetic.div(prod,100);
	}

	public void setArithmetic(mocks.Arithmetic arith) {
		// TODO Auto-generated method stub
		
	}

	

}
