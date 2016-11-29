
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import javax.swing.*;

public class Game extends JFrame {
/***
 .....................DECLARING NECCESSARY COMPONANTS.................................................. 
 */
    Game object;
    JButton Start;
    JButton Help;
    JButton FRUITS;
    JButton FLOWERS;
    JButton ANIMALES;
    JButton EXAMTIME;
    JButton LEARNINGTIME;
    JButton NEXT;
    JButton PREVIOUS;
    JButton FINISHED;
    JButton EXIT;
    JButton BACK;
    JButton OK;
    JButton Back;
    
    JTextField text;
    JLabel menu;
    JLabel score;
    JLabel verdict;
    JLabel toShowImage;
    JLabel timer;
    JLabel name;
    JPanel Panel1;
   
    
     int firstIndex,lastIndex,lowerBound;
    ImageIcon toShowbackground;
    ImageIcon toShowelement;
    public static String string1[]=new String[45];
  
       boolean gamerunning,IsStart,IsExit,Isexam,IsLearning,Isfinished,Isnext=false;  
       static boolean IsFlower=false,IsFruits=false,IsAnimales=false;
       int Index,multiple;
  
    /***
     ************************* CONSTRUCTOR***************************************
     */
    Game() {
        super("Visual Word Guessing Game");


    }
/***
 *************************MAIN METHOD***********************************
 * @param args
 * Author: Shorot
 * 
 */
    public static void main(String args[]) {

        Game t = new Game();
      
        t.run();
        

    }
/***
 ********************** init() METHOD INITIALIZES all components ****************************
 */
    public void init() {
        gamerunning=false;
        //IsFlower=false;
        //IsAnimales=false;
        IsExit=false;
        IsStart=false;
        //IsFruits=false;
        Isfinished=false;
        string1[0]="BUTTERFLY";
         string1[1]="CROCODILE";
         string1[2]="DOG";
         string1[3]="DONKEY";
         string1[4]="EAGLE";
         string1[5]="ELEPHANT";
         string1[6]="FROG";
         string1[7]="GIRAFFE";
         string1[8]="HORSE";
         string1[9]="LION";
         string1[10]="KANGAROO";
         string1[11]="RABBIT";
         string1[12]="SHARK";
         string1[13]="SNAKE";
         string1[14]="TORTOISE";
         string1[15]="ORANGE";
         string1[16]="MANGO";
         string1[17]="PLUMS";
         string1[18]="ROSEAPPLE";
         string1[19]="PINEAPPLE";
         string1[20]="STRAWBERRY";
         string1[21]="WATERMELON";
         string1[22]="PAPAYA";
         string1[23]="GUAVA";
         string1[24]="LICHI";
         string1[25]="COCONUT";
         string1[26]="APPLE";
         string1[27]="BANANA";
         string1[28]="CARROT";
         string1[29]="GRAPE";
         string1[30]="ROSE";
         string1[31]="LILY";
         string1[32]="LILAC";
         string1[33]="MARIGOLD";
         string1[34]="TULIP";
         string1[35]="SUNFLOWER";
         string1[36]="HIBISCUS";
         string1[37]="DAISY";
         string1[38]="ORCHID";
         string1[39]="BLOSSOM";
         string1[40]="DANDELION";
         string1[41]="STEM";
         string1[42]="JASMINE";
         string1[43]="TUBEROSE";
         string1[44]="LOTUS";
         Start=new JButton ("START");
         EXIT=new JButton ("EXIT");
         FRUITS=new JButton("FRUITS");
         ANIMALES=new JButton("ANIMALES");
         FLOWERS=new JButton("FLOWERS");
         FINISHED=new JButton("FINISHED");
         NEXT=new JButton("NEXT");
         PREVIOUS=new JButton("PREV");
         EXAMTIME=new JButton("EXAMTIME");
         LEARNINGTIME= new JButton("LEARN");
         Help=new JButton("HELP");
          BACK=new JButton("BACK");
          Back=new JButton("BACK");
          OK=new  JButton("OK");
          Panel1=new JPanel();
        
         text=new JTextField();
          
         
         ButtonHandler handler=new ButtonHandler();
        
         Start.addActionListener(handler);
         
         EXIT.addActionListener(handler);
         FRUITS.addActionListener(handler);
         ANIMALES.addActionListener(handler);
         FLOWERS.addActionListener(handler);
         FINISHED.addActionListener(handler);
         NEXT.addActionListener(handler);
         PREVIOUS.addActionListener(handler);
         Help.addActionListener(handler);
         EXAMTIME.addActionListener(handler);
         LEARNINGTIME.addActionListener(handler);
         BACK.addActionListener(handler);
         Back.addActionListener(handler);
          OK.addActionListener(handler);
       


    }


/***
 ************** RUN METHOD, GAME STARTS************************
 */
    public void run() {
        outer:
        {
            init();
   object = new Game();
            
     
            MainMenue();
               object.setSize(800, 600);
              object.setResizable(false);
              object.setVisible(true);
              object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
       
        }

    }
    
