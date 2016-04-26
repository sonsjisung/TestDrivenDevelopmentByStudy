package test.money;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import main.money.Dollar;

public class MoneyTest {

	@Test
	public void testMultiplication() {
		Dollar five = new Dollar(5);
		assertThat(new Dollar(10), is(five.times(2)));
		assertThat(new Dollar(15), is(five.times(3)));
	}

}