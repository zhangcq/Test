package com.mas.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.graduate.entity.Thing;
import com.mas.graduate.entity.User;
import com.mas.graduate.mapper.ThingMapper;
import com.mas.graduate.service.IThingService;

@Service("thingServiceImpl")
public class ThingServiceImpl implements IThingService{

	@Autowired
	private ThingMapper thingMapper;

	@Override
	public List<Thing> getAllThingByPage(Thing thing) {
		return thingMapper.getAllThingByPage(thing);
	}

	@Override
	public int getAllThing(Thing thing) {
		return thingMapper.getAllThing(thing);
	}

	@Override
	public List<Thing> getAllMyThingByPage(Thing thing, User user) {
		return thingMapper.getAllMyThingByPage(thing,user);
	}
	
	@Override
	public int getAllMyThing(Thing thing, User user) {
		return thingMapper.getAllMyThing(thing,user);
	}

	@Override
	public int addThing(Thing thing,User user) {
		return thingMapper.addThing(thing,user);
	}

	@Override
	public int editThing(Thing thing) {
		return thingMapper.editThing(thing);
	}

	@Override
	public int deleteThing(Thing thing) {
		return thingMapper.deleteThing(thing);
	}
}
