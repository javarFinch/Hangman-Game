/**
 * 
 */
package hangManGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import test.Test;

/**
 * @author Javar Finch
 * @version 1.0 July 25, 2017
 */
public class HangMan implements ActionListener {

	private JFrame frame;
	private JFrame canvas;
	private JLabel label;
	private JLabel hiddenAnswer;
	private JButton button;
	private JButton a;
	private JButton b;
	private JButton c;
	private JButton d;
	private JButton ee;
	private JButton f;
	private JButton g;
	private JButton h;
	private JButton i;
	private JButton j;
	private JButton k;
	private JButton l;
	private JButton m;
	private JButton n;
	private JButton o;
	private JButton p;
	private JButton q;
	private JButton r;
	private JButton s;
	private JButton t;
	private JButton u;
	private JButton v;
	private JButton w;
	private JButton x;
	private JButton y;
	private JButton z;
	private  String finalAnswer = JOptionPane.showInputDialog(null, "What is the Final Answer to the Game?",
			"Final Answer Goes Here");
	private String answer = printSpacesToString();
	private int numberOfWrongGuesses = 0;
	private String category;
	private JLabel categoryLabel;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HangMan test = new HangMan();
		System.out.println(test.printSpacesToString());
		test.setCategory();
		test.hiddenAnswer = new JLabel("Guess this: " + test.printSpacesToString(), SwingConstants.LEFT);
		test.hiddenAnswer.setVerticalAlignment(SwingConstants.BOTTOM);
		test.hiddenAnswer.setFont(new Font("Ariel", Font.BOLD, 20));
		test.playGame();
	}

	public void playGame() {
		canvas = new JFrame("HangMan");
		frame = new JFrame("Hangman");
		label = new JLabel("Play:");
		button = new JButton("Guess final answer");
		a = new JButton("a");
		b = new JButton("b");
		c = new JButton("c");
		d = new JButton("d");
		ee = new JButton("e");
		f = new JButton("f");
		g = new JButton("g");
		h = new JButton("h");
		i = new JButton("i");
		j = new JButton("j");
		k = new JButton("k");
		l = new JButton("l");
		m = new JButton("m");
		n = new JButton("n");
		o = new JButton("o");
		p = new JButton("p");
		q = new JButton("q");
		r = new JButton("r");
		s = new JButton("s");
		t = new JButton("t");
		u = new JButton("u");
		v = new JButton("v");
		w = new JButton("w");
		x = new JButton("x");
		y = new JButton("y");
		z = new JButton("z");
		new JLabel("Guess a Letter:");
		categoryLabel = new JLabel("Category: " + category, SwingConstants.LEFT);
		categoryLabel.setVerticalAlignment(SwingConstants.TOP);
		categoryLabel.setFont(new Font("Ariel", Font.BOLD, 16));
		frame.setLayout(new FlowLayout());
		frame.add(label);
		frame.add(button);
		frame.add(a);
		frame.add(b);
		frame.add(c);
		frame.add(d);
		frame.add(ee);
		frame.add(f);
		frame.add(g);
		frame.add(h);
		frame.add(i);
		frame.add(j);
		frame.add(k);
		frame.add(l);
		frame.add(m);
		frame.add(n);
		frame.add(o);
		frame.add(p);
		frame.add(q);
		frame.add(r);
		frame.add(s);
		frame.add(t);
		frame.add(u);
		frame.add(v);
		frame.add(w);
		frame.add(x);
		frame.add(y);
		frame.add(z);
		button.addActionListener(this);
		a.addActionListener(this);
		b.addActionListener(this);
		c.addActionListener(this);
		d.addActionListener(this);
		ee.addActionListener(this);
		f.addActionListener(this);
		g.addActionListener(this);
		h.addActionListener(this);
		i.addActionListener(this);
		j.addActionListener(this);
		k.addActionListener(this);
		l.addActionListener(this);
		m.addActionListener(this);
		n.addActionListener(this);
		o.addActionListener(this);
		p.addActionListener(this);
		q.addActionListener(this);
		r.addActionListener(this);
		s.addActionListener(this);
		t.addActionListener(this);
		u.addActionListener(this);
		v.addActionListener(this);
		w.addActionListener(this);
		x.addActionListener(this);
		y.addActionListener(this);
		z.addActionListener(this);
		canvas.setResizable(false);
		categoryLabel.setLocation(0, 0);
		canvas.add(categoryLabel);
		canvas.pack();
		canvas.add(hiddenAnswer);
		canvas.pack();
		canvas.setSize(480, 700);
		canvas.setVisible(true);
		canvas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setSize(550, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocation(850, 500);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == button) {
			String answer = JOptionPane.showInputDialog(frame, "What is your final answer?", "Your final guess here");
			DrawRightArm drawRighhtArm = new DrawRightArm();
			int compareFinalAnswerToAnswer = finalAnswer.compareToIgnoreCase(answer);
			int compareAnswerToFinalAnswer = answer.compareToIgnoreCase(finalAnswer);
			if (compareAnswerToFinalAnswer == compareFinalAnswerToAnswer)
				youWin();
			else {
				JOptionPane.showMessageDialog(frame, "Sorry the correct  answer was " + finalAnswer, "You Lose",
						JOptionPane.ERROR_MESSAGE);
			}

		} else if (source == a) {
			if (countHowMany('a') >= 1 || countHowMany('A') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'a' || t[i] == 'A') {
						if (t[i] == 'a') {
							answer = fillSpaces('a');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('A');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					a.setVisible(false);
				}
			} else {
				youLoseMaybe();
				a.setVisible(false);
			}
		} else if (source == b) {
			if (countHowMany('b') >= 1 || countHowMany('B') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'b' || t[i] == 'B') {
						if (t[i] == 'b') {
							answer = fillSpaces('b');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('B');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
						b.setVisible(false);
					}
				}
			} else {
				youLoseMaybe();
				b.setVisible(false);
			}
		} else if (source == c) {
			if (countHowMany('c') >= 1 || countHowMany('C') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'c' || t[i] == 'C') {
						if (t[i] == 'c') {
							answer = fillSpaces('c');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						}
					} else {
						answer = fillSpaces('C');
						youWin();
						hiddenAnswer.setText("Guess this " + answer);
					}
					c.setVisible(false);
				}
			} else {
				youLoseMaybe();
				c.setVisible(false);
			}

		} else if (source == d) {
			if (countHowMany('d') >= 1 || countHowMany('D') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'd' || t[i] == 'D') {
						if (t[i] == 'd') {
							answer = fillSpaces('d');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('D');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					d.setVisible(false);
				}
			} else {
				youLoseMaybe();
				d.setVisible(false);
			}

		} else if (e.getSource() == ee) {
			System.out.println();
			if (countHowMany('e') >= 1 || countHowMany('E') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'e' || t[i] == 'E') {
						if (t[i] == 'e') {
							answer = fillSpaces('e');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('E');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
				}
				ee.setVisible(false);
			} else {
				youLoseMaybe();
				ee.setVisible(false);
			}

		} else if (source == f) {
			if (countHowMany('f') >= 1 || countHowMany('F') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'f' || t[i] == 'F') {
						if (t[i] == 'f') {
							answer = fillSpaces('f');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('F');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					f.setVisible(false);
				}
			} else {
				youLoseMaybe();
				f.setVisible(false);
			}

		} else if (source == g) {
			if (countHowMany('g') >= 1 || countHowMany('G') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'g' || t[i] == 'G') {
						if (t[i] == 'g') {
							answer = fillSpaces('g');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('G');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					g.setVisible(false);
				}
			} else {
				youLoseMaybe();
				g.setVisible(false);
			}

		} else if (source == h) {
			if (countHowMany('h') >= 1 || countHowMany('H') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'h' || t[i] == 'H') {
						if (t[i] == 'h') {
							answer = fillSpaces('h');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('H');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					h.setVisible(false);
				}
			} else {
				youLoseMaybe();
				h.setVisible(false);
			}

		} else if (source == i) {
			if (countHowMany('i') >= 1 || countHowMany('I') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int j;
				for (j = 0; j < t.length; j++) {
					if (t[j] == 'i' || t[j] == 'I') {
						if (t[j] == 'i') {
							answer = fillSpaces('i');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('I');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					i.setVisible(false);
				}
			} else {
				youLoseMaybe();
				i.setVisible(false);
			}

		} else if (source == j) {
			if (countHowMany('j') >= 1 || countHowMany('J') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'j' || t[i] == 'J') {
						if (t[i] == 'j') {
							answer = fillSpaces('j');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('J');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					j.setVisible(false);
				}
			} else {
				youLoseMaybe();
				j.setVisible(false);
			}

		} else if (source == k) {
			if (countHowMany('k') >= 1 || countHowMany('K') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'k' || t[i] == 'K') {
						if (t[i] == 'k') {
							answer = fillSpaces('k');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('K');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					k.setVisible(false);
				}
			} else {
				youLoseMaybe();
				k.setVisible(false);
			}

		} else if (source == l) {
			if (countHowMany('l') >= 1 || countHowMany('L') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'l' || t[i] == 'L') {
						if (t[i] == 'l') {
							answer = fillSpaces('l');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('L');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					l.setVisible(false);
				}
			} else {
				youLoseMaybe();
				l.setVisible(false);
			}

		} else if (source == m) {
			if (countHowMany('m') >= 1 || countHowMany('M') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'm' || t[i] == 'M') {
						if (t[i] == 'm') {
							answer = fillSpaces('m');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('M');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					m.setVisible(false);
				}
			} else {
				youLoseMaybe();
				m.setVisible(false);
			}

		} else if (source == n) {
			if (countHowMany('n') >= 1 || countHowMany('N') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'n' || t[i] == 'N') {
						if (t[i] == 'n') {
							answer = fillSpaces('n');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('N');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					n.setVisible(false);
				}
			} else {
				youLoseMaybe();
				n.setVisible(false);
			}

		} else if (source == o) {
			if (countHowMany('o') >= 1 || countHowMany('O') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'o' || t[i] == 'O') {
						if (t[i] == 'o') {
							answer = fillSpaces('o');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('O');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					o.setVisible(false);
				}
			} else {
				youLoseMaybe();
				o.setVisible(false);
			}

		} else if (source == p) {
			if (countHowMany('p') >= 1 || countHowMany('P') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'p' || t[i] == 'P') {
						if (t[i] == 'p') {
							answer = fillSpaces('p');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('P');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					p.setVisible(false);
				}
			} else {
				youLoseMaybe();
				p.setVisible(false);
			}

		} else if (source == q) {
			if (countHowMany('q') >= 1 || countHowMany('Q') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'q' || t[i] == 'Q') {
						if (t[i] == 'q') {
							answer = fillSpaces('q');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('Q');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					q.setVisible(false);
				}
			} else {
				youLoseMaybe();
				q.setVisible(false);
			}

		} else if (source == r) {
			if (countHowMany('r') >= 1 || countHowMany('R') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'r' || t[i] == 'R') {
						if (t[i] == 'r') {
							answer = fillSpaces('r');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('R');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					r.setVisible(false);
				}
			} else {
				youLoseMaybe();
				r.setVisible(false);
			}

		} else if (source == s) {
			if (countHowMany('s') >= 1 || countHowMany('S') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 's' || t[i] == 'S') {
						if (t[i] == 's') {
							answer = fillSpaces('s');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('S');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					s.setVisible(false);
				}
			} else {
				youLoseMaybe();
				s.setVisible(false);
			}

		} else if (source == t) {
			if (countHowMany('t') >= 1 || countHowMany('T') >= 1) {
				char[] ti = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < ti.length; i++) {
					if (ti[i] == 't' || ti[i] == 'T') {
						if (ti[i] == 't') {
							answer = fillSpaces('t');
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('T');
							youWin();
						}
					}
					t.setVisible(false);
				}
			} else {
				youLoseMaybe();
				t.setVisible(false);
			}

		} else if (source == u) {
			if (countHowMany('u') >= 1 || countHowMany('U') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'u' || t[i] == 'U') {
						if (t[i] == 'u') {
							answer = fillSpaces('u');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('U');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					u.setVisible(false);
				}
			} else {
				youLoseMaybe();
				u.setVisible(false);
			}

		} else if (source == v) {
			if (countHowMany('v') >= 1 || countHowMany('V') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'v' || t[i] == 'V') {
						if (t[i] == 'v') {
							answer = fillSpaces('v');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('V');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					v.setVisible(false);
				}
			} else {
				youLoseMaybe();
				v.setVisible(false);
			}

		} else if (source == w) {
			if (countHowMany('w') >= 1 || countHowMany('W') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'w' || t[i] == 'W') {
						if (t[i] == 'w') {
							answer = fillSpaces('w');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('W');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					w.setVisible(false);
				}
			} else {
				youLoseMaybe();
				w.setVisible(false);
			}

		} else if (source == x) {
			if (countHowMany('x') >= 1 || countHowMany('X') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'x' || t[i] == 'X') {
						if (t[i] == 'x') {
							answer = fillSpaces('x');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('X');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					x.setVisible(false);
				}
			} else {
				youLoseMaybe();
				x.setVisible(false);
			}

		} else if (source == y) {
			if (countHowMany('y') >= 1 || countHowMany('Y') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'y' || t[i] == 'Y') {
						if (t[i] == 'y') {
							answer = fillSpaces('y');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('Y');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					y.setVisible(false);
				}
			} else {
				youLoseMaybe();
				y.setVisible(false);
			}

		} else if (source == z) {
			if (countHowMany('z') >= 1 || countHowMany('Z') >= 1) {
				char[] t = finalAnswer.toCharArray();
				int i;
				for (i = 0; i < t.length; i++) {
					if (t[i] == 'z' || t[i] == 'Z') {
						if (t[i] == 'z') {
							answer = fillSpaces('z');
							youWin();
							hiddenAnswer.setText("Guess this: " + answer);
						} else {
							answer = fillSpaces('Z');
							youWin();
							hiddenAnswer.setText("Guess this " + answer);
						}
					}
					z.setVisible(false);
				}
			} else {
				youLoseMaybe();
				z.setVisible(false);
			}
		}

	}

	private int countHowMany(char letter) {
		int count = 0;
		char[] a = finalAnswer.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == letter)
				count++;
		}
		return count;
	}

	public String fillSpaces(char letter) {
		return changeToLetter(letter);
	}

	public String changeToLetter(char letter) {
		// try creating a new printSpacesToString() that does not use spaces
		// after the '_' so it should look like "_____"
		String temp = answer;
		char[] t = temp.toCharArray();
		char[] a = getFinalAnswerSpaced().toCharArray();
		for (int i = 0; i < t.length; i++) {
			if (temp.charAt(i) == '_' && a[i] == letter)
				t[i] = letter;
		}
		String answer = new String(t);
		return answer;
	}

	public String getFinalAnswer() {
		return finalAnswer;
	}

	public String getCategory() {

		return category;
	}

	public void setCategory() {
		this.category = JOptionPane.showInputDialog(null, "What is the category of the final answe to the game?",
				"Category of the final answer goes here");
	}

	public String printSpacesToString() {
		// create variable that is initialized to the first instance of the
		// character " " then skip over it. in the loop
		String temp = "";
		char[] answer = finalAnswer.toCharArray();
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == ' ') {
				temp += " ";
			} else {
				temp += "_ ";
			}
		}
		return temp;
	}

	public String printSpaces() {
		String temp = "";
		char[] answer = finalAnswer.toCharArray();
		for (int i = 0; i < answer.length; i++) {
			if (answer[i] == ' ') {
				temp += " ";
			} else {
				temp += "_";
			}
		}
		return temp;
	}

	public int findLetterInFinalAnswer(char letterToFind) {
		String answer1 = finalAnswer;
		char[] answer = answer1.toCharArray();
		int i;
		for (i = 0; i < answer.length; i++) {
			if (answer[i] == letterToFind) {

			}
		}
		return i;
	}

	public String getFinalAnswerSpaced() {
		String temp = "";
		char[] a = finalAnswer.toCharArray();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == ' ') {
				temp += " ";
			} else {
				temp += a[i] + " ";
			}
		}
		return temp;
	}

	public void youWin() {
		if (answer.equalsIgnoreCase(getFinalAnswerSpaced())) {
			JOptionPane.showMessageDialog(frame, "The answer was " + finalAnswer + ".", "CONGRATULATIONS YOU WON",
					JOptionPane.PLAIN_MESSAGE);
			int decision = JOptionPane.showOptionDialog(null, "Do you want to play again?", "Play again?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (decision == JOptionPane.YES_OPTION) {
				canvas.dispose();
				frame.dispose();
				HangMan newGame = new HangMan();
				newGame.setCategory();
				newGame.hiddenAnswer = new JLabel("Guess this: " + newGame.printSpacesToString(), SwingConstants.LEFT);
				newGame.hiddenAnswer.setVerticalAlignment(SwingConstants.BOTTOM);
				newGame.hiddenAnswer.setFont(new Font("Ariel", Font.BOLD, 20));
				newGame.playGame();
			} else {
				frame.dispose();
				canvas.dispose();
			}
		}

	}

	public void setFinalAnswer() {
		finalAnswer = JOptionPane.showInputDialog(null, "What is the Final Answer to the Game?",
				"Final Answer Goes Here");
	}

	public void youLoseMaybe() {
		if (numberOfWrongGuesses == 0) {
			Draw draw = new Draw();
			canvas.add(draw);
			canvas.pack();
			canvas.setSize(480, 700);
			numberOfWrongGuesses++;
		} else if (numberOfWrongGuesses == 1) {
			DrawBody drawBody = new DrawBody();
			canvas.add(drawBody);
			canvas.pack();
			canvas.setSize(480, 700);
			numberOfWrongGuesses++;
		} else if (numberOfWrongGuesses == 2) {
			DrawLeftLeg drawLeftLeg = new DrawLeftLeg();
			canvas.add(drawLeftLeg);
			canvas.pack();
			canvas.setSize(480, 700);
			numberOfWrongGuesses++;
		} else if (numberOfWrongGuesses == 3) {
			DrawRightLeg drawRightLeg = new DrawRightLeg();
			canvas.add(drawRightLeg);
			canvas.pack();
			canvas.setSize(480, 700);
			numberOfWrongGuesses++;
		} else if (numberOfWrongGuesses == 4) {
			DrawLeftArm drawLeftArm = new DrawLeftArm();
			canvas.add(drawLeftArm);
			canvas.pack();
			canvas.setSize(480, 700);
			numberOfWrongGuesses++;
		} else if (numberOfWrongGuesses == 5) {
			DrawRightArm dra = new DrawRightArm();
			canvas.add(dra);
			canvas.pack();
			canvas.setSize(480, 700);
			JOptionPane.showMessageDialog(frame, "Sorry the correct  answer was " + finalAnswer, "You Lose",
					JOptionPane.ERROR_MESSAGE);
		}

	}
}
