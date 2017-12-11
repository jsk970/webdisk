package webdisk.service.Impl;

import java.util.List;

import webdisk.bean.Catelog;
import webdisk.dao.ICatelogDao;
import webdisk.factory.DaoFactory;
import webdisk.services.ICatelogService;

public class ICatelogServiceImpl implements ICatelogService {
	private ICatelogDao dao = DaoFactory.CreateCatelogDao();

	@Override
	public int addCatelog(Catelog c) {
		// TODO Auto-generated method stub
		if(dao.addCatelog(c)!=0)
			return 1;
		return 0;
	}

	@Override
	public int deleteCatelog(String fTel) {
		// TODO Auto-generated method stub
		if(dao.deleteCatelog(fTel)!=0)
			return 1;
		return 0;
	}

	@Override
	public int updateCatelog(String fTel, Catelog c) {
		// TODO Auto-generated method stub
		if(dao.updateCatelog(fTel)!=0)
			return 1;
		return 0;
	}

	@Override
	public List<Catelog> finCatelogAll() {
		// TODO Auto-generated method stub
		if(dao.findCatelogAll()!=null)
			return dao.findCatelogAll();
		return null;
	}

}
