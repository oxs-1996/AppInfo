package cn.appsys.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.appsys.dao.DataDictionaryDao;
import cn.appsys.pojo.DataDictionary;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {

	@Resource
	private DataDictionaryDao dataDictionaryDao;
	
	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode) {
		return null;
	}

}
