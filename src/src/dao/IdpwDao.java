package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Idpw;
public class IdpwDAO {
	//ログイン
    public boolean isLoginOK(Idpw idpw) {
		Connection conn = null;
		boolean loginResult = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
			// SELECT文を準備する
			String sql = "select count(*) from IDPW where NUMBER = ? and PW = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, idpw.getNumber());
			pStmt.setString(2,idpw.getPw());
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();
			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}
		// 結果を返す
		return loginResult;
	}

	//新規追加
	public int account(String name,String pw){
		Connection conn = null;
		boolean result=false;
		int number=0;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
			// SQL文を準備する
			String sql="insert into IDPW (NAME,PW) values(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
				pStmt.setString(1,name);
				pStmt.setString(2, pw);

				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			if(result) {
				// SQL文を準備する
			String sql2="select NUMBER from IDPW where NAME=? AND PW=?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			// SQL文を完成させる
				pStmt2.setString(1, name);
				pStmt2.setString(2, pw);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt2.executeQuery();
					// 結果表をコレクションにコピーする
					rs.next();
						number=rs.getInt("NUMBER");

				}

			}
				catch (SQLException e) {
					e.printStackTrace();
					number=0;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					number=0;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							number=0;
						}
					}
				}
	return number;
	}
	//名前取得
	public String name(Idpw idpw ){
		Connection conn = null;
		String name="";

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");

			// SQL文を準備する
			String sql="select NAME from IDPW where NUMBER=? and PW=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setInt(1, idpw.getNumber());
				pStmt.setString(2,idpw.getPw());

			// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();
						// 結果表をコレクションにコピーする
						rs.next();
							name =rs.getString("NAME");
					}
					catch (SQLException e) {
						e.printStackTrace();
						name = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						name = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								name = null;
							}
						}
					}
		return name;
	}


}