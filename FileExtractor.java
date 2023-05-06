import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.net.*; 
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.EventListener;
public class FileExtractor implements ActionListener
{
    private static JLabel title, url;
    private static JFrame frame;
    private static JTextField urlTextField;
    private static JTextArea contentsTextArea;
    private static JPanel panel;
    private static JScrollPane scroll;
    private static JButton loadButton, exitButton;
    private static String wholeContent = "";
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
        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                try{
                    String urlPath = urlTextField.getText();
                    if(urlPath.isEmpty()){
                    JOptionPane.showMessageDialog(null,"URL IS EMPTY","Error",JOptionPane.WARNING_MESSAGE);
                    return;
                    }
                    URL url = new URL(urlPath);
                    URLConnection connection = url.openConnection();

                    // Read the contents of the URL
                    BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        wholeContent += line + "\n";
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"URL IS INVALID","Error",JOptionPane.WARNING_MESSAGE);
                    ex.printStackTrace();
                }   
                
                contentsTextArea.setText(wholeContent);
            }
        });
        panel.add(loadButton);
        
        contentsTextArea = new JTextArea();
        contentsTextArea.setBounds(200, 100, 600, 500);
        contentsTextArea.setEditable(false);
        //panel.add(contentsTextArea);
        
        scroll = new JScrollPane(contentsTextArea);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setBounds(200, 100, 600, 500);
        panel.add(scroll);
        
        exitButton = new JButton("Exit");
        exitButton.setBounds(450, 630, 100, 20);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel.add(exitButton);
        
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
    }   
}
