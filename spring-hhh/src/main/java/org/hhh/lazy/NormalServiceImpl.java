package org.hhh.lazy;

import org.springframework.stereotype.Service;

/**
 * @Author: hhh
 * @Date: 2021/10/23 11:15 下午
 * @Description TODO
 */
@Service
public class NormalServiceImpl implements NormalService{


	@Override
	public void test() {
		System.out.println("NormalServiceImpl");
	}
}
