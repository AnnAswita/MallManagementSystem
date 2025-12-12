//Author Ann Aswita
package com.mall.interceptor;
import java.util.ArrayList;
import java.util.List;

import com.mall.interceptor.context.DeliveryContext;

public class Dispatcher {
	
	private final List<Interceptor> interceptors = new ArrayList<>();
	
	public void attach(Interceptor interceptor) {
	interceptors.add(interceptor);
	}
	
	public void dispatch(DeliveryContext context) {
		for (Interceptor interceptor : interceptors) {
		interceptor.intercept(context);
		}
	}
}
