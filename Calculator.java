// Java program to create a simple calculator
// with basic +, -, /, * using java swing elements

import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
class Calculator extends JFrame implements ActionListener
{
	// create a frame
	static JFrame f;

	// create a textfield
	static JTextField l;

	// store operator and operands
	String s0, s1, s2;

	// default constructor
	Calculator()
	{
		s0 = s1 = s2 = "";
	}

	// main function
	public static void main(String args[])
	{
		// create a frame
		f = new JFrame("Calculator");
		f.setLayout(new BorderLayout());

		try {
			// set look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (Exception e) {
			System.err.println(e.getMessage());
		}

		// create a object of class
		Calculator c = new Calculator();

		// create a textfield
		l = new JTextField(40);

		// set the textfield to non editable
		l.setEditable(false);
		f.add(l, BorderLayout.NORTH);
		l.setPreferredSize(new Dimension(200, 50));

		// create number buttons and some operators
		JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, bclear, bequal, bpercent;

		// create number buttons
		b0 = new JButton("0");
		b1 = new JButton("1");
		b2 = new JButton("2");
		b3 = new JButton("3");
		b4 = new JButton("4");
		b5 = new JButton("5");
		b6 = new JButton("6");
		b7 = new JButton("7");
		b8 = new JButton("8");
		b9 = new JButton("9");

		// equals button
		bequal = new JButton("=");

		// create operator buttons
		ba = new JButton("+");
		bs = new JButton("-");
		bd = new JButton("/");
		bm = new JButton("*");
		bpercent = new JButton("%");
		bclear = new JButton("C");

		// create . button
		be = new JButton(".");

		// set font size for buttons
		Font buttonFont = new Font("Arial", Font.PLAIN, 18);  // Adjust the font size as needed
		
		l.setFont(buttonFont);
		bm.setFont(buttonFont);
		bd.setFont(buttonFont);
		bs.setFont(buttonFont);
		ba.setFont(buttonFont);
		b9.setFont(buttonFont);
		b8.setFont(buttonFont);
		b7.setFont(buttonFont);
		b6.setFont(buttonFont);
		b5.setFont(buttonFont);
		b4.setFont(buttonFont);
		b3.setFont(buttonFont);
		b2.setFont(buttonFont);
		b1.setFont(buttonFont);
		b0.setFont(buttonFont);
		be.setFont(buttonFont);
		bclear.setFont(buttonFont);
		bequal.setFont(buttonFont);
		bpercent.setFont(buttonFont);
		
		// create a panel
		JPanel p = new JPanel(new GridLayout(5, 4, 5, 5));

		// add action listeners
		bm.addActionListener(c);
		bd.addActionListener(c);
		bs.addActionListener(c);
		ba.addActionListener(c);
		b9.addActionListener(c);
		b8.addActionListener(c);
		b7.addActionListener(c);
		b6.addActionListener(c);
		b5.addActionListener(c);
		b4.addActionListener(c);
		b3.addActionListener(c);
		b2.addActionListener(c);
		b1.addActionListener(c);
		b0.addActionListener(c);
		be.addActionListener(c);
		bclear.addActionListener(c);
		bequal.addActionListener(c);
		bpercent.addActionListener(c);

		// add elements to panel
		//p.add(l);
		p.add(ba);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		p.add(bs);
		p.add(b4);
		p.add(b5);
		p.add(b6);
		p.add(bm);
		p.add(b7);
		p.add(b8);
		p.add(b9);
		p.add(bd);
		p.add(be);
		p.add(b0);
		p.add(bclear);
		p.add(bequal);
		p.add(bpercent);

		// set Background of panel
		p.setBackground(Color.gray);

		// add panel to frame
		f.add(p,BorderLayout.CENTER);

		f.setSize(400, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		f.show();
	}
	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand();

		// if the value is a number
		if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
			// if operand is present then add to second no
			if (!s1.equals(""))
				s2 = s2 + s;
			else
				s0 = s0 + s;

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == 'C') {
			// clear the one letter
			s0 = s1 = s2 = "";

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
		else if (s.charAt(0) == '=') {

			double te;

			// store the value in 1st
			if (s1.equals("+"))
				te = (Double.parseDouble(s0) + Double.parseDouble(s2));
			else if (s1.equals("-"))
				te = (Double.parseDouble(s0) - Double.parseDouble(s2));
			else if (s1.equals("/"))
				te = (Double.parseDouble(s0) / Double.parseDouble(s2));
			else if (s1.equals("*"))
				te = (Double.parseDouble(s0) * Double.parseDouble(s2));
			else
				te = (Double.parseDouble(s0) / 100);

			// set the value of text
			l.setText(s0 + s1 + s2 + "=" + te);

			// convert it to string
			s0 = Double.toString(te);

			s1 = s2 = "";
		}
		else {
			// if there was no operand
			if (s1.equals("") || s2.equals(""))
				s1 = s;
			// else evaluate
			else {
				double te;

				// store the value in 1st
				if (s1.equals("+"))
					te = (Double.parseDouble(s0) + Double.parseDouble(s2));
				else if (s1.equals("-"))
					te = (Double.parseDouble(s0) - Double.parseDouble(s2));
				else if (s1.equals("/"))
					te = (Double.parseDouble(s0) / Double.parseDouble(s2));
				else if (s1.equals("*"))
					te = (Double.parseDouble(s0) * Double.parseDouble(s2));
				else
					te = (Double.parseDouble(s0) / 100);

				// convert it to string
				s0 = Double.toString(te);

				// place the operator
				s1 = s;

				// make the operand blank
				s2 = "";
			}

			// set the value of text
			l.setText(s0 + s1 + s2);
		}
	}
}
