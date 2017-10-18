
public abstract class Ship {
	
	private int bowRow;
	private int bowColumn;
	private	int length;
	private boolean horizontal;
	private boolean[] hit;
	
	abstract String getShipType();
	
	boolean okToPlaceShipAt(int row,int column,boolean horizontal, Ocean ocean){
		boolean resp = true;
		for(int i=0;i<ocean.ocean.length;i++){
			for(int j=0;j<ocean.ocean[i].length;j++){
				if(ocean.ocean[i][j].getShipType()!="empty"){
					int p1X1 = row -1;
					int p1Y1 = column - 1;
					int p1X2 = 0;
					int p1Y2 = 0;
					int p2X1 = ocean.ocean[i][j].getBowRow()-1;
					int p2Y1 = ocean.ocean[i][j].getBowColumn()-1;
					int p2X2 = 0;
					int p2Y2 = 0;
					int h1 = 0,w1 = 0,h2 = 0,w2 = 0;
					if(horizontal){
						w1 = 1;
						h1 = length;
						if(ocean.ocean[i][j].horizontal){
							w2 = 1;
							h2 = ocean.ocean[i][j].length;
						}else{
							w2 = ocean.ocean[i][j].length;
							h2 = 1;
						}
					}else{
						w1 = length;
						h1 = 1;
					}
					p1X2 = row + w1;
					p1Y2 = column + h1;
					p2X2 = ocean.ocean[i][j].getBowRow() + w2;
					p2Y2 = ocean.ocean[i][j].getBowColumn() + h2;
					if(p1X2>ocean.ocean.length && p1Y2>ocean.ocean[i].length){
						resp=false;
					}
					if((p2X1 >= p1X1 && p2X1 <= p1X2) || (p2X2>=p1X1 && p2X1 <= p1X2)){
						if((p2Y1 >= p1Y1 && p2Y1 <= p1Y2) || (p2Y2>=p1Y1 && p2Y1 <= p1Y2)){
							resp = false;
						}
					}
				}
			}
		}
		return resp;
	}
	
	void placeShipAt(int row, int column, boolean horizontal, Ocean ocean){
		for(int i=0;i<length;i++){
			if(horizontal){
				ocean.ocean[row+i][column] = this;
			}else{
				ocean.ocean[row][column+i] = this;
			}
		}
	}
	
	boolean shootAt(int row,int column){
		boolean resp = false;
		if(horizontal){
			if(row==getBowRow() && (column>=getBowColumn() && (column<=getBowColumn()+getLength()-1))){
				hit[column-getBowColumn()] = true;
				resp = true;
			}
		}else{
			if(column==getBowColumn() && (row>=getBowRow() && (row<=getBowRow()+getLength()-1))){
				hit[row-getBowRow()] = true;
				resp = true;
			}
		}
		return resp;
	}
	
	boolean isSunk(){
		boolean resp = true;
		for(int i = 0;i<getLength();i++){
			if(!hit[i]){
				resp = false;
				return resp;
			}
		}
		return resp;
	}
	
	@Override
	public String toString(){
		if(isSunk()){
			return "x";
		}else{
			return "S";
		}
	}
	
	public int getBowRow() {
		return bowRow;
	}
	public void setBowRow(int bowRow) {
		this.bowRow = bowRow;
	}
	public int getBowColumn() {
		return bowColumn;
	}
	public void setBowColumn(int bowColumn) {
		this.bowColumn = bowColumn;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public boolean[] getHit() {
		return hit;
	}
	public void setHit(boolean[] hit) {
		this.hit = hit;
	}
}
