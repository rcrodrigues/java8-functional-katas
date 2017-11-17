package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

public class Kata11Test {

    @Test
    public void testExecute() {
	Assert.assertThat(Kata11.execute().size(), equalTo(2));
    }

    // At this point, I believe I got to a reasonable comprehension level of
    // streams and functional programming, so I decide not to test the this
    // Kata's response.

}
