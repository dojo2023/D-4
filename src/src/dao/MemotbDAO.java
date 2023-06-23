//2023-06-23
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Memo;
public class MemotbDAO {
	//取得
		public String memo(int number,String day){
			Connection conn = null;
			String memo="";
			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");

				// SQL文を準備する
				String sql="SELECT MEMO FROM MEMOTB where NUMBER=? and DAY = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
					pStmt.setInt(1, number);
					pStmt.setString(2, day);

				// SQL文を実行し、結果表を取得する
							ResultSet rs = pStmt.executeQuery();

							// 結果表をコレクションにコピーする
							if(rs.next()) {
							memo=rs.getString("MEMO");
						}
			}
						catch (SQLException e) {
							e.printStackTrace();
							memo = "";
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
							memo = "";
						}
						finally {
							// データベースを切断
							if (conn != null) {
								try {
									conn.close();
								}
								catch (SQLException e) {
									e.printStackTrace();
									memo = "";
								}
							}
						}
			return memo;
		}
	//追加・変更
		public boolean updateMemo(Memo memo) {
			Connection conn = null;
			boolean result1 =false;
			boolean result = false;

			try {
				// JDBCドライバを読み込む
				Class.forName("org.h2.Driver");

				// データベースに接続する
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
				// SQL文を準備する
				String sql = "select COUNT(*) from MEMOTB where NUMBER=? and DAY=?";
				PreparedStatement pStmt = conn.prepareStatement(sql);
				// SQL文を完成させる
					pStmt.setInt(1, memo.getNumber());
					pStmt.setString(2, memo.getDay());
				// SELECT文を実行し、結果表を取得する
				ResultSet rs = pStmt.executeQuery();

				// memoがあるかどうかチェックする
				rs.next();
				if (rs.getInt("count(*)") == 1) {
					result1 = true;
				}

				//memoがある場合変更
				if(result1) {
					// SQL文を準備する
					String sql2 = "update MEMOTB set MEMO=? where NUMBER=? and DAY=?";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);


					// SQL文を完成させる
						pStmt2.setString(1, memo.getMemo());
						pStmt2.setInt(2, memo.getNumber());
						pStmt2.setString(3, memo.getDay());

					// SQL文を実行する
					if (pStmt2.executeUpdate() == 1) {
						result = true;
					}
				}else {//memoがない場合追加
					// SQL文を準備する
					String sql2 = "insert into MEMOTB (NUMBER,DAY,MEMO) values (?,?,?)";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);


					// SQL文を完成させる
						pStmt2.setInt(1, memo.getNumber());
						pStmt2.setString(2, memo.getDay());
						pStmt2.setString(3, memo.getMemo());
					// SQL文を実行する
					if (pStmt2.executeUpdate() == 1) {
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

