package webdisk.dao.Impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import webdisk.bean.Log;
import webdisk.dao.ILogDao;
import webdisk.util.DbUtil;

public class ILogDaoImpl implements ILogDao{
	private QueryRunner qr = null;
	
	
	public ILogDaoImpl(QueryRunner qr) {
		super();
		this.qr = qr;
	}


	@Override
	public int addLog(Log l) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO t_log(fTime,fTel,fType,fDocld,fResult)values(?,?,?,?,?)";
		int result = 0;
		Object[] params = {l.getfTime(),l.getfTel(),l.getfType(),l.getfDocld(),l.getfResult()};
		try {
			result = qr.update(sql,params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<Log> finLogALL() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM t_log ORDER BY ASC";
		List<Log> list = null;
		try {
			list = qr.query(sql, new BeanListHandler<Log>(Log.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
