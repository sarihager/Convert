import java.io.Serializable;


public class ILS extends Coin implements Serializable{
	double value= 0.28;

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public double calculate(double value) {
		return this.value*value;
	}
}