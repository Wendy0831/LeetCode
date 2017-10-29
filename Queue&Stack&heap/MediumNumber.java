package com.classes.two;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MediumNumber {

}



class SolutionSeven{
	private PriorityQueue<Integer> maxHeap;
	private PriorityQueue<Integer> minHeap;
	public SolutionSeven(){
		Comparator<Integer> comparator = new Comparator<Integer>(){

			@Override
			public int compare(Integer l, Integer r) {
				return r.compareTo(l);
			}

		};

		maxHeap = new PriorityQueue<Integer>(20,comparator);
		minHeap = new PriorityQueue<Integer>(20);
	}

	public void addNumber(int num){
		//����Ϊ��ʱ��ֱ�����num������
		if(maxHeap.isEmpty()&&minHeap.isEmpty()){
			minHeap.add(num);
		}else if(minHeap.size()>maxHeap.size()){
			//����С�ѵĴ�С�������ѵĴ�Сʱ
			//num����С�ѶѶ�Ԫ�ش󣬽���С�ѶѶ�Ԫ�ط��������У��ٽ�num������С����
			if(num > minHeap.peek()){
				maxHeap.add(minHeap.poll());
				minHeap.add(num);
			}else{
				maxHeap.add(num);
			}
		}else if(minHeap.size()<maxHeap.size()){
			//����С�Ѵ�СС������ʱ��
			//���num�����ѵĶѶ�С�������ѵĶѶ�Ԫ�ط�����С���У��ٽ�num����������
			if(num < maxHeap.peek()){
				minHeap.add(maxHeap.poll());
				maxHeap.add(num);
			}else{
				minHeap.add(num);
			}
		}else{//�����Ѻ���С�Ѵ�С���ʱ
			if(num < maxHeap.peek()){
				maxHeap.add(num);
			}else{
				minHeap.add(num);
			}
		}
	}

	public double findMedian() {
		if(minHeap.size()==0&&maxHeap.size()==0){
			return 0.0;
		}
		if(maxHeap.size()==minHeap.size()){
			return (double)(maxHeap.peek()+minHeap.peek())/2;
		}else if(maxHeap.size() > minHeap.size()){
			return maxHeap.peek();
		}
		return minHeap.peek();
	}





}



