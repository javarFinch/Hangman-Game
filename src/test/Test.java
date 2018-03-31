package test;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Test {
	private String finalAnswer;

	public static void main(String[] args) {
		/*Test t = new Test();
		t.setFinalAnswer();
		JLabel nl = new JLabel("Guess this: " + t.printSpacesToString(), SwingConstants.CENTER);
		nl.setVerticalAlignment(SwingConstants.TOP);
		JFrame canvas = new JFrame("Test");
		canvas.add(nl);
		canvas.setSize(1500, 3000);
		canvas.setResizable(true);
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas.setVisible(true);
		Drawing d = new Drawing();
		canvas.add(d);
		System.out.println(t.printSpacesToString());
		*/
		Test j = new Test();
		System.out.println(j.fillASpace('a', 7));
	}

	public void setFinalAnswer() {
		finalAnswer = JOptionPane.showInputDialog(null, "What is your final Answer?", "Final Answer goes here.");
	}

	public String printSpacesToString() {
		// create variable that is initialized to the first instance of the
		// character " " then skip over it. in the loop
		String temp = "";
		int finalAnswerLength = finalAnswer.length();
		do {
			if (finalAnswerLength <= finalAnswer.length() && finalAnswerLength > 0) {
				if (finalAnswer.contains(" ")) {
					int firstSpace = finalAnswer.indexOf(" ");
					for (int i = 0; i < finalAnswer.length(); i++) {
						if (i == firstSpace) {
							i++;
							temp += " ";
							finalAnswerLength--;
						}
						temp += "_ ";
						finalAnswerLength--;
					}
				} else {
					temp += "_ ";
					finalAnswerLength--;
				}

			}
		} while (finalAnswerLength > 0);
		return temp;

	}

	public String fillASpace(char letter, int position) {
		Test t = new Test();
		return t.changeToLetter(letter, position);

	}

	private String changeToLetter(char letter, int position) {
		Test h = new Test();
		String temp = h.printSpacesToString();
		char[] t = temp.toCharArray();
		for (int i = 0; i < t.length; i++) {
			if (temp.charAt(position) == '_') {
				t[position] = letter;
			}
		}
		return t.toString();
	}

}
