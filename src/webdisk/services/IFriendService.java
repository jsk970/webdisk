package webdisk.services;

import java.util.List;

import webdisk.bean.Friend;

public interface IFriendService {
	/**
	 * 添加好友
	 * @param f 
	 * @return 添加成功返回1；否则返回0
	 */
	public int add(Friend f);
	/**
	 * 删除好友
	 * @param fTel
	 * @param f
	 * @return 删除成功返回1；否则返回0
	 */
	public int delete(String fTel);
	/**
	 * 通过fTel查找好友
	 * @param fTel
	 * @return 返回Friend
	 */
	public Friend findByTel(String fTel);
	
	/**
	 * 查找所有好友
	 * @return 返回我的好友列表 List  list
	 */
	public List<Friend> findAllFriend(String myTel);
	
	
	
	

}
