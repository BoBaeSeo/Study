package com.TestProject4.t4Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.TestProject4.mapper.TestMapper;
import com.TestProject4.testDto.TestDto;

@Controller
public class TestController {

	@Autowired
	TestMapper tm;
	
	@RequestMapping(value="testMain")
	public String testMain() {
		System.out.println("testMain");
		return "testPage/testMain";
	}
	@RequestMapping(value="insertForm")
	public String insertForm() {
		System.out.println("insertDB");
		return "testPage/insertForm"; 
	}
	@RequestMapping(value="insertTest")
	public String insertTest(TestDto dto) {
		System.out.println("insertTest");
		System.out.println(dto.getUserName());
		int insertResult = tm.insertUserData(dto);
		System.out.println(dto);
		System.out.println("insertResult: " + insertResult);
		return "testPage/testMain";
	}
	@RequestMapping(value="selectTest")
	public String selectTest(Model model) {
		System.out.println("selectTest");
		ArrayList<TestDto> userList=tm.selectUserData();
		System.out.println(userList);
		model.addAttribute("userList", userList);
		return "testPage/resultTest";
	}
	@RequestMapping(value="modifyTest")
	public String modifyTest(String userName, Model model) {
		TestDto dto = tm.modifyUser(userName);
		System.out.println(dto);
		model.addAttribute("dto", dto);
		return "testPage/modifyForm";
	}
	@RequestMapping(value="modifyUser")
	public String modifyUser(TestDto dto) {
		System.out.println("modifyUser");
		int updateResult = tm.updateUser(dto);
		System.out.println("updateResult: " + updateResult);
		return "testPage/testMain";
	}
	@RequestMapping(value="deleteTest")
	public String deleteTest(String userName) {
		System.out.println("deleteTest");
		int deleteResult = tm.deleteUser(userName);
		System.out.println("deleteResult: " + deleteResult);
		return "testPage/testMain";
	}
}
