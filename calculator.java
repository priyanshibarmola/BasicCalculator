import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class calculator implements ActionListener
{
    JFrame frame;
    JTextField textfield;
    JButton[] numberButton=new JButton[10];
    JButton[] functionButton=new JButton[8];
    JButton add,sub,mul,div,decimal,equals,del,clr;
    JPanel panel;
    
    //Font ft=new Font("");
    
    double n1=0,n2=0,res=0;
    char op;
    
    calculator()
    {
        frame=new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,600);
        frame.setLayout(null);
        
        textfield=new JTextField();
        textfield.setBounds(50,50,400,50);
        frame.add(textfield);
        
        add=new JButton("+");
        sub=new JButton("-");
        mul=new JButton("*");
        div=new JButton("/");
        decimal=new JButton(".");
        equals=new JButton("=");
        del=new JButton("DELETE");
        clr=new JButton("CLEAR");
        
        functionButton[0]=add;
        functionButton[1]=sub;
        functionButton[2]=mul;
        functionButton[3]=div;
        functionButton[4]=decimal;
        functionButton[5]=equals;
        functionButton[6]=del;
        functionButton[7]=clr;
        
        for(int i=0;i<8;i++)
        {
            functionButton[i].addActionListener(this);
            functionButton[i].setFocusable(false);
        }
        
        for(int i=0;i<10;i++)
        {
            numberButton[i]=new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
        }
        
        del.setBounds(50,150,200,50);
        clr.setBounds(300,150,150,50);
        
        panel=new JPanel();
        panel.setBounds(50,250,400,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(add);
        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(sub);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mul);
        panel.add(decimal);
        panel.add(numberButton[0]);
        panel.add(equals);
        panel.add(div);
        
        frame.add(panel);
        frame.add(del);
        frame.add(clr);
        
        frame.setVisible(true);
    }
    public static void main(String args[])
    {
        calculator cal=new calculator();
    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()== numberButton[i])
            {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decimal)
        {
            textfield.setText(textfield.getText().concat("."));
        }
        
        if(e.getSource()==add)
        {
            n1=Double.parseDouble(textfield.getText());
            op='+';
            textfield.setText("");
        }
        
        if(e.getSource()==sub)
        {
            n1=Double.parseDouble(textfield.getText());
            op='-';
            textfield.setText("");
        }
        
        if(e.getSource()==mul)
        {
            n1=Double.parseDouble(textfield.getText());
            op='*';
            textfield.setText("");
        }
        
        if(e.getSource()==div)
        {
            n1=Double.parseDouble(textfield.getText());
            op='/';
            textfield.setText("");
        }
        
        if(e.getSource()==equals)
        {
            n2=Double.parseDouble(textfield.getText());
            
            switch(op)
            {
                case '+':
                    res=n1+n2;
                    break;
                case '-':
                    res=n1-n2;
                    break;
                case '*':
                    res=n1*n2;
                    break;
                case '/':
                    res=n1/n2;
                    break;
            }
            textfield.setText(String.valueOf(res));
            n1=res;
        }
        
        if(e.getSource()==clr)
        {
            textfield.setText("");
        }
        
        if(e.getSource()==del)
        {
            String s=textfield.getText();
            textfield.setText("");
            for(int i=0;i<s.length()-1;i++)
            {
                textfield.setText(textfield.getText()+s.charAt(i));
            }
        }
    }
}