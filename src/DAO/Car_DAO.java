package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.Car_DTO;

public class Car_DAO {

	private Connection conn = null;
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl";
	private String id = "system";
	private String pwd = "1111";

	private ResultSet rs = null;

	private static Car_DAO cdao = new Car_DAO();
	
	public static Car_DAO getInstance() {
		return cdao;
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

	// 자동차 등록하기 메서드
	public void insertone(Car_DTO c) {
		String sql = "insert into car values(seq_auto.nextval,?,?,?,?,?,?)";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				Car_DTO cDTO = new Car_DTO();
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, c.getBrand());
				ppst.setString(2, c.getName());
				ppst.setString(3, c.getModel());
				ppst.setInt(4, c.getCc());
				ppst.setInt(5, c.getPrice());
				ppst.setInt(6, c.getEa());
				ppst.executeUpdate();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 자동차 목록보기 메서드
	public ArrayList<Car_DTO> selectAll() {
		String sql = "select * from car";
		Statement st = null;
		ArrayList<Car_DTO> cList = new ArrayList<>();
		if (conn() != null) {
			try {
				st = conn.createStatement();
				rs = st.executeQuery(sql);

				while (rs.next()) {
					Car_DTO cDTO = new Car_DTO();
					cDTO.setNo(rs.getInt("no"));
					cDTO.setBrand(rs.getString("brand"));
					cDTO.setName(rs.getString("name"));
					cDTO.setModel(rs.getString("model"));
					cDTO.setCc(rs.getInt("cc"));
					cDTO.setPrice(rs.getInt("price"));
					cDTO.setEa(rs.getInt("ea"));
					cList.add(cDTO);
				}
			} catch (Exception e) {

			} finally {
				try {
					if (st != null)
						st.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return cList;
	}

	// 이름으로 삭제하기 메서드
	public void delete(String name) {
		String sql = "delete from car where name = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setString(1, name);
				ppst.executeUpdate();
			} catch (Exception e) {

			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 자동차 재고수량 업데이트 메서드
	public void updateea(int ea, int no) {
		String sql = "update car set ea = ? where no = ?";
		PreparedStatement ppst = null;
		if (conn() != null) {
			try {
				ppst = conn.prepareStatement(sql);
				ppst.setInt(1, ea);
				ppst.setInt(2, no);
				ppst.executeUpdate();
			} catch (Exception e) {

			} finally {
				try {
					if (ppst != null)
						ppst.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 자동차 브랜드 검색목록보기 메서드
		public Car_DTO brandsearch(String brand) {
			String sql = "select * from car where brand = ?";
			PreparedStatement ppst = null;
			Car_DTO cdto = new Car_DTO();
			if (conn() != null) {
				try {
					ppst = conn.prepareStatement(sql);
					ppst.setString(1, brand);
					rs = ppst.executeQuery();

					if (rs.next()) {
						cdto.setNo(rs.getInt("no"));
						cdto.setBrand(rs.getString("brand"));
						cdto.setName(rs.getString("name"));
						cdto.setModel(rs.getString("model"));
						cdto.setCc(rs.getInt("cc"));
						cdto.setPrice(rs.getInt("price"));
						cdto.setEa(rs.getInt("ea"));
					}
				} catch (Exception e) {

				} finally {
					try {
						if (ppst != null)
							ppst.close();
						if (conn != null)
							conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			return cdto;
		}
	
	// 자동차 재고수량 감소 메서드
		public void updateeaminus(int no, int ea) {
			String sql = "update car set ea = ea - ? where no = ?";
			PreparedStatement ppst = null;
			if(conn() != null) {
				try {
					ppst = conn.prepareStatement(sql);
					ppst.setInt(1, ea);
					ppst.setInt(2, no);
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
	
	
	
	
	
	
}