   /***
    * ******* ACTIONLISTENER FOR BUTTON*****************
    */
    public class ButtonHandler implements ActionListener{
    
      public void actionPerformed(ActionEvent event)
      {
        if(event.getSource()==Start)
        {
            IsStart=true;
            showSecondMenu();
       
        }
        else if(event.getSource()==Back)
        {
            
             MainMenue();       
        }
        else if(event.getSource()==EXIT)
             System.exit(0);
        
        else if(event.getSource()==EXAMTIME)
        {
           
          TakeExam();
        }
        else if(event.getSource()==FRUITS)
        {
             firstIndex=15;
            lastIndex=29;
            multiple=1;
          
           lowerBound=firstIndex;
           IsFruits=true;
           IsFlower=false;
           IsAnimales=false;
           showOptions();
           
        }
        else if(event.getSource()==ANIMALES)
        {
            firstIndex=0;
            lastIndex=14;
            multiple=0;
           IsFruits=false;
           IsFlower=false;
           IsAnimales=true;
           lowerBound=firstIndex;
          showOptions();
          
        }
        else if(event.getSource()==FLOWERS)
        {
             firstIndex=30;
            lastIndex=44;
            multiple=2;
             lowerBound=firstIndex;
         IsFruits=false;
           IsFlower=true;
           IsAnimales=false;
          showOptions();
        }
        else if(event.getSource()==Help)
        {
            showHelpMenu();
        
        }
        else if(event.getSource()==LEARNINGTIME)
        {
          
             ShowLearningOptions();
        
        }
        else if(event.getSource()==OK)
        {
        MainMenue();       
        }
        
        else if(event.getSource()==BACK)
        {
            firstIndex=lowerBound;
            IsFruits=false;
            IsFlower=false;
            IsAnimales=false;
           
            showSecondMenu();
        }
        else if(event.getSource()==NEXT)
        {
          firstIndex++;
          if(firstIndex>lastIndex)
          {
           firstIndex=lowerBound;
          }
          
           toShowImage.setVisible(false);
           if(string1[firstIndex].length()<=5)
           name.setText("  "+string1[firstIndex]);
           else 
                name.setText(string1[firstIndex]);
             toShowelement= new ImageIcon(getClass().getResource("Images/"+string1[firstIndex]+".png"));
      toShowImage=new JLabel(toShowelement);
      toShowImage.setBounds(250,70,300,350);
      toShowImage.setVisible(true);
     
    
      Panel1.add(toShowImage);
         object.setContentPane(Panel1);
      
       
        }
        else if(event.getSource()==PREVIOUS)
        {
           --firstIndex;
            if(firstIndex<lowerBound)
            {
            firstIndex=lastIndex;
            }
            toShowImage.setVisible(false);
             if(string1[firstIndex].length()<=5)
              name.setText("  "+string1[firstIndex]);
           else 
                name.setText(string1[firstIndex]);
                        //name.setText(string1[firstIndex]);  
            toShowelement= new ImageIcon(getClass().getResource("Images/"+string1[firstIndex]+".png"));

               toShowImage=new JLabel(toShowelement);
      toShowImage.setBounds(250,70,300,350);
      toShowImage.setVisible(true);
      Panel1.add(toShowImage);
      object.setContentPane(Panel1);
       
        
        }
        else if(event.getSource()==FINISHED)
        {
            Isfinished=true;
            
          firstIndex=lowerBound;
           showOptions();
        }
      }
      }
    /***
     * ************* METHOD WHICH SHOWS MAIN MENUE***************
     */
    void MainMenue()
    {
             
            Panel1.removeAll();
                Panel1.repaint();
                 Panel1.revalidate();
                Panel1.setLayout(null);
             toShowbackground=new ImageIcon(getClass().getResource("Images/Visual Word Guess (1).png"));
              menu=new JLabel(toShowbackground);
              menu.setBounds(0, 0, 800, 600); 
             
                
                // Panel1.setVisible(true);
              object.setLayout(null); 
              
              Start.setBounds(600,200,100,30);
              Start.setBackground(Color.YELLOW);
              Start.setForeground(Color.BLACK);
             Start.setFocusable(false); 
              Help.setBackground(Color.YELLOW);
              Help.setForeground(Color.BLACK);
              Help.setBounds(600,250,100,30);
             Help.setFocusable(false);   
              EXIT.setBackground(Color.YELLOW);
              EXIT.setForeground(Color.BLACK);
              EXIT.setBounds(600,300,100,30);
              EXIT.setFocusable(false); 
              
              menu.add(Start);
              menu.add(Help);
              menu.add(EXIT);
           
               Panel1.add(menu);
               object.setContentPane(Panel1); 
            
     
                                   
    }
    /***
     * **************** METHOD TO SHOW HELP**********************
     */
      void showHelpMenu()
     {
         Panel1.removeAll();
                Panel1.repaint();
                 Panel1.revalidate();
                 Panel1.setLayout(null);
                Panel1.setVisible(true);
                
          Font f=new Font("SansSerif",Font.BOLD,20);
          
                 ImageIcon helper;
        helper = new ImageIcon(getClass().getResource("Images/Help.png"));
                 JLabel helping=new JLabel(helper);
                 helping.setBounds(0,0,800,600);
          OK.setBounds(420, 520, 120, 50);
          
          OK.setFont(f);
          OK.setBackground(Color.darkGray);
          OK.setForeground(Color.black);
          OK.setFocusable(false); 
          helping.add(OK);
          Panel1.add(helping);
         
          object.setContentPane(Panel1);
     
     
     }
      /***
       * ******************* METHOD TO SHOW COMPONENTS TO LEARN****************************
                              it refreshes Panel and set images        
                              in proper place, some button is
                              used to control image changing 
       */
    void ShowLearningOptions()
    {
         Panel1.removeAll();
                Panel1.repaint();
                 Panel1.revalidate();
                 Panel1.setLayout(null);
                 Panel1.setVisible(true);
          Panel1.setBackground(Color.lightGray);
          NEXT.setBounds(350, 480, 150, 50);
         NEXT.setBackground(Color.darkGray);
              NEXT.setForeground(Color.BLACK);
              NEXT.setFocusable(false); 
              PREVIOUS.setBounds(150, 480, 150, 50);
              
              PREVIOUS.setBackground(Color.darkGray);
              PREVIOUS.setForeground(Color.BLACK);
              PREVIOUS.setFocusable(false); 
              FINISHED.setBounds(550,480,150,50);
              FINISHED.setBackground(Color.darkGray);
              FINISHED.setForeground(Color.BLACK);
              FINISHED.setFocusable(false); 
              Font f=new Font("SansSerif",Font.BOLD,20);
              NEXT.setFont(f);
              PREVIOUS.setFont(f);
              FINISHED.setFont(f);
              
              Panel1.add(NEXT);
              Panel1.add(PREVIOUS);
              Panel1.add(FINISHED);
         object.setContentPane(Panel1);       

         toShowelement= new ImageIcon(getClass().getResource("Images/"+string1[firstIndex]+".png"));
       name= new JLabel(string1[firstIndex]);
       name.setBounds(300,300,400,180);
       Font f2=new Font("SansSerif",Font.ITALIC,50);
       name.setFont(f2);
       toShowImage=new JLabel(toShowelement);
       toShowImage.setBounds(250,70,300,350);
       Panel1.add(name);
       Panel1.add(toShowImage);
       
  
      
    }
    
