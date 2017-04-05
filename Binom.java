package binomialProb;
import java.util.Scanner;
import java.lang.*;

public class Binom {

	public static void main(String[] args) {
	
		float probsucc = 0;
		Scanner scnr = new Scanner(System.in);
		
		
		System.out.println("enter the number for how many trials you have:");
		int trials = scnr.nextInt();

		int[] succs = new int[trials + 1];
		
		System.out.println("\nenter the probability for success (in decimal form please):");
		probsucc = scnr.nextFloat();
		
		for (int i=0; i<(succs.length); i++){
			succs[i] = i;
		}
		
		generateCombo(trials, succs, probsucc);
		

	}
	
	
	public static void generateCombo(int trials, int[] succ, float probsucc){
		int printtrials = trials;vi p	
		int[] succfacts = new int[succ.length];
		int[] combos = new int[succ.length];
		int trialfact = 1;
		int succfact = 1;

		
		// generates factorial for total number of trials
		for (int i=trials; i>0; i--){
			trialfact = trialfact * i;
		}
		
		// generate factorial for each possible success
		for (int i=0; i<succ.length; i++){
			if (succ[i] == 0){
				succfacts[0] = 1;
			}
			else{
				succfact = succfact * succ[i];
				succfacts[i] = succfact;
			}
		}

		// generate combinations for each success and trial number
		for (int i=0; i<succ.length; i++){
			 int combo = (trialfact / (succfacts[i] * succfacts[printtrials - i]));
			 combos[i] = combo;	
		}
		
		prob(combos, probsucc, trials);
		
	}
	public static void prob(int[] combos, float probsucc, int trials){
		int printtrials = trials;
		double prob;
		double[] probs = new double[combos.length];
		
		//generates probabilities for each success 
		for (int i=0; i<combos.length; i++){
			prob = (combos[i] * (Math.pow(probsucc, trials)) * (Math.pow((1 - probsucc), (printtrials - trials))));
			probs[i] = prob;
			trials --;
		}
		
		//prints answers to screen
		trials = printtrials;
		int start = 0;
		System.out.println();
		for (int i=0; i<probs.length; i++){
			System.out.println(trials +"C" + start + " = " + probs[i]);
			start ++;
		}
			
		
	}

}
