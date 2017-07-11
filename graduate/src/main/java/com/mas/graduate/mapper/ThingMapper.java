package com.mas.graduate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mas.graduate.entity.Thing;
import com.mas.graduate.entity.User;

public interface ThingMapper {

	int getAllThing(Thing thing);

	List<Thing> getAllThingByPage(Thing thing);

	List<Thing> getAllMyThingByPage(@Param("thing")Thing thing, @Param("user")User user);

	int getAllMyThing(@Param("thing")Thing thing,@Param("user") User user);

	int addThing(@Param("thing")Thing thing,@Param("user") User user);

	int editThing(Thing thing);

	int deleteThing(Thing thing);

}
