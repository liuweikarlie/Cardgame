import java.util.Random;

import java.util.Arrays;
import java.util.ArrayList;



/**


* this is the game class

* @author Liu Wei


*/


public class game {
	//ArrayList<Integer>all_array=new ArrayList<Integer>();
	private ArrayList<Integer>current_card1=new ArrayList<Integer>();
	private ArrayList<Integer>current_card2=new ArrayList<Integer>();
	private ArrayList<Integer>remain_card=new ArrayList<Integer>();
	/**
	
	
	* This is the constructor to add the value into the ArrayList called remain_card
	
	* 
	
	
	*/
		
	

	public  game() {
		
		for(int i=1;i<5;i++) {
			for(int j=1;j<14;j++) {
				if(j>=10) {
					int z= 100*i+j;
					this.remain_card.add(z);
					
				}
				else {
					int z=10*i+j;
					this.remain_card.add(z);
					
					
				}
			
			}
		}
		
		
		
		
			
		
		
		
		
		
		
		
		
	}
	
	/**
		
		
		* This method is to create random card for dealer and player
		
		* 
		
		
		*/
	public void random_card() {
		Random myRandom=new Random();
		for(int i=0;i<3;i++) {
			int j=myRandom.nextInt(this.remain_card.size());
			//System.out.println("a "+j);
			int z=this.remain_card.get(j);
			this.current_card1.add(z);
			this.remain_card.remove(j);
		}
		for(int i=0;i<3;i++) {
			int j=myRandom.nextInt(this.remain_card.size());
			int z=this.remain_card.get(j);
			this.current_card2.add(z);
			this.remain_card.remove(j);
		}
		
		
	}
	
	/**
	
	
	* This method is to determine player win or not
	* 
	* @return the boolean value of  player win or not
	
	*/
	public boolean win() {
		
		int count1=0;
		int count2=0;
		int sum1=0;
		int sum2=0;
		boolean playerwin;
		//check the deal special card
		for (int i:this.current_card1) {
			if (i>100 & i%5!=0){
				count1=count1+1;
			}
			else {
				if(i%10!=0) {
					sum1=sum1+(i%10);}
					else {
						sum1=sum1+10;
					}
			}
			
		}
		//check the play special card
		for (int i:this.current_card2) {
			if (i>100 & i%5!=0){
				count2=count2+1;
			}
			else {
				if(i%10!=0) {
				sum2=sum2+(i%10);}
				else {
					sum2=sum2+10;
				}
			}
		}
		//compare
		if(count1>count2) {
			playerwin=false;
		}
		else if(count1<count2) {
			playerwin=true;
		}
		else {
			int re1=sum1%10;
			int re2=sum2%10;
			if(re1>re2) {
				playerwin=false;
			}
			else if (re1<re2) {
				playerwin=true;
			}
			else {
				playerwin=false;
			}
		}
		
		
		
		return playerwin;
		
		
	}
	
	/**
	* This method is to switch the player card
	* 
	* @param i means the player switch card index -1
	*/
	
	public void switch_card(int i) {
		//i is the player card position
		Random myRandom=new Random();
		int j=myRandom.nextInt(this.remain_card.size());
		int value=this.remain_card.get(j);
		this.remain_card.remove(j);
		this.current_card2.set(i, value);
		
		
	}
	/**
	* This method get the current_card1 ArrayList (dealer card)
	* 
	* @return current_card1 ArrayList
	*/

	public ArrayList<Integer> getCurrent_card1() {
		return current_card1;
	}
	
	/**
	* This method get the current_card2 ArrayList (player card)
	* 
	* @return current_card2 ArrayList
	*/

	public ArrayList<Integer> getCurrent_card2() {
		return current_card2;
	}
	
	
	/**
	* This method restart the game, it will clear the all the ArrayList and add the card element into the remain_card ArrayList
	* 
	*/
	
	
	public void restart_game() {
		this.current_card1.clear();
		this.current_card2.clear();
		this.remain_card.clear();
		for(int i=1;i<5;i++) {
			for(int j=1;j<14;j++) {
				if(j>=10) {
					int z= 100*i+j;
					this.remain_card.add(z);
					
				}
				else {
					int z=10*i+j;
					this.remain_card.add(z);
					
					
				}
			
			}
		}
	}
	
	
	

}
