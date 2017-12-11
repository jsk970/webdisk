package webdisk.factory;

import org.apache.commons.dbutils.QueryRunner;

import webdisk.dao.ICatelogDao;
import webdisk.dao.IDocumentDao;
import webdisk.dao.IFriendDao;
import webdisk.dao.ILogDao;
import webdisk.dao.IUserDao;
import webdisk.dao.Impl.ICatelogDaoImpl;
import webdisk.dao.Impl.IDocumentDaoImpl;
import webdisk.dao.Impl.IFriendDaoImpl;
import webdisk.dao.Impl.ILogDaoImpl;
import webdisk.dao.Impl.IUserDaoImpl;
import webdisk.util.DbUtil;

public class DaoFactory {
	private static QueryRunner qr = new QueryRunner(DbUtil.getDataSource());
	
	
	public static IUserDao CreateUserDao(){
		return new IUserDaoImpl(qr);
	}
	public static IDocumentDao CreateDocumentDao(){
		return new IDocumentDaoImpl(qr);
		
	}
	public static IFriendDao CreateFriendDao(){
		return new IFriendDaoImpl(qr);
		
	}
	public static ILogDao CreateLogDao(){
		return new ILogDaoImpl(qr);
		
	}
	public static ICatelogDao CreateCatelogDao(){
		return new ICatelogDaoImpl(qr);
		
	}

}
