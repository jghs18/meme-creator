
/**
 * Write a description of class LogoEngine here.
 *Handles all the logic and 'brain' of the memeCreator
 */
//importing classes for use
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;
import java.applet.Applet;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//add listeners to buttons
public class LogoEngine implements ActionListener
{
    JFrame frame;
    Font font;;
    JButton save;
    JButton updateAll;
    JColorChooser colorPicker;
    boolean boldF = false;
    boolean underlineF = false;
    boolean italicF = false;
    JLabel topLabel;
    JLabel bottomLabel;
    int size;
    int photoNum = 0;
    int photoNum2 = 0;
    JRadioButton underline;
    JRadioButton bold;
    JRadioButton italic;
    Font fontB;
    String nameFont;
    JComboBox<Integer> sizeBoxes;
    JButton choose;
    JRadioButton top;
    JButton cap;
    JButton cap2;
    JRadioButton bottom;
    JTextField txtBox;
    JButton upFont;
    JFileChooser fC;
    JComboBox fontBoxes;
    JPanel topRight;
    ImageComponent iC;
    JPanel mainPanel;
    JPanel bottomLeft;
    JPanel bottomRight;
    JPanel topLeft;
    JTextField txtBox2;
    String path;
    boolean jpg;
    int length;
    boolean labelChecker;
    public LogoEngine()//constructor method LogoEngine
    {
        frame = new JFrame("Logo Creator");//initializing object reference frame to the newly constructed JFrame Object with explicit parameter
        //of tyoe string
        frame.setSize(1000,1000);//invoking mutator mehtod setSize with explicit parameters of type int on the object referenced by frame
        fC = new JFileChooser();//initialzing object reference fC to the newly constructed JFileChooserObject
    }

