package com.nt.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowHomeController {

	/*@RequestMapping("/home")
	public String showHome() {
		return "welcome";
	}
	*/
	
	/*@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}*/
	
	/*
	@RequestMapping("/process")
	public String showHome(Map<String, Object> map)
	{
		System.out.println("ShowHomeController.showHome()" + map.getClass());
		map.put("attr1",new Random().nextInt());
		map.put("sysDt", LocalDateTime.now());
		return "show_data";
	}
	*/
	
	/*@RequestMapping("/process")
	public String showHome(ModelMap map) {
		System.out.println("ShowHomeController.showHome()"+ map.getClass());
		map.addAttribute("attr1", new Random().nextInt(10000));
		map.addAttribute("sysDt", LocalDateTime.now());
		return "show_data";
	}*/
	
	/*
	@RequestMapping("/process")
	public String showHome(Model model) {
		System.out.println("ShowHomeController.showHome()" + model.getClass());
		model.addAttribute("attr1", new Random().nextInt(1000));
		model.addAttribute("sysDt", LocalDateTime.now().getMonth());
		return "show_data";
	}*/
	
	//taking handler method return type as model (I)
	//here we need to create model memory manually and set the values to model memory which is shared object.
	//here LVN is the request path itself.
	
	/*@RequestMapping("/process")
	private Model showHome() {
		Model model = new BindingAwareModelMap();
		model.addAttribute("attr1", "value 1222");
		model.addAttribute("sysDt", LocalDateTime.now().getMonth());
		
		return model;
	}*/
	
	/*
	
	@RequestMapping("/process")
	public Map<String, Object> showHome(){
		Map<String, Object> map = new HashMap<>();
		map.put("attr1", "attr1");
		map.put("sysDt", LocalDateTime.now().getDayOfMonth());
		return map;
	}
	*/
	
	//using model and view as the model object
	@RequestMapping("process")
	public ModelAndView showHome() {
		ModelAndView model = new ModelAndView();
		model.addObject("attr1", "Model and Viwe object");
		model.addObject("sysDt", LocalDateTime.now().getDayOfYear());
		model.setViewName("show_data");
		return model;
	}
	
}
