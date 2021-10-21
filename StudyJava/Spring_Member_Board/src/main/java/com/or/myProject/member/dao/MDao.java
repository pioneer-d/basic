package com.or.myProject.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.or.myProject.Constant;
import com.or.myProject.member.dto.MDto;


public class MDao {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	public MDao() {
		template = Constant.template;
	}
	
	public void join(MDto dto) {
		String query = "insert into S_MEMBER values (?,?,?,?,?,?,?,?)";
		template.update(query,dto.getM_Id(),dto.getM_Pwd(),dto.getM_Email(),dto.getM_Name(),
				dto.getM_Num1(),dto.getM_Num2(),dto.getM_Intro(),new Timestamp(System.currentTimeMillis()));
	}
	
	//select Į��1, Į��2 from ���̺��;
	
	public String login(String m_Id, String m_Pwd) {
		String query = "select * from S_MEMBER where m_Id ='"+m_Id+"'";
		String returnId = null;
		
		try {
			MDto dto = template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
			// �̺κ� ������ dto�� �⺻ �����ڰ� ������ �ȵȴ�.

			if (m_Id.equals(dto.getM_Id())) {
				if (m_Pwd.equals(dto.getM_Pwd())) { // ���̵�� ��й�ȣ�� ��� ��ġ�� ��� id�� return
					returnId = dto.getM_Id();
					System.out.println("��ġ�� ��� id : " + returnId);
				} else { // ��ġ���� �������
					returnId = null;
					System.out.println("��ġ���� ���� ��� id : " + returnId); // �̺κ��� OK
				}
			}	
		} catch (Exception e) {
			returnId = null;	//���� �������� �������
			System.out.println("���� �������� ������� id : " + returnId);
		}

		
		return returnId;
	}
	
	
	

}
