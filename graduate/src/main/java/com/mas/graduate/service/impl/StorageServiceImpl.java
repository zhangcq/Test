package com.mas.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.graduate.entity.Storage;
import com.mas.graduate.mapper.StorageMapper;
import com.mas.graduate.service.IStorageService;

@Service("storageServiceImpl")
public class StorageServiceImpl implements IStorageService{

	@Autowired
	private StorageMapper storageMapper;
	
	@Override
	public List<Storage> getAllStorageByPage(Storage storage) {
		return storageMapper.getAllStorageByPage(storage);
	}

	@Override
	public int getAllStorage(Storage storage) {
		return storageMapper.getAllStorage(storage);
	}

	@Override
	public int addStorage(Storage storage) {
		return storageMapper.addStorage(storage);
	}

	@Override
	public int editStorage(Storage storage) {
		return storageMapper.editStorage(storage);
	}

	@Override
	public int deleteStorage(Storage storage) {
		return storageMapper.deleteStorage(storage);
	}

}
