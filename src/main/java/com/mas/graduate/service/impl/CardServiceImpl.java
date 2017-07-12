package com.mas.graduate.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mas.graduate.entity.Card;
import com.mas.graduate.mapper.CardMapper;
import com.mas.graduate.service.ICardService;

@Service("cardServiceImpl")
public class CardServiceImpl implements ICardService{

	@Autowired
	private CardMapper cardMapper;

	@Override
	public List<Card> getAllCardByPage(Card card) {
		return cardMapper.getAllCardByPage(card);
	}

	@Override
	public int getAllCard(Card card) {
		return cardMapper.getAllCard(card);
	}

	@Override
	public int addCard(Card card) {
		return cardMapper.addCard(card);
	}

	@Override
	public int editCard(Card card) {
		return cardMapper.editCard(card);
	}

	@Override
	public int deleteCard(Card card) {
		return cardMapper.deleteCard(card);
	}

	@Override
	public int recharge(int cardId, int money) {
		return cardMapper.recharge(cardId,money);
	}

}