    /***
     * ************** METHOD TO SHOW LEARN AND EXAMTIME BUTTON**********************
                      
    */
    void showOptions()
    {
        
        
        if(IsFruits==true){
            
        toShowbackground=new ImageIcon(getClass().getResource("Images/bag4.png"));
              EXAMTIME.setBackground(Color.blue);
              LEARNINGTIME.setBackground(Color.blue);
              BACK.setBackground(Color.blue);
        }
        else if(IsFlower==true)
        { toShowbackground=new ImageIcon(getClass().getResource("Images/bag2.png"));
           EXAMTIME.setBackground(Color.lightGray);
              LEARNINGTIME.setBackground(Color.lightGray);
              BACK.setBackground(Color.lightGray);
        
        }
        else if(IsAnimales==true){
           
            toShowbackground=new ImageIcon(getClass().getResource("Images/bag5.png"));
            EXAMTIME.setBackground(Color.orange);
              LEARNINGTIME.setBackground(Color.orange);
              BACK.setBackground(Color.orange);
        }
            
                menu=new JLabel(toShowbackground);
                 menu.setBounds(0,0,800,600);
                  Panel1.removeAll();
                Panel1.repaint();
                 Panel1.revalidate();
                 Panel1.setLayout(null);
                 Panel1.setVisible(true);
                 Panel1.add(menu);
                 object.setContentPane(Panel1);
          
  
        EXAMTIME.setForeground(Color.BLACK);
        EXAMTIME.setBounds(680,30,100,30);
        EXAMTIME.setFocusable(false); 
        
        LEARNINGTIME.setForeground(Color.BLACK);
        LEARNINGTIME.setBounds(680,80,100,30);
        LEARNINGTIME.setFocusable(false); 
        
        BACK.setForeground(Color.BLACK);
        BACK.setBounds(680,130,100,30);
       BACK.setFocusable(false); 
        
        menu.add(EXAMTIME);
        menu.add(LEARNINGTIME);
        menu.add(BACK);     
        
        
        
    
    }
    /***
     *********************Overloaded method**************************** 
                          takes parameters from ExamTaking
                          class,here lower and upper
                          is the index range of the array
                          multi is a flag
     * @param t
     * @param p 
     */
     void showOptions(Game t ,JPanel p,int lower,int last,int multi)
    {
        init();
        object=t;
        Panel1=p;
        this.lowerBound=lower;
        this.lastIndex=last;
        this.firstIndex=lower;
        multiple=multi;
       
        if(IsFruits==true){
            
        toShowbackground=new ImageIcon(getClass().getResource("Images/bag4.png"));
              EXAMTIME.setBackground(Color.blue);
              LEARNINGTIME.setBackground(Color.blue);
              BACK.setBackground(Color.blue);
        }
        else if(IsFlower==true)
        { toShowbackground=new ImageIcon(getClass().getResource("Images/bag2.png"));
           EXAMTIME.setBackground(Color.lightGray);
              LEARNINGTIME.setBackground(Color.lightGray);
              BACK.setBackground(Color.lightGray);
        
        }
        else if(IsAnimales==true){
           
            toShowbackground=new ImageIcon(getClass().getResource("Images/bag5.png"));
            EXAMTIME.setBackground(Color.orange);
              LEARNINGTIME.setBackground(Color.orange);
              BACK.setBackground(Color.orange);
        }
      
                menu=new JLabel(toShowbackground);
                 menu.setBounds(0,0,800,600);
                  Panel1.removeAll();
                Panel1.repaint();
                 Panel1.revalidate();
                 Panel1.setLayout(null);
                 Panel1.setVisible(true);
                 Panel1.add(menu);
                 object.setContentPane(Panel1);
                 //JButton EXAMTIME=new JButton("EXAMTIME");
                 
         
      
        EXAMTIME.setForeground(Color.BLACK);
        EXAMTIME.setBounds(625,40,100,30);
        EXAMTIME.setFocusable(false); 
      
        LEARNINGTIME.setForeground(Color.BLACK);
        LEARNINGTIME.setBounds(625,90,100,30);
        LEARNINGTIME.setFocusable(false); 
      
        BACK.setForeground(Color.BLACK);
        BACK.setBounds(625,140,100,30);
       BACK.setFocusable(false); 
        
        menu.add(EXAMTIME);
        menu.add(LEARNINGTIME);
        menu.add(BACK);   
        
        
        
        
    
    }
    
    /***
     * ******************** METHOD THAT SHOWS OPTIONS THAT TO LEARN*************************
                            After clicking Start it appears
     */
 void showSecondMenu()
 {
      toShowbackground=new ImageIcon(getClass().getResource("Images/bag1.png"));
                menu=new JLabel(toShowbackground);
                menu.setBounds(0,0,800,600);
                //Panel2.setVisible(true);
                Panel1.removeAll();
                Panel1.repaint();
                Panel1.revalidate();
            
                    Panel1.setLayout(null);
               Panel1.add(menu);
                    object.setContentPane(Panel1);
                
                    
                 FRUITS.setBackground(Color.GREEN);
              FRUITS.setForeground(Color.RED);
              FRUITS.setBounds(625,40,100,30);
           FRUITS.setFocusable(false);    
              ANIMALES.setBackground(Color.GREEN);
              ANIMALES.setForeground(Color.RED);
              ANIMALES.setBounds(625,90,100,30);
              ANIMALES.setFocusable(false); 
              FLOWERS.setBackground(Color.GREEN);
              FLOWERS.setForeground(Color.RED);
              FLOWERS.setBounds(625,140,100,30);
             FLOWERS.setFocusable(false); 
             Back.setBackground(Color.GREEN);
              Back.setForeground(Color.RED);
              Back.setBounds(625,190,100,30);
              Back.setFocusable(false); 
                menu.add(FRUITS);
                menu.add(FLOWERS);
                menu.add(ANIMALES);
                menu.add(Back);
       
 }
 /***
  * ***************** METHOD THAT CONTROLS EXAMTAKING PART******************************
  */
 void TakeExam ()
 {
    
     ExamTaking exam=new ExamTaking(object, lowerBound, lastIndex,multiple,Panel1);
   
 }
 
}


