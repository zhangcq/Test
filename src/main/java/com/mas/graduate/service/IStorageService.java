package com.mas.graduate.service;

import java.util.List;

import com.mas.graduate.entity.Storage;

public interface IStorageService {

	List<Storage> getAllStorageByPage(Storage storage);

	int getAllStorage(Storage storage);

	int addStorage(Storage storage);

	int editStorage(Storage storage);

	int deleteStorage(Storage storage);

}
