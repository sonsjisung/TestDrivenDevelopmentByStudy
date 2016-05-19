package main.money;


public class Money implements Expression {
	protected int amount;
	protected String currency;
	
	public Money(int amount, String currency) {
		this.amount = amount;
		this.currency = currency;
	}
	
	public static Money dollar(int amount) {
		return new Money(amount, "USD");
	}
	
	public static Money franc(int amount) {
		return new Money(amount, "CHF");
	}
	
	public Money times(int multiplier) {
		return new Money(amount * multiplier, currency);
	}
	
	public Expression plus(Money addend) {
		return new Sum(this, addend);
	}
	
	public String currency() {
		return currency;
	}
	
	@Override
	public boolean equals(Object object) {
		Money money = (Money) object;
		return this.amount == money.amount
		&& this.currency.equals(money.currency());
	}
	
	@Override
	public String toString() {
		return amount + " " + currency;
	}

	@Override
	public Money reduce(String to) {
		return this;
	}

}