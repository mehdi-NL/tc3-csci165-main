import javax.swing.JPanel;

public class Savanna extends JPanel {
	
	private static int day;
	
	public Savanna() {
		
	}
	
	public static int getDay() {
		return day;
	}
	
	public void setDay() {
		Savanna.day = day++;
	}
	
	
	
}
