package view;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;


//버튼에 올리면 손가락 커서로 변경
//(버튼명).setCursor(new Cursor(Cursor.HAND_CURSOR));


@SuppressWarnings("serial")
public class A_MyCustomJButton extends JButton implements MouseListener
{

    private Cursor defaultCursor;
    private Cursor handCursor;

    public A_MyCustomJButton()
    {
        super();

        init();
    }

    public A_MyCustomJButton(Action a)
    {
        super(a);

        init();
    }

    public A_MyCustomJButton(Icon icon)
    {
        super(icon);

        init();
    }

    public A_MyCustomJButton(String text, Icon icon)
    {
        super(text, icon);

        init();
    }

    public A_MyCustomJButton(String text)
    {
        super(text);

        init();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {

    }

    @Override
    public void mousePressed(MouseEvent e)
    {

    }

    @Override
    public void mouseReleased(MouseEvent e)
    {

    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        this.setCursor(handCursor);
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        this.setCursor(defaultCursor);
    }

    private void init()
    {
        defaultCursor = this.getCursor();
        handCursor = new Cursor(Cursor.HAND_CURSOR);

        addMouseListener(this);
    }

}
