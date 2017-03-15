import javax.swing.JFrame; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent; 
import javax.swing.JPanel; 
import javax.swing.*;
import java.awt.*;
public class GameWindow extends JFrame implements ActionListener{
  public JLabel title;
  public JPanel table;
  public JButton up;
  public JButton down;
  public JButton left;
  public JButton right;
  public GameEngine ge;
  
  
  public GameWindow(){
    this.setSize(500,500);
    this.setVisible(true); 
    this.title = new JLabel("2048 Game");
    this.title.setHorizontalAlignment(0);
    this.table = new JPanel();
    this.table.setLayout(new GridLayout(GameEngine.SIZE, GameEngine.SIZE));
    this.ge = new GameEngine();
    
    String s = "" +'/' +'\\';
    this.up = new JButton(s); 
    this.up.addActionListener(this);
    this.up.setSize(100,100);
   
    this.left = new JButton("<");
    this.left.addActionListener(this);

    
    s = "" + '\\' + '/';
    this.down = new JButton(s);
    this.down.addActionListener(this);
    
    
    
    this.right = new JButton(">");
    this.right.addActionListener(this);

    
  }
  
  public JPanel createContentPane(){
    JPanel base = new JPanel();
    base.setLayout(new BoxLayout(base, BoxLayout.PAGE_AXIS));
    base.add(Box.createVerticalGlue());
    base.add(this.title);
    base.add(Box.createRigidArea(new Dimension(20,40)));
    
    
    base.add(this.table);
    base.add(Box.createRigidArea(new Dimension(20,40)));
    
    JPanel buttons = new JPanel();
    buttons.setSize(200,100);
    Dimension buttonSize = new Dimension(200,100);
    buttons.setPreferredSize(buttonSize);
    buttons.setMinimumSize(buttonSize);
    buttons.setMaximumSize(buttonSize);
    buttons.setLayout(new GridLayout(2,3));
    buttons.add(Box.createRigidArea(new Dimension(100,100)));
    buttons.add(this.up);
    buttons.add(Box.createRigidArea(new Dimension(100,100)));
    
    buttons.add(this.left);
    
    buttons.add(this.down);
    
    buttons.add(this.right);
    
    base.add(buttons);
    base.add(Box.createVerticalGlue());
return base;
  }
  
  public void updateTable(){
    this.table = new JPanel();
    this.table.setLayout(new GridLayout(GameEngine.SIZE, GameEngine.SIZE));
    JLabel label;
    for(int i =0 ; i<GameEngine.SIZE; i++){
      for(int j = 0; j<GameEngine.SIZE; j++){
       String s = "";
       if(this.ge.board[i][j] == 0){
        s = " "; 
       }else{
        s = "" + this.ge.board[i][j]; 
       }
       label = new JLabel(s);
       label.setFont(label.getFont().deriveFont(32.0f));
       label.setHorizontalAlignment(0);

       this.table.add(label);
        
      }
    }
  }
  
  public void actionPerformed(ActionEvent e){
    if(e.getSource() ==this.left){
      this.ge.shiftLeft();
     
    }else if(e.getSource() == this.right){
     this.ge.shiftRight();
     
    }else if(e.getSource() == this.up){
     this.ge.shiftUp();
     
    }else if(e.getSource() ==this.down){
     this.ge.shiftDown(); 
    }
    this.ge.addNumber();
    this.updateTable();
    this.setContentPane(this.createContentPane());
    this.pack();
    this.results();

  }
  
  public void results(){
    this.ge.decide();
    
  }
  
  public static void main(String[] args){
    GameWindow gw = new GameWindow(); 
    gw.setContentPane(gw.createContentPane());
    gw.pack();
  }
}