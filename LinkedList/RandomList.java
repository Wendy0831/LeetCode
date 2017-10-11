package com.classes.one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomList {
	public static void main(String[] args) {
		
		RandomListNode a = new RandomListNode(5);
		RandomListNode b = new RandomListNode(3);
		RandomListNode c = new RandomListNode(6);
		
		a.next = b;
		b.next = c;
		a.random = c;
		b.random = a;
		c.random = c;
		
		//����1����
//		RandomListNode res = new SolutionSix().copyRandomList(a);
//		int i = 0;
//		RandomListNode old = a;
//		while(res != null && old != null){
//			System.out.println("����ǰ������--�� "+i+"���ڵ� labelΪ��"+old.label+" random��labelΪ��"+old.random.label);
//			System.out.println("���ƺ������--�� "+i+"���ڵ� labelΪ��"+res.label+" random��labelΪ��"+res.random.label);
//			res = res.next;
//			old = old.next;
//			i++;
//		}
		
		//����2����
		RandomListNode res_two = new SolutionSix().copyRandomList_two(a);
		int k = 0;
		RandomListNode temp = a;
		while(res_two != null && temp != null){
			System.out.println("����ǰ������--�� "+k+"���ڵ� labelΪ��"+temp.label+" random��labelΪ��"+temp.random.label);
			System.out.println("���ƺ������--�� "+k+"���ڵ� labelΪ��"+res_two.label+" random��labelΪ��"+res_two.random.label);
			res_two = res_two.next;
			temp = temp.next;
			k++;
		}
	}
}

class RandomListNode{
	int label;
	RandomListNode next,random;
	public RandomListNode(int x){
		label = x;
		next = null;
		random = null;
	}
}

class SolutionSix{
	
	//˼·1��
	public RandomListNode copyRandomList(RandomListNode head){
		//����һ��map��keyΪ�ڵ��ַ��valueΪ���͡��洢ԭ����
		Map<RandomListNode,Integer> old_map = new HashMap<RandomListNode,Integer>();
		//List�洢�ڵ�λ�÷��ʵ�ַ���±꼴�ɴ���λ�ã��൱������������ʹ��map
		List<RandomListNode> node_list = new ArrayList<RandomListNode>();
		RandomListNode ptr = head;
		int i=0;
		//����ԭ�������ڵ���Ϣ����list��map��
		
		if(head == null){
			return null;
		}
		
		while(ptr != null){
			//�������м���ڵ�
			node_list.add(new RandomListNode(ptr.label));
			//map�м�¼ԭ����
			old_map.put(ptr, i);
	        ptr = ptr.next;
	        //��¼�ڵ�λ��
	        i++; 
		}
		//�ص����
		ptr = head;
		i = 0;
		while(ptr != null){
			//��list�еĽڵ����������������
			if(ptr.next!=null){//��ֹlistԽ��
				node_list.get(i).next = node_list.get(i+1);
			}
			//���ӽڵ��ͬʱ���ҵ���ǰ�ڵ��Ӧ��randomֵ
			if(ptr.random!=null){
				//�õ�ԭ�����еĵ�ǰ�ڵ��random������λ��
				int id = old_map.get(ptr.random);
				node_list.get(i).random = node_list.get(id);
			}
			ptr = ptr.next;
			i++;
		}
		//list�ĵ�һ���ڵ㼴������Ҫ��������ͷ�ڵ�
		return node_list.get(0);
	}
	
	//˼·2
	public RandomListNode copyRandomList_two(RandomListNode head){
		if (head == null) return null;
		  
		  Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		  
		  // �������нڵ�
		  RandomListNode node = head;
		  while (node != null) {
		    map.put(node, new RandomListNode(node.label));
		    node = node.next;
		  }
		  
		  // ���ӽڵ��������ָ��random
		  node = head;
		  while (node != null) {
		    map.get(node).next = map.get(node.next);
		    map.get(node).random = map.get(node.random);
		    node = node.next;
		  }
		  
		  return map.get(head);
	}
}
