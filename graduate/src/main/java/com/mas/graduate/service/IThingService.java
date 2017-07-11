package com.mas.graduate.service;

import java.util.List;

import com.mas.graduate.entity.Thing;
import com.mas.graduate.entity.User;

public interface IThingService {

	List<Thing> getAllThingByPage(Thing thing);

	int getAllThing(Thing thing);

	List<Thing> getAllMyThingByPage(Thing thing, User user);

	int getAllMyThing(Thing thing, User user);

	int addThing(Thing thing, User user);

	int editThing(Thing thing);

	int deleteThing(Thing thing);

}
