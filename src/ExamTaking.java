import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;
import javax.swing.*;
public class ExamTaking extends JFrame
{
    Game object;
    int lowerBound,lastIndex,oneWrong,oneTime;
    JButton AGAIN,Quiet,Pause,Resume;
    JTextField text;
    JLabel toShowImage,verdict,label1;
    JLabel missTyped[],timeUp[];
    JPanel Panel1;
    int bool[];
    boolean Track;
    int rannum;
    int success,count;
    String countdown,typed[];
    String str;
    int sec,right,vool,somoy,temp;
    public Timer timer,timer1;
    
    ImageIcon toShowelement,wrong,correct,thumsDown,excelent,perfect,bronje,gold,silver,cup;
    int multiple;
    /**
     * ************Constructor to initialize all ****************
     *           it takes a Test object, and the range of the
     *           string array ,Panel and a flag multi from 
     *           Test class
     * @param t
     * @param lowerBound
     * @param lastIndex
     * @param multiple
     * @param panel1 
     */
    public ExamTaking(Game t,int lowerBound,int lastIndex,int multiple,JPanel panel1 )
    {

        
        excelent=new ImageIcon(getClass().getResource("Images/EXCELENT.png"));
        success=0;
        count=0;
        sec=10;
        right=0;
        vool=0;
        somoy=0;
        Track=false;
        wrong=new ImageIcon(getClass().getResource("Images/wrong.png"));
        correct=new ImageIcon(getClass().getResource("Images/correct.png"));
        thumsDown=new ImageIcon(getClass().getResource("Images/Thumbs_down.png"));
              bronje=new ImageIcon(getClass().getResource("Images/Bronje.png"));
              gold=new ImageIcon(getClass().getResource("Images/Gold.png"));
              silver=new ImageIcon(getClass().getResource("Images/Silver.png"));
              cup=new ImageIcon(getClass().getResource("Images/TROPHY.png"));
        this.multiple=multiple;
        bool=new int[15];
        
         missTyped=new JLabel[15];
        timeUp=new JLabel[15];
        for(int i=0; i<15; i++)
        {
            missTyped[i]=new JLabel(" ");
            timeUp[i]=new JLabel("");
           // missTyped[i].setText("");
            bool[i]=0;

        }
        
        object=t;

        this.lowerBound=lowerBound;
        this.lastIndex=lastIndex;
        this.Panel1=panel1;
        text=new JTextField();
        TextFieldHandler handler=new TextFieldHandler();
        
             Quiet=new JButton("Leave Exam");
        AGAIN=new JButton("BACK");
         Pause=new JButton("Pause");
         Resume=new JButton("Resume");
                ButtonHandler handler1=new ButtonHandler();
                 Quiet.addActionListener(handler1);
                AGAIN.addActionListener(handler1);
                Pause.addActionListener(handler1);
                 Resume.addActionListener(handler1);
        text.addActionListener(handler);
        
       
        oneWrong=0;
        oneTime=0;
        
        timer1 = new Timer(1000, new TimerListener());
        ExamTime();
        timer1.start();


    }
    
    public class ButtonHandler implements ActionListener{
    public void actionPerformed( ActionEvent event )
    {
        if(event.getSource()==AGAIN||event.getSource()==Quiet)
        {
            //timer.stop();
            timer1.stop();
            object.showOptions(object,Panel1,lowerBound,lastIndex,multiple);}
        else if(event.getSource()==Pause){
        
        Pause.setVisible(false);
        Resume.setBounds(180, 0, 150,30);
        Resume.setBackground(Color.red);
        Resume.setForeground(Color.black);
        Resume.setFocusable(false);
        Resume.setVisible(true);
        Panel1.add(Resume);
        temp=sec;
        sec=10000000;
        text.setEditable(false);
        text.setFocusable(false); 
        }
        else if(event.getSource()==Resume){
        Resume.setVisible(false);
        
        Pause.setBounds(180, 0, 150,30);
        Pause.setBackground(Color.green);
        Pause.setForeground(Color.black);
        Pause.setVisible(true);
        Panel1.add(Pause);
        sec=temp;
         text.setFocusable(true); 
          text.setEditable(true);
          text.requestFocusInWindow();
        }
        
    }
    
    }
    /***
     *********************TextFieldHandler for taking users input *******************************
     */
    
