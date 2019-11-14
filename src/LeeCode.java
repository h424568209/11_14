
import java.util.*;

public class LeeCode {
    /**
     * 求众数
     * 超过三分之一数组长度的数最多只能有2个，先选出两个候选人A B 遍历数组 ，分三种情况
     * 1 若投A（当前元素A） 则A的票数加1
     * 2 若投B（当前元素B） 则B的票数加1
     * 3 若AB 都不投 则查看当前AB的票数是否为0
     *          1 若为0 则当前元素是新的候选人
     *          2 若不是0  则两个人的票数进行减1
     *    最后遍历数组 查看是否当前候选人的票数是数组长度的三分之一
     * @param nums  数组
     * @return 超过数组长度三分之一的数
     */
    public List<Integer> majorityElement(int[] nums) {
    List<Integer> list = new ArrayList<>();
    if(nums == null){
        return  list;
    }
    int candidateA = nums[0];
    int candidtteB = nums[0];
    int countA = 0;
    int countB  = 0;
    for(int num : nums){
        if(num == candidateA){
            countA++;
            continue;
        }
        if(num == candidtteB){
            countB++;
            continue;
        }
        if(countA == 0 ){
            candidateA = num;
            countA++;
            continue;
        }
        if(countB == 0){
            candidtteB = num;
            countB++;
            continue;
        }
        countA--;
        countB--;
    }
    countA = 0;
    countB = 0;
    for(int num : nums){
        if(num == candidateA){
            countA++;
        }
      else  if(num == candidtteB){
            countB++;
        }
    }
    if(countA > nums.length/3){
        list.add(candidateA);
    }
    if(countB>nums.length/3){
        list.add(candidtteB);
    }
    return list;
    }
    //按递增顺序显示卡牌
    public int[] deckRevealedIncreasing(int[] deck) {
        Queue<Integer> queue = new LinkedList<>();
        Arrays.sort(deck);
        int n = deck.length;
        for(int i = 0 ; i < n ; i++){
            queue.add(i);
        }
        int []ans = new int[n];
        Arrays.sort(deck);
        for(int card :deck){
            ans[queue.poll()] = card;
            if(!queue.isEmpty()){
                queue.add(queue.poll());
            }
        }
        return ans;
    }
    /**
     *  打印第K行的杨辉三角数组 --索引值
     *  只保存第上一次的杨辉三角的值，然后进行推除要求的值
     * @param rowIndex 行数
     * @return 杨辉三角的一层
     */
    public List<Integer> getRow(int rowIndex) {
       List<Integer> pre = new ArrayList<>();
       List<Integer> cur = new ArrayList<>();
       for(int i= 0 ; i <= rowIndex ; i++){
           cur = new ArrayList<>();
           for(int j =0 ; j <=i ; j++){
               if(j == 0 || j == i){
                   cur.add(1);
               }else{
                   cur.add(pre.get(j-1) + pre.get(j));
               }
           }
           pre = cur;
       }
       return cur;
    }
    /**
     *  杨辉三角
     * @param numRows 行数
     * @return 杨辉三角
     */
    public List<List<Integer>> generates(int numRows) {
        if(numRows==0){
            return new ArrayList<>();
        }
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        list.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> temp = list.get(i-1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(temp.get(j - 1) + temp.get(j));
            }
            row.add(1);
            list.add(row);
        }
        return list;
    }

    public static void main(String[] args) {
        LeeCode l = new LeeCode();
        System.out.println(l.generates(4));
        int nums[] = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(l.deckRevealedIncreasing(nums)));
        int []arr = {1,1,1,1,1,2,2,3,3,3,3,3,3};
        System.out.println(l.majorityElement(arr));
    }
}
