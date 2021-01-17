package com.example.demo.Leetcode;

import java.util.*;

/**
 * @author caomuya
 */
public class Solution {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * @param s
     * @return
     */

    private Stack<String> stack = new Stack<>();

    public boolean isValid(String s) {

//        if(StringUtils.isEmpty(s)){
//            if(stack ==null || stack.size()==0){
//                return true;
//            }else {
//                return false;
//            }
//        }
//
//        if(s.startsWith("(")||s.startsWith("{")||s.startsWith("[")) {
//            stack.push(s.substring(0, 1));
//        }
//        if(s.startsWith(")")||s.startsWith("}")||s.startsWith("]")){
//            if(stack ==null || stack.size()==0){
//                return false;
//            }
//            String pop = stack.pop();
//            if(pop.equals("(") && s.startsWith(")")){
//                return isValid(s.substring(1));
//            }else if(pop.equals("{") && s.startsWith("}")){
//                return isValid(s.substring(1));
//            }else if(pop.equals("[") && s.startsWith("]")){
//                return isValid(s.substring(1));
//            }else {
//                return false;
//            }
//        }
//        return isValid(s.substring(1));

        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        boolean valid = solution.isValid("()[{()}]");
//        System.out.println(valid);
//        int i = solution.longestValidParentheses2("((()()()()(");
//        System.out.println(i);
//        int i = solution.evalRPN(new String[]{"4","13","5","/","+"});
//        System.out.println(i);
//        int[] result =  solution.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3);
//        for(int i=0;i<result.length;i++){
//            System.out.println(result[i]);
//        }

        int i = solution.mySqrt(8);
        System.out.println(i);

    }



    /**
     * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int n = s.length();
        int left = 0,right=0;
        int max = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) ==  '('){
                left++;
            }
            if(s.charAt(i) == ')'){
                right++;
            }
            if(left == right){
                max = Math.max(max,left*2);
            }else if(right > left){
                left = right =0;
            }
        }

        left = right =0;
        for(int i=n-1; i>0; i--){
            if(s.charAt(i) ==  '('){
                left++;
            }
            if(s.charAt(i) == ')'){
                right++;
            }
            if(left == right){
                max = Math.max(max,left*2);
            }else if(right < left){
                left = right =0;
            }
        }
        return  max;

    }

    public int longestValidParentheses2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        int n = tokens.length;
        for(int i=0;i<n;i++){
            if(tokens[i].equals("+")|| tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int a = 0;
                if(!stack.isEmpty()){
                    a =stack.pop();
                }
                if(!stack.isEmpty()){
                    int b =stack.pop();
                    if(tokens[i].equals("+")){
                        result = a +b;
                    }else if(tokens[i].equals("-")){
                        result = a -b;
                    }else if(tokens[i].equals("*")){
                        result = a *b;
                    }else if(tokens[i].equals("/")){
                        result = b /a;
                    }
                    stack.push(result);
                }
            }else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return result;

    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // 保证从大到小 如果前面数小 弹出
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if(list.peek()<=i-k){
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if(i-k+1>=0){
                result[i-k+1] = nums[list.peek()];
            }
        }
        return result;
    }


    /**
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * @param x
     * @return
     */
    public int mySqrt(int x) {
//        int i = mySqrtInternally(x, 0, x);
//        return i;
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private int mySqrtInternally(int x,int a,int b){
        int c = a+(b-1)/2;
        if((c*c)<=x && (c+1)*(c+1)>x){
            return c;
        }else if((c*c)>x){
            return mySqrtInternally(x,a,c-1);
        }else {
            return mySqrtInternally(x,c+1,b);
        }

    }

}
