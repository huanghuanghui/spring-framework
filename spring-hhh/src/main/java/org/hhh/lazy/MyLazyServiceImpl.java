package org.hhh.lazy;

import org.springframework.stereotype.Component;

/**
 * @Author: hhh
 * @Date: 2021/10/23 11:15 下午
 * @Description TODO
 */
@Component
public class MyLazyServiceImpl implements MyLazyService{

	@Override
	public void test() {
		System.out.println("MyLazyServiceImpl test");
	}
}
