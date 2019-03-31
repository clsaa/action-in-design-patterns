package com.clsaa.edu.pattern.th18_state.example03;

public class Client {
	public static void main(String[] args) {
		VoteManager vm = new VoteManager();
		for(int i=0;i<11;i++){
			vm.vote("u1", "A");
		}
	}
}