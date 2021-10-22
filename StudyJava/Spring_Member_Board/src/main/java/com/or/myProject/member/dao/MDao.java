package com.or.myProject.member.dao;

import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.or.myProject.Constant;
import com.or.myProject.member.dto.MDto;


public class MDao {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	public MDao() {
		template = Constant.template;
	}
	
	//회원가입
	public void join(MDto dto) {	
		String query = "insert into S_MEMBER values (?,?,?,?,?,?,?,?)";
		template.update(query,dto.getM_Id(),dto.getM_Pwd(),dto.getM_Email(),dto.getM_Name(),
				dto.getM_Num1(),dto.getM_Num2(),dto.getM_Intro(),new Timestamp(System.currentTimeMillis()));
	}
	
	//로그인
	public String login(String m_Id, String m_Pwd) {
		String query = "select * from S_MEMBER where m_Id ='"+m_Id+"'";
		String returnId = null;
		
		try {
			MDto dto = template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
			// 이부분 때문에 dto에 기본 생성자가 없으면 안된다.

			if (m_Id.equals(dto.getM_Id())) {
				if (m_Pwd.equals(dto.getM_Pwd())) { // 아이디와 비밀번호가 모두 일치할 경우 id만 return
					returnId = dto.getM_Id();
					System.out.println("일치할 경우 id : " + returnId);
				} else { // 일치하지 않을경우
					returnId = null;
					System.out.println("일치하지 않을 경우 id : " + returnId); // 이부분은 OK
				}
			}	
		} catch (Exception e) {
			returnId = null;	//값이 존재하지 않을경우
			System.out.println("값이 존재하지 않을경우 id : " + returnId);
		}
		return returnId;
	}
	
	//개인정보 확인
	public MDto myInfo(String id) {
		String query = "select * from S_MEMBER where m_Id ='"+id+"'";
		return template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	}
	
	

}
