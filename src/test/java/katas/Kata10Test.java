package katas;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Assert;
import org.junit.Test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

public class Kata10Test {

    @Test
    public void testExecute() {
	Assert.assertThat(Kata10.execute().size(), equalTo(2));
    }

    @Test
    public void testResponse() {

	Assert.assertEquals(Kata10.execute(), ImmutableList.of(

		ImmutableMap.of("name", "New Releases", "videos",
			ImmutableList.of(ImmutableMap.of("id", 65432445, "title", "The Chamber"

			), ImmutableMap.of("id", 675465, "title", "Fracture"

			))

		), ImmutableMap.of("name", "Thrillers", "videos", ImmutableList.of(ImmutableMap.of("id", 70111470, "title", "Die Hard"

		), ImmutableMap.of("id", 654356453, "title", "Bad Boys"

		))

		)

	));

    }

}
