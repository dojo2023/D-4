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

		//達成度入力
			public List<AllA> achieve(int number,String month) {
				Connection conn = null;
				List<SgA> sgList = new ArrayList<SgA>();
				List<TodoA> todoList = new ArrayList<TodoA>();
				List<Integer> sgidList = new ArrayList<Integer>();
				List<AllA> avhieveList = new ArrayList<AllA>();
				int LgA=0;
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


				//SGIDの個数を取得
					// SQL文を準備する
					String sql2="select count(SGID) from SGOAL where LGID=?";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);

					// SQL文を完成させる
						pStmt2.setInt(1, lgid);
					ResultSet rs2 = pStmt2.executeQuery();
					rs2.next();
					int sgnum=rs2.getInt("count(SGID)");
				//todoAを取得
					for(int i=0;i<sgnum;i++) {
					// SQL文を準備する
					String sql4="select TODOID,SGID,ACHIEVE from TODOTB where SGID=?";
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
									rs4.getInt("ACHIEVE")
									);
									todoList.add(card);
								}
				//todoの個数を取得
					int todonum=todoList.size();
				//短期目標達成度を入力
					//SGIDを取得
					// SQL文を準備する
					String sql3="select SGID,LGID from SGOAL where LGID=?";
					PreparedStatement pStmt3 = conn.prepareStatement(sql3);

					// SQL文を完成させる
						pStmt3.setInt(1, lgid);

					// SQL文を実行し、結果表を取得する
					ResultSet rs3 = pStmt3.executeQuery();
					while (rs3.next()) {
						int achieve=0;
						int j=0;
						for(int k=0;k<todonum;k++) {
						if(rs3.getInt("SGID")==todoList.get(k).getSgId()) {
							achieve=+todoList.get(k).gettAchieve();
							j++;
							}
						}
						if(j==0) {
							j++;//0では割れないため１にする
						}
						SgA card = new SgA(
						rs3.getInt("SGID"),
						rs3.getInt("LGID"),
						achieve/j
						);
						sgList.add(card);
					}

				//長期目標達成度を入力
					for(int l=0;l<sgnum;l++) {
						LgA=+sgList.get(l).getsAchieve();
					}
					LgA=LgA/sgnum;
					}
							}
							catch (SQLException e) {
								e.printStackTrace();
								avhieveList = null;
							}
							catch (ClassNotFoundException e) {
								e.printStackTrace();
								avhieveList = null;
							}
							finally {
								// データベースを切断
								if (conn != null) {
									try {
										conn.close();
									}
									catch (SQLException e) {
										e.printStackTrace();
										avhieveList = null;
									}
								}
							}
				AllA card = new AllA(
						LgA,
						sgList,
						todoList
						);
				avhieveList.add(card);
				return avhieveList;
			}


}
