package com.mas.graduate.mapper;

import java.util.List;

import com.mas.graduate.entity.Storage;

public interface StorageMapper {

	int deleteStorage(Storage storage);

	int editStorage(Storage storage);

	int addStorage(Storage storage);

	int getAllStorage(Storage storage);

	List<Storage> getAllStorageByPage(Storage storage);

}
