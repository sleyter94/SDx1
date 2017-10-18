
public class EmptySea extends Ship {

	EmptySea(){
		setLength(1);
	}
	
	@Override
	boolean shootAt(int row,int column){
		return false;
	}
	
	@Override
	public String toString(){
		return "E";
	}
	
	@Override
	String getShipType() {
		return "empty";
	}

}
