package org.hhh.component;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Service;

/**
 * @Author: hhh
 * @Date: 2021/9/28 12:21 下午
 * @Description TODO
 */
@Service
public abstract class LookUpService {


	@Lookup
	public abstract BService bService();
	public void method(){
		BService bService = bService();
		System.out.println("The hashcode is " + bService.hashCode());
	}

    public void test(){
        bService().test();
    }

}