    private class TextFieldHandler implements ActionListener
    {
        public void actionPerformed( ActionEvent event )
        {
            str="";
            if(event.getSource()==text)
            {
                str=str+event.getActionCommand();
               
                text.setText("");
                timer = new Timer(1000, new TimerListener()); 
                ShowVerdict();
                timer.start(); 
               
            }
        }
    }

/***
 * *************************Time Listener used to control timer1 and timer object of Timer class************************************
 *    here timer is used for countdown clock and timer1 for delay in verdict
 */
    class TimerListener implements ActionListener 
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource()==timer)
            {
               
                timer.stop();
               
                if(sec<10)
                    ExamTime();

            }
            else if(event.getSource()==timer1)
            {
                if(sec<=10)
                {     
                sec--;
                countdown="0"+sec;
                label1.setText(countdown);


                if(sec<0)
                {
                   somoy++;
                   if(somoy+right+vool==count)
                    
                   { timeUp[oneTime].setText(object.string1[rannum]);
                      oneTime++;}
                   else
                        somoy--;
                      
                   
                    ExamTime();
                    
                }
            }
            }
        }
    }
    /**
     * ****************Method to show final result******************
     */
    void ShowResult()
    {
        timer1.stop();
        Panel1.removeAll();

        Panel1.repaint();
        Panel1.revalidate();
        Panel1.setLayout(null);
        Panel1.setBackground(Color.CYAN);
        object.setContentPane(Panel1);
        ImageIcon image=new ImageIcon(getClass().getResource("Images/bag3.png"));
        JLabel label=new JLabel(image);
        label.setBounds(0,0,800,575);
        Font f=new Font("SansSerif",Font.BOLD,30);
        Font f1=new Font("SansSerif",Font.BOLD,20);
       
        JLabel Bronje=new JLabel(bronje);
        JLabel Gold=new JLabel(gold);
        JLabel DOWN=new JLabel(thumsDown);
        JLabel ex=new JLabel(excelent);
       JLabel Silver=new JLabel(silver);
       JLabel Trophy=new JLabel(cup);
       Trophy.setBounds(250,70,300,350);
        Silver.setBounds(250,70,300,350);
         Bronje.setBounds(250,70,300,350);
         Gold.setBounds(250,70,300,350);
        DOWN.setBounds(250,70,300,350);
        ex.setBounds(350,280,350,350);
        AGAIN.setBounds(550,500,200,50);
        AGAIN.setBackground(Color.DARK_GRAY);
        AGAIN.setForeground(Color.red);
        AGAIN.setFont(f1);
if(success==15)
{

            String st="Correctly Answered All...!!!!Perfection...!!!!!!!!!";
            JLabel msg=new JLabel(st);
            msg.setBounds(50,30,800,50);
            msg.setFont(f);
            label.add(msg);
            label.add(Trophy);
            label.add(ex);
           
}

        else if(success<=14&&success>=13)
        {
            String st="You have given"+" "+success+" "+"correct answers out of 15!!!";
            JLabel msg=new JLabel(st);
            msg.setBounds(50,30,800,50);
            msg.setFont(f);
            label.add(msg);
            label.add(Gold);
            
           
        }
        else if(success<=12&&success>=10){
        
            String st="You have given"+" "+success+" "+"correct answers out of 15!!!";
            JLabel msg=new JLabel(st);
            msg.setBounds(50,30,800,50);
            msg.setFont(f);
            label.add(msg);
            label.add(Silver);
}
        else if(success<=9&&success>=7)
        {



            String st="You have given"+" "+success+" "+"correct answers out of 15!!!";
            JLabel msg=new JLabel(st);
            msg.setBounds(50,30,800,50);
            msg.setFont(f);
            label.add(msg);
            label.add(Bronje);



        }
        else
        {
            String st;
            if(success>1)
                st="You have given"+" "+success+" "+"correct answers out of 15";
            else
                st="You have given"+" "+success+" "+"correct answer out of 15";
            JLabel msg=new JLabel(st);
            msg.setBounds(50,30,800,50);
            msg.setFont(f);

            label.add(msg);
            label.add(DOWN);
            
        }
        if(oneWrong>0||oneTime>0)
        {
        JLabel headline=new JLabel("Mistyped:");
       JLabel headline2=new JLabel("TimeOut:");
            headline.setBounds(50,80,800,40);
            headline.setFont(f);
            headline.setForeground(Color.blue);
               headline2.setBounds(610,80,800,40);
            headline2.setFont(f);
            headline2.setForeground(Color.blue);
             
            label.add(headline); 
             label.add(headline2);
        Font f2=new Font("SansSerif",Font.BOLD,15);
            missTyped[0].setBounds(50, 130, 800, 15);
            missTyped[0].setFont(f2);
            missTyped[0].setForeground(Color.red);
            missTyped[1].setBounds(50, 155, 800, 15);
            missTyped[1].setFont(f2);
            missTyped[1].setForeground(Color.red);
            missTyped[2].setBounds(50, 180, 800, 15);
            missTyped[2].setFont(f2);
            missTyped[2].setForeground(Color.red);
            missTyped[3].setBounds(50, 205, 800, 15);
            missTyped[3].setFont(f2);
            missTyped[3].setForeground(Color.red);
            missTyped[4].setBounds(50, 230, 800, 15);
            missTyped[4].setFont(f2);
            missTyped[4].setForeground(Color.red); 
            missTyped[5].setBounds(50, 255, 800, 15);
            missTyped[5].setFont(f2);
            missTyped[5].setForeground(Color.red);
            missTyped[6].setBounds(50, 280, 800, 15);
            missTyped[6].setFont(f2);
            missTyped[6].setForeground(Color.red); 
            missTyped[7].setBounds(50, 305, 800, 15);
            missTyped[7].setFont(f2);
            missTyped[7].setForeground(Color.red); 
            missTyped[8].setBounds(50, 330, 800, 15);
            missTyped[8].setFont(f2);
            missTyped[8].setForeground(Color.red); 
            missTyped[9].setBounds(50, 355, 800, 15);
            missTyped[9].setFont(f2);
            missTyped[9].setForeground(Color.red); 
            missTyped[10].setBounds(50, 380, 800, 15);
            missTyped[10].setFont(f2);
            missTyped[10].setForeground(Color.red); 
            missTyped[11].setBounds(50, 405, 800, 15);
            missTyped[11].setFont(f2);
            missTyped[11].setForeground(Color.red); 
            missTyped[12].setBounds(50, 430, 800, 15);
            missTyped[12].setFont(f2);
            missTyped[12].setForeground(Color.red); 
            missTyped[13].setBounds(50, 455, 800, 15);
            missTyped[13].setFont(f2);
            missTyped[13].setForeground(Color.red);
            missTyped[14].setBounds(50, 480, 800, 15);
            missTyped[14].setFont(f2);
            missTyped[14].setForeground(Color.red);
            
            timeUp[0].setBounds(620,130,800,15);
            timeUp[0].setFont(f2);
            timeUp[0].setForeground(Color.red);
            timeUp[1].setBounds(620, 155, 800, 15);
            timeUp[1].setFont(f2);
            timeUp[1].setForeground(Color.red);
            timeUp[2].setBounds(620, 180, 800, 15);
            timeUp[2].setFont(f2);
            timeUp[2].setForeground(Color.red);
            timeUp[3].setBounds(620, 205, 800, 15);
            timeUp[3].setFont(f2);
            timeUp[3].setForeground(Color.red);
            timeUp[4].setBounds(620, 230, 800, 15);
            timeUp[4].setFont(f2);
            timeUp[4].setForeground(Color.red); 
            timeUp[5].setBounds(620, 255, 800, 15);
            timeUp[5].setFont(f2);
            timeUp[5].setForeground(Color.red);
            timeUp[6].setBounds(620, 280, 800, 15);
            timeUp[6].setFont(f2);
            timeUp[6].setForeground(Color.red); 
            timeUp[7].setBounds(620, 305, 800, 15);
            timeUp[7].setFont(f2);
            timeUp[7].setForeground(Color.red); 
            timeUp[8].setBounds(620, 330, 800, 15);
            timeUp[8].setFont(f2);
            timeUp[8].setForeground(Color.red); 
            timeUp[9].setBounds(620, 355, 800, 15);
            timeUp[9].setFont(f2);
            timeUp[9].setForeground(Color.red); 
            timeUp[10].setBounds(620, 380, 800, 15);
            timeUp[10].setFont(f2);
            timeUp[10].setForeground(Color.red); 
            timeUp[11].setBounds(620, 405, 800, 15);
            timeUp[11].setFont(f2);
            timeUp[11].setForeground(Color.red); 
            timeUp[12].setBounds(620, 430, 800, 15);
            timeUp[12].setFont(f2);
            timeUp[12].setForeground(Color.red); 
            timeUp[13].setBounds(620, 455, 800, 15);
            timeUp[13].setFont(f2);
            timeUp[13].setForeground(Color.red);
            timeUp[14].setBounds(620, 480, 800, 15);
            timeUp[14].setFont(f2);
            timeUp[14].setForeground(Color.red);
            
            
            label.add(timeUp[0]);
           
            label.add(timeUp[1]);
            label.add(timeUp[2]);
            label.add(timeUp[3]);
            label.add(timeUp[4]);
            label.add(timeUp[5]);
            label.add(timeUp[6]);
            label.add(timeUp[7]);
            label.add(timeUp[8]);
            label.add(timeUp[9]);
            label.add(timeUp[10]);
            label.add(timeUp[11]);
            label.add(timeUp[12]);
            label.add(timeUp[13]);
            label.add(timeUp[14]);
           
            label.add(missTyped[0]);
            label.add(missTyped[1]);
            label.add(missTyped[2]);
            label.add(missTyped[3]);
            label.add(missTyped[4]);
            label.add(missTyped[5]);
            label.add(missTyped[6]);
            label.add(missTyped[7]);
            label.add(missTyped[8]);
            label.add(missTyped[9]);
            label.add(missTyped[10]);
            label.add(missTyped[11]);
            label.add(missTyped[12]);
            label.add(missTyped[13]);
            label.add(missTyped[14]);
           
            
            
            
        
        }
        AGAIN.setFocusable(false); 
        label.add(AGAIN);
        Panel1.add(label);
    }
