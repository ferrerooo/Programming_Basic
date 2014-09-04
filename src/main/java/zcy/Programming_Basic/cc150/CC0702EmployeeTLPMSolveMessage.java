package zcy.Programming_Basic.cc150;

public class CC0702EmployeeTLPMSolveMessage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}



/*
 * 
 * 思路还是听清楚的：
 * 设计5个主要类 画泳道图，sequence diagram ：   1 outside client  2 MessageManager  3 Employee 4 TL  5 PM
 * 另外，employee TL PM 都继承于people类, message概念本身也要包装成一个类
 * 
 * 1 call 2 's reportMessage()
 * 2 call 3 's dispatchToEmployee()
 * 3 return 2, solved OR need escalate
 * 2 call 4 's dispatchToTeamLeader()
 * 4 return 2, solved OR need escalated
 * 2 call 5 's dispatchToPM()
 * 5 return 2, solved OR need to wait
 * 
 * 
 * 
 * 
 * 
 * 
 */