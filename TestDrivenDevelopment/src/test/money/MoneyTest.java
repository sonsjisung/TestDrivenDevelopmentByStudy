package test.money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import main.money.Dollar;
import main.money.Franc;
import main.money.Money;

public class MoneyTest {

	@Test
	public void testMultiplication() {
		Dollar five = Money.dollar(5);
		assertThat(Money.dollar(10), is(five.times(2)));
		assertThat(Money.dollar(15), is(five.times(3)));
	}
	
	@Test
	public void testFrancMultiplication() {
		Franc five = Money.franc(5);
		assertThat(Money.franc(10), is(five.times(2)));
		assertThat(Money.franc(15), is(five.times(3)));
	}
	
	@Test
	public void testEquality(){
		assertThat(Money.dollar(5), is(Money.dollar(5)));
		assertThat(Money.dollar(6), is(Money.dollar(6)));
		assertThat(Money.franc(5), is(Money.franc(5)));
		assertThat(Money.franc(6), is(Money.franc(6)));
		assertFalse( Money.franc(6).equals(Money.dollar(6)) );
	}

}