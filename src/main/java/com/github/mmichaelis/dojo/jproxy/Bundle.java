package com.github.mmichaelis.dojo.jproxy;

public interface Bundle {
  String hello(String egal);

  String thatsMe(Object name);

  String countToThree(int i1, int i2, int i3);

  String haveThings(int count, Object[] things);

  String iAmOnlyGerman();

  String manyArguments(String first, Object... args);
}
