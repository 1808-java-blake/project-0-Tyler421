package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.beans.Account;
import com.revature.util.ConnectionUtil;

public class AccountDaoJdbc implements AccountDao {
	private Logger log = Logger.getRootLogger();
	private ConnectionUtil cu = ConnectionUtil.cu;

	@Override
	public void createAccount(Account u) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(
					"INSERT INTO accounts (accountname, accounttype, balance, userid) VALUES (?,?,?,?)",
					new String[] { "accountid" });
			ps.setString(1, u.getAccountName());
			ps.setString(2, u.getAccountType());
			ps.setDouble(3, u.getBalance());
			ps.setInt(4, u.getUserId());
			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " records created");

			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				u.setAccountId(rs.getInt("accountid"));
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
	public void updateAccount(Account u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccount(Account u) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Account> findByUserId(int userId) {
		try (Connection conn = cu.getConnection()) {
			List<Account> accounts = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE userid=?",
					new String[] { "accountid" });
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Account u = new Account();
				u.setAccountName(rs.getString("accountname"));
				u.setUserId(rs.getInt("userid"));
				u.setAccountType(rs.getString("accounttype"));
				u.setBalance(rs.getDouble("balance"));
				u.setAccountId(rs.getInt("accountid"));

				accounts.add(u);
			}
			return accounts;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Account getBankAccount(int userId) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE userid=? ");
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Account u = new Account();
				u.setAccountName(rs.getString("accountname"));
				u.setUserId(rs.getInt("userid"));
				u.setAccountType(rs.getString("accounttype"));
				u.setBalance(rs.getDouble("balance"));
				return u;
			} else {
				log.warn("failed to find user with provided credentials from the db");
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Account findByAccountName(String accountName) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE accountname=? ",
					new String[] { "accountid" });
			ps.setString(1, accountName);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				Account u = new Account();
				u.setAccountName(rs.getString("accountname"));
				u.setUserId(rs.getInt("userid"));
				u.setAccountType(rs.getString("accounttype"));
				u.setBalance(rs.getDouble("balance"));
				u.setAccountId(rs.getInt("accountid"));
				return u;
			} else {
				log.warn("failed to find user with provided credentials from the db");
				return null;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

//	public List<Account> findByAccountName(String accountName) {
//		try (Connection conn = cu.getConnection()) {
//			List<Account> accounts = new ArrayList<>();
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts WHERE accountname=?");
//			ps.setString(1, accountName);
//			ResultSet rs = ps.executeQuery();
//			while (rs.next()) {
//				Account u = new Account();
//				u.setAccountName(rs.getString("accountname"));
//				u.setUserId(rs.getInt("userid"));
//				u.setAccountType(rs.getString("accounttype"));
//				u.setBalance(rs.getDouble("balance"));
//
//				accounts.add(u);
//			}
//			return accounts;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}

	@Override
	public void updateUser(Account ad) {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("UPDATE accounts SET balance = ? WHERE accountname = ? ");
			ps.setDouble(1, ad.getBalance());
			ps.setString(2, ad.getAccountName());
			int recordsCreated = ps.executeUpdate();
			log.trace(recordsCreated + " account updated");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			log.error(e.getMessage());
			for (StackTraceElement ste : e.getStackTrace()) {
				log.error(ste);
			}
			log.warn("failed to update user");
		}
		return;

	}

	@Override
	public Account viewAllAccounts() {
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM accounts", new String[] { "accountid" });

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Account u = new Account();
				u.setAccountName(rs.getString("accountname"));
				u.setUserId(rs.getInt("userid"));
				u.setAccountType(rs.getString("accounttype"));
				u.setBalance(rs.getDouble("balance"));
				u.setAccountId(rs.getInt("accountid"));
				System.out.println(u);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
