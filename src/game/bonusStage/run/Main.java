package game.bonusStage.run;

import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Main extends JFrame {
  public static JButton buzz = new JButton(new ImageIcon("images/bonus/hok1.png"));

  public void prepareGUI() {
    buzz.addActionListener(new BuzzActionListener(this));
    setSize(300, 200);
    getContentPane().add(buzz);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String st[]) {
    Main bFrame = new Main();
    bFrame.prepareGUI();
    bFrame.setVisible(true);

  }
}

class BuzzActionListener implements ActionListener {
  JFrame frame;
  
  Point currLocation;
  int iDisplaceXBy = 5;
  int iDisplaceYBy = -5;

  public BuzzActionListener(JFrame frame) {
    this.frame = frame;
  }

  @Override
  public void actionPerformed(ActionEvent evt) {
    currLocation = frame.getLocationOnScreen();

    Point position1 = new Point(currLocation.x + iDisplaceXBy, currLocation.y
        + iDisplaceYBy);
    Point position2 = new Point(currLocation.x - iDisplaceXBy, currLocation.y
        - iDisplaceYBy);
    for (int i = 0; i < 20; i++) {
      frame.setLocation(position1);
      frame.setLocation(position2);
    }
    frame.setLocation(currLocation);
  }
}