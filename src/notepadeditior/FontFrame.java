/**
 *
 * @author Mohit
 */
package notepadeditior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FontFrame implements ActionListener
{
    private JFrame frame;
    private JComboBox font_name, font_style, font_size;
    private JButton ok_btn, cancel_btn;

    FontFrame()
    {
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (Exception e) {e.printStackTrace();}

        frame = new JFrame("Font");
        frame.setSize(500,300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String [] font_family = ge.getAvailableFontFamilyNames();
        font_name = new JComboBox(font_family);
        font_name.setBounds(10,50, 200, 25);
        frame.add(font_name);

        String [] style = {"Plain", "Bold", "Italic", "Bold Italic"};
        font_style = new JComboBox(style);
        font_style.setBounds(220,50, 150, 25);
        frame.add(font_style);

        String [] size = {"8", "9","10","11","12","14","16","18","20","22","24","26","28","36","48","72"};
        font_size = new JComboBox(size);
        font_size.setBounds(390,50,60,25);
        frame.add(font_size);

        ok_btn = new JButton("OK");
        ok_btn.setBounds(140,200,100,25);
        frame.add(ok_btn);
        ok_btn.addActionListener(this);
        cancel_btn = new JButton("Close");
        cancel_btn.setBounds(260,200,100,25);
        frame.add(cancel_btn);
        cancel_btn.addActionListener(this);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==ok_btn) {okMethod();}
        if (e.getSource()==cancel_btn) {frame.setVisible(false);}
    }
    private void okMethod()
    {
        int font_style_str ;

        if (font_style.getSelectedItem().equals("Bold")) {font_style_str = 1;}
        else if (font_style.getSelectedItem().equals("Italic")) {font_style_str = 2;}
        else if (font_style.getSelectedItem().equals("Bold Italic")) {font_style_str = 3;}
        else {font_style_str = 4;}

        String font_name_str = (String) font_name.getSelectedItem();
        int font_size_str = Integer.parseInt(String.valueOf(font_size.getSelectedItem()));
        frame.setVisible(false);

        CodingPart1.openFontFrame(font_name_str,font_style_str,font_size_str);
    }
}