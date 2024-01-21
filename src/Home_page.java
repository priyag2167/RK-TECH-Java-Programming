
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Home_page extends JFrame  {
    private generate passwordGenerate;
    JButton generate ,copy;
    JCheckBox upper, lower, number, special;
    JTextArea tframe, passwordoutput;


    Home_page() {
        // change the panel color....
        getContentPane().setBackground(new Color(0, 0, 0));
        setLayout(null);

        // Image section....
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("image/Passwordimage.png"));
        JLabel ima = new JLabel(image);
        ima.setBounds(50, 15, 210, 400);
        add(ima);

        // heading section....
        JLabel heading = new JLabel("Password  Generator");
        heading.setBounds(300, 30, 500, 50);
        heading.setFont(new Font("Comic Sans MS", Font.BOLD, 32));
        heading.setForeground(new Color(0, 153, 0));
        add(heading);
        // Password Length section....
        JLabel length = new JLabel("Password Length  :");
        length.setBounds(330, 120, 300, 40);
        length.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
        length.setForeground(new Color(204, 204, 204));
        add(length);

        // Input length of the password...
        tframe = new JTextArea();
        tframe.setBounds(530, 124, 300, 30);
        tframe.setBorder(BorderFactory.createLineBorder(Color.black));
        tframe.setBackground(new Color(255, 255, 204));
        tframe.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tframe);

        passwordGenerate = new generate();

        // generate button of the password...
        generate = new JButton("Generate");
        generate.setBounds(530, 180, 150, 25);
        generate.setBackground(new Color(0, 102, 0));
        generate.setForeground(new Color(255, 255, 255));
        generate.setBorder(BorderFactory.createLineBorder(Color.black));
        generate.addActionListener(a -> {
                    if (tframe.getText().length() <= 0) return;
                    boolean anyselected = upper.isSelected() ||
                            lower.isSelected() ||
                            number.isSelected() ||
                            special.isSelected();
                    //convert the password string into the integer
                    int passwordlenght = Integer.parseInt(tframe.getText());
                    if (anyselected) {
                        String generatePassword = passwordGenerate.generatepassword(passwordlenght, upper.isSelected(),
                                lower.isSelected(), number.isSelected(), special.isSelected());
                        passwordoutput.setText(generatePassword);

                    }
                }
        );
        add(generate);
        // Choose uppercase,lowercase, number and special chacter use to generate password...
        upper = new JCheckBox("Upper Case");
        upper.setBounds(530, 250, 120, 30);
        upper.setForeground(new Color(0, 0, 0));
        upper.setBackground(new Color(255, 255, 204));
        add(upper);

        lower = new JCheckBox("Lower Case");
        lower.setBounds(710, 250, 120, 30);
        lower.setForeground(new Color(0, 0, 0));
        lower.setBackground(new Color(255, 255, 204));
        add(lower);

        number = new JCheckBox("Number");
        number.setBounds(530, 300, 120, 30);
        number.setForeground(new Color(0, 0, 0));
        number.setBackground(new Color(255, 255, 204));
        add(number);

        special = new JCheckBox("Special character ");
        special.setBounds(710, 300, 120, 30);
        special.setForeground(new Color(0, 0, 0));
        special.setBackground(new Color(255, 255, 204));
        add(special);


        // password Output....

        JLabel password = new JLabel("Password  :");
        password.setBounds(360, 353, 300, 40);
        password.setFont(new Font("Palatino Linotype", Font.BOLD, 18));
        password.setForeground(new Color(204, 204, 204));
        add(password);

        passwordoutput = new JTextArea();
        passwordoutput.setEditable(false);
        passwordoutput.setBackground(new Color(255, 255, 204));
        passwordoutput.setFont(new Font("Dialog", Font.BOLD, 25));

        JScrollPane passwordoutputpanel = new JScrollPane(passwordoutput);
        passwordoutputpanel.setBounds(490, 350, 350, 45);
        passwordoutputpanel.setBorder(BorderFactory.createLineBorder(Color.black));
        add(passwordoutputpanel);

        // Copy the password to paste anywhere...
        copy=new JButton("Copy");
        copy.setBounds(610,400,100,25);
        copy.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        copy.setBorder(BorderFactory.createLineBorder(Color.black));
        copy.setForeground(new Color(255,255,255));
        copy.setBackground(new Color(0,102,0));
        copy.addActionListener(a -> {
                    String str = passwordoutput.getText();
                    Clipboard clip = Toolkit.getDefaultToolkit().getSystemClipboard();
                    StringSelection strsel = new StringSelection(str);
                    clip.setContents(strsel, strsel);
                    JOptionPane.showMessageDialog(null, "Password Copy");
                });
        add(copy);


        // set the size and location of the JFrame....
        setSize(900, 520);
        setLocation(230, 110);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new Home_page();
    }

}
