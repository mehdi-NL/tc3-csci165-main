import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.util.Random;

class Drawer extends JPanel {

    private static final long serialVersionUID = 1L;
    private JFrame window = new JFrame();

    public Drawer() {
        initUI();
    }

    private void initUI() {
        window.add(this);
        window.setTitle("2D Drawing");
        window.setSize(500, 500);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        doDrawing(g);
    }

    private void doDrawing(Graphics g) {

        /*
            RGB Colors:
            ================================================
            Black       => (0, 0, 0)        => low elevation
            Mid Grey    => (128, 128, 128)  => mid elevation
            White       => (255, 255, 255)  => high elevation

            Grey Scale colors are scaled in matching set of 3 numeric values
        */

        Graphics2D g2d = (Graphics2D) g;
        
        int [][] matrix = MapDataDrawer.map;
        int BLACK = MapDataDrawer.findMin(matrix);
		int WHITE = MapDataDrawer.findMax(matrix);
		int GRAY_LOW = WHITE - (((WHITE-BLACK)/3)*2);
		int GRAY_HIGH = WHITE - (((WHITE-BLACK)/3));
		

        int x = 0, y = 0;
        for(int c = 0; c < matrix[0].length; c++) {
        	for(int r = 0; r < matrix.length; r++) {
        		if(BLACK <= matrix[r][c] && matrix[r][c] < GRAY_LOW) {
        			g2d.setColor(Color.black);
	        		g2d.fillRect(x, y, 1, 1);
	                y += 1;
	                x += 1;
                 }
        		if(GRAY_LOW <= matrix[r][c] && matrix[r][c] <= GRAY_HIGH) {
        			g2d.setColor(Color.gray);
	        		g2d.fillRect(x, y, 1, 1);
	                y += 1;
	                x += 1;
                 }
        		if(GRAY_HIGH < matrix[r][c] && matrix[r][c] <= WHITE) {
        			g2d.setColor(Color.white);
	        		g2d.fillRect(x, y, 1, 1);
	                y += 1;
	                x += 1;
                 }
        	}
        }

        int width = getWidth();
        int height = getHeight();
        g2d.setColor(Color.GREEN);
        String s = "I'm a graphics programmer now!!";
        g2d.drawString(s, (width / 2) - s.length() * 3 , height / 2);

        g2d.setColor(Color.RED);
        Random random = new Random();
        for(int i = 0; i < 2000; i++){
            x = Math.abs(random.nextInt()) % width;
            y = Math.abs(random.nextInt()) % height;
            g2d.drawLine(x, y, x + 2, y + 2);
        }
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { 
                Drawer ex = new Drawer();
                ex.setVisible(true);
            }
        });
    } // end main
} // end class
