package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AllA;
import model.SgA;
import model.Todo;
import model.TodoA;
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

			//達成度取得
			public AllA achieve(int number,String month) {
				Connection conn = null;
				List<SgA> sgList = new ArrayList<SgA>();
				List<Integer> sgidList = new ArrayList<Integer>();
				int LgA=0;
				String lg="";
				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
				//LGID取得
					// SQL文を準備する
					String sql="select LG,LGID from LGOAL where NUMBER=? and MONTH=?";
					PreparedStatement pStmt = conn.prepareStatement(sql);

					// SQL文を完成させる
						pStmt.setInt(1, number);
						pStmt.setString(2, month);

					// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();
						rs.next();
						lg=rs.getString("LG");
						int lgid=rs.getInt("LGID");


				//SGIDの個数を取得
					// SQL文を準備する
					String sql2="select count(SGID) from SGOAL where LGID=?";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);

					// SQL文を完成させる
						pStmt2.setInt(1, lgid);
					ResultSet rs2 = pStmt2.executeQuery();
					rs2.next();
					int sgnum=rs2.getInt("count(SGID)");
				//SGIDを取得
					// SQL文を準備する
					String sql5="select SGID from SGOAL where LGID=?";
					PreparedStatement pStmt5 = conn.prepareStatement(sql5);

					// SQL文を完成させる
						pStmt5.setInt(1, lgid);

					// SQL文を実行し、結果表を取得する
								ResultSet rs5 = pStmt5.executeQuery();
								// 結果表をコレクションにコピーする
								while (rs5.next()) {
									sgidList.add(rs5.getInt("SGID"));
								}
				//todoAを取得
					for(int i=0;i<sgnum;i++) {
						List<TodoA> todoList = new ArrayList<TodoA>();
					// SQL文を準備する
					String sql4="select * from TODOTB where SGID=?";
					PreparedStatement pStmt4 = conn.prepareStatement(sql4);

					// SQL文を完成させる
						pStmt4.setInt(1, sgidList.get(i));

					// SQL文を実行し、結果表を取得する
								ResultSet rs4 = pStmt4.executeQuery();
								// 結果表をコレクションにコピーする
								while (rs4.next()) {
									TodoA card = new TodoA(
									rs4.getInt("TODOID"),
									rs4.getInt("SGID"),
									rs4.getString("TODO"),
									rs4.getInt("ACHIEVE")
									);
									todoList.add(card);
								}

				//todoの個数を取得
					int todonum=todoList.size();
					if(todonum==0) {
						todonum++;
					}
				//短期目標達成度を入力
					//SGIDを取得
					// SQL文を準備する
					String sql3="select SG from SGOAL where SGID=?";
					PreparedStatement pStmt3 = conn.prepareStatement(sql3);

					// SQL文を完成させる
						pStmt3.setInt(1, sgidList.get(i));

					// SQL文を実行し、結果表を取得する
					ResultSet rs3 = pStmt3.executeQuery();
					rs3.next();
						int achieve=0;
						for(int k=0;k<todonum;k++) {
							achieve=achieve+todoList.get(k).gettAchieve();
						}
						SgA card = new SgA(
						sgidList.get(i),
						lgid,
						rs3.getString("SG"),
						(achieve/todonum),
						todoList
						);
						sgList.add(card);
					}

				//長期目標達成度を入力
					for(int l=0;l<sgnum;l++) {
						LgA=LgA+sgList.get(l).getsAchieve();
					}
					LgA=(LgA/sgnum);

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
				//データを格納
				AllA card = new AllA(
						lg,
						LgA,
						sgList
						);
				return card;
			}


		//達成度の入力
			// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
			public boolean update(int todoid,int achieve) {
				Connection conn = null;
				boolean result = false;

				try {
					// JDBCドライバを読み込む
					Class.forName("org.h2.Driver");

					// データベースに接続する
					conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");

					// SQL文を準備する
					String sql = "update TODOTB set ACHIEVE = ? where TODOID = ?";
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
