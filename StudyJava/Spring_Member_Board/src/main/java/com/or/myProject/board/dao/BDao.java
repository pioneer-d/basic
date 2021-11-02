package com.or.myProject.board.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.or.myProject.Constant;
import com.or.myProject.board.dto.BDto;

public class BDao {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	public BDao() {
		template = Constant.template;
	}
	
	public ArrayList<BDto> list(){	//��� �� �ҷ�����
			//array
		String query = "select * from S_BOARD order by b_Group desc, b_Step asc";
		return (ArrayList<BDto>)template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void write(final String id, final String title, final String content) {	//���Է��ϱ�
		String query = "insert into S_BOARD values(S_BOARD_seq.nextval,?,?,?,?,0,S_BOARD_seq.currval,0,0)";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, id);
				ps.setString(2, title);
				ps.setString(3, content);
				ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
			}
		});
	}
	
	public BDto viewContent(String num){	//�� 1�� �ڼ��� ����
		int b_Num = Integer.parseInt(num);
		upHit(b_Num);
		String query = "select * from S_BOARD where b_Num ='"+b_Num+"'";
		return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
	}
	
	public void modify(final String b_Num, final String b_Title, final String b_Content) {	//�� �����ϱ�
		String query = "update S_BOARD set b_Title = ?, b_Content = ? where b_Num = ?";
		template.update(query, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1,b_Title);
				ps.setString(2, b_Content);
				ps.setInt(3, Integer.parseInt(b_Num));
			}
		});
	}
	
	public void delete(String b_Num) {	//�� �����ϱ�
		int num = Integer.parseInt(b_Num);
		String query = "delete from S_BOARD where b_Num ='"+num+"'";
		template.update(query);
	}
	
	public void upHit(int b_Num) {	//��ȸ�� ����
		String query = "update S_BOARD set b_Hit = b_Hit+1 where b_Num = '"+b_Num+"'";
		template.update(query);
	}
	
	//��۴ޱ�
	public void reply(final String m_Id, final String b_Title, final String b_Content, final String b_Group, final String b_Step, final String b_Indent ) {
		reply_shape(b_Group, b_Step);
		String query = "insert into S_BOARD values (S_BOARD_seq.nextval,?,?,?,?,0,?,?,?)";
		template.update(query,new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, m_Id);
				ps.setString(2, b_Title);
				ps.setString(3, b_Content);
				ps.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				ps.setInt(5,Integer.parseInt(b_Group));
				ps.setInt(6,Integer.parseInt(b_Step)+1);
				ps.setInt(7,Integer.parseInt(b_Indent)+1);
			}
		});
	}
	
	//��� ����
	public void reply_shape(final String b_Group, final String b_Step) {
		String query = "update S_BOARD set b_Step = b_Step + 1 where b_Group = ? and b_Step > ?";
		template.update(query, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setInt(1, Integer.parseInt(b_Group));
				ps.setInt(2, Integer.parseInt(b_Step));
			}
		});
	}
	

}