    public void createUI()//method signature for mutator method createUI
    {
        String response = JOptionPane.showInputDialog(null, "WAIT! Make sure you read the ReadME file for instructions.\nType the format of the image you want to save. Either 'png' or 'jpeg'.");/*assigning the value of the String referenced by object
        reference word to whatever is returned by static method showInputDialog with explicit parameters(null, Stringx)*/
        if (response==null)
        {
            System.exit(0);/*invoking static mutator method exit with explicit paramter (0) on System class*/
            //error handles the cancel button on the JOptionPane
        }
        if(response.equalsIgnoreCase("jpeg"))
        {    
            jpg = true;
        }
        else
        {
            jpg = false;
        }

        mainPanel = new JPanel();//initializing object reference mainPanel to a newly constructed JPanel object
        mainPanel.setLayout(new GridLayout(2,2));//invoking mutator method setLayout on the object referenced by mainPanel with an explicit parameter
        //of a newly constructed GridLayout object
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));//invoking mutator method setBorder on the object referenced by mainPanel with
        //explicit parameter of static method createLineBorder invoked on class BorderFactory with explicit parameter of type Color on the obect referenced by topRight

        topLeft = new JPanel();//initializing topLeft to the newly constructed JPanel object
        topLeft.setBorder(BorderFactory.createLineBorder(Color.black));//invoking mutator method setBorder on the object referenced by mainPanel with
        //explicit parameter of static method createLineBorder invoked on class BorderFactory with explicit parameter of type Color on the object referenced by topLeft
        topLeft.setLayout(new BorderLayout());//invoking the mutator method setLayout on the object referenced by topLeft with explicit paramerter of a newly constructed BorderLayout

        topRight = new JPanel();//initializing topRight to the newly constructed JPanel object
        topRight.setBorder(BorderFactory.createLineBorder(Color.black));//invoking mutator method setBorder on the object referenced by mainPanel with
        //explicit parameter of static method createLineBorder invoked on class BorderFactory with explicit parameter of type Color on the object referenced by topLeft
        topRight.setLayout(new BorderLayout());//invoking the mutator method setLayout on the object referenced by topRight with explicit paramerter of a newly constructed BorderLayout
        JPanel view = new JPanel();//constructing new JPanel object referenced by view
        JLabel vW = new JLabel("Viewer Window");//constructing a new JLabel object with explicit parameter of type String and assigning it to the object reference vW
        vW.setFont(new Font("Zapfino", Font.BOLD, 10));//invoking mutator method setFont on the object reference vW with explicit paramter to type Font
        vW.setOpaque(false);//invoking mutator method setOpaque with explicit parameter of type boolean on the object referenced by vW
        view.add(vW, BorderLayout.CENTER);//invoking mutator add method on view with explicit parameters of type JLabel and a layout

        bottomLeft = new JPanel();//initializing bottomLeft to the newly constructed JPanel object
        bottomLeft.setLayout(new GridLayout(5,0));//invoking mutator method setLayout on the object reference bottomLeft with explicit parameter of a type GridLayout
        bottomLeft.setBorder(BorderFactory.createLineBorder(Color.black));//invoking mutator add method on view with explicit parameters of type JLabel and a layout

        JPanel styleTXT = new JPanel();//constructing new JPanel object referenced by styleTXT
        JLabel style = new JLabel("Style");//constructing new JLabel object referenced by style with explicit parameter of type String
        styleTXT.add(style, BorderLayout.CENTER);//invoking mutator add method on view with explicit parameters of type JLabel and a layout
        style.setFont(new Font("Impact", Font.BOLD, 40));//invoking mutator method setFont on the object reference vW with explicit paramter to type Font
        bottomLeft.add(styleTXT);//invoking mutator method add on the object reference bottomLeft with explicit parameter styleTXT which is a JPanel type

        bottomRight = new JPanel();//initializing bottomRight to the newly constructed JPanel object
        bottomRight.setBorder(BorderFactory.createLineBorder(Color.black));//invoking mutator add method on view with explicit parameters of type JLabel and a layout
        bottomRight.setLayout(new BorderLayout());//invoking the mutator method setLayout on the object referenced by topRight with explicit paramerter of a newly constructed BorderLayout

        //ColorPicker
        //-----------------------------------------------------------------------------------------
        JLabel color = new JLabel("Color");//constructing new JLabel object referenced by color with explicit parameter of type string
        JPanel c = new JPanel();//constructing new JPanel object referenced by c
        color.setFont(new Font("Serif", Font.BOLD, 40));//invoking mutator method setFont on the object referenced by color with explicit parameter of type font
        c.add(color, BorderLayout.CENTER);//invoking mutator add method on the object referenced by c with explicit parameters of type color and a layout
        bottomRight.add(c, BorderLayout.NORTH);//invoking the mutator add metho on the object reference bottomRight with explicit parameter of type Label and borderLayout
        colorPicker = new JColorChooser(Color.black);//initializing object reference colorPicker to a newly constructed JColorChooser Object
        colorPicker.getSelectionModel().addChangeListener(new ChangeListener()
            {
                public void stateChanged(ChangeEvent e)
                {
                    Color newColor = colorPicker.getColor();//declaring and initializing a new Color opject to whatver is returned by accessor method getColor invoked on object reference
                    //colorPicker
                    topLabel.setForeground(newColor);//invoking mutator method setForeground on object reference topLabel with explicit parameter newColor
                    bottomLabel.setForeground(newColor);//invoking mutator method setForeground on object reference bottomLabel with explicit parameter newColor
                }
            });
        bottomRight.add(colorPicker, BorderLayout.CENTER);//invoking the mutator add metho on the object reference bottomRight with explicit parameter of type Label and borderLayout

        //-----------------------------------------------------------------------------------------

        JPanel textBoxes = new JPanel();//constructing new JPanel object referenced by textBoxes
        textBoxes.setLayout(new BoxLayout(textBoxes, BoxLayout.Y_AXIS));//invoking mutator method setLayout on the object reference bottomLeft with explicit parameter of a type boxLayout

        txtBox = new JTextField("Add your first line of text here.", 24);//initializing the value of txtBox to a newly constructed JTextField object
        textBoxes.add(txtBox);//invoking mutator method on the object reference textBoxes with explicit parameters txtbox

        txtBox2 = new JTextField("Add your second line of text here.",24);
        textBoxes.add(txtBox2);//invoking mutator method on the object reference textBoxes with explicit parameters txtbox2

        JPanel cpC = new JPanel();//constructing new JPanel object referenced by cpC
        cpC.setLayout(new BorderLayout());//invoking mutator method setLayout on the object reference bottomLeft with explicit parameter of a type borderlayout   
        cap = new JButton("Add Text");//assigning object reference cap to the newly constructed JButton object
        cpC.add(cap, BorderLayout.CENTER);//invoking mutator method add on the object reference cpC with explicit parameters cap, and a borderlayout static instance field variable
        textBoxes.add(cpC);//invoking mutator method on the object reference textBoxes with explicit parameters cpC
        cap.addActionListener(this);//invoking mutator method addActionListener on the object reference cap with explicit parameter the instance of this class

        topLeft.add(textBoxes, BorderLayout.NORTH);//invoking mutator method on the object reference topLeft with explicit parameters textBoxes and a borderlayout instance field
        //----------------------------------------------------------------------------------------
        //FileChooser
        //----------------------------------------------------------------------------------------
        JPanel bottomHalf = new JPanel();//constructing a new JPanel object referenced by bottomHalf
        bottomHalf.setBorder(BorderFactory.createLineBorder(Color.black));//invoking mutator add method on view with explicit parameters of type JLabel and a layout

        JPanel fLC = new JPanel();//constructing a new JPanel object referenced by flC
        JLabel fL = new JLabel("File Manager", JLabel.CENTER);//constructing a new JLabel object referenced by fL and explicit parameter of type String and static variable belonging to class JLabel
        fL.setFont(new Font("Times", Font.BOLD, 20));//invoking mutator method setFont on the object referenced by fL with explicit pararmters of type String, static final variable of class font, an int value
        fLC.add(fL, BorderLayout.CENTER);//invoking mutator method on the object reference flC with explicit parameters fL and final static variable belonging to borderLayout class
        bottomHalf.add(fLC, BorderLayout.NORTH);//invoking mutator method on the object reference bottomHald with explicit parameters fLC and final static variable belonging to borderLayout class

        JPanel sPP = new JPanel();//constructing a new JPanel object referenced by sPP
        sPP.setLayout(new BorderLayout());//invoking mutator method setLayout on the object reference bottomLeft with explicit parameter of a new borderlayout object   
        JPanel subPanelColor = new JPanel();//constructing a new JPanel object referenced by subPanelColor
        subPanelColor.setLayout(new BorderLayout());//invoking mutator method setLayout on the object reference subPabelColor with explicit parameter of a new borderlayout object  

        JComboBox backColor = new JComboBox();//declaring and initializing object reference backColor to the newly constructed JComboBox object
        sPP.add(fC,BorderLayout.NORTH);//invoking mutator method add on the object reference sPP with explicit parameter fC and static final instance field variable NORTH that belongs to BorderLayout class
        topLeft.add(sPP);//invoking the mutator method add on the object reference topLeft wtih explicit parameter of type JPanel
        choose = new JButton("Use the selected image");//initializing the object reference choose to a newly constructed JButton object
        choose.addActionListener(this);//invoking addActionListener with explicit parameter of type actionlistener on the object reference topLeft
        topLeft.add(choose, BorderLayout.SOUTH);//invoking the mutator method add on the object reference topLeft wtih explicit parameter of type JPanel, and and static final instance field variable SOUTH that belongs to BorderLayout class
        //}

        //----------------------------------------------------------------------------------------
        JPanel fonts = new JPanel();//constructing a new JPanel object referenced by fonts
        JLabel fontType = new JLabel("Font:");//declaring fontType as a JLabel object and assigning it to the newly constructed JLabel with explicit parameter of type String

        GraphicsEnvironment gE =  GraphicsEnvironment.getLocalGraphicsEnvironment();//declaring and initializing gE to a newly constructed GraphicsEnvironment object
        String[] fontList;//declaring fontList as a  String array
        fontList = gE.getAvailableFontFamilyNames();//initializing array fontList to the String array returned by invoking accessor method getAvailableFontFamilyNames() on object reference gE
        fontBoxes = new JComboBox(fontList);//constructing a new JComboBox object referenced by fontBoxes
        fontBoxes.addActionListener(this);//invoking addActionListener with explicit parameter of type actionlistener on the object reference fontBoxes
        fonts.add(fontType);//invoking the mutator method add on the object reference topLeft wtih explicit parameter of type JLabel
        fonts.add(fontBoxes);//invoking the mutator method add on the object reference topLeft wtih explicit parameter of type JPanel
        //bottomLeft.add(fonts, BorderLayout.CENTER);

        Integer[] sizeList = new Integer[34];//declaring and initializing a new Integer array to object reference sizeList
        //INTENGER IS USED as a wrapper class because arrays cannot store primitive type variables
        int ii=4;//declaring and initializing the value of int ii to be 7
        for(int i=0; i<34; i++){
            sizeList[i]= ii;//assigning the value at place i of sizeList to be equal to ii
            ii++;
            //this for loop populates the array with integer values in order to have a variety of font sizes available
        }
        sizeBoxes = new JComboBox<>(sizeList);//initailizing the value of object reference sizeBoxes to the newly constructed JComboBox object
        sizeBoxes.addActionListener(this);//invoking the mutator addActionListener method on the object reference sizeBoxes
        JLabel sizeF = new JLabel("Font Size:");//declaring and initializing sizeF to the newly constructed JLabel object
        fonts.add(sizeF);//invoking mutator add method on the object reference fonts with explicit parameter JLabel
        fonts.add(sizeBoxes);//invoking mutator add method on the object reference fonts with explicit parameter JCombobox
        bottomLeft.add(fonts);//invoking mutator add method on the object reference bottomLeft with explicit parameter JPanel

        JPanel radios = new JPanel();//constructing a new JPanel object referenced by radios
        JLabel fontSize = new JLabel("Font Size:");//constructing a new JLabel object referenced by fontSize
        bold = new JRadioButton("Bold");//initializing the object reference choose to a newly constructed JRadioButton object
        underline = new JRadioButton("Underline");//initializing the object reference choose to a newly constructed JRadioButton object
        italic = new JRadioButton("Italicize");//initializing the object reference choose to a newly constructed JRadioButton object
        bold.addActionListener(this);//invoking the mutator addActionListener method on the object reference bold
        italic.addActionListener(this);//invoking the mutator addActionListener method on the object reference italic
        underline.addActionListener(this);//invoking the mutator addActionListener method on the object reference underline
        radios.add(fontSize, BorderLayout.CENTER);//invoking mutator add method on the object reference radios with explicit parameter JRadioButton, and static Final variable that belongs to class BorderLayout
        radios.add(bold, BorderLayout.CENTER);//invoking mutator add method on the object reference radios with explicit parameter JRadioButton, and static Final variable that belongs to class BorderLayout
        radios.add(underline, BorderLayout.CENTER);//invoking mutator add method on the object reference radios with explicit parameter JRadioButton, and static Final variable that belongs to class BorderLayout
        radios.add(italic, BorderLayout.CENTER);//invoking mutator add method on the object reference radios with explicit parameter JRadioButton, and static Final variable that belongs to class BorderLayout
        bottomLeft.add(radios, BorderLayout.CENTER);//invoking mutator add method on the object reference bottomLeft with explicit parameter JPanel, and static Final variable that belongs to class BorderLayout

        upFont = new JButton("Update Fonts");//initializing the object reference choose to a newly constructed JButton object
        upFont.addActionListener(this);//invoking mutator addActionListener method on the object reference upFont with explicit parameter of an ActionListener
        bottomLeft.add(upFont);//invoking mutator add method on the object reference bottomLeft with explicit parameter JPanel

        JPanel updateA = new JPanel();//constructing a new JPanel object referenced by updateA
        updateA.setLayout(new GridLayout(1,2));//invoking mutator method setLayout on the object reference bottomLeft with explicit parameter of a new GridLayout object  
        updateA.setBorder(BorderFactory.createLineBorder(Color.black));//invoking mutator add method on view with explicit parameters of type JLabel and a layout
        updateAll = new JButton("Update Everything");//initializing the value of object reference updateAll to the newly constructed JButton
        updateAll.setFont(new Font("Marker Felt", Font.BOLD, 20));//invoking mutator method setFont on object reference updateAll with explicit parameter of type font
        updateAll.addActionListener(this);//invoking the mutator addActionListener method with explicit parameter of type actionListener on the object reference updatAll
        updateA.add(updateAll);//invoking mutator add method on the object reference bottomLeft with explicit parameter JPanel
        save = new JButton("Save your masterpiece");//initializing the value of object reference updateAll to the newly constructed JButton
        save.addActionListener(this);//invoking the mutator addActionListener method with explicit parameter of type actionListener on the object reference save
        save.setFont(new Font("Impact", Font.BOLD, 22));//invoking mutator method setFont on object reference save with explicit parameter of type font
        updateA.add(save);//invoking mutator add method on the object reference updateA with explicit parameter JPanel

        bottomLeft.add(updateA);//invoking mutator add method on the object reference bottomLeft with explicit parameter JPanel

        topLabel = new JLabel(txtBox.getText(), JLabel.CENTER);//initializing the object reference topLabel to the newly constructed JLabel object with explicit parameter of type string returned by accessor method
        //and a static final variable that belongs to class JLabel

        bottomLabel = new JLabel(txtBox2.getText(), JLabel.CENTER);//initializing the object reference bottomLabel to the newly constructed JLabel object with explicit parameter of type string returned by accessor method
        //and a static final variable that belongs to class JLabel

        this.drawAgain();//invoking mutator method drawAgain on this instance of the class
    }

    public void actionPerformed(ActionEvent e)
    {
        //all the if statements handle the different buttons that share the same actionListener
        //invoking the accessor method getSource (which returns an EventSource) and comparing that value to the object reference
        if(e.getSource()==save)
        {           
            if(jpg)
            {
                this.tP(topRight);//invoking mutator method tP on this object with explicit paramter topRight
            }
            else
            {
                this.takePicture(topRight);//invoking mutator method takePicture on this object with explicit paramter topRight
            }
        }
        if(e.getSource()==choose)
        {
            if(iC==null);
            else topRight.remove(iC);//invoking mutator method remove with instance field iC on object reference topRight
            File file = fC.getSelectedFile();//declaring and initializng the object reference file to the newly constructed file object returned by accessor method getSelected file invoked on fC
            iC = new ImageComponent(file);//initializing the object reference iC to the newly constructed ImageComponent object
            topRight.add(iC, BorderLayout.CENTER);//invoking mutator add method on the object reference topRight with explicit parameter ImageComponent, and static Final variable that belongs to class BorderLayout

            this.drawAgain();//invoking mutator method drawAgain on this instance of the class
        }
        if(e.getSource()==fontBoxes)
        {
            nameFont = (String) fontBoxes.getSelectedItem();//initializing instance field variable nameFont to the casted as String object returned by accessor method getSelectedItem invoked on object reference fontBoxes
            this.drawAgain();
        }
        if(e.getSource()==sizeBoxes)
        {
            size = (int) sizeBoxes.getSelectedItem();//initializing instance field variable size to the casted as int value returned by getSlectedItem invoked on object reference sizeBoxes
            this.drawAgain();
        }
        if(e.getSource()==upFont)
        {
            this.setFont();//invoking mutator method setFont on this instance of this class
            this.drawAgain();//invoking mutator method drawAgain on this instance of the class
        }
        if(e.getSource()==cap)
        {
            this.setFont();//invoking mutator method setFont on this instance of this class
            topRight.add(topLabel, BorderLayout.NORTH);//invoking mutator add method on the object reference topRight with explicit parameter JLabel, and static Final variable that belongs to class BorderLayout
            topRight.add(bottomLabel, BorderLayout.SOUTH);//invoking mutator add method on the object reference topRight with explicit parameter JLabel, and static Final variable that belongs to class BorderLayout
            this.drawAgain();//invoking mutator method drawAgain on this instance of the class
        }
        if(e.getSource()==underline)
        {
            underlineF = true;//mutating value of instance field variable underLineF
            this.drawAgain();
        }
        if(e.getSource()==bold)
        {
            boldF = true;//mutating value of instance field variable boldF
            this.drawAgain();
        }
        if(e.getSource()==italic)
        {
            italicF = true;//mutating value of instance field variable italicF
            this.drawAgain();
        }
        if(e.getSource()==updateAll)
        {
            if(iC==null) ;
            else topRight.remove(iC);//invoking mutator method remove with instance field iC on object reference topRight
            topRight.remove(topLabel);//invoking mutator method remove with instance field topLabel on object reference topRight
            topRight.remove(bottomLabel);//invoking mutator method remove with instance field bottomLabel on object reference topRight

            File file = fC.getSelectedFile();//declaring and initializng the object reference file to the newly constructed file object returned by accessor method getSelected file invoked on fC

            if(file==null);
            else 
            {
                iC = new ImageComponent(file);//initializing the object reference iC to the newly constructed ImageComponent object
                topRight.add(iC, BorderLayout.CENTER);//invoking mutator add method on the object reference topRight with explicit parameter ImageComponent, and static Final variable that belongs to class BorderLayout
            }

            nameFont = (String) fontBoxes.getSelectedItem();//initializing instance field variable nameFont to the casted as String object returned by accessor method getSelectedItem invoked on object reference fontBoxes
            size = (int) sizeBoxes.getSelectedItem();//initializing instance field variable size to the casted as int value returned by getSlectedItem invoked on object reference sizeBoxes
            this.setFont();//invoking mutator method setFont on this instance of this class
            topRight.add(topLabel, BorderLayout.NORTH);//invoking mutator add method on the object reference topRight with explicit parameter JLabel, and static Final variable that belongs to class BorderLayout
            topRight.add(bottomLabel, BorderLayout.SOUTH);//invoking mutator add method on the object reference topRight with explicit parameter JLabel, and static Final variable that belongs to class BorderLayout

            this.drawAgain();//invoking mutator method drawAgain on this instance of the class

        }
    }

    public void setFont()
    {
        size = (int) sizeBoxes.getSelectedItem();//initializing instance field variable size to the casted as int value returned by getSlectedItem invoked on object reference sizeBoxes
        boolean bF = false;//initializing the value of primitive variable bF to be false
        boolean iF = false;//initializing the value of primitive variable iF to be false
        boolean uF = false;//initializing the value of primitive variable uF to be false
        if(underline.isSelected())
        {
            font = new Font(nameFont, Font.PLAIN, size);//initializing object reference font to newly constructed Font object
            topLabel.setText("<html><u>" + txtBox.getText() + "</u></html>");//invoking mutator setText method on the object referenced by topLabel with explicit parameter html tag in order to underline text
            bottomLabel.setText("<html><u>" + txtBox2.getText() + "</u></html>");//invoking mutator setText method on the object referenced by bottomLabel with explicit parameter html tag in order to underline text
            uF = true;//assigning the value of primitive variable uF to be true
        }
        if(bold.isSelected())
        {         
            font = new Font(nameFont, Font.BOLD, size);//initializing object reference font to newly constructed Font object
            topLabel.setText(txtBox.getText());//invoking mutator method setText on topLabel object with explicit parameters of accessor method getText invoked on txtBox
            //and final static field CENTER
            bottomLabel.setText(txtBox2.getText());//invoking mutator method setText on topLabel object with explicit parameters of accessor method getText invoked on txtBox
            //and final static field CENTER
            bF = true;//assigning the value of primitive variable bF to be true
        }
        if(italic.isSelected())
        {
            font = new Font(nameFont, Font.ITALIC, size);//initializing object reference font to newly constructed Font object
            topLabel.setText(txtBox.getText());//invoking mutator method setText on topLabel object with explicit parameters of accessor method getText invoked on txtBox
            //and final static field CENTER
            bottomLabel.setText(txtBox2.getText());//invoking mutator method setText on topLabel object with explicit parameters of accessor method getText invoked on txtBox
            //and final static field CENTER
            iF = true;//assigning the value of primitive variable iF to be true
        }
        if(bF&&iF)
        {
            font = new Font(nameFont, Font.BOLD + Font.ITALIC, size);//initializing object reference font to newly constructed Font object
        }
        if(uF)
        {
            //font = new Font(nameFont, Font.BOLD + Font.ITALIC, size);
            topLabel.setText("<html><u>" + txtBox.getText() + "</u></html>");//invoking mutator setText method on the object referenced by topLabel with explicit parameter html tag in order to underline text
            bottomLabel.setText("<html><u>" + txtBox2.getText() + "</u></html>");//invoking mutator setText method on the object referenced by bottomLabel with explicit parameter html tag in order to underline text
        }
        if(!uF&&!iF&&!bF)
        {
            font = new Font(nameFont, Font.PLAIN, size);//initializing object reference font to newly constructed Font object
        }
        topLabel.setFont(font);//invoking the mutator method setFont on the object reference by topLabel with explicit parameter font
        bottomLabel.setFont(font);//invoking mutator method setFont on the object referenced by bottomLabel with explict parameter font

    }

    public void takePicture(JPanel panel) {
        BufferedImage bi = new BufferedImage(topRight.getSize().width, topRight.getSize().height, BufferedImage.TYPE_INT_ARGB); //declaring and initializing the object reference img to 
        //the newly constructed BufferedImage
        Graphics g = bi.createGraphics();//constructing a new Graphic object by invoking accessor method createGraphics on the object reference bi and assigning it to object reference g
        topRight.paint(g);//invoking mutator method paint on object reference topRight
        g.dispose();//invoking mutator dispose method on object reference g
        if (photoNum<44)
        {
            try{ImageIO.write(bi,"png",new File("meme" + photoNum+".png"));}catch (Exception e) {}
            photoNum++;
        }
    }

    public void tP(JPanel panel){
        BufferedImage img = new BufferedImage(panel.getWidth(), panel.getHeight(), BufferedImage.TYPE_INT_RGB);//declaring and initializing the object reference img to 
        //the newly constructed BufferedImage
        panel.print(img.getGraphics());//invoking the print mutator method on the panel that was imported as the explicit parameter of this method
        if(photoNum2<44)
        {
            try {
                ImageIO.write(img, "jpg", new File("meme1.jpg"));
            }
            catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            photoNum2++;
        }
    }

    public void drawAgain()
    {
        topLeft.repaint();//invoking mutator method repaint on the following JPanel objects referenced by the implicit parameter
        topRight.repaint();//invoking mutator method repaint on the following JPanel objects referenced by the implicit parameter
        bottomLeft.repaint();//invoking mutator method repaint on the following JPanel objects referenced by the implicit parameter
        bottomRight.repaint();//invoking mutator method repaint on the following JPanel objects referenced by the implicit parameter
        frame.repaint();//invoking mutator method repaint on the following JPanel objects referenced by the implicit parameter
        mainPanel.add(topLeft);//invoking mutator method add with explicit parameter of type JPanel on the object reference listed as the implicit parameter
        mainPanel.add(topRight);//invoking mutator method add with explicit parameter of type JPanel on the object reference listed as the implicit parameter
        mainPanel.add(bottomLeft);//invoking mutator method add with explicit parameter of type JPanel on the object reference listed as the implicit parameter
        mainPanel.add(bottomRight);//invoking mutator method add with explicit parameter of type JPanel on the object reference listed as the implicit parameter
        frame.add(mainPanel);//invoking mutator method add with explicit parameter of type JPanel on the object reference listed as the implicit parameter
        frame.setVisible(true);//invoking mutator method setVisible on the object reference frame with explicit parameter of type boolean
    }
}
