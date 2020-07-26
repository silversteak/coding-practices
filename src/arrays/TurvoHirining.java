package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TurvoHirining {

	public static int me(List<Integer> requirements, int noOfFlasks, List<List<Integer>> markings) {
		
		int index = 0;
		int k = requirements.size();
		int totalCost = Integer.MAX_VALUE,finalIndex = -1;
		for(List<Integer> marking : markings) {
			
			if(requirements.get(requirements.size()-1) > marking.get(marking.size()-1)) {
				index++;
				continue;
			}
			
			int n = marking.size();
			int i = 0, j = 0; 
			int minCost = 0;
			while(i < k ) {
				int require = requirements.get(i);
				boolean isFlag = false;
				while(j < n) {
					if(require < marking.get(j)) {
						minCost += (marking.get(j) - require);
						isFlag = true;
						i++;
					}
					j++;
				}
				
				//if(!isFlag) i++;
				
			}
			
			if(minCost < totalCost) {
				totalCost = minCost;
				finalIndex = index;
			}
			
			index++;
		}
		
		
		return finalIndex;
		
	}
	
	public static void main(String[] args) {

		/*2    →   requirements[] size n = 2
				10   →   requirements = [10, 15]
				15    
				3    →   flaskTypes = 3
				6    →   markings[] size totalMarks = 6
				2    →   markings[][] size columns = 2
				0 11 →   markings = [[0, 11], [0, 20], [1, 11], [1, 17], [2, 12], [2, 16]]
				0 20
				1 11
				1 17
				2 12
				2 16*/
	
		List<Integer> requirements = new ArrayList<>();
		requirements.add(4);
		requirements.add(6);
		
		List<List<Integer>> markings = new ArrayList<>();
		markings.add(new ArrayList<>(Arrays.asList(11,20)));
		markings.add(new ArrayList<>(Arrays.asList(11,17)));
		markings.add(new ArrayList<>(Arrays.asList(12,16)));
		
		System.out.println(me(requirements,3,markings));
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		ArrayList<Integer> myList = new ArrayList<>();
		myList.addAll(map.values());
		
	
	}
	
	
	
	
	

}
