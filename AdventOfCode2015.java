
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventOfCode2015 {

	public static void main(String[] args) throws FileNotFoundException {
		
		int day = 2;
		
		// Console Input
		// Scanner scan = new Scanner(System.in);
		
		// File input
		Scanner scan = new Scanner(new File("input.txt"));
		
		// Day 1 
		if(day == 1) {
			elevatorDecoder(scan.nextLine());
		}
		
		// Day 2 
		if(day == 2) {
			ArrayList<String[]> strs = new ArrayList<String[]>();
			while(scan.hasNextLine()) {
				strs.add(scan.nextLine().split("x"));
			}
			wrappingPaperSurfaceArea(strs);
		}
	}

	// Day 1
	static void elevatorDecoder(String input) {
		int res = 0;
		boolean printedP2 = false;
		for(int i = 1; i <= input.length(); i++) {
			if(input.charAt(i-1) == '(') res++;
			else {
				res--;
			}
			
			// Part 2 of day 1
			if(res < 0 && !printedP2) {
				System.out.println("Part 2: " + i);
				printedP2 = true;
			}
		}
		
		// Part 1 of day 1
		System.out.println("Part 1: " + res);
	}
	
	// Day 2
	static void wrappingPaperSurfaceArea(ArrayList<String[]> lws) { //String l, String w, String h) {
		System.out.println("Day 2 results: ");
		int sa = 0;
		int rl = 0;
		for(int i = 0; i < lws.size(); i++) {
			
			int l = Integer.parseInt(lws.get(i)[0]);
			int w = Integer.parseInt(lws.get(i)[1]);
			int h = Integer.parseInt(lws.get(i)[2]);
			
			// Part 1
			int s1 = 2*l*w;
			int s2 = 2*w*h;
			int s3 = 2*h*l;
			sa += s1 + s2 + s3 + ((Math.min(s1, Math.min(s2,s3))) / 2);
			
			// Part 2
			s1 = 2*(l+w);
			s2 = 2*(w+h);
			s3 = 2*(l+h);
			rl += ((Math.min(s1, Math.min(s2,s3)))) + (l*w*h);
		}
		System.out.println("part 1: " + sa);
		System.out.println("part 2: " + rl);
	}
}