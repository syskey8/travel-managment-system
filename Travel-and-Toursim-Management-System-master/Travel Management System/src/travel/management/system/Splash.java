package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
public class Splash extends JFrame implements Runnable {
    Thread thread;
    Splash() {
        //setSize(1200, 600);
        //setLocation(300, 200);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Travel/Management/System/icons/splash.png"));
        Image i2 = i1.getImage().getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        setVisible(true);
        thread = new Thread(this);
        thread.start();//this calls run method [thread.run is not used coz it will not work as multithread as intended]
    }
    public void run() {
        try {
            Thread.sleep(5000);
            new Login().setVisible(true);
            setVisible(false);
        } catch(Exception e) {

        }
    }
    public static void main(String[] args) {
        Splash frame = new Splash();
        int x = 1;
        for(int i = 1; i <= 650; x+=7, i+=6)
        {
            frame.setLocation(960 - (x + i)/2, 540 - (i/2));
            frame.setSize(i * 2, i);
            try {
                Thread.sleep(10);
            } catch(Exception e) {

            }
        }
    }
}

//"Travel/Management/System/icons/splash.png"