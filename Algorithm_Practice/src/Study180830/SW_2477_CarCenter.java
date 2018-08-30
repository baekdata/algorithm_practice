package Study180830;

import java.util.LinkedList;
import java.util.Scanner;

public class SW_2477_CarCenter { // 차량 정비소 //  추 후 혼자 풀어보기 
	//http://ppikanyang.tistory.com/entry/2477번-모의-SW-역략테스트-차량-정비소 // 소스 참고 // 
	// 그대로 구현할 줄 알면 된다. 
	
	static LinkedList<People> groupPeopleA = new LinkedList<>();
	static LinkedList<People> groupPeopleB = new LinkedList<>();
	
	static Window[] windowA, windowB; // A창구, B창구 목록 
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1; i<=num; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			
			windowA = new Window[N];
			windowB = new Window[M];
			
			for(int j=0; j<N; j++) {
				windowA[j] = new Window(j+1, sc.nextInt(), "A");
			}
			
			for(int j=0; j<M; j++) {
				windowB[j] = new Window(j+1, sc.nextInt(), "B");
			}
			
			for(int j=1; j<=K; j++) {
				groupPeopleA.add(new People(j, sc.nextInt()));
			}
			
			//////입력부/////////
			
			//출력 
			System.out.println("#"+i+" "+calPeople(A, B));
		}
	}
	
	public static int calPeople(int A, int B) { // 계산하는 함수 
		int nowTime=0, endPeopleNum=0, result=0;
		int maxPeopleNum=groupPeopleA.size();
		
		while(endPeopleNum < maxPeopleNum) { // 모든 사람이 끝날 때까지 수행 
			int nextTime = -1;
			
			//A창구 
			for(int i=0; i<windowA.length; i++) {
				if(windowA[i].isUsed()) {
					int finishTime = windowA[i].getFinishTime();
					if(finishTime!=nowTime) {
						nextTime = getNextTime(nextTime, finishTime);
						continue;
					}
					groupPeopleB.add(windowA[i].getFinishPeople());
				}
				
				if(groupPeopleA.size() > 0) {
					People nextPeople = groupPeopleA.getFirst();
					int calTime = nextPeople.getArriveTime();
					if(calTime <= nowTime) {
						windowA[i].setNowPeople(nowTime, nextPeople);
						groupPeopleA.removeFirst();
						calTime = windowA[i].getFinishTime();
					}
					nextTime = getNextTime(nextTime, calTime);
				}
			}
			
			//B창구 
			for(int i=0; i<windowB.length; i++) {
				if(windowB[i].isUsed()) {
					int finishTime = windowB[i].getFinishTime();
					if(finishTime!=nowTime) {
						nextTime = getNextTime(nextTime, finishTime);
						continue;
					}
					
					endPeopleNum += 1;
					People endPeople = windowB[i].getFinishPeople();
					if(endPeople.getA() == A && endPeople.getB() == B) {
						result += endPeople.getNum();
					}
				}
				
				//B창구 대기 사람이 있으면 접수하기
				if(groupPeopleB.size() > 0) {
					windowB[i].setNowPeople(nowTime, groupPeopleB.getFirst());
					groupPeopleB.removeFirst();
					nextTime = getNextTime(nextTime, windowB[i].getFinishTime());
				}
			}
			nowTime = nextTime; // 다음시간으로 이동 
		}
		
		if(result == 0) {
			return -1;
		}
		
		return result;
	}
	
	public static int getNextTime(int nextTime, int time) {
		if(nextTime == -1 || nextTime >= time) {
			return time;
		}
		return nextTime;
	}
}

class Window{ // 시간과 사람 체크할 수 있는 클래스 
	int num, delayTime = 0, finishTime = -1;
	String type;
	People nowPeople = null;
	
	public Window(int N, int delayTime, String type) {
		num = N;
		this.delayTime = delayTime;
		this.type = type;
	}
	
	public void setNowPeople(int nowTime, People nowPeople) {
		finishTime = nowTime + delayTime;
		this.nowPeople = nowPeople;
		
		if(type.equals("A")) {
			this.nowPeople.setA(num);
		}else {
			this.nowPeople.setB(num);
		}
	}
	
	public int getFinishTime() {
		return finishTime;
	}
	
	public People getFinishPeople() {
		People now = nowPeople;
		this.nowPeople = null;
		return now;
	}
	
	public boolean isUsed() {
		if(this.nowPeople == null) {
			return false;
		}
		return true;
	}
}

class People{ // 사람 클래스 
	int arrivalTime; // 도착 시간 
	int A, B; // 접수, 정비 구역 
	int num; 
	
	public People(int arrivalTime, int num) {
		this.arrivalTime = arrivalTime;
		this.num = num;
	}
	
    public int getA() {
    	return A;
    }
    
    public int getB() {
    	return B;
    }
    
    public void setA(int A) {
    	this.A = A;
    }
    
    public void setB(int B) {
    	this.B = B;
    }
    
    public int getArriveTime() {
    	return arrivalTime;
    }
    
    public int getNum() {
    	return num;
    }
}