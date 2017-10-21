1.ʹ�ö���ʵ��ջ
LeetCode 225 Implement Stack using Queues
https://leetcode.com/problems/implement-stack-using-queues/description/

˼·1��
    �ؼ�����pop��push����
    ά��һ��data_queue���ж���
    ��push(x)ʱ������һ����ʱ����temp_queue,
    ��x push��temp_queue��
    �ٽ�data_queue����Ԫ��pop��temp_queue��
    �ٽ�temp_queue������Ԫ�طŻص�data_queue��

    pop����ͬqueue��poll����
˼·2��
    ά��һ��data_queue���ж���
    push����ͬqueue��add����
   
    popʱ������һ����ʱ���У���data_queue�����ڿ�ʱ����¼pollֵΪres��
    ���û�е����βԪ�ؼ���poll֮��data_queue��Ȼ��Ϊ�գ�
    �ͽ�res��ӵ�temp_queue�С�
    ��������˶�βԪ�أ���temp_queue�е�Ԫ�طŻص�data_queue�У�������res��

    
    topʱ����data_queue��Ϊ�գ���������ͷ��Ԫ�ؼ�¼Ϊres��
    ��res��ӵ�temp_queue�У�
    �����ʱ�����˶�β����data_queue.isEmpty()==true������temp_queue��Ԫ�طŻص�data_queue��
    ����res��
����ΪQueueToStack.java
-------------------------------------------------------------------------------------

2.ʹ��ջʵ�ֶ���
LeetCode 232 Implement Queue using Stacks
https://leetcode.com/problems/implement-queue-using-stacks/description/

˼·1��
  �ؼ�����pop��push��������
  ά��һ��data_stackջ�����洢Ԫ��
  ��push(x)��ʱ��ʹ��һ����ʱջtemp_stack, �Ƚ�x push��temp_stack���Ƚ�ԭ������һһpush����ʱջtemp_stack��
  �ٽ�xpush��temp_stack��
  �ٽ�temp_stack��Ԫ��ȫ���Ż�data_stack�У���������push��x�ͷ�����ջ��

  pop����ͬջ��pop����

˼·2��
  ά��һ��data_stackջ���洢Ԫ��
  push(x)����ͬջ��push(x)����

  ��popʱ������һ����ʱջtemp_stack,��data_stack�е�����Ԫ��push��temp_stack��
  temp_stack.pop()��Ϊ��Ҫ��ֵ��Ȼ��temp_stack��Ԫ�طŻ�data_stack��

  peek������pop����˼·����

����Ϊ��StackToQueue.java
------------------------------------------------------------------------------------
3.����min������ջ
LeetCode 155 Min Stack
https://leetcode.com/problems/min-stack/description/

���һ��ջ��֧�����²�������Щ�������㷨���Ӷ��ǳ�������O(1)ʱ�临�Ӷ�
1��push(x)��Ԫ��xѹ��ջ��
2��pop����ջ��Ԫ��
3��top����ջ��Ԫ��
4������ջ����СԪ��

˼·��
  ��Ҫ��O(1)��ʱ�临�Ӷȵõ�ջ����СԪ��
  ����Ҫ��ÿһ�β���ʱ��¼��Сֵ
  ���ǵ�pop�����������ά��һ��ջ���洢��Сֵ��ÿ��getMin()ʱ����ջ��Ԫ��

����ΪMinStackBuild.java

-------------------------------------------------------------------------------
4.�Ϸ���ջ����
��֪��1��n���������У���˳����ջ��ÿ��������ջ�󼴿ɳ�ջ��Ҳ����ջ��ͣ�����ȴ����������
��ջ��ջ�󣬸������ٳ�ջ������������еĳ�ջ�����Ƿ�Ϸ�

 poj 1363 Rails
http://poj.org/problem?id=1363

˼·��
1������һ������order���洢��ջ���
2����Ԫ��˳�򣬽�Ԫ��push����ջ
3��ÿpushһ��Ԫ�أ�������Ƿ�������ײ�Ԫ����ͬ������ͬ�򵯳�����Ԫ�أ�����ջ��Ԫ��
ֱ����Ԫ�ز�ͬ����
4��������ջΪ�գ�˵�����кϷ������򲻺Ϸ�

����Ϊ��RightOutOrder.java

���죺ͳ�����п��ܵó�ջ���У�����������������

-----------------------------------------------------------------------------
5.������
LeetCode 224 Basic Calculator
https://leetcode.com/problems/basic-calculator/description/

���һ��������������һ���ַ����洢�ı��ʽ�����Լ��������������+��-
���ַ��ŵ���ѧ���ʽ���������ѧ���ʽ�ַ�����֤�Ƿ�Ϸ��ġ��������ѧ�ı��ʽ��
���ܴ��ڿո��ַ���

˼·��
  1.������������number_stack,operator_stack����������ֺͷ���
  2.���岼������compute_flag��¼�Ƿ���Լ���
  3.�����ַ�����
    NUMBER_STATE
    1�����Ϊ���� number=number*10+ch-'0';
    2) �������ֽ�����ջnumber_stack.push
       ����compute_flag���м��㣬���л���OPERATION_STATE
       �����ַ�ָ���˸�number=0
    OPERATION_STATE
    1)���Ϊ+,-
    operation_state.push
    compute_flag=1
    2)���Ϊ��
    compute_flag=0
    �л���NUMBER_STACK
    3)���Ϊ��
     ���м���
    4�����Ϊ����
     �л���NUMBER_STATE�������ַ�ָ��i�˸�

 
   ע���˸�ָ��i��ʱ��
����ΪStackToCalculator.java

