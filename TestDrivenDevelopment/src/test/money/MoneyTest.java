package test.money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import main.money.Money;


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
}