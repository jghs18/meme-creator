
/**
 * Write a description of class LogoEngine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;

public class LogoEngine
{
    JFrame frame;
    public LogoEngine()
    {
        frame = new JFrame("Logo Creator");
        frame.setSize(600,600);
    }

    public void createUI()
    {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2,2));
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel topLeft = new JPanel();
        topLeft.setBorder(BorderFactory.createLineBorder(Color.black));

        JPanel topRight = new JPanel();
        topRight.setBorder(BorderFactory.createLineBorder(Color.black));               
        JLabel vW = new JLabel("Viewer Window");
        topRight.add(vW);

        JPanel bottomLeft = new JPanel();
        bottomLeft.setLayout(new GridLayout(4,1));
        bottomLeft.setBorder(BorderFactory.createLineBorder(Color.black));
        
        JPanel styleTXT = new JPanel();
        JLabel style = new JLabel("Style");
        styleTXT.add(style, BorderLayout.CENTER);
        style.setFont(new Font("Serif", Font.BOLD, 21));
        bottomLeft.add(styleTXT);

        JPanel bottomRight = new JPanel();
        bottomRight.setBorder(BorderFactory.createLineBorder(Color.black));

        JTextField txtBox = new JTextField("Add your text here.", 20);
        topLeft.add(txtBox);

        JButton cap = new JButton("Add Text");
        topLeft.add(cap);

        JPanel fonts = new JPanel();
        JLabel fontType = new JLabel("Font:");
        fonts.setLayout(new BoxLayout(fonts, BoxLayout.X_AXIS));
        JRadioButton serif = new JRadioButton("Serif");
        JRadioButton times = new JRadioButton("Times");
        JRadioButton impact = new JRadioButton("Impact");
        ButtonGroup fontGroup = new ButtonGroup();
        fontGroup.add(serif);
        fontGroup.add(times);        
        fontGroup.add(impact);
        fonts.add(fontType);
        fonts.add(serif);
        fonts.add(times);        
        fonts.add(impact);
        bottomLeft.add(fonts);

        JPanel checks = new JPanel();
        JLabel fontStyle = new JLabel("Font Style:");
        JCheckBox bold = new JCheckBox("Bold");
        JCheckBox italic = new JCheckBox("Italicize");
        JCheckBox underline = new JCheckBox("Underline");        
        checks.setLayout(new BoxLayout(checks, BoxLayout.X_AXIS));
        checks.add(fontStyle);
        checks.add(bold);
        checks.add(italic);
        checks.add(underline);
        bottomLeft.add(checks);

        JPanel radios = new JPanel();
        JLabel fontSize = new JLabel("Font Size:");
        radios.setLayout(new BoxLayout(radios, BoxLayout.X_AXIS));
        ButtonGroup radioGroup = new ButtonGroup();
        JRadioButton jR1 = new JRadioButton("Small");
        JRadioButton jR2 = new JRadioButton("Medium");
        JRadioButton jR3 = new JRadioButton("Large");
        radioGroup.add(jR1);
        radioGroup.add(jR2);
        radioGroup.add(jR3);
        radios.add(fontSize);
        radios.add(jR1);
        radios.add(jR2);
        radios.add(jR3);        
        bottomLeft.add(radios);

        mainPanel.add(topLeft);
        mainPanel.add(topRight);
        mainPanel.add(bottomLeft);
        mainPanel.add(bottomRight);
        frame.add(mainPanel);
        frame.setVisible(true);        
    }
}
