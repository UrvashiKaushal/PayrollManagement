import java.awt.*;
import javax.swing.*;
public class SplashS {
    public static void main(String args[]){
        sframe f1 = new sframe("WELCOME SCREEN.");
        f1.setVisible(true);
        int i;
        int x = 1;
        for(i=2;i<=600;i+=4,i+=1)
        {
            f1.setLocation((800-((i+x)/2)),500-(i/2));
            f1.setSize(i*x,i);
            try{
                Thread.sleep(10);
            }catch(Exception e){}
        }
    }
}
class sframe extends JFrame implements Runnable{
    Thread t1;
    sframe(String s){
        super(s);
        setLayout(new FlowLayout());
        ImageIcon c1 = new ImageIcon(ClassLoader.getSystemResource("icon/banner.jpg"));
        Image  i1 = c1.getImage().getScaledInstance(730,550,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i1);
        
        JLabel n1 = new JLabel(i2);
        add(n1);
        add(new JLabel("This is free Licence"));
        add(new JLabel("Support Security"));
        
        t1 = new Thread(this);
        t1.start();
    }
    public void run(){
        try{
            Thread.sleep(7000);
            this.setVisible(false);
            login f1 = new login();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
