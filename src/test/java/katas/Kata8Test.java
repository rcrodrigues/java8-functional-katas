package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata8Test {

    @Test
    public void testExecute() {
	Assert.assertThat(Kata8.execute().size(), equalTo(3));
    }

    @Test
    public void testResponse() {

	Assert.assertEquals(Kata8.execute(),
		ImmutableList.of(ImmutableMap.of("videoId", 70111470, "bookmarkId", 470),
			ImmutableMap.of("videoId", 654356453, "bookmarkId", 453),
			ImmutableMap.of("videoId", 65432445, "bookmarkId", 445)));

    }
}
