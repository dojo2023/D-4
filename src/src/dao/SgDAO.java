//2023-06-23 h1630
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sg;
public class SgDAO {
	//取得
			public List<Sg> sg(int number,String month){
				Connection conn = null;
				List<Sg> sgList = new ArrayList<Sg>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
					// SQL文を準備する
					String sql="select LGID from LGOAL where NUMBER=? and MONTH = ?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
						pStmt.setInt(1, number);
						pStmt.setString(2, month);

					// SQL文を実行し、結果表を取得する
								ResultSet rs = pStmt.executeQuery();
								rs.next();
								int lgid=rs.getInt("LGID");

					// SQL文を準備する
					String sql2="select * from SGOAL where LGID=?";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);

					// SQL文を完成させる
						pStmt2.setInt(1, lgid);

					// SQL文を実行し、結果表を取得する
								ResultSet rs2 = pStmt2.executeQuery();

								// 結果表をコレクションにコピーする
								while (rs2.next()) {
									Sg card = new Sg(
									rs2.getInt("SGID"),
									rs2.getInt("LGID"),
									rs2.getString("DAY_S"),
									rs2.getString("DAY_E"),
									rs2.getString("SG")
									);
									sgList.add(card);
								}
							}
							catch (SQLException e) {
								e.printStackTrace();
								sgList = null;
							}
							catch (ClassNotFoundException e) {
								e.printStackTrace();
								sgList = null;
							}
							finally {
								// データベースを切断
								if (conn != null) {
									try {
										conn.close();
									}
									catch (SQLException e) {
										e.printStackTrace();
										sgList = null;
									}
								}
							}
				return sgList;
			}
		//追加・変更・消去
			public boolean updateSg(Sg sg) {
				Connection conn = null;
				boolean result1 =false;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
					// SQL文を準備する
					String sql = "select COUNT(*) from SGOAL where SGID=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);
					// SQL文を完成させる
						pStmt.setInt(1, sg.getSgid());
					// SELECT文を実行し、結果表を取得する
					ResultSet rs = pStmt.executeQuery();

					// 短期目標があるかどうかチェックする
					rs.next();
					if (rs.getInt("count(*)") == 1) {
						result1 = true;
					}

					//短期目標がある場合
					if(result1) {
						if(sg.getSg() == null || sg.getSg().equals("")) {//未記入なら短期目標消去
							// SQL文を準備する
							String sql2 = "delete from SGOAL where SGID=?";
							PreparedStatement pStmt2 = conn.prepareStatement(sql2);


							// SQL文を完成させる
								pStmt2.setInt(1, sg.getSgid());


							// SQL文を実行する
							if (pStmt2.executeUpdate() == 1) {
								result = true;
							}
						}else {//短期目標変更
							// SQL文を準備する
							String sql2 = "update SGOAL set SG=? where SGID= ?";
							PreparedStatement pStmt2 = conn.prepareStatement(sql2);


							// SQL文を完成させる
								pStmt2.setString(1, sg.getSg());
								pStmt2.setInt(2, sg.getSgid());


							// SQL文を実行する
							if (pStmt2.executeUpdate() == 1) {
								result = true;
							}
						}
					}else {//短期目標がない場合追加
						//長期目標IDを取得
							// SQL文を準備する
							String sql2 = "select LGID from LGOAL where NUMBER = ? and MONTH = ?";
							PreparedStatement pStmt2 = conn.prepareStatement(sql2);


							// SQL文を完成させる
								pStmt2.setInt(1, sg.getNumber());
								pStmt2.setString(2, sg.getMonth());

								// SQL文を実行し、結果表を取得する
								ResultSet rs2 = pStmt2.executeQuery();
								rs2.next();
								int lgid=rs2.getInt("LGID");
						//短期目標追加
							// SQL文を準備する
							String sql3 = "insert into SGOAL (LGID,DAY_S,DAY_E,SG) values ( ?,?,?,?)";
							PreparedStatement pStmt3 = conn.prepareStatement(sql3);


							// SQL文を完成させる
								pStmt3.setInt(1, lgid);
								pStmt3.setString(2, sg.getDay_s());
								pStmt3.setString(3, sg.getDay_e());
								pStmt3.setString(4, sg.getSg());
							// SQL文を実行する
							if (pStmt3.executeUpdate() == 1) {
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
