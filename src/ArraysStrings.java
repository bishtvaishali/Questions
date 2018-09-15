
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


public class ArraysStrings {
	   static int[] arr = new int[2];
	   static  int[] arr1 = new int[2];

	
	   
//complexity of O(n^2)
public int[] twoSum(int[] nums, int target) {		 
    for(int i=0; i<nums.length; i++){ 	
                arr[0] = i;
                arr1[0] = nums[i];
                int val = target - nums[i]; 
                for(int j=i+1 ; j<nums.length; j++){
                    if(nums[j] ==  val){
                        arr[1] = j;
                        arr1[1] = nums[j];
                        return arr;
                    }
                }  		        		    
    }

    return null;
}


//complexity of O(n)
public int[] twoSumMap(int[] nums, int target) {
        
	 HashMap<Integer, Integer> map = new HashMap<>();
	 
        for(int i=0; i<nums.length; i++){
        	int diff =  target - nums[i];
        	if(!map.containsKey(diff)) {
        		map.put(nums[i], i);
        	}else {
        		arr[0] = map.get(diff);
        		arr[1] = i;
        		arr1[0] = diff;
        		arr1[1] = nums[i];
        	}        		        		    
        }
    
        return null;
   }	   
	   

public void moveZeroes(int[] nums) {
	
	System.out.println(Arrays.toString(nums));
	Queue<Integer> q = new LinkedList<Integer>();
///First Solution
//	for(Integer i : nums) {
//		if(i!=0) {
//			q.add(i);	
//		}
//	}
//		
//	int quesize = q.size();
//	
//	for(int i=0; i< nums.length; i++) {
//		if(i<quesize) {
//			nums[i] = q.poll();
//		}
//		else {
//			nums[i]=0;
//		}
//	}
//	
	//System.out.println(Arrays.toString(nums));
	
//second solution
//	System.out.println("2nd Solution Move zeros");
//	int arrSize = nums.length;
//	int j =0;
//	for(int i=0; i< arrSize; i++) {
//		if(nums[i]!=0) {
//			nums[j] = nums[i];
//			j++;
//			System.out.println("Move---- "+ i +", "+ Arrays.toString(nums));
//		} 			
//	}
//	
//	while(j<nums.length) {
//		nums[j] = 0;
//		j++;
//		System.out.println("Fill Zero---- "+ j +", "+ Arrays.toString(nums));
//	}
	
	//System.out.println("Move zero sol2: "+ Arrays.toString(nums));
	
	//3rd solution
	int lastNonZero = 0;
	
	for(int i =0; i < nums.length; i++) {
		if(nums[i]!=0) {
			//swap
			int temp;
			temp = nums[i];
			nums[i] = nums[lastNonZero];
			nums[lastNonZero] = temp;
			//swap
			
			lastNonZero++;
			System.out.println("Move--3rd-- "+ i +", "+ Arrays.toString(nums));
		}	
	}
	
}




public boolean isValid(String s) {
	 
   Stack<Character> stack = new Stack<>(); 

    if(s.length()%2!=0) {
    	return false;
    }
    
   for(Character c : s.toCharArray()) {
	   
	   System.out.println(c);
	   if(c== '(' || c== '{' || c== '[') {
		   stack.push(c);  
		   Character para = stack.peek();
		   System.out.println("para1 on top of stack:" + para);
	   }else {
		   if(stack.isEmpty()) {
			   return false;
		   }		   
		   Character para = stack.peek();
		   System.out.println("para on top of stack:" + para);
		   if(para == '(' && c==')') {
			   //stack.pop();
			   System.out.println("pop:" + stack.pop());
		   }else if(para == '{' && c=='}') {
			  // stack.pop();
			   System.out.println("pop:" + stack.pop());
			   
		   }else if(para == '[' && c==']') {
			  // stack.pop();
			   System.out.println("pop:" + stack.pop());
		   }else {
			   return false;
		   }
	   }
   }
   
    return stack.isEmpty();
	
 }

 
public boolean isAnagram(String s, String t) {
    
	if(s.isEmpty() && t.isEmpty()) {
		return true;
	} 
	
	if(s.length()!=t.length()) {
		return false;
	}
	
    HashMap<Character, Integer> map = new HashMap<>();
    
    for(Character c : s.toCharArray()){
    	map.put(c,map.getOrDefault(c, 0) +1);       
    }
    
    for(Character val : t.toCharArray()){
    	if(map.containsKey(val)) {
    		int i = map.get(val);
    		if(i == 0) {
    			return false;
    		}		
    		map.put( val,i - 1); 
    	}else { 
    		System.out.println("false1");
    		return false;
    	}
    } 
  
    
  return true;
      
} 
 

//check if string has unique characters with extra datastructure
public boolean hasUniqueChar(String s) {
	int[] arr = new int[26];
	
	
	for(int i=0; i< s.length(); i++) {
		arr[s.charAt(i)-'a']++;
	}
		
	for(int i : arr) {
		if(i>1) {
			return false;
		}	
		System.out.println(arr.length);
	}
	
	return true;
}  
 

public void removeDuplicates(String str ) {

	System.out.println("Initial array: " + str);	
	Set<Character> set = new HashSet<Character>();
	char[] s = new char[str.length()];
	int i = 0;
 	for(char c : str.toCharArray()) {
		if(!set.contains(c)) {
			set.add(c);	
			s[i] = c;
			i++;
		}		
		
	}
 	System.out.println("Final array: " + Arrays.toString(s));	
}


public void removeSpacesWithSmth(String str) {

	char[] charStr = str.toCharArray();	
	int i = 0;
	for (char a : charStr) {
		if(a == ' ') {
			i++;
		}
	} 
	
	System.out.println(String.valueOf(charStr));
	
	int newLength = str.length() + (3*i);
	char[] arr = new char[newLength];
	int k =0 ;
	
	for(int j = 0; j< charStr.length ; j++) {
	
		if(charStr[j] == ' ') {
			arr[k] = '%';
			arr[++k] = '2';
			arr[++k] ='0';
			System.out.println("1: " + String.valueOf(arr));
		}else {			
			arr[k] = charStr[j];
			System.out.println("2: " + String.valueOf(arr));
		}	
		k++;
	}
	
	System.out.println("ARR1");
	System.out.print(String.valueOf(arr));


}



public static void main(String[] args) {

	ArraysStrings sum = new ArraysStrings();
	
	int[] nums = {-1, -2, -3, -4, -5};
	int[] nums1 = {1, 0, 0, 3, 12};
	
//	sum.twoSum(nums, -8);
	//sum.twoSumMap(nums, -8);
	System.out.println("isValidPara: " + sum.isValid("(("));
	
	System.out.println("isAnagram: " + sum.isAnagram("abcdgg", "abcdge"));
	
	System.out.println("hasUniqueChar: " + sum.hasUniqueChar("afbcercdf"));
	
	System.out.println("MoveZeroes: ");
	sum.moveZeroes(nums1);

	
	
	System.out.println("remove duplicates");
	sum.removeDuplicates("abdcddde");
	sum.removeSpacesWithSmth("I am using IDE Eclipse");


}



}
