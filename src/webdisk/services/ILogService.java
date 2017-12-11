package webdisk.services;

import java.util.List;

import webdisk.bean.Log;

public interface ILogService {
	/**
	 * 添加日志
	 * @param l
	 * @return 添加成功返回1；否则返回0
	 */
	public int addLog(Log l);
	/**
	 * 查看所有操作日志
	 * @return 返回 List list 
	 */
	public List<Log> findLogAll();

}
