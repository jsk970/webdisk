package webdisk.service.Impl;



import java.util.List;

import webdisk.bean.User;
import webdisk.dao.IUserDao;
import webdisk.factory.DaoFactory;
import webdisk.services.IUserService;

public class IUserServiceImpl implements IUserService {
	private IUserDao dao = DaoFactory.CreateUserDao();

	@Override
	public int regist(User user) {
		// TODO Auto-generated method stub
		if(dao.regist(user)!=0)
			return 1;
		return 0;
	}

	@Override
	public boolean login(String fTel, String fPassword) {
		// TODO Auto-generated method stub
		if(dao.login(fTel, fPassword))
			return true;
		return false;
	}

	@Override
	public User findByfTel(String fTel) {
		// TODO Auto-generated method stub
		if(dao.findByfTel(fTel)!=null)
			return dao.findByfTel(fTel);
		return null;
	}

	@Override
	public int update(String fTel,User user) {
		// TODO Auto-generated method stub
		if(dao.update(fTel, user)!=0)
			return 1;
		return 0;
	}

	@Override
	public void setLevel(String fTel) {
		// TODO Auto-generated method stub
		String level="1";
		
		int scouse = 0;
		if(scouse >=0 && scouse<100)
			level="1";
		else if(scouse <200)
			level="2";
		else if(scouse <200)
			level="3";
		else if(scouse <200)
			level="4";
		else if(scouse <200)
			level="5";
		else
			level="1";
			

	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		if(dao.findAll()!=null)
			return dao.findAll();
		return null;
	}

}
