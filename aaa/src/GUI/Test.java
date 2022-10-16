package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import KWIC.demo1;
import KWIC2.Alphabetizer;
import KWIC2.Input;
import KWIC2.Output;
import KWIC2.Shift;
import KWIC4.Pipe;

public class Test {
    public static void main(String[] args) {
        Frame frame = new Frame("Flow Layout");
        frame.setLayout(new FlowLayout());

        Button button1 = new Button("主程序-子程序");
        Button button2 = new Button("面向对象");
        Button button3 = new Button("事件系统");
        Button button4 = new Button("管道-过滤器");

        //增加事件处理器
        button1.addActionListener(new ButtonHandler1());
        button2.addActionListener(new ButtonHandler1());
        button3.addActionListener(new ButtonHandler1());
        button4.addActionListener(new ButtonHandler1());


        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.setSize(1000, 1000);
        
        frame.setVisible(true);
    }
}

class ButtonHandler1 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
    	demo1 kwic = new demo1();
        kwic.input("C:\\Users\\sjj\\Desktop\\input.txt");
        kwic.shift();
        kwic.alphabetizer();
        kwic.output("C:\\Users\\sjj\\Desktop\\output.txt");
        FileInputStream fis = null;
        try {
         File file = new File("C:\\Users\\sjj\\Desktop\\output.txt");
         fis = new FileInputStream(file);
         byte[] b = new byte[(int)file.length()];
         while (fis.read(b) != -1) {
         }
         System.out.println(new String(b));
        } catch (Exception e1) {
         e1.printStackTrace();
        }
        
    }
}

class ButtonHandler2 implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
    	Input input = new Input();
        input.input("C:\\Users\\sjj\\Desktop\\input.txt");
        Shift shift = new Shift(input.getLineTxt());
        shift.shift();
        Alphabetizer alphabetizer = new Alphabetizer(shift.getKwicList());
        alphabetizer.sort();
        Output output = new Output(alphabetizer.getKwicList());
        output.output("C:\\Users\\sjj\\Desktop\\output.txt");
        FileInputStream fis = null;
        try {
         File file = new File("C:\\Users\\sjj\\Desktop\\output.txt");
         fis = new FileInputStream(file);
         byte[] b = new byte[(int)file.length()];
         while (fis.read(b) != -1) {
         }
         System.out.println(new String(b));
        } catch (Exception e1) {
         e1.printStackTrace();
        }
        
    }
}


        




