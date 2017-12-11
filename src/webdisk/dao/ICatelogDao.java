package webdisk.dao;

import java.util.List;

import webdisk.bean.Catelog;

public interface ICatelogDao {
	/**
	 * 新建分类
	 * @param c
	 * @return
	 */
	public int addCatelog(Catelog c);
	/**
	 * 查询所有分类列表
	 * @return
	 */
	public List<Catelog> findCatelogAll(String fTel);
	/**
	 * 删除分类
	 * @param fTel
	 * @return
	 */
	public int deleteCatelog(String fTel);
	/**
	 * 修改分类
	 * @param fTel
	 * @return
	 */
	public int updateCatelog(String fTel);
	
	

}
