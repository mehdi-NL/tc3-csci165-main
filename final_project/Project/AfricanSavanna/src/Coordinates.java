
public class Coordinates {
	
        int row;
        int column;

        public Coordinates(int row, int column){
        	
            setRow(row);
            setColumn(column);
            
        }

        public void setColumn(int column){
        	if(column >= 0 || column <= 100) {
        		this.column = column;
        	}
        	else {
        		this.column = 0;
        	}
        }

        public void setRow(int row){
        	if(row >= 0 || row <= 100) {
        		this.row = row;
        	}
        	else {
        		this.row = 0;
        	}
        }

        public int getRow(){
            return row;
        }

        public int getColumn(){
            return column;
        }

        public void setCoordinates (int row, int column){
            this.setRow(row);
            this.setColumn(column);
            
        }

        public Coordinates getCoord(){
            return new Coordinates(row, column);
        }
}