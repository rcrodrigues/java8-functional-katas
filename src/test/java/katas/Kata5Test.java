package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

public class Kata5Test {

    @Test
    public void testExecute() {
	Assert.assertThat(Kata5.execute(), equalTo(5.0));
    }

}
