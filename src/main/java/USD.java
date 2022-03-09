import java.io.Serializable;


public class USD extends Coin implements Serializable{
	double value= 3.85;

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public double calculate(double value) {
		return getValue()*value;
	}
}
