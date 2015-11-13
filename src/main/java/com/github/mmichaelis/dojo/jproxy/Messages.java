package com.github.mmichaelis.dojo.jproxy;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.ResourceBundle;

import static java.util.Objects.requireNonNull;

public class Messages {
  public static <T> T getInstance(@NotNull Class<T> bundleInterface) {
    requireNonNull(bundleInterface, "bundleInterface must not be null.");
    final ResourceBundle bundle = ResourceBundle.getBundle(bundleInterface.getName());

    Object proxy = Proxy.newProxyInstance(bundleInterface.getClassLoader(),
        new Class[]{bundleInterface},
        new InvocationHandler() {
          @Override
          public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return MessageFormat.format(bundle.getString(method.getName()),
                possiblyExpandVarargArguments(method, args));
          }
        });
    return bundleInterface.cast(proxy);
  }

  private static Object[] possiblyExpandVarargArguments(@NotNull Method method,
                                                        Object[] args) {
    if (hasVarargs(method)) {
      Object[] varargsArgument = (Object[]) args[args.length - 1];
      Object[] newArgs = new Object[args.length + varargsArgument.length - 1];
      System.arraycopy(args, 0, newArgs, 0, args.length - 1);
      System.arraycopy(varargsArgument, 0, newArgs, args.length - 1, varargsArgument.length);
      return newArgs;
    }
    return args;
  }

  private static boolean hasVarargs(Method method) {
    Parameter[] parameters = method.getParameters();
    return parameters.length > 0 && parameters[parameters.length - 1].isVarArgs();
  }
}
