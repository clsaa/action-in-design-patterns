package com.clsaa.edu.pattern.th18_state.example03;

public class RepeatVoteState implements VoteState{
	public void vote(String user, String voteItem, VoteManager voteManager) {
		//重复投票
		//暂时不做处理
		System.out.println("请不要重复投票");
	}
}