package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

public class Kata10Test {

	@Test
	public void testExecute() {
		Assert.assertThat(Kata10.execute().size(), equalTo(2));
	}
}
