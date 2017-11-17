package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

public class Kata3Test {

    @Test
    public void testExecute() {

	Assert.assertThat(Kata3.execute().size(), equalTo(4));

    }

    @Test
    public void testResponse() {

	Assert.assertEquals(Kata3.execute(), ImmutableList.of(70111470, 654356453, 65432445, 675465));

    }
}
