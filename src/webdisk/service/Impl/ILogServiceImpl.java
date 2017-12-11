package webdisk.service.Impl;

import java.util.List;

import webdisk.bean.Log;
import webdisk.dao.ILogDao;
import webdisk.factory.DaoFactory;
import webdisk.services.ILogService;

public class ILogServiceImpl implements ILogService {
	private ILogDao dao = DaoFactory.CreateLogDao();	

	@Override
	public int addLog(Log l) {
		// TODO Auto-generated method stub
		if(dao.addLog(l)!=0)
			return 1;
		return 0;
	}

	@Override
	public List<Log> findLogAll() {
		// TODO Auto-generated method stub
		if(dao.finLogALL()!=null)
			return dao.finLogALL();
		return null;
	}

}
