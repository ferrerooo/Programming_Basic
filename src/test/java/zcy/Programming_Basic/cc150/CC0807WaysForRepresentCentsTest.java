package zcy.Programming_Basic.cc150;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import zcy.Programming_Basic.cc150.CC0807WaysForRepresentCents;

public class CC0807WaysForRepresentCentsTest {
	
	@Test
	public void test_howManyWays() {
		int z = new CC0807WaysForRepresentCents().howManyWays(5);
		assertEquals(2, z);
		z = new CC0807WaysForRepresentCents().howManyWays(4);
		assertEquals("incorrect",1, z);		
		assertThat(z, is(1));
	}
}
