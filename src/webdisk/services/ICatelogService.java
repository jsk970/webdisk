package webdisk.services;

import java.util.List;

import webdisk.bean.Catelog;

public interface ICatelogService {
	/**
	 * 添加分类
	 * @param c
	 * @return 添加成功返回1；否则返回0
	 */
	public int addCatelog(Catelog c);
	/**
	 * 通过fTel删除分类
	 * @param fTel 
	 * @return 删除成功返回1；否则返回0
	 */
	public int deleteCatelog(String fTel);
	/**
	 * 修改分类
	 * @param fTel
	 * @param c
	 * @return 修改成功返回1；否则返回0
	 */
	public int updateCatelog(String fTel,Catelog c);
	/**
	 * 查看分类
	 * @return 返回List list
	 */
	public List<Catelog> findCatelogAll(String fTel);

}
