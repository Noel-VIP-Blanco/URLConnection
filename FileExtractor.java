import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.EventListener;
public class FileExtractor
{
    private static JLabel title, url;
    private static JFrame frame;
    private static JTextField urlTextField;
    private static JTextArea contentsTextArea;
    private static JPanel panel;
    private static JScrollPane scroll;
    private static JButton loadButton;
    public static void main(String[] args){
        frame=new JFrame();
        frame.setSize(1000, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        
        JPanel panel=new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        title=new JLabel("File Extractor");
        title.setFont(new Font("ARIAL",Font.BOLD,16));
        title.setBounds(450, 10, 300, 20);
        panel.add(title);
        
        url =new JLabel("URL");
        url.setFont(new Font("ARIAL",Font.BOLD,16));
        url.setBounds(200, 50, 50, 20);
        panel.add(url);
        
        urlTextField = new JTextField();
        urlTextField.setBounds(250, 50, 300, 20);
        panel.add(urlTextField);
        
        loadButton = new JButton("Load");
        loadButton.setBounds(600, 50, 100, 20);
        panel.add(loadButton);
        
        
        
        contentsTextArea = new JTextArea();
        contentsTextArea.setBounds(200, 100, 600, 800);
        contentsTextArea.setEditable(false);
        panel.add(contentsTextArea);
        
        //scroll = new JScrollPane(contentsTextArea);
        //scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //panel.add(scroll);
        
        frame.setVisible(true);
    }
}
