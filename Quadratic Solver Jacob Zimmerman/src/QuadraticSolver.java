//Quadratic Solver by Jacob Zimmerman

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import java.awt.Color;

public class QuadraticSolver {

	private JFrame frmQuadraticSolverBy;
	JTextField cTxtBox;
	JTextField aTxtBox;
	JTextField bTxtBox;
	JTextField rootsTxtBox;
	JLabel lblA;
	JLabel lblB;
	JLabel lblC;
	JLabel lblXSqr;
	JLabel lblX;
	JLabel frstPlus;
	JLabel scndPlus;
	JButton btnCompute;
	JLabel lblIntstruction;
	public JFrame frmQuadraticSolverGraph;
	JInternalFrame internalFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuadraticSolver window = new QuadraticSolver();
					window.frmQuadraticSolverBy.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public QuadraticSolver() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmQuadraticSolverBy = new JFrame();
		frmQuadraticSolverBy.getContentPane().setBackground(new Color(192, 192, 192));
		frmQuadraticSolverBy.setTitle("Quadratic Solver by Jacob Zimmerman");
		frmQuadraticSolverBy.setBounds(100, 100, 647, 400);
		frmQuadraticSolverBy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuadraticSolverBy.getContentPane().setLayout(null);
		
		cTxtBox = new JTextField();
		cTxtBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cTxtBox.setBounds(462, 85, 119, 42);
		frmQuadraticSolverBy.getContentPane().add(cTxtBox);
		cTxtBox.setColumns(10);
		
		aTxtBox = new JTextField();
		aTxtBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aTxtBox.setBounds(27, 85, 119, 42);
		frmQuadraticSolverBy.getContentPane().add(aTxtBox);
		aTxtBox.setColumns(10);
		
		bTxtBox = new JTextField();
		bTxtBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bTxtBox.setBounds(239, 85, 119, 42);
		frmQuadraticSolverBy.getContentPane().add(bTxtBox);
		bTxtBox.setColumns(10);
		
		rootsTxtBox = new JTextField();
		rootsTxtBox.setEditable(false);
		rootsTxtBox.setFont(new Font("Tahoma", Font.BOLD, 14));
		rootsTxtBox.setHorizontalAlignment(SwingConstants.CENTER);
		rootsTxtBox.setBounds(76, 208, 475, 42);
		frmQuadraticSolverBy.getContentPane().add(rootsTxtBox);
		rootsTxtBox.setColumns(10);
		
		lblA = new JLabel("A");
		lblA.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblA.setBounds(76, 47, 38, 27);
		frmQuadraticSolverBy.getContentPane().add(lblA);
		
		lblB = new JLabel("B");
		lblB.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblB.setBounds(290, 47, 38, 27);
		frmQuadraticSolverBy.getContentPane().add(lblB);
		
		lblC = new JLabel("C");
		lblC.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblC.setBounds(513, 47, 38, 27);
		frmQuadraticSolverBy.getContentPane().add(lblC);
		
		lblXSqr = new JLabel("X²");
		lblXSqr.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblXSqr.setBounds(158, 88, 38, 27);
		frmQuadraticSolverBy.getContentPane().add(lblXSqr);
		
		lblX = new JLabel("X");
		lblX.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblX.setBounds(368, 88, 38, 27);
		frmQuadraticSolverBy.getContentPane().add(lblX);
		
		frstPlus = new JLabel("+");
		frstPlus.setFont(new Font("Tahoma", Font.BOLD, 22));
		frstPlus.setBounds(206, 88, 38, 27);
		frmQuadraticSolverBy.getContentPane().add(frstPlus);
		
		scndPlus = new JLabel("+");
		scndPlus.setFont(new Font("Tahoma", Font.BOLD, 22));
		scndPlus.setBounds(426, 88, 38, 27);
		frmQuadraticSolverBy.getContentPane().add(scndPlus);
		
		btnCompute = new JButton("Compute!");
		btnCompute.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCompute.addMouseListener(new BtnComputeMouseListener());
		btnCompute.setBounds(239, 155, 119, 42);
		frmQuadraticSolverBy.getContentPane().add(btnCompute);
		
		lblIntstruction = new JLabel("Enter the coefficients of the quadratic you would like to find the roots of");
		lblIntstruction.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntstruction.setBounds(20, 11, 611, 34);
		frmQuadraticSolverBy.getContentPane().add(lblIntstruction);
		
	}
	private class BtnComputeMouseListener extends MouseAdapter {
		public void mouseClicked(MouseEvent arg0) {
			//try {
				double a = Double.parseDouble(aTxtBox.getText());
				double b = Double.parseDouble(bTxtBox.getText());
				double c = Double.parseDouble(cTxtBox.getText());
				if ((b*b) < (4*a*c)) {
					double rootPartial = Math.round(((Math.sqrt(Math.abs(((b*b)-((4)*(a)*(c))))))) * 100.0) / 100.0;
					String firstRoot = Double.toString(Math.round(((-b)/(2*a))*100.0)/100.0) + " - " 
					+ Double.toString(rootPartial) + "i" + "/" + Double.toString(Math.round((2*a)*100.0)/100.0);
					String secondRoot = Double.toString(Math.round(((-b)/(2*a))*100.0)/100.0) + " + " 
					+ Double.toString(rootPartial) + "i" + "/" + Double.toString(Math.round((2*a)*100.0)/100.0);
					rootsTxtBox.setText(" X = " + firstRoot + ", " + secondRoot);
				} else {
					double firstRoot = Math.round((((-b) - (Math.sqrt(((b*b)-((4)*(a)*(c))))))/(2*a)) * 100.0) / 100.0;
					double secondRoot = Math.round((((-b) + (Math.sqrt(((b*b)-((4)*(a)*(c))))))/(2*a)) * 100.0) / 100.0;
					if (firstRoot == secondRoot) {
						rootsTxtBox.setText(" X = " + firstRoot);
					} else {
						rootsTxtBox.setText(" X = " + firstRoot + ", " + secondRoot);
					}
				}
			} //catch (Exception e) { 
				//JOptionPane.showMessageDialog(btnCompute, "Uh Oh! Please change " + e.toString().substring(51)
			//	+ " to a single real number.");
			//}
		//}
	}
}
