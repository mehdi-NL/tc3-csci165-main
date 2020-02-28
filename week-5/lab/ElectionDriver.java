import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ElectionDriver {

	private ArrayList<CountyResults2016> list = new ArrayList<CountyResults2016>();
	public String [] data = new String [10];
	public CountyResults2016 cr = new CountyResults2016();
	
	public void fillList() throws FileNotFoundException {
		Scanner sc = new Scanner(new File("2016_US_County_Level_Presidential_Results.csv"));
		sc.nextLine();
		while(sc.hasNextLine()) 
        {
			String line = "";
			int j = 0;
			line = sc.nextLine();
			data = line.split(",");
            cr.setDemVotes(Double.parseDouble(data[j]));
            cr.setGopVotes(Double.parseDouble(data[j+1]));
            cr.setTotalVotes(Double.parseDouble(data[j+2]));
            cr.setPercentDem(Double.parseDouble(data[j+3]));
            cr.setPercentGOP(Double.parseDouble(data[j+4]));
            cr.setDifference(Double.parseDouble(data[j+5]+","+data[j+6]));
            cr.setPercentDifference(Double.parseDouble(data[j+7]));
            cr.setStateAbbreviation(data[j+8]);
            cr.setCounty(data[j+9]);
            cr.setFips(Integer.parseInt(data[j+10]));
            
            list.add(cr);
        }
	    sc.close();
	}
	public String findLargestMargin() {
		String largestCounty = "";
		CountyResults2016 first = new CountyResults2016();
		CountyResults2016 next = new CountyResults2016();
		for(int i=0; i < list.size(); i++) {
			first = list.get(i);
			next = list.get(i+1);
			if(first.getDifference() < next.getDifference()) {
				largestCounty = next.getCounty();
			}
			else {
				largestCounty = first.getCounty();
			}
		}
		return largestCounty;
		
	}
	public String findLargestMargin(String state) {
		String largestCounty = "";
		CountyResults2016 first = new CountyResults2016();
		CountyResults2016 next = new CountyResults2016();
		for(int i=0; i < list.size(); i++) {
			first = list.get(i);
			next = list.get(i+1);
			if(first.getStateAbbreviation() == state && 
				next.getStateAbbreviation() == state) {
				if(first.getDifference() < next.getDifference()) {
					largestCounty = next.getCounty();
				}
				else {
					largestCounty = first.getCounty();
				}
			}
		}
		return largestCounty;
		
	}
	public String [] getStateTotals() {
		CountyResults2016 first = new CountyResults2016();
		CountyResults2016 next = new CountyResults2016();
		String [] totalsState = new String [5];
		int i = 0;
		while( i < list.size()) {
			
			double totalDemVotes = 0;
			double totalGOPVotes = 0;
			String winner = "";
			
			first = list.get(i);
			next = list.get(i+1);
			String state = first.getStateAbbreviation();
			while(first.getStateAbbreviation() == next.getStateAbbreviation()) {
				totalDemVotes = totalDemVotes + first.getDemVotes() + next.getDemVotes();
				totalGOPVotes = totalGOPVotes + first.getGopVotes() + next.getGopVotes();
				i = i +2;
				
			}i++;
			
			double margin = Math.abs(totalDemVotes - totalGOPVotes);
			
			if(totalDemVotes > totalGOPVotes) {
				winner = "Democrats";
			}
			
			if(totalDemVotes < totalGOPVotes) {
				winner = "Republicans";
			}
			else {
				winner = "Tie";
			}
		
		
			totalsState[0] = state;
			totalsState[1] = String.valueOf(totalDemVotes);
			totalsState[2] = String.valueOf(totalGOPVotes);
			totalsState[3] = String.valueOf(margin);
			totalsState[4] = winner;
			return totalsState;
		}
		return totalsState;
	}

}



