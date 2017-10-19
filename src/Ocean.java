
public class Ocean {

	Ship[][] ocean = new Ship[20][20];
	int shotsFired;
	int hitCount;
	int shipsSunk;
	
	Ocean(){
		for(int i=0;i<ocean.length;i++){
			for(int j=0;j<ocean[i].length;j++){
				ocean[i][j] = new EmptySea();
			}
		}
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
	}
	
	void placeAllShipsRandomly(){
		int row = 0;
		int column = 0;
		Ship battleShip = new BattleShip();
		Ship battlecruiser = new BattleCruiser();
		Ship cruiser_1 = new Cruiser();
		Ship cruiser_2 = new Cruiser();
		Ship destroyer_1 = new Destroyer();
		Ship destroyer_2 = new Destroyer();
		Ship destroyer_3 = new Destroyer();
		Ship submarine_1 = new Submarine();
		Ship submarine_2 = new Submarine();
		Ship submarine_3 = new Submarine();
		Ship submarine_4 = new Submarine();
		
		row = (int)(Math.random()*19) + 1;
		column = (int)(Math.random()*19) + 1;
		battleShip.placeShipAt(row, column, true, this);
		while(!battlecruiser.okToPlaceShipAt(row, column, false, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		battlecruiser.placeShipAt(row, column, false, this);
		
		while(!cruiser_1.okToPlaceShipAt(row, column, true, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		cruiser_1.placeShipAt(row, column, true, this);
		
		while(!cruiser_2.okToPlaceShipAt(row, column, true, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		cruiser_2.placeShipAt(row, column, true, this);
		
		while(!destroyer_1.okToPlaceShipAt(row, column, true, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		destroyer_1.placeShipAt(row, column, true, this);
		
		while(!destroyer_2.okToPlaceShipAt(row, column, false, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		destroyer_2.placeShipAt(row, column, false, this);
		
		while(!destroyer_3.okToPlaceShipAt(row, column, false, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		destroyer_3.placeShipAt(row, column, false, this);
		
		while(!submarine_1.okToPlaceShipAt(row, column, false, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		submarine_1.placeShipAt(row, column, false, this);
		
		while(!submarine_2.okToPlaceShipAt(row, column, false, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		submarine_2.placeShipAt(row, column, false, this);
		
		while(!submarine_3.okToPlaceShipAt(row, column, false, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		submarine_3.placeShipAt(row, column, false, this);
		
		while(!submarine_4.okToPlaceShipAt(row, column, false, this)){
			row = (int)(Math.random()*19) + 1;
			column = (int)(Math.random()*19) + 1;
		}
		submarine_4.placeShipAt(row, column, false, this);
		
	}
	
	boolean isOccupied(int row,int column){
		if(ocean[row][column].getShipType()!="empty"){
			return true;
		}else{
			return false;
		}
	}
	
	boolean shootAt(int row,int column){
		boolean resp = true;
		if(ocean[row][column].getShipType()!="empty"){
			if(ocean[row][column].isSunk()){
				resp = false;
			}else{
				shotsFired++;
				hitCount++;
			}
		}else{
			resp = false;
		}
		return resp;
	}
	
	int getShotsFired(){
		return shotsFired;
	}
	
	int getHitCount(){
		return hitCount;
	}
	
	boolean isGameOver(){
		boolean resp = true;
		for(int i = 0;i<this.ocean.length;i++){
			for(int j = 0;i<this.ocean[i].length;j++){
				if(ocean[i][j].getShipType()!="empty"){
					if(!ocean[i][j].isSunk()){
						resp = false;
						return resp;
					}
				}
			}
		}
		return resp ;
	}
	
	int getShipsSunk(){
		return shipsSunk;
	}
	
	Ship[][] getShipArray(){
		return ocean;
	}
	
	void print(){
		System.out.print(" ");
		for(int j = 0; j<ocean.length;j++){
			System.out.print(j);
			System.out.print(" ");
		}
		System.out.println("");
		for(int i = 0; i<ocean.length;i++){
			System.out.println(i);
		}
	}
	
	void printOcean(){
		
		
	}
	
}
