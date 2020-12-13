package com.TestProject3.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.TestProject3.dto.TestDto;

public interface TestMapper {

	@Select("SELECT * FROM TESTTBL")
	public ArrayList<TestDto> selectTest();
	
	@Insert("INSERT INTO TESTTBL VALUES(#{name}, #{age}, #{addr})")
	public int insertTest(TestDto dto);
	
	@Select("SELECT * FROM TESTTBL WHERE AGE > #{age}")
	public ArrayList<TestDto> selectTest2(int age);
}
