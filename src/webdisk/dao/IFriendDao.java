package webdisk.dao;

import java.util.List;

import webdisk.bean.Friend;

/**
 * 对t_friend表的抽象操作
 * @author ch
 * 2017-10-19
 */
public interface IFriendDao {
	/**
	 * 添加好友
	 * @param f Friend类型
	 * @return 成功返回1，否则返回0
	 */
	public int add(Friend f);
	
	/**
	 * 根据好友的电话号码删除
	 * @param tel 根据好友的电话删除好码
	 * @return  成功删除返回1，否则返回0
	 */
	public int delete(String fTel);
	
	/**
	 * 根据电话号码查找好友
	 * @param tel
	 * @return
	 */
	public Friend findByTel(String fTel);
	
	/**
	 * 查找所有的好友
	 * @return List类型
	 */
	public List<Friend> findMyfriendAll(String fTel);
}
