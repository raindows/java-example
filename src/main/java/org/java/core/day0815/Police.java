package org.java.core.day0815;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Service("police")
@Component("police")
public class Police implements Job {
	@Override
	public String work() {
		return "抓罪犯";
	}
}
