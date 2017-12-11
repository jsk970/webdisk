package webdisk.service.Impl;

import java.util.List;

import webdisk.bean.Friend;
import webdisk.dao.IFriendDao;
import webdisk.factory.DaoFactory;
import webdisk.services.IFriendService;

public class IFriendServiceImpl implements IFriendService {
	private IFriendDao dao = DaoFactory.CreateFriendDao();

	@Override
	public int add(Friend f) {
		// TODO Auto-generated method stub
		if(dao.add(f)!=0)
			return 1;
		return 0;
	}

	@Override
	public int delete(String fTel) {
		// TODO Auto-generated method stub
		if(dao.delete(fTel)!=0)
			return 1;
		return 0;
	}

	@Override
	public Friend findByTel(String fTel) {
		// TODO Auto-generated method stub
		if(dao.findByTel(fTel)!=null)
			return dao.findByTel(fTel);
		return null;
	}

	@Override
	public List<Friend> findAllFriend(String myTel) {
		if(dao.findMyfriendAll(myTel)!=null)
		// TODO Auto-generated method stub
			return dao.findMyfriendAll(myTel);
		return null;
	}

}
