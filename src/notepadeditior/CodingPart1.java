/**
 *
 * @author Mohit
 */
package notepadeditior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.print.PageFormat;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CodingPart1 implements ActionListener {
    private JFrame frame;
    private JMenuBar note_menu_bar;
    private JMenu file_menu, edit_menu, format_menu, help_menu;
    private JMenuItem new_file_MI, save_file_MI, open_file_MI, saveas_file_MI, exit_file_MI, print_setup_file_MI, print_file_MI;
    private JMenuItem cut_edit_MI, copy_edit_MI, paste_edit_MI, replace_edit_MI, timedate_edit_MI;
    private JMenuItem font_format_MI, font_color_format_MI, textarea_color_formate_MI;
    private JCheckBoxMenuItem word_wrap_MI;
    private static JTextArea textArea;
    private JFileChooser file_chooser;
    private File file_location;
    private String title = "Untitled-Notepad";

    CodingPart1() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame = new JFrame(title);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Mohit\\IdeaProjects\\Core-Java-Projects\\src\\Mohit\\project3\\notepadeditior\\images\\notepadIcon.png");
        frame.setIconImage(icon);
        note_menu_bar = new JMenuBar();

        file_menu = new JMenu("File");
        new_file_MI = new JMenuItem("New");
        new_file_MI.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        file_menu.add(new_file_MI);
        new_file_MI.addActionListener(this);
        open_file_MI = new JMenuItem("Open");
        open_file_MI.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_DOWN_MASK));
        file_menu.add(open_file_MI);
        open_file_MI.addActionListener(this);
        save_file_MI = new JMenuItem("Save");
        save_file_MI.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_DOWN_MASK));
        file_menu.add(save_file_MI);
        save_file_MI.addActionListener(this);
        saveas_file_MI = new JMenuItem("Save as");
        saveas_file_MI.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.SHIFT_DOWN_MASK));
        file_menu.add(saveas_file_MI);
        saveas_file_MI.addActionListener(this);
        file_menu.addSeparator();
        print_file_MI = new JMenuItem("Print");
        print_file_MI.setAccelerator(KeyStroke.getKeyStroke('P', InputEvent.CTRL_DOWN_MASK));
        file_menu.add(print_file_MI);
        print_file_MI.addActionListener(this);
        print_setup_file_MI = new JMenuItem("Print setup");
        file_menu.add(print_setup_file_MI);
        print_setup_file_MI.addActionListener(this);
        file_menu.addSeparator();
        exit_file_MI = new JMenuItem("Exit");
        file_menu.add(exit_file_MI);
        exit_file_MI.addActionListener(this);
        note_menu_bar.add(file_menu);

        edit_menu = new JMenu("Edit");
        cut_edit_MI = new JMenuItem("Cut");
        cut_edit_MI.setAccelerator(KeyStroke.getKeyStroke('X', InputEvent.CTRL_DOWN_MASK));
        edit_menu.add(cut_edit_MI);
        cut_edit_MI.addActionListener(this);
        copy_edit_MI = new JMenuItem("Copy");
        copy_edit_MI.setAccelerator(KeyStroke.getKeyStroke('C', InputEvent.CTRL_DOWN_MASK));
        edit_menu.add(copy_edit_MI);
        copy_edit_MI.addActionListener(this);
        paste_edit_MI = new JMenuItem("Paste");
        paste_edit_MI.setAccelerator(KeyStroke.getKeyStroke('V', InputEvent.CTRL_DOWN_MASK));
        edit_menu.add(paste_edit_MI);
        paste_edit_MI.addActionListener(this);
        edit_menu.addSeparator();
        replace_edit_MI = new JMenuItem("Replace");
        replace_edit_MI.setAccelerator(KeyStroke.getKeyStroke('H', InputEvent.CTRL_DOWN_MASK));
        edit_menu.add(replace_edit_MI);
        replace_edit_MI.addActionListener(this);
        edit_menu.addSeparator();
        timedate_edit_MI = new JMenuItem("Time/Date");
        timedate_edit_MI.setAccelerator(KeyStroke.getKeyStroke('t',InputEvent.CTRL_DOWN_MASK));
        edit_menu.add(timedate_edit_MI);
        timedate_edit_MI.addActionListener(this);
        note_menu_bar.add(edit_menu);

        format_menu = new JMenu("Format");
        word_wrap_MI = new JCheckBoxMenuItem("Word Wrap");
        format_menu.add(word_wrap_MI);
        word_wrap_MI.addActionListener(this);
        format_menu.addSeparator();
        font_format_MI = new JMenuItem("Font");
        format_menu.add(font_format_MI);
        font_format_MI.addActionListener(this);
        format_menu.addSeparator();
        font_color_format_MI = new JMenuItem("Font Color");
        format_menu.add(font_color_format_MI);
        font_color_format_MI.addActionListener(this);
        textarea_color_formate_MI = new JMenuItem("Textarea Color");
        format_menu.add(textarea_color_formate_MI);
        textarea_color_formate_MI.addActionListener(this);
        note_menu_bar.add(format_menu);
        help_menu = new JMenu("Help");
        note_menu_bar.add(help_menu);


        frame.setJMenuBar(note_menu_bar);

        textArea = new JTextArea();
        JScrollPane scrollpane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        frame.add(scrollpane);

        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        file_chooser = new JFileChooser();

        if (e.getSource() == new_file_MI) {condChecker("new_file_MI");}
        if (e.getSource() == open_file_MI) {openFile();}
        if (e.getSource() == save_file_MI) {fileSave();}
        if (e.getSource() == saveas_file_MI) {fileSaver_as("saveas_file_MI");}
        if (e.getSource() == exit_file_MI) {condChecker("exit_file_MI");}
        if (e.getSource() == print_file_MI) {relatePrint(1);}
        if (e.getSource() == print_setup_file_MI) {relatePrint(2);}
        if (e.getSource() == cut_edit_MI) {textArea.cut();}
        if (e.getSource() == copy_edit_MI) {textArea.copy();}
        if (e.getSource() == paste_edit_MI) {textArea.paste();}
        if (e.getSource() == replace_edit_MI) {new EditReplace(textArea.getText());}
        if (e.getSource() == timedate_edit_MI) {setDateTime();}
        if (e.getSource() == font_color_format_MI) {setFontColor();}
        if (e.getSource() == textarea_color_formate_MI) {setTextAreaColor();}
        if (e.getSource() == font_format_MI) {new FontFrame();}
        if (e.getSource() == word_wrap_MI)
        {
            boolean b = word_wrap_MI.getState();
            textArea.setLineWrap(b);
        }
    }

    public static void setTextArea(String str) {
        textArea.setText(str);
    }

    private void condChecker(String str) {
        if (!textArea.getText().equals(""))
        {
            int i = JOptionPane.showConfirmDialog(frame, "Do you want to save?", "Notepad", JOptionPane.YES_NO_OPTION);
            if (i == 0) {fileSaver_as(str);}
            else if (i == 1)
            {
                if (str.equalsIgnoreCase("exit_file_MI")) {System.exit(0);}
                else if (str.equalsIgnoreCase("new_file_MI"))
                {
                    frame.setVisible(false);
                    new CodingPart1();
                }
            }
        }
        else if (textArea.getText().equals("")) {
            if (str.equalsIgnoreCase("exit_file_MI")) {System.exit(0);}
            if (str.equalsIgnoreCase("new_file_MI")) {
                frame.setVisible(false);
                new CodingPart1();
            }
        }
    }

    private void openFile()
    {
        int i = file_chooser.showOpenDialog(frame);
        reseter();
        if (i == 0) {
            textArea.setText(null);
            try (FileInputStream fis = new FileInputStream(file_chooser.getSelectedFile());)
            {
                int n;
                while ((n = fis.read()) != -1) {textArea.append(String.valueOf((char) n));}
                frame.setTitle(file_chooser.getSelectedFile().getName());
                title = file_chooser.getSelectedFile().getName();
            }
            catch (Exception exp2) {System.err.println(exp2.getMessage());}
        }
    }

    private void reseter()
    {
        textArea.setForeground(Color.BLACK);
        textArea.setBackground(Color.white);
        textArea.setFont(new Font("Arial",4,15));
    }

    private void fileSave() {
        if (frame.getTitle().equalsIgnoreCase(title)) {
            fileSaver_as("save_file_MI");
        } else {
            String get_textarea = textArea.getText();
            byte[] b = get_textarea.getBytes();
            try (FileOutputStream fos = new FileOutputStream(file_location);) {
                fos.write(b);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void fileSaver_as(String str) {
        int n = file_chooser.showSaveDialog(frame);
        if (n == 0) {
            file_location = file_chooser.getSelectedFile();
            String get_textarea = textArea.getText();
            byte[] b = get_textarea.getBytes();
            try (FileOutputStream fos = new FileOutputStream(file_location);) {
                fos.write(b);
                if (str.equalsIgnoreCase("new_file_MI")) {
                    frame.setVisible(false);
                    new CodingPart1();
                }
                if (str.equalsIgnoreCase("save_file_MI") || str.equalsIgnoreCase("saveas_file_MI")) {
                    frame.setTitle(file_location.getName());
                }
                if (str.equalsIgnoreCase("exit_file_MI")) {
                    System.exit(0);
                }
            } catch (Exception exp) {
                System.err.println(exp.getMessage());
            }
        }
    }

    private void relatePrint(int i) {
        PrinterJob pj = PrinterJob.getPrinterJob();
        if (i == 1) {
            if (pj.printDialog()) {
                try {
                    pj.print();
                } catch (Exception exp3) {
                    System.err.println(exp3.getMessage());
                }
            }
        }
        if (i == 2) {
            PageFormat pf = pj.pageDialog(pj.defaultPage());
        }
    }

    private void setDateTime() {
        LocalDateTime ldt = LocalDateTime.now();
        String date_time = ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        textArea.append(date_time);
    }

    private void setFontColor()
    {
        Color clr = JColorChooser.showDialog(frame,"Select Font Color", Color.BLACK);
        textArea.setForeground(clr);
    }

    private void setTextAreaColor()
    {
        Color clr = JColorChooser.showDialog(frame,"Select TextArea Color", Color.WHITE);
        textArea.setBackground(clr);
    }
    static void openFontFrame(String fname, int fstyle, int fsize) {textArea.setFont(new Font(fname,fstyle,fsize));}
}
