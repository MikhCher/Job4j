package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<Integer> stack = new SimpleStack<>();

    @Test
    public void whenPushThreeElementsThenPollEach() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertThat(stack.poll(), is(3));
        assertThat(stack.poll(), is(2));
        assertThat(stack.poll(), is(1));
    }
}