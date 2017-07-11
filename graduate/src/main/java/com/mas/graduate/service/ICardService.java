package com.mas.graduate.service;

import java.util.List;

import com.mas.graduate.entity.Card;

public interface ICardService {

	List<Card> getAllCardByPage(Card card);

	int getAllCard(Card card);

	int addCard(Card card);

	int editCard(Card card);

	int deleteCard(Card card);

	int recharge(int cardId, int money);

}
