package cn.appsys.service;

import java.util.List;

import cn.appsys.pojo.DataDictionary;

public interface DataDictionaryService {
	public List<DataDictionary> getDataDictionaryList(String typeCode);
}