/**
 * *************** Method to show verdict******************
 */
    void ShowVerdict()
    {
       
        Panel1.removeAll();
        Panel1.repaint();
        Panel1.revalidate();
        Panel1.setLayout(null);
        object.setContentPane(Panel1);
        if(str.replaceAll("\\s+","").equalsIgnoreCase(object.string1[rannum]))
        { right++;
            success++;
            verdict=new JLabel(correct);
            verdict.setBounds(0,0,800,600);
        }
        else
        {
            vool++;
            missTyped[oneWrong].setText(object.string1[rannum]);
            oneWrong++;
            verdict=new JLabel(wrong);
            verdict.setBounds(0,0,800,600);
        }
        Panel1.add(verdict);
        
    }
/**
 * ********************Method for taking exam********************
        it generates images randomly and ask user for proper spelling
       
        
 */
    public void ExamTime()
    {
        
        if(count==15)
        {
         
            ShowResult();
        }
        else
        {
            Panel1.removeAll();

            Panel1.repaint();
            Panel1.revalidate();
            Panel1.setLayout(null);
            Panel1.setBackground(Color.LIGHT_GRAY);
            object.setContentPane(Panel1);
           
            label1=new JLabel("10");
            sec=10;
            label1.setBounds(700,20,100,100);
             JLabel score=new JLabel();
             JLabel score2=new JLabel();
             JLabel score3=new JLabel();
        Font f=new Font("SansSerif",Font.BOLD,15);     
             score.setText("Correct: "+right);
             score2.setText("Wrong  : "+vool);
             score3.setText("TimeUp: "+somoy);
            score.setFont(f);
            score2.setFont(f);
            score3.setFont(f);
             score.setBounds(700,120,100,100);
              score.setForeground(Color.GREEN);
            score2.setBounds(700,220,100,100);
              score2.setForeground(Color.RED);
              score3.setBounds(700,320,100,100);
              score3.setForeground(Color.BLUE);
              while(true)
            {
                
                rannum=(int)(Math.random()*15);
                rannum=rannum+(15*multiple);
                int  mod=rannum%15;
                

                if(bool[mod]==0)
                {

                    count++;
                    bool[mod]=1;
                    break;
                }

            }
            toShowelement= new ImageIcon(getClass().getResource("Images/"+object.string1[rannum]+".png"));
            toShowImage=new JLabel(toShowelement);
            toShowImage.setBounds(250,70,300,350);
            Panel1.add(toShowImage);

            Font f2=new Font("SansSerif",Font.ITALIC,40);
            label1.setFont(f2);
            label1.setBackground(Color.GREEN);
            Panel1.add(label1);
            text.setBackground(Color.white);
            text.setFont(f2);
            text.setBounds(280, 450, 250,50);
            text.setText("");
           
            Quiet.setBounds(0,0,150,30);
            Quiet.setBackground(Color.blue);
            Quiet.setForeground(Color.black);
            Quiet.setFocusable(false);
            Pause.setBounds(180,0,150,30);
            Pause.setBackground(Color.green);
            Pause.setForeground(Color.black);
             Pause.setFocusable(false); 
            
            Panel1.add(score);
            Panel1.add(score2);
            Panel1.add(score3);
            Panel1.add(text);
             Panel1.add(Quiet); 
             Panel1.add(Pause);
            text.requestFocusInWindow();
        }

    }
}
