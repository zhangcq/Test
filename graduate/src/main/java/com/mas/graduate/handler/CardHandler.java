package com.mas.graduate.handler;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.mas.graduate.entity.Card;
import com.mas.graduate.service.ICardService;

@Controller
@RequestMapping("/card")
public class CardHandler {
	@Autowired
	private ICardService service;
	
	@RequestMapping(value = "/getAllCard", method = RequestMethod.GET)
	public String getAllCard(String cardNum,String uname,String cardType,int pageNumber,int pageSize,PrintWriter out) {
		Card card = new Card();
		try {
			if(cardNum != null){
				card.setCardNum(URLDecoder.decode(cardNum,"utf-8"));
			}
			if(uname != null){
				card.setUname(URLDecoder.decode(uname,"utf-8"));
			}
			if(cardType != null){
				if(URLDecoder.decode(cardType,"utf-8").equals("临时卡")){
					card.setCardType(0);
				}else{
					card.setCardType(1);
				}
			}
			card.setPageNumber(pageNumber);
			card.setPageSize(pageSize);
			System.out.print(pageSize);
			List<Card> cards = service.getAllCardByPage(card);
			Gson gson = new Gson();
			String userStr = gson.toJson(cards);
			String json = "{\"total\":" + service.getAllCard(card) + ",\"rows\":"
					+ userStr + "}";
			out.print(json);
			out.flush();
			out.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "car";
	}
	
	@RequestMapping(value = "/addCard", method = RequestMethod.POST)
	public void addCard(Card card,PrintWriter out) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHH24mmss");
		String cardNum = sdf.format(new Date())+new Random().nextInt(9999);
		card.setBalance(0);
		card.setCardNum(cardNum);
		int result = service.addCard(card);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/editCard", method = RequestMethod.POST)
	public void editCard(Card card,PrintWriter out) {
		int result = service.editCard(card);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/deleteCard", method = RequestMethod.POST)
	public void deleteCard(Card card,PrintWriter out) {
		int result = service.deleteCard(card);
		out.print(result);
		out.flush();
		out.close();
	}
	
	@RequestMapping(value = "/recharge", method = RequestMethod.POST)
	public void recharge(int cardId,int money,PrintWriter out) {
		int result = service.recharge(cardId,money);
		out.print(result);
		out.flush();
		out.close();
	}
	
}
