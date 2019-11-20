package game.bonusStage.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Shake extends JPanel implements Runnable {

  private JButton button;

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(new Shake());
  }

  @Override
  public void run() {
	  button = new JButton(new ImageIcon("images/bonus/hok1.png"));
		button.setBounds(400, 185, 500, 400);
		button.setFont(new Font("DungGeunMo", Font.BOLD, 40));
		button.setBorderPainted(false);
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        shakeButton();
      }
    });
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(button);

    frame.setSize(1300, 770);
    frame.setBackground(Color.BLACK);
    frame.setVisible(true);
    frame.setLayout(null);
  }

  private void shakeButton() {
    final Point point = button.getLocation();
    final Insets margin = button.getMargin();
    final int delay = 10;
    Runnable r = new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 5; i++) {
          try {
            setButtonMargin(new Insets(margin.top, margin.left + 5,
                margin.bottom, margin.right - 4));
            Thread.sleep(delay);
            setButtonMargin(margin);
            Thread.sleep(delay);
            setButtonMargin(new Insets(margin.top, margin.left - 4,
                margin.bottom, margin.right + 5));
            Thread.sleep(delay);
            setButtonMargin(margin);
            Thread.sleep(delay);
          } catch (InterruptedException ex) {
            ex.printStackTrace();
          }
        }
      }
    };
    Thread t = new Thread(r);
    t.start();
  }

  private void setButtonMargin(final Insets margin) {
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        button.setMargin(margin);
      }
    });
  }
}
