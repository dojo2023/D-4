//2023-06-26 h13
//2023-06-27 h11
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Task;
public class TasktbDAO {
	//取得
	public List<Task> task(int number,String day){
		Connection conn = null;
		List<Task> taskList = new ArrayList<Task>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");

			// SQL文を準備する
			String sql="SELECT * FROM TASKTB where NUMBER=? and HOUR_S LIKE ? ORDER BY HOUR_S";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setInt(1, number);
				pStmt.setString(2, day +"%");

			// SQL文を実行し、結果表を取得する
						ResultSet rs = pStmt.executeQuery();

						// 結果表をコレクションにコピーする
						while (rs.next()) {
							Task card = new Task(
							rs.getInt("NUMBER"),
							rs.getString("HOUR_S"),
							rs.getString("HOUR_E"),
							rs.getString("TASK")
							);
							taskList.add(card);
						}
					}
					catch (SQLException e) {
						e.printStackTrace();
						taskList = null;
					}
					catch (ClassNotFoundException e) {
						e.printStackTrace();
						taskList = null;
					}
					finally {
						// データベースを切断
						if (conn != null) {
							try {
								conn.close();
							}
							catch (SQLException e) {
								e.printStackTrace();
								taskList = null;
							}
						}
					}
		return taskList;
	}
	//変更・消去・追加
	public boolean updateTask(Task task) {
		Connection conn = null;
		boolean result1 =false;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/amateur", "sa", "");
			// SQL文を準備する
			String sql = "select COUNT(*) from TASKTB where NUMBER=? and HOUR_S=? and HOUR_E=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる
				pStmt.setInt(1, task.getNumber());
				pStmt.setString(2, task.getHour_s());
				pStmt.setString(3, task.getHour_e());
			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// Taskがあるかどうかチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				result1 = true;
			}

			//Taskがある場合
			if(result1) {

				if(task.getTask() == null || task.getTask().equals("")) {//未記入ならtask消去
					// SQL文を準備する
					String sql2 = "delete from TASKTB where NUMBER=? and HOUR_S=? and HOUR_E=?";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);


					// SQL文を完成させる
						pStmt2.setInt(1, task.getNumber());
						pStmt2.setString(2, task.getHour_s());
						pStmt2.setString(3, task.getHour_e());


					// SQL文を実行する
					if (pStmt2.executeUpdate() == 1) {
						result = true;
					}
				}else {//task変更
					// SQL文を準備する
					String sql2 = "update TASKTB set TASK=? where NUMBER=? and HOUR_S= ? and HOUR_E=?";
					PreparedStatement pStmt2 = conn.prepareStatement(sql2);


					// SQL文を完成させる
						pStmt2.setString(1, task.getTask());
						pStmt2.setInt(2, task.getNumber());
						pStmt2.setString(3, task.getHour_s());
						pStmt2.setString(4, task.getHour_e());



					// SQL文を実行する
					if (pStmt2.executeUpdate() == 1) {
						result = true;
					}
				}
			}else {//Taskがない場合追加
				// SQL文を準備する
				String sql2 = "insert into TASKTB (NUMBER,HOUR_S,HOUR_E,TASK) values ( ?,?,?,?)";
				PreparedStatement pStmt2 = conn.prepareStatement(sql2);


				// SQL文を完成させる
					pStmt2.setInt(1, task.getNumber());
					pStmt2.setString(2, task.getHour_s());
					pStmt2.setString(3, task.getHour_e());
					pStmt2.setString(4, task.getTask());

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
