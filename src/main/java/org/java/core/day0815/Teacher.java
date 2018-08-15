package org.java.core.day0815;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service("teacher")
//@Component("teacher")
public class Teacher implements Job {
    @Override
    public String work() {
        return "教课";
    }
}

