package com.aia.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aia.firstspring.member.domain.OrderCommand;

@Controller
@RequestMapping("/order/order")
public class OrderController {

	// 동일한 URL로 GET,POST 방식 모두 처리할 경우
	@RequestMapping(method = RequestMethod.GET)
	public String getOrderForm() {
		return "order/orderForm";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String orderComplete(@ModelAttribute("userOrder") OrderCommand order) {
		return "order/orderComplete";
	}

}
