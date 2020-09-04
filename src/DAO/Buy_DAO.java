package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Buy_DTO;

public class Buy_DAO {

	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";

	private ResultSet rs = null;

	private static Buy_DAO bdao = new Buy_DAO();
	
	public static Buy_DAO getInstance() {
		return bdao;
	}
	
	public Connection conn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pwd);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 자동차 구입하기 메서드
	public void buy(Buy_DTO b) {
		String sql = "insert into buycar values (?,?,?)";
		PreparedStatement ppst = null;
		if(conn() != null) {
			try {
				Buy_DTO bdto = new Buy_DTO();
				bdto.setUsername(b.getUsername());
				bdto.setNo(b.getNo());
				bdto.setEa(b.getEa());
				ppst.executeUpdate();
			} catch (Exception e) {
				
			} finally {
				try {
					if(ppst != null) ppst.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// 자동차 구매내역보기 메서드
	public ArrayList<Buy_DTO> selectAll() {
		String sql = "select * from buy";
		Statement st = null;
		ArrayList<Buy_DTO> bList = new ArrayList<>();
		if(conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);
				
				while(rs.next()) {
					Buy_DTO bdto = new Buy_DTO();
					bdto.setUsername(rs.getString("username"));
					bdto.setNo(rs.getInt("no"));
					bdto.setEa(rs.getInt("ea"));
					bList.add(bdto);
				}
				
			} catch (Exception e) {
				 
			} finally {
				try {
					if(st != null) st.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bList;
	}
	
	
	
	
	
	
}
