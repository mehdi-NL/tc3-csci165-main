
public class CountyResults2016 {
	
	private double demVotes;
	private double gopVotes;
	private double totalVotes;
	private double percentDem;
	private double percentGOP;
	private double difference;
	private double percentDifference ;
	private String stateAbbreviation;
	private String county;
	private int fips;
	
	
	public CountyResults2016() {};
	
	public CountyResults2016(double demVotes, double gopVotes, 
			double totalVotes, double percentDem, double percentGOP,
			double difference, double percentDifference, 
			String stateAbbreviation, String county, int fips) {
		
		this.demVotes = demVotes;
		this.gopVotes = gopVotes;
		this.totalVotes = totalVotes;
		this.percentDem = percentDem;
		this.percentGOP = percentGOP;
		this.difference = difference;
		this.percentDifference = percentDifference;
		this.stateAbbreviation = stateAbbreviation;
		this.county = county;
		this.fips = fips;
	}




	public double getDemVotes() {
		return demVotes;
	}




	public void setDemVotes(double demVotes) {
		this.demVotes = demVotes;
	}




	public double getGopVotes() {
		return gopVotes;
	}




	public void setGopVotes(double gopVotes) {
		this.gopVotes = gopVotes;
	}




	public double getTotalVotes() {
		return totalVotes;
	}




	public void setTotalVotes(double totalVotes) {
		this.totalVotes = totalVotes;
	}




	public double getPercentDem() {
		return percentDem;
	}




	public void setPercentDem(double percentDem) {
		this.percentDem = percentDem;
	}




	public double getPercentGOP() {
		return percentGOP;
	}




	public void setPercentGOP(double percentGOP) {
		this.percentGOP = percentGOP;
	}




	public double getDifference() {
		return difference;
	}




	public void setDifference(double difference) {
		this.difference = difference;
	}




	public double getPercentDifference() {
		return percentDifference;
	}




	public void setPercentDifference(double percentDifference) {
		this.percentDifference = percentDifference;
	}




	public String getStateAbbreviation() {
		return stateAbbreviation;
	}




	public void setStateAbbreviation(String stateAbbreviation) {
		this.stateAbbreviation = stateAbbreviation;
	}




	public String getCounty() {
		return county;
	}




	public void setCounty(String county) {
		this.county = county;
	}




	public int getFips() {
		return fips;
	}




	public void setFips(int fips) {
		this.fips = fips;
	}
	
}
