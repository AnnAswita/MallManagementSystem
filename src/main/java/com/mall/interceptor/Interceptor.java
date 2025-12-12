/**
 * author: carolin.thomas
 */
package com.mall.interceptor;

import com.mall.interceptor.context.DeliveryContext;

public interface Interceptor {
	
	void intercept(DeliveryContext context);

}
