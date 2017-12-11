package webdisk.dao;

import java.util.List;

import webdisk.bean.Log;

public interface ILogDao {
	/**
	 * 添加日志
	 * @param l
	 * @return 添加成功，返回1；否则，返回0
	 */
	public int addLog(Log l);
	/**
	 * 查询日志内容
	 * @return 返回日志内容集合list
	 */
	public List<Log> finLogALL();

}
