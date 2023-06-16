package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public List<Idpw> account(Idpw info){
		Connection conn = null;
		boolean result=false;
		List<Idpw> infoList=new ArrayList<Idpw>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");
			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
			// SQL文を準備する
			String sql="insert into IDPW (NAME,PW) values(?,?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
				pStmt.setString(1, info.getName());
				pStmt.setString(2, info.getPw());

				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			if(result) {
				// SQL文を準備する
			String sql2="select * from IDPW where NAME=? AND PW=?";
			PreparedStatement pStmt2 = conn.prepareStatement(sql2);
			// SQL文を完成させる
				pStmt2.setString(1, info.getName());
				pStmt2.setString(2, info.getPw());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt2.executeQuery();
					// 結果表をコレクションにコピーする
					while (rs.next()) {
						Idpw card = new Idpw(
						rs.getInt("NUMBER"),
						rs.getString("NAME"),
						rs.getString("PW")
						);
						infoList.add(card);
					}
				}

			}
				catch (SQLException e) {
					e.printStackTrace();
					infoList = null;
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
					infoList = null;
				}
				finally {
					// データベースを切断
					if (conn != null) {
						try {
							conn.close();
						}
						catch (SQLException e) {
							e.printStackTrace();
							infoList = null;
						}
					}
				}
	return infoList;
	}
}