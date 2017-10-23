package com.classes.two;

public class MaxKValue {
	public static void main(String[] args) {
		int[] nums = {7,6,5,4,3,2,1};
		int res = new SolutionSix().findKthLargest(nums, 5);
		System.out.println(res);
	}
}

//��С��ʵ��
class MinHeap{
	private int[] data;
	
	public MinHeap(int[] data){
		this.data = data;
		buildHeap();
	}
	
	//����ת������С��
	private void buildHeap(){
		//��ȫ������ֻ�������±�С�ڻ��ߵ���(data.length)/2-1��Ԫ���к��ӽڵ㣬������Щ�ڵ�
		for(int i=(data.length)/2-1;i>=0;i--){
			heapify(i);
		}
	}
	
	private int left(int i){
		return ((i+1)<<1)-1;
	}
	
	private int right(int i){
		return (i+1)<<1;
	}
	private void swap(int i, int j){
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
	public int getRoot(){
		return data[0];
	}
	public void setRoot(int root){
		data[0]=root;
		heapify(0);
	}
	private void heapify(int i){
		//��ȡ���ҽڵ�������±�
		int l = left(i);
		int r = right(i);
		//����һ����ʱ��������ʾ�����㣬��ڵ㣬�ҽڵ�����Сֵ�Ľڵ���±�
		int smallest = i;
		//������ڵ㣬����ڵ��ֵС�ڸ��ڵ�
		if(l < data.length && data[l]<data[i]){
			smallest = l;
		}
		//�����ҽڵ㣬���ҽڵ��ֵС�ڸ��ڵ�
		if(r < data.length && data[r]<data[smallest]){
			smallest = r;
		}
		//������ڵ㼴��Сֵ����ֱ�ӷ��ز����κβ���
		if(i == smallest){
			return;
		}
		//�������ڵ�����ҽڵ�����Сֵ,�Ѹ��ڵ��ֵ�滻��ȥ
		swap(i,smallest);
		//�����滻������������ᱻӰ�죬����Ҫ����Ӱ��������ٽ���heapify()
		heapify(smallest);
	}
	
	@Override
	public String toString() {
		String str = "";
		for(int i =0;i<data.length;i++){
			str = str+"->"+data[i];
		}
		return str;
	}
}

class SolutionSix{
	public int findKthLargest(int[] nums,int k){
		int[] topK = new int[k];
		for(int i=0;i<topK.length;i++){
			topK[i] = nums[i];
		}
		
		
		
		MinHeap minHeap = new MinHeap(topK);
		System.out.println(minHeap.toString());
		for(int i=k;i<nums.length;i++){
			int root = minHeap.getRoot();
			if(nums[i]>root){
				minHeap.setRoot(nums[i]);
			}
		}
		return minHeap.getRoot();
	}
	
}