package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.beans.Transaction;
import com.revature.util.ConnectionUtil;

public class TransactionDaoJdbc implements TransactionDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.cu;

	@Override
	public Transaction getTransaction(int accountId) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM transactions WHERE accountid=?",
					new String[] { "transactionid" });
			;
			ps.setInt(1, accountId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Transaction t = new Transaction();
				t.setTransactionInfo(rs.getString("transactioninfo"));
				t.setTransactionTotal(rs.getInt("transactiontotal"));
				t.setAccountId(rs.getInt("accountid"));
				t.setTransactionId(rs.getInt("transactionid"));

				System.out.println(t);
			} // else {
//				log.warn("failed to find user with provided credentials from the db");
//				return null;
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void createTransaction(Transaction t) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO transactions (transactioninfo, transactiontotal, accountid) VALUES (?,?,?)",
					new String[] { "transactionid" });
			ps.setString(1, t.getTransactionInfo());
			ps.setDouble(2, t.getTransactionTotal());
			ps.setDouble(3, t.getAccountId());

			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				t.setTransactionId(rs.getInt("transactionid"));
			} else {

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for (StackTraceElement ste : e.getStackTrace()) {
				log.error(ste);

			}
			// log.warn("failed to create new user");

		}

	}

	@Override
	public Transaction getAllTransactions() {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM transactions",
					new String[] { "transactionid" });
			;

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Transaction t = new Transaction();
				t.setTransactionInfo(rs.getString("transactioninfo"));
				t.setTransactionTotal(rs.getInt("transactiontotal"));
				t.setAccountId(rs.getInt("accountid"));
				t.setTransactionId(rs.getInt("transactionid"));

				System.out.println(t);
			} // else {
//				log.warn("failed to find user with provided credentials from the db");
//				return null;
//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
