package com.github.mmichaelis.dojo.jproxy;

import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.*;

public class MessagesTest {


  private Bundle instance;

  @Before
  public void setUp() throws Exception {
    Locale.setDefault(Locale.US);
    instance = Messages.getInstance(Bundle.class);
  }

  @Test
  public void hello() throws Exception {
    String string = instance.hello("");
    assertEquals("Hello World!", string);
  }

  @Test
  public void thatsMe() throws Exception {
    String me = "Hurz";
    assertEquals("That's me: Hurz", instance.thatsMe(me));
  }

  @Test
  public void haveThings() throws Exception {
    String[] me = {"Hurz", "Schasndasn"};
    assertEquals("I have 2 things: Hurz, Schasndasn", instance.haveThings(me.length, me));
  }

  @Test
  public void manyArguments() throws Exception {
    assertEquals("a b c d e",
        instance.manyArguments("a", "b", "c", "d", "e", "f"));
  }
}
