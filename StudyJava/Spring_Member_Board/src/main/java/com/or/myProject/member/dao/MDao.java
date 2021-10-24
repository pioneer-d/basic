package com.or.myProject.member.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

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
	
	//ȸ������
	public void join(MDto dto) {	
		String query = "insert into S_MEMBER values (?,?,?,?,?,?,?,?)";
		template.update(query,dto.getM_Id(),dto.getM_Pwd(),dto.getM_Email(),dto.getM_Name(),
				dto.getM_Num1(),dto.getM_Num2(),dto.getM_Intro(),new Timestamp(System.currentTimeMillis()));
	}
	
	//�α���
	public String login(String m_Id, String m_Pwd) {
		String query = "select * from S_MEMBER where m_Id ='"+m_Id+"'";
		String returnId = null;
		
		try {
			MDto dto = template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
			// �̺κ� ������ dto�� �⺻ �����ڰ� ������ �ȵȴ�.

			if (m_Id.equals(dto.getM_Id())) {
				if (m_Pwd.equals(dto.getM_Pwd())) { // ���̵�� ��й�ȣ�� ��� ��ġ�� ��� id�� return
					returnId = dto.getM_Id();
					System.out.println("id�� pwd�� ��ġ�� ��� id : " + returnId);
				} else { // ��ġ���� �������
					returnId = null;
					System.out.println("id�� pwd�� ��ġ���� ���� ���"); // �̺κ��� OK
				}
			}	
		} catch (Exception e) {
			returnId = null;	//���� �������� �������
			System.out.println("�α��� id ���� �������� ���� ���");
		}
		return returnId;
	}
	
	//�������� Ȯ��
	public MDto myInfo(String id) {
		String query = "select * from S_MEMBER where m_Id ='"+id+"'";
		return template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	}
	
	//�������� ����(��� ���� �ڱ�Ұ�)
	public void myInfoUpdate(String id, final String pwd, final String mail, final String intro) {
		String query = "update S_MEMBER set m_Pwd = ?, m_Email = ?, m_Intro = ? where m_Id ='"+id+"'";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, pwd);
				ps.setString(2,mail);
				ps.setString(3, intro);
			}
		});
	}
	
	//�Ϲݻ���� ���̵� ���
	public List<String> memberList() {
		String query = "select m_Id from S_MEMBER";
		return template.queryForList(query, String.class);
	}
	
	//����� Ż��
	public void deleteM(String id) {
		deleteB(id);
		String query = "delete from S_MEMBER where m_Id ='"+id+"'";
		template.update(query);
	}
	
	//�Խñ� ����
	public void deleteB(String id) {
		String query = "delete from S_BOARD where m_Id ='"+id+"'";
		template.update(query);
		
	}

}
