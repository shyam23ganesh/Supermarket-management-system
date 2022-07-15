package com.company;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.*;

public class Main {

    public static void main(String[] args)
    {
        choice a = new choice();
    }
}
class addemp extends JFrame
{
    JTextField ph,em,pass;
    JButton sub;
    JLabel res1,ent1,ent2,ent3;
    public static HashMap<String,String> empl = new HashMap<String,String>();
    public addemp()
    {
        ent1 = new JLabel("Enter phone number");
        ent2 = new JLabel("Enter email ID");
        ent3 = new JLabel("Enter a suitable password");
        ph = new JTextField(20);
        em = new JTextField(20);
        pass = new JTextField(20);
        sub = new JButton("OK");
        res1 = new JLabel("lets wait and see");
        add(ent1);
        add(ph);
        add(ent2);
        add(em);
        add(ent3);
        add(pass);
        add(sub);
        add(res1);

        ActionListener al = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int cnt=0;
                String phone,email;
                phone = ph.getText();
                email = em.getText();
                Pattern p = Pattern.compile("[6-9][0-9]{9}");
                Matcher m = p.matcher(phone);
                if(m.find() && m.group().equals(phone))
                    cnt+=1;

                Pattern q = Pattern.compile("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
                Matcher n = q.matcher(email);
                if(n.find() && n.group().equals(email))
                    cnt+=1;
                if(cnt==2)
                {
                    res1.setText("Verified");
                    empl.put(phone,pass.getText());
                    for(Map.Entry entry : empl.entrySet())
                    {
                        System.out.println("key "+entry.getKey());
                        System.out.println("value "+entry.getValue());
                    }
                }
                else
                {
                    res1.setText("Invalid email or phone");
                }
            }
        };

        sub.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}
class admin extends JFrame
{
    public admin()
    {

        JButton op1 = new JButton("Add employee");
        add(op1);
        ActionListener al = new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==op1)
                    new addemp();

            }
        };
        op1.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class employee extends JFrame
{
    HashMap<String,String> empo = new HashMap<String,String>();
    JLabel en1,en2,ha;
    JTextField ge1,ge2;
    public employee()
    {
        en1 = new JLabel("Enter phone number");
        en2 = new JLabel("Enter password");
        ge1 = new JTextField(20);
        ge2 = new JTextField(20);
        JButton tr =new JButton("OK");
        ha = new JLabel("Lets see");
        add(en1);
        add(ge1);
        add(en2);
        add(ge2);
        add(tr);
        add(ha);
        ActionListener al = new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                String ph,pa;
                int che = 0;
                ph = ge1.getText();
                pa = ge2.getText();
                empo.putAll(addemp.empl);
                System.out.println(empo);
                for(Map.Entry entr : empo.entrySet())
                {
                    if((ph.equals(entr.getKey()))&&(pa.equals(entr.getValue())))
                    {
                        che = 1;
                        break;
                    }
                }
                if(che==1)
                    ha.setText("Welcome");
            }
        };
        tr.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
