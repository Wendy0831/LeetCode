package com.classes.two;

import java.util.LinkedList;
import java.util.Stack;

public class RightOutOrder {
	public static void main(String[] args) {
		
	}
}

class Solution{
	public boolean check_is_valid_order(LinkedList<Integer> order){
		Stack<Integer> stack = new Stack<Integer>();
		int size = order.size();
		
		//ջ��order������ͬ���洢��������1-n
		for(int i=1;i<=size;i++){
			stack.push(i);
		}
		
		//����ȡһ��Ԫ�رȽϣ���ͬ���Ƴ����к�ջ
		while(stack.peek() == order.peek() && order.size()!=0){
			stack.pop();
			order.pop();
		}
		
		if(order.size() != 0){
			return false;
		}
		return true;
	}
}
