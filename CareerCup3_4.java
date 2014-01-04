import java.util.*;


public class CareerCup3_4{
	public static void main(String []args){
		int n = 4;
		Tower[] test = new Tower[3];
		for(int i = 0; i<3; i++){
			test[i] = new Tower(i);
		}
		for (int i = n ; i>0;i--){
			test[0].addDisk(i);
		}
		test[0].moveTo(n, test[2], test[1]);
	}
}

class Tower{
	private Stack<Integer>disks;
	private int name;
	
	public Tower(int name){
		this.name = name;
		disks = new Stack<Integer>();		
	}
	
	public void addDisk(int i){
		disks.push(i);
	}
	
	public int getName(){
		return this.name;
	}
	public void moveTop(Tower des){
		int temp = disks.pop();
		des.addDisk(temp);	
		System.out.println("Move "+ temp+ " from "+ this.name + " to " + des.getName());
	}
	
	public void moveTo(int n, Tower des, Tower buf){
		if(n<=0) return;
		if(n==1) moveTop(des);
	  else {
			moveTo(n-1, buf, des);
			moveTop(des);
			buf.moveTo(n-1,des,this);
		}
	}
}
