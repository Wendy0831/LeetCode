package com.classes.one;

public class ReserveLinkedList_two {
	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(4);
		ListNode f = new ListNode(5);
		
		a.next=b;
		b.next=c;
		c.next=d;
		d.next=e;
		e.next=f;
		f.next=null;
		
		SolutionTwo s = new SolutionTwo();
		ListNode head = s.resverseBetween(a,2,3);
		
		while(head.next != null){
			System.out.print(head.val+"->");
			head=head.next;
		}
		
		System.out.print(head.val);
	}
}

class SolutionTwo{
	
	
	public ListNode resverseBetween(ListNode head,int m,int n){
		int change_len = n-m+1;//��¼��Ҫ���õĽڵ㳤��
		ListNode pre_head = null;//��ʼ����ʼ���õĽڵ��ǰ��
		ListNode result = head;//����ת���������ͷ�ڵ㣬�����������Ϊhead
		while(head != null && --m > 0){
			pre_head = head; //��¼head��ǰ��
			head = head.next;
		} 
		//��modify_list_tailָ��ǰ��head����ת�ú������β
		ListNode modify_list_tail = head;
		ListNode new_head = null;
		
		while(head!=null&&change_len>0){
			ListNode next = head.next;
			head.next = new_head;
			new_head = head;
			head = next;
			change_len--; //ÿ���һ���ڵ����ã�change_len--;
		}
		
		modify_list_tail.next = head; //�������ú������β�����öεĺ�һ���ڵ�
		//���pre_head���գ�˵�����Ǵӵ�һ���ڵ㿪ʼ���õ�m>1
		if(pre_head != null){
			pre_head.next = new_head; //����������ʼ�Ľڵ�ǰ�������ú��ͷ�ڵ�����
		}else{
			result = new_head; //���pre_headΪ�գ�˵��m=1�ӵ�һ���ڵ㿪ʼ���á���������ú��ͷ�ڵ�.
		}
		
		return result;
	}
}