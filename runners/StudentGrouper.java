package runners;

import java.awt.Dimension;
import java.awt.EventQueue;

import components.GUI;

public class StudentGrouper
{
	/**
	 * Launches the StudentGrouper interface.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setSize(new Dimension(650, 350));
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
