package com.fangjian.framework.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fangjian.framework.po.IepfUser;
import com.fangjian.framework.service.IepfUserService;


@Controller
@RequestMapping("/demoController") 
public class DemoAction  {
	
	@Autowired
	private IepfUserService iepfUserService;
	

	@RequestMapping("/index") 
	public ModelAndView  login(HttpServletRequest request,HttpServletResponse response, IepfUser vo) throws Exception{
		System.out.println("username:"+vo.getUsername());
		System.out.println("password:"+vo.getPassword());
		ModelAndView mv = new ModelAndView("/success");
		IepfUser bo = new IepfUser();
		bo.setUsername(vo.getUsername());
		bo.setPassword(vo.getPassword());
		mv.addObject("vo", vo);
		this.iepfUserService.saveEntry(bo);
		return mv;
	}
	
}
