import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame implements ActionListener
{

    static CreditCardGeneratorDriver c1 =  new CreditCardGeneratorDriver();
    static CreditCardGeneratorDriver c2 =  new CreditCardGeneratorDriver();
    static CreditCardGeneratorDriver c3=  new CreditCardGeneratorDriver();


    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });

    }

    static JLabel redLabel, label1, blueScore, label2;
    static JPanel buttonPanel, titlePanel, scorePanel;
    static JButton visa,amex,master, EX, goruntule;
    static JLabel l1;
    static TextField tf1, tf2;
    JRadioButton r1=new JRadioButton("Visa");
    JRadioButton r2=new JRadioButton("MasterCard");
    JRadioButton r3=new JRadioButton("American Express");




    public JPanel createContentPane()

    {


        JPanel totalGUI = new JPanel();
        totalGUI.setLayout(null);
        label1 = new JLabel("Ad/Soyad: ");
        label1.setLocation(100, 95);
        label1.setSize(70, 30);
        label1.setHorizontalAlignment(0);
        totalGUI.add(label1);
        label2 = new JLabel("Kart Limiti: ");
        label2.setLocation(87, 145);
        label2.setSize(95, 30);
        label2.setHorizontalAlignment(0);
        totalGUI.add(label2);
        tf1 = new TextField();
        tf1.setBounds(220, 100, 150, 20);
        tf2 = new TextField();
        tf2.setBounds(220, 150, 150, 20);
        totalGUI.add(tf1);
        totalGUI.add(tf2);
        l1=new JLabel();
        EX = new JButton("EXIT");
        EX.setBackground(Color.RED);
        EX.setBounds(225,350,100,30);
        EX.addActionListener(this);
        totalGUI.add(EX);
        totalGUI.add(l1);
        l1.setBounds(175,475,200,30);




        titlePanel = new JPanel();
        titlePanel.setLayout(null);
        titlePanel.setLocation(70, 20);
        titlePanel.setSize(400, 120);
        totalGUI.add(titlePanel);

        redLabel = new JLabel("KREDİ KARTI OLUŞTURMA PROGRAMINA HOŞGELDİNİZ");
        redLabel.setLocation(-85, 0);
        redLabel.setSize(600, 30);
        redLabel.setHorizontalAlignment(0);
        titlePanel.add(redLabel);



        scorePanel = new JPanel();
        scorePanel.setLayout(null);
        scorePanel.setLocation(250, 20);
        scorePanel.setSize(250, 50);
        totalGUI.add(scorePanel);


        blueScore = new JLabel("");
        blueScore.setLocation(0, 30);
        blueScore.setSize(100, 30);
        blueScore.setHorizontalAlignment(0);
        scorePanel.add(blueScore);

        buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setLocation(10, 170);
        buttonPanel.setSize(5200, 250);
        totalGUI.add(buttonPanel);

        goruntule = new JButton("Kart Görüntüle");
        goruntule.setLocation(200, 100);
        goruntule.setBackground(Color.YELLOW);
        goruntule.setSize(140, 30);
        goruntule.addActionListener(this);
        buttonPanel.add(goruntule);

        r1.setBounds(50,50,100,30);
        r2.setBounds(170,50,150,30);
        r3.setBounds(300,50,250,30);
        ButtonGroup bg=new ButtonGroup();
        bg.add(r1);bg.add(r2);bg.add(r3);
        buttonPanel.add(r1);
        buttonPanel.add(r2);
        buttonPanel.add(r3);
        buttonPanel.setLayout(null);
        buttonPanel.setVisible(true);


        totalGUI.setOpaque(true);
        return totalGUI;
    }
    public void actionPerformed(ActionEvent e)
    {

        String s1 = tf1.getText();
        String s2 = tf2.getText();

        if (r1.isSelected()){
                CardType.VISA.setNameSurname(s1);
                CardType.VISA.setLimit(s2);
                String mes= "VISA CARD: " +c1.generateByCardType(CardType.VISA);
                JOptionPane.showMessageDialog(null, mes,
                        "Status", JOptionPane.PLAIN_MESSAGE);
        }
        else if (r2.isSelected()){
                CardType.MASTERCARD.setNameSurname(s1);
                CardType.MASTERCARD.setLimit(s2);
                String mes= "MASTER CARD: " +c2.generateByCardType(CardType.MASTERCARD);
                JOptionPane.showMessageDialog(null, mes,
                        "Status", JOptionPane.PLAIN_MESSAGE);

        }
        else if (r3.isSelected()){
                CardType.AMERICAN_EXPRESS.setNameSurname(s1);
                CardType.AMERICAN_EXPRESS.setLimit(s2);
                String mes= "AMEX CARD: " +c3.generateByCardType(CardType.AMERICAN_EXPRESS);
                JOptionPane.showMessageDialog(null, mes,
                        "Status", JOptionPane.PLAIN_MESSAGE);

        }

        else if (e.getSource() == EX)
        {
            System.exit(0);
        }

    }

    public static void createAndShowGUI()
    {

        // JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Credit Card Generator");

        // Create and set up the content pane.
        GUI demo = new GUI();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 600, 500);

        frame.setVisible(true);

    }



}


