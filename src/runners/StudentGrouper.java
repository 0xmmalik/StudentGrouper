package runners;

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
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
