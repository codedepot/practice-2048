import javax.swing.JOptionPane;

public class GameEngine{
  
  public int[][] board;
  
  public boolean[][] boardCode;
  
  public static final int SIZE = 4;
  
  
  public GameEngine(){
    
    this.board = new int[SIZE][SIZE];
    this.boardCode = new boolean[SIZE][SIZE];
    
  }
  
  //the process of adding a new 2 number somewhere in the board
  public void addNumber(){
    int numEmpty = 0;
    int[] emptyArray = new int[SIZE*SIZE];
    for(int i = 0; i<SIZE*SIZE; i++){
      if(this.board[i/SIZE][i%4] == 0){
        emptyArray[i] = 1;
      }
    }
    for(int i = 0;i<SIZE*SIZE; i++){
      if(emptyArray[i] == 1){
        numEmpty++;
      }
    }
    if(numEmpty >0){
      //System.out.println(numEmpty);
      int randomPlacement = (int) (Math.random()*numEmpty);
      //System.out.println(randomPlacement);
      int counter =0;
      for(int i = 0; i<SIZE; i++){
        for(int j= 0;j<SIZE;j++){
          if(emptyArray[i*4+j]== 1){
            
            if(counter == randomPlacement){
              this.board[i][j] = 2; 
            }
            counter++;
          }
        }
      }
    }
  }
  
  public void shiftLeft(){
    for( int i = 0; i<SIZE; i++){
      if(this.board[i][2] == 0){
        if(this.board[i][3] != 0){
          this.board[i][2] = this.board[i][3];
          this.board[i][3] = 0;
        }
      }
      if(this.board[i][1] == 0){
        if(this.board[i][2] != 0){
          this.board[i][1] = this.board[i][2];
          this.board[i][2] = 0;
        }
      }
      if(this.board[i][0] == 0){
        if(this.board[i][1] != 0){
          this.board[i][0] = this.board[i][1];
          this.board[i][1] = 0;
        }
      }
    }
    //now to combine
    for( int i = 0; i<SIZE; i++){
      if(this.board[i][0] == this.board[i][1]){
        this.board[i][0] = this.board[i][0]*2;
        this.board[i][1] = 0;
      }
      
      if(this.board[i][1] == this.board[i][2]){
        this.board[i][1] = this.board[i][1]*2;
        this.board[i][2] = 0;
        
      }
      if(this.board[i][2] == this.board[i][3]){
        this.board[i][2] = this.board[i][2]*2;
        this.board[i][3] = 0;
        
      }
      
    }
  }
  public void shiftUp(){
    for( int j = 0; j<SIZE; j++){
      if(this.board[2][j] == 0){
        if(this.board[3][j] != 0){
          this.board[2][j] = this.board[3][j];
          this.board[3][j] = 0;
        }
      }
      if(this.board[1][j] == 0){
        if(this.board[2][j] != 0){
          this.board[1][j] = this.board[2][j];
          this.board[2][j] = 0;
        }
      }
      if(this.board[0][j] == 0){
        if(this.board[1][j] != 0){
          this.board[0][j] = this.board[1][j];
          this.board[1][j] = 0;
        }
      }
    }
    //now to combine
    for( int j = 0; j<SIZE; j++){
      if(this.board[0][j] == this.board[1][j]){
        this.board[0][j] = this.board[0][j]*2;
        this.board[1][j] = 0;
      }
      
      if(this.board[1][j] == this.board[2][j]){
        this.board[1][j] = this.board[1][j]*2;
        this.board[2][j] = 0;
        
      }
      if(this.board[2][j] == this.board[3][j]){
        this.board[2][j] = this.board[2][j]*2;
        this.board[3][j] = 0;
        
      }
      
    }
  }
  
  public void shiftRight(){
    for( int i = 0; i<SIZE; i++){
      if(this.board[i][1] == 0){
        if(this.board[i][0] != 0){
          this.board[i][1] = this.board[i][0];
          this.board[i][0] = 0;
        }
      }
      if(this.board[i][2] == 0){
        if(this.board[i][1] != 0){
          this.board[i][2] = this.board[i][1];
          this.board[i][1] = 0;
        }
      }
      if(this.board[i][3] == 0){
        if(this.board[i][2] != 0){
          this.board[i][3] = this.board[i][2];
          this.board[i][2] = 0;
        }
      }
    }
    //now to combine
    for( int i = 0; i<SIZE; i++){
      if(this.board[i][3] == this.board[i][2]){
        this.board[i][3] = this.board[i][3]*2;
        this.board[i][2] = 0;
      }
      
      if(this.board[i][2] == this.board[i][1]){
        this.board[i][2] = this.board[i][2]*2;
        this.board[i][1] = 0;
        
      }
      if(this.board[i][1] == this.board[i][0]){
        this.board[i][1] = this.board[i][1]*2;
        this.board[i][0] = 0;
        
      }
      
    }
  }
  
  public void shiftDown(){
    for( int j = 0; j<SIZE; j++){
      if(this.board[1][j] == 0){
        if(this.board[0][j] != 0){
          this.board[1][j] = this.board[0][j];
          this.board[0][j] = 0;
        }
      }
      if(this.board[2][j] == 0){
        if(this.board[1][j] != 0){
          this.board[2][j] = this.board[1][j];
          this.board[1][j] = 0;
        }
      }
      if(this.board[3][j] == 0){
        if(this.board[2][j] != 0){
          this.board[3][j] = this.board[2][j];
          this.board[2][j] = 0;
        }
      }
    }
    //now to combine
    for( int j = 0; j<SIZE; j++){
      if(this.board[3][j] == this.board[2][j]){
        this.board[3][j] = this.board[3][j]*2;
        this.board[2][j] = 0;
      }
      
      if(this.board[2][j] == this.board[1][j]){
        this.board[2][j] = this.board[2][j]*2;
        this.board[1][j] = 0;
        
      }
      if(this.board[1][j] == this.board[0][j]){
        this.board[1][j] = this.board[1][j]*2;
        this.board[0][j] = 0;
      }
    }
  }
  
  public void decide(){
    int sum = 0;
    for(int i =0; i<SIZE;i++){
      
      for(int j = 0; j<SIZE;j++){
        if(this.board[i][j] == 2048){
          sum++;
        }
      }
    }
    if(sum>0){
     JOptionPane.showMessageDialog(null,"You WON!"); 
     System.exit(0);
    }
    sum=0;
    for(int i =0; i<SIZE;i++){
      
      for(int j = 0; j<SIZE;j++){
        if(this.board[i][j] == 0){
          sum++; 
        }
      }
    }
    if(sum == 0){
     JOptionPane.showMessageDialog(null, "You lost...");
     System.exit(0);
    }
    
  }
  
  
  
  public String print(){
    String output = "";
    for(int i =0; i<SIZE; i++){
      for(int j = 0; j<SIZE; j++){
        output += "" + this.board[i][j] +" | ";
      }
      output = output.substring(0, output.length()-2);
      if(i< SIZE-1){
        output += "\n- - - - - - -\n";
      }
    }
    
    return output;
  }
  
  
  
}