class choice extends JFrame
{
    public choice()
    {
        JButton ch1 = new JButton("Admin");
        JButton ch2 = new JButton("Employee");
        JButton ch3 = new JButton("Customer");
        add(ch1);
        add(ch2);
        add(ch3);
        ActionListener al = new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==ch1)
                    new adminlog();
                else if(e.getSource()==ch2)
                    new employee();
                else
                    new customer();
            }
        };
        ch1.addActionListener(al);
        ch2.addActionListener(al);
        ch3.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class customer extends JFrame
{
    public static HashMap<String,String> cust = new HashMap<String,String>();
    public customer()
    {
        JLabel l1 = new JLabel("Are you an member of ABC supermarket");
        JRadioButton r1 = new JRadioButton("yes");
        JRadioButton r2 = new JRadioButton("no");
        JButton b1 = new JButton("continue");
        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        add(l1);
        add(r1);
        add(r2);
        add(b1);
        ActionListener al = new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                JLabel b;
                JRadioButton r3,r4;
                JButton B;
                if(r1.isSelected())
                    new memberlog();
                else
                {
                    b = new JLabel("Do you want to become a member of ABC supermarket");
                    r3 = new JRadioButton("yes");
                    r4 = new JRadioButton("no");
                    B = new JButton("continue");
                    ButtonGroup bg1 = new ButtonGroup();
                    bg1.add(r3);
                    bg1.add(r4);
                    add(b);
                    add(r3);
                    add(r4);
                    add(B);
                    ActionListener al1 = new ActionListener()
                    {

                        public void actionPerformed(ActionEvent e)
                        {
                            JTextField T,T1;
                            JLabel b2,b3;
                            JButton B1;
                            if(r3.isSelected())
                            {
                                b2 = new JLabel("Enter user ID");
                                b3 = new JLabel("Enter password");
                                T = new JTextField(20);
                                T1 = new JTextField(20);
                                B1 = new JButton("ok");
                                add(b2);
                                add(T);
                                add(b3);
                                add(T1);
                                add(B1);
                                ActionListener al2 = new ActionListener()
                                {
                                    public void actionPerformed(ActionEvent e)
                                    {
                                        cust.put(T.getText(), T1.getText());
                                        for(Map.Entry entry : cust.entrySet())
                                        {
                                            System.out.println("key "+entry.getKey());
                                            System.out.println("value "+entry.getValue());
                                        }
                                    }
                                };
                                B1.addActionListener(al2);
                                setVisible(true);
                            }
                            else
                                new shop();
                        }
                    };
                    B.addActionListener(al1);
                    setVisible(true);
                }
            }
        };
        b1.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class adminlog extends JFrame
{
    String username = "shyamrajiv";
    String password = "rajivshyam";
    public adminlog()
    {
        JLabel l1 = new JLabel("Enter user ID");
        JLabel l2 = new JLabel("Enter password");
        JTextField t1 = new JTextField(20);
        JTextField t2 = new JTextField(20);
        JLabel l3 = new JLabel("Lets wait and see");
        JButton b1 = new JButton("ok");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(l3);
        ActionListener al = new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                String s1 = t1.getText();
                String s2 = t2.getText();
                if((s1.equals(username))&&(s2.equals(password)))
                    new admin();
                else
                    l3.setText("Invalid username and password");
            }
        };
        b1.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class memberlog extends JFrame
{
    public static int check=0;
    public memberlog()
    {
        JLabel l1 = new JLabel("Enter username");
        JLabel l2 = new JLabel("Enter password");
        JTextField t1 = new JTextField(20);
        JTextField t2 = new JTextField(20);
        JButton b1 = new JButton("ok");
        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        ActionListener al = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String uid,pas;
                uid = t1.getText();
                pas = t2.getText();
                for(Map.Entry entr : customer.cust.entrySet())
                {
                    if((uid.equals(entr.getKey()))&&(pas.equals(entr.getValue())))
                    {
                        check = 1;
                        new shop();
                    }
                }
            }
        };
        b1.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class shop extends JFrame
{
    double total;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    public shop()
    {
        JCheckBox i1 = new JCheckBox("rice");
        JCheckBox i2 = new JCheckBox("wheat");
        JCheckBox i3 = new JCheckBox("ragi");
        JCheckBox i4 = new JCheckBox("barley");
        JCheckBox i5 = new JCheckBox("badam");
        JCheckBox i6 = new JCheckBox("pistha");
        JCheckBox i7 = new JCheckBox("maggi");
        JCheckBox i8 = new JCheckBox("boost");
        JCheckBox i9 = new JCheckBox("dairy milk");
        JCheckBox i10 = new JCheckBox("good day");
        JCheckBox i11 = new JCheckBox("dark fantasy");
        JCheckBox i12 = new JCheckBox("gold winner");
        JCheckBox i13 = new JCheckBox("dhal");
        JCheckBox i14 = new JCheckBox("lays");
        JCheckBox i15 = new JCheckBox("ice cream");
        t1 = new JTextField(10);
        t2 = new JTextField(10);
        t3 = new JTextField(10);
        t4 = new JTextField(10);
        t5 = new JTextField(10);
        t6 = new JTextField(10);
        t7 = new JTextField(10);
        t8 = new JTextField(10);
        t9 = new JTextField(10);
        t10 = new JTextField(10);
        t11 = new JTextField(10);
        t12 = new JTextField(10);
        t13 = new JTextField(10);
        t14 = new JTextField(10);
        t15 = new JTextField(10);
        JLabel l = new JLabel("Total");
        JButton b = new JButton("ok");
        add(i1);
        add(t1);
        add(i2);
        add(t2);
        add(i3);
        add(t3);
        add(i4);
        add(t4);
        add(i5);
        add(t5);
        add(i6);
        add(t6);
        add(i7);
        add(t7);
        add(i8);
        add(t8);
        add(i9);
        add(t9);
        add(i10);
        add(t10);
        add(i11);
        add(t11);
        add(i12);
        add(t12);
        add(i13);
        add(t13);
        add(i14);
        add(t14);
        add(i15);
        add(t15);
        add(b);
        add(l);
        ActionListener al = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if(i1.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t1.getText());
                    n = n*60;
                    total += n;
                }
                if(i2.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t2.getText());
                    n = n*50;
                    total += n;
                }
                if(i3.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t3.getText());
                    n = n*40;
                    total += n;
                }
                if(i4.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t4.getText());
                    n = n*50;
                    total += n;
                }
                if(i5.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t5.getText());
                    n = n*50;
                    total += n;
                }
                if(i6.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t6.getText());
                    n = n*50;
                    total += n;
                }
                if(i7.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t7.getText());
                    n = n*12;
                    total += n;
                }
                if(i8.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t8.getText());
                    n = n*200;
                    total += n;
                }
                if(i9.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t9.getText());
                    n = n*10;
                    total += n;
                }
                if(i10.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t10.getText());
                    n = n*5;
                    total += n;
                }
                if(i11.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t11.getText());
                    n = n*30;
                    total += n;
                }
                if(i12.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t12.getText());
                    n = n*90;
                    total += n;
                }
                if(i13.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t13.getText());
                    n = n*35;
                    total += n;
                }
                if(i14.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t14.getText());
                    n = n*10;
                    total += n;
                }
                if(i15.isSelected())
                {
                    float n;
                    n = Float.parseFloat(t15.getText());
                    n = n*25;
                    total += n;
                }
                if(memberlog.check == 1 )
                {
                    total = 0.10*total;
                }

                l.setText(total+"");
            }
        };
        b.addActionListener(al);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
