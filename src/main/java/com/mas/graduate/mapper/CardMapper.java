package com.mas.graduate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mas.graduate.entity.Card;

public interface CardMapper {

	public List<Card> getAllCardByPage(Card card);

	public int getAllCard(Card card);

	public int addCard(Card card);

	public int editCard(Card card);

	public int deleteCard(Card card);

	public int recharge(@Param("cardId")int cardId,@Param("money") int money);

}
