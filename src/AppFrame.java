import comp_decomp.compressor;
import comp_decomp.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null); // freely place the control wherever you like // components will only take space that you gave

        compressButton = new JButton("Select File to Compress");
        compressButton.setBounds(250,50,200,30);
        compressButton.addActionListener(this);
//        compressButton.setHorizontalAlignment(JButton.CENTER);
//        compressButton.setVerticalAlignment(JButton.CENTER);
        decompressButton = new JButton("Select File to decompress");
        decompressButton.setBounds(250,200,200,30);
        decompressButton.addActionListener(this);
//        decompressButton.setHorizontalAlignment(JButton.CENTER);
//        decompressButton.setVerticalAlignment(JButton.CENTER);


        this.add(compressButton);
        this.add(decompressButton);
        this.setTitle("Compressor - Decompressor");
        this.setBounds(750,200,700,420);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(120,25,240));
//        this.pack();

    }
    @Override
    public void actionPerformed(ActionEvent e){ // Implementing the action performed method of Action listener interface
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file =new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    compressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try{
                    decompressor.method(file);
                }
                catch(Exception ee){
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }

}
