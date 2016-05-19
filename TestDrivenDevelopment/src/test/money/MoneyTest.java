package test.money; 

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import main.money.Bank;
import main.money.Expression;
import main.money.Money;
import main.money.Sum;


public class MoneyTest {
    @Test
    public void testMultiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));

        Money ten = Money.dollar(10);
        assertEquals(Money.dollar(30), ten.times(3));
    }
	
	@Test
	public void testDifferentClassEquality(){
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.dollar(5).equals(Money.franc(5)));
		//assertThat("CHF", is(Money.franc(1).currency()) );
	}
	
	@Test
	public void testSimpleAddition(){
//		Money sum = Money.dollar(5).plus(Money.dollar(5));
//		assertEquals(Money.dollar(10), 10);
		
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();  
		Money reduced = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(10), reduced);
	}
	
	@Test
	public void testPlusReturnsSum(){
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum = (Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}
	
	@Test
	public void testReduceSum(){
		Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
		Bank bank = new Bank();
		Money reuslt = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(7), reuslt);
	}
	
	@Test
	public void testReduceMoney(){
		Bank bank = new Bank();
		Money reuslt = bank.reduce(Money.dollar(1), "USD");
		assertEquals(Money.dollar(1), reuslt);
	}
	
	
	
	
}