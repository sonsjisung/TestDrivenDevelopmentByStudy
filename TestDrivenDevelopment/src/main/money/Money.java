package main.money;

public abstract class Money {
	protected int amount;
	
	abstract Money times(int multiplier);
	
	@Override
	public boolean equals(Object obj) {
		Money money = (Money) obj;
		return amount == money.amount
				&& this.getClass().equals( money.getClass() );
	}

	public static Dollar dollar(int amount) {
		return new Dollar(amount);
	}

	public static Franc franc(int amount) {
		return new Franc(amount);
	}
	
	
	
}
