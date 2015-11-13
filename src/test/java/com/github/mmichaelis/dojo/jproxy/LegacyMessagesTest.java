package com.github.mmichaelis.dojo.jproxy;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.ResourceBundle;

import static com.google.common.reflect.Reflection.getPackageName;
import static java.text.MessageFormat.format;

/**
 * Not a real test, but this shows how you would deal normally with resource bundles not using the idea of
 * Java Proxy.
 */
public class LegacyMessagesTest {
  private static final Logger LOG = LoggerFactory.getLogger(LegacyMessagesTest.class);

  private ResourceBundle resourceBundle;

  @Before
  public void setUp() throws Exception {
    resourceBundle = getBundle(this.getClass());
  }

  private static ResourceBundle getBundle(Class<?> context) {
    return ResourceBundle.getBundle(getPackageName(context) + "." + "Bundle", Locale.getDefault(), context.getClassLoader());
  }

  @Test
  public void hello() throws Exception {
    LOG.info(resourceBundle.getString("hello"));
  }

  @Test
  public void thatsMe() throws Exception {
    LOG.info(format(resourceBundle.getString("thatsMe"), this, "hurz"));
  }

  @Test
  public void countToThree() throws Exception {
    LOG.info(format(resourceBundle.getString("countToThree"), 1, 2, 3));
  }

  @Test
  public void haveThings() throws Exception {
    String key = "haveThings";
    Collection<Object> things = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      reportThings(things.toArray());
      things.add(i);
    }
  }

  /**
   * This is the API :-) So: What is a good way to log an array argument?
   */
  private void reportThings(Object... things) {
    LOG.info(format(resourceBundle.getString("haveThings"), things.length, things));
  }
}
