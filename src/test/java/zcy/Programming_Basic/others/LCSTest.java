package zcy.Programming_Basic.others;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class LCSTest {

	@Test
	public void testGetLCS() {
		int z = new LCS().getLCS("abcd", "abc");
		assertThat(z, is(3));
	}
	
}
