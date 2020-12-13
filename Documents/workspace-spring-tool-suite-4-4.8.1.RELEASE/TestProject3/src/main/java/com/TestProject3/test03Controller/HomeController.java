package com.TestProject3.test03Controller;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.TestProject3.dto.TestDto;
import com.TestProject3.mapper.TestMapper;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	TestMapper tm;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value="selectTest")
	public String selectTest() {
		System.out.println("selectTest");
		/* ArrayList<TestDto> dto = tm.selectTest(); */
		System.out.println(tm.selectTest());
		return "result/selectTest";
	}
	
	@RequestMapping("insertTest")
	public String insertTest(TestDto dto) {
		System.out.println("insertTest");
		int result = tm.insertTest(dto);
		System.out.println("result: " + result);
        System.out.println(tm.selectTest());
		return "result/insertTest";
	}
	
	@RequestMapping(value="selectTest2")
	public String selectTest2(@ModelAttribute("age") int age, Model model) {
		System.out.println("selectTest2");
		System.out.println(tm.selectTest2(age));
		ArrayList<TestDto> dto = tm.selectTest2(age);
		model.addAttribute("dto", dto);
		return "result/selectTest2";
	}
}
