package com.TestProject4.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.TestProject4.testDto.TestDto;

public interface TestMapper {

	@Insert("INSERT INTO TEST_TBL2 VALUES(#{userName}, #{userPhone}, #{userBirth})")
	public int insertUserData(TestDto dto);
	
	@Select("SELECT * FROM TEST_TBL2")
	public ArrayList<TestDto> selectUserData();
	
	@Select("SELECT * FROM TEST_TBL2 WHERE USERNAME=#{userName}")
	public TestDto modifyUser(String userName);
	
	@Update("UPDATE TEST_TBL2 SET USERPHONE=#{userPhone}, USERBIRTH=#{userBirth} WHERE USERNAME=#{userName}")
	public int updateUser(TestDto dto);
	
	@Delete("DELETE FROM TEST_TBL2 WHERE USERNAME=#{username}")
	public int deleteUser(String userName);
}
