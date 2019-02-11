package ru.ifmo.wst.lab.beans;

import ru.ifmo.wst.lab1.rs.ExterminatusResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class Root extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return new HashSet<>(Arrays.asList(ExterminatusResource.class));
    }

}
