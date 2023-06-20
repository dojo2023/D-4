package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Todo;
public class TodotbDAO {
	//取得
			public List<Todo> todo(int number ,String month){
				Connection conn = null;
				List<Todo> todoList = new ArrayList<Todo>();
				List<Integer> sgidList = new ArrayList<Integer>();

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
					//LGID取得
					// SQL文を準備する
					String sql="select LGID from LGOAL where NUMBER=? and MONTH=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
						pStmt.setInt(1, number);
						pStmt.setString(2, month);

					// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();
						rs.next();
						int lgid=rs.getInt("LGID");

					//SGIDを取得
					// SQL文を準備する
					String sql2="select SGID from SGOAL where LGID=?";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);

					// SQL文を完成させる
						pStmt2.setInt(1, lgid);

					// SQL文を実行し、結果表を取得する
					ResultSet rs2 = pStmt2.executeQuery();
					while (rs2.next()) {
						sgidList.add(rs2.getInt("SGID"));
					}
					int num=sgidList.size();

					//各短期目標に対してtodoを取得
					for(int i=0;i<num;i++) {
					// SQL文を準備する
					String sql3="select * from TODOTB where SGID=?";
					PreparedStatement pStmt3 = conn.prepareStatement(sql3);

					// SQL文を完成させる
						pStmt3.setInt(1, sgidList.get(i));

					// SQL文を実行し、結果表を取得する
								ResultSet rs3 = pStmt3.executeQuery();

								// 結果表をコレクションにコピーする
								while (rs3.next()) {
									Todo card = new Todo(
									rs3.getInt("TODOID"),
									rs3.getInt("SGID"),
									rs3.getString("TODO"),
									rs3.getInt("ACHIEVE")
									);
									todoList.add(card);
								}
					}
							}
							catch (SQLException e) {
								e.printStackTrace();
								todoList = null;
							}
							catch (ClassNotFoundException e) {
								e.printStackTrace();
								todoList = null;
							}
							finally {
								// データベースを切断
								if (conn != null) {
									try {
										conn.close();
									}
									catch (SQLException e) {
										e.printStackTrace();
										todoList = null;
									}
								}
							}
				return todoList;
			}

		//達成度入力
			public boolean achieve(int todoid,int achieve) {
				Connection conn = null;
				boolean result =false;
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");

					// SQL文を準備する
					String sql = "update TODOTB set ACHIEVE=? where TODOID=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
						pStmt.setInt(1, achieve);
						pStmt.setInt(2, todoid);


					// SQL文を実行する
					if (pStmt.executeUpdate() == 1) {
						result = true;
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
