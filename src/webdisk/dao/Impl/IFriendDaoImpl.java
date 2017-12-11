package webdisk.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import webdisk.bean.Friend;
import webdisk.dao.IFriendDao;
//DbUtil
public class IFriendDaoImpl implements IFriendDao {
	private QueryRunner qr = null;
	

	public IFriendDaoImpl(QueryRunner qr) {
		super();
		this.qr = qr;
	}

	@Override
	public int add(Friend f) {
		String sql = "INSERT INTO t_friend(fFriendTel,fMyTel,fUser,fMemo) "
				+ "values(?,?,?,?)";
		int result = 0;
		Object[] params = {f.getfFriendTel(),f.getfMytel(),f.getfUser(),f.getfMemo()};
		try {
			result = qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delete(String fTel) {
		String sql ="DELETE FROM t_friend where fFriendTel=?";
		int result = 0;
		try {
			result = qr.update(sql,fTel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}

	@Override
	public Friend findByTel(String fTel) {
		// TODO Auto-generated method stub
		String sql ="SELECT * from t_user where fTel=?";
		Friend friend =null;
		try {
			friend = qr.query(sql, new BeanHandler<Friend>(Friend.class), fTel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return friend;
	}

	@Override
	public List<Friend> findMyfriendAll(String fTel) {
		String sql = "SELECT * from t_friend where fMytel=? ORDER BY fMytel ASC";
		List<Friend> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Friend>(Friend.class),fTel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}


	


}
