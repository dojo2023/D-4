package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LgDao {
//取得
	public String lg(int number,String month ){
		Connection conn = null;
		String lg="";

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");

			// SQL文を準備する
			String sql="select LG from LGOAL where NUMBER=? and MONTH?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setInt(1, number);
				pStmt.setString(2, month);

			// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							lg = rs.getString("LG");
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						lg = "";
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						lg = "";
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								lg = "";
							}
						}
					}
		return lg;
	}

//追加・変更
	public boolean updateLg(Lg goal) {
		Connection conn = null;
		boolean result1 =false;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
			// SQL文を準備する
			String sql = "select COUNT(*),LGID from LGOAL where NUMBER=? and MONTH=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
				pStmt.setInt(1, goal.getNumber());
				pStmt.setString(2, goal.getMonth());
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 長期目標があるかどうかチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				result1 = true;
			}
			int lgid=rs.getInt("LGID");

			//長期目標がある場合変更
			if(result1) {
				// SQL文を準備する
				String sql2 = "update LGOAL set LG=? where LGID=?";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);


				// SQL文を完成させる
					pStmt.setString(1, goal.getLg());
					pStmt.setInt(2, lgid);

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}else {//長期目標がない場合追加
				// SQL文を準備する
				String sql2 = "insert into LGOAL (NUMBER,MONTH,LG) values ( ?,?,?)";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);


				// SQL文を完成させる
					pStmt.setInt(1, goal.getNumber());
					pStmt.setString(2, goal.getMonth()+"-01");
				if (goal.getLg() != null && !goal.getLg().equals("")) {
					pStmt.setString(3, goal.getLg());
				}
				else {
					pStmt.setString(3, "");
				}

				// SQL文を実行する
				if (pStmt.executeUpdate() == 1) {
					result = true;
				}
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}
