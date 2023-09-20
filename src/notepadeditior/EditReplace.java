/**
 *
 * @author Mohit
 */
package notepadeditior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditReplace implements ActionListener
{
    private JFrame frame;
    private JTextField find_what_text, replace_with_text;
    private JButton replace_all_btn, cancel_btn;
    private String str;
    EditReplace(String str)
    {
        this();
        this.str = str;
    }
    private EditReplace()
    {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (Exception e) {e.printStackTrace();}

        frame = new JFrame("Replace");
        frame.setSize(400,150);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel find_what = new JLabel("Find what:");
        find_what.setFont(new Font("arial",4,12));
        find_what.setBounds(5,15,80,10);
        frame.add(find_what);
        find_what_text = new JTextField();
        find_what_text.setFont(new Font("arial",4,12));
        find_what_text.setBounds(90,9,180,22);
        frame.add(find_what_text);

        JLabel replace_with = new JLabel("Replace with:");
        replace_with.setFont(new Font("arial",4,12));
        replace_with.setBounds(5,48,100,20);
        frame.add(replace_with);
        replace_with_text = new JTextField();
        replace_with_text.setFont(new Font("arial",4,12));
        replace_with_text.setBounds(90,47,180,22);
        frame.add(replace_with_text);

        replace_all_btn = new JButton("Replace All");
        replace_all_btn.setFont(new Font("arial",4,12));
        replace_all_btn.setBounds(280,9,100,25);
        frame.add(replace_all_btn);
        replace_all_btn.addActionListener(this);

        cancel_btn = new JButton("Cancel");
        cancel_btn.setFont(new Font("arial",4,12));
        cancel_btn.setBounds(280,48,100,25);
        frame.add(cancel_btn);
        cancel_btn.addActionListener(this);

        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==replace_all_btn)
        {
            String str2 = str.replaceAll(find_what_text.getText(),replace_with_text.getText());
            CodingPart1.setTextArea(str2);
        }
        if (e.getSource()==cancel_btn) {frame.setVisible(false);}
    }
}
