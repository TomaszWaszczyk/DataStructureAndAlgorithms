package com.waszczyk.swingadapter;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TooltipExample extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooltipExample() {

		initUI();
	}

	private void initUI() {

		JPanel pane = (JPanel) getContentPane();
		GroupLayout gl = new GroupLayout(pane);
		pane.setLayout(gl);

		pane.setToolTipText("Content pane");

		JButton btn = new JButton("Button");
		
		
		//// MouseAdapter in Swing, MouseListener implements lots of methods
		btn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
			}
		});
		btn.setToolTipText("A button component");

		gl.setAutoCreateContainerGaps(true);

		gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(btn)
				.addGap(200));

		gl.setVerticalGroup(gl.createSequentialGroup().addComponent(btn)
				.addGap(120));

		pack();

		setTitle("Tooltip");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				TooltipExample ex = new TooltipExample();
				ex.setVisible(true);
			}
		});
	}
}