package com.leetcode;

import java.util.Arrays;

public class LEETCODE_1626 {

	static class Player implements Comparable<Player>{
		int score;
		int age;
		Player(int score, int age){
			this.score = score;
			this.age = age;
		}
		@Override
		public int compareTo(Player player) {
			if(this.age > player.age)
				return -1;
			else if(this.age == player.age) {
				if(this.score >= player.score)
					return -1;
				else
					return 1;
			}
			return 1;
		}
	}

	static public int bestTeamScore(int[] scores, int[] ages) {

		int n = scores.length;

		Player players[] = new Player[n];

		for(int i = 0; i < n; i++) {
			players[i] = new Player(scores[i], ages[i]);
		}
		Arrays.sort(players);

		int dp[] = new int[n];
		dp[0] = players[0].score;
		int max = dp[0];
		for(int i = 1; i < n; i++){
			dp[i] = players[i].score;
			for(int j = 0; j < i;j++){
				if(players[j].score >= players[i].score){
					dp[i] = Math.max(players[i].score + dp[j], dp[i]);
				}
			}

			max = Math.max(max, dp[i]);

		}

		return max ;
	}

	public static void main(String[] args) {
		
		int scores[] = {319776,611683,835240,602298,430007,574,142444,858606,734364,896074};
		int ages[] = {1,1,1,1,1,1,1,1,1,1};
		
		bestTeamScore(scores, ages);
		

	}

}
