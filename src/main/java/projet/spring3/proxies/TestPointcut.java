package projet.spring3.proxies;

import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

public class TestPointcut extends StaticMethodMatcherPointcut {
    public boolean matches(Method method, Class cls) {
        return ("advised".equals(method.getName()));
    }
}
