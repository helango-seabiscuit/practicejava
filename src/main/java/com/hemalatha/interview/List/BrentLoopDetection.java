package com.hemalatha.interview.List;


/**
 * 
   turtle = top
   rabbit = top
  
   steps_taken = 0
   step_limit = 2
  
   forever:
      if rabbit == end:
         return 'No Loop Found'
      rabbit = rabbit.next 
      steps_taken += 1
      if rabbit == turtle:
         return 'Loop found'
 
     if steps_taken == step_limit:
         steps_taken = 0
         step_limit *= 2
         // teleport the turtle
         turtle = rabbit
 *
 */

public class BrentLoopDetection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	public boolean isCyclic(Node root){
		
		Node turtle = root;
		Node rabbit = root.getNext();
		
		int limit = 0;
		int limit_calculated = 2;
		
		while(true){
			if(rabbit ==null)
				break;
			rabbit = rabbit.getNext();
			
			if (limit ==limit_calculated){
				limit_calculated *= 2;
				turtle = rabbit;
				limit = 0;
			}
			
			if (turtle == rabbit){
					return true;
			}
			
			limit++;										
		}
		
		return false;
	}

}
