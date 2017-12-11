package webdisk.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import webdisk.bean.Catelog;
import webdisk.dao.ICatelogDao;
import webdisk.util.DbUtil;

public class ICatelogDaoImpl implements ICatelogDao {
	private QueryRunner qr = null;
	

	public ICatelogDaoImpl(QueryRunner qr) {
		super();
		this.qr = qr;
	}

	@Override
	public int addCatelog(Catelog c) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_catelog(fTel,fCatelog) values(?,?)";
		int result = 0;
		Object[] params = {c.getfTel(),c.getfCatelog()};
		try {
			result = qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Catelog> findCatelogAll(String fTel) {
		// TODO Auto-generated method stub
		String sql= "SELECT * FROM t_catelog where fTel=?";
		List<Catelog> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Catelog>(Catelog.class),fTel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int deleteCatelog(String fTel) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM t_catelog where fTel=?";
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
	public int updateCatelog(String fTel) {
		// TODO Auto-generated method stub
		String sql ="UPDATE t_catelog SET fcatelog=? where fTel=?";
		int result = 0;
		try {
			result = qr.update(sql,fTel);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
