package cn.appsys.dao;

import java.util.List;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryDao {
	public List<DataDictionary> getDataDictionaryList(String typeCode);
}
