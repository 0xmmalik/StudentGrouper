package runners;

import java.awt.EventQueue;

import components.GUI;

public class Runner
{
	/**
	 * Launches the StudentGrouper interface.
	 */
	public static void main(String...strings) {
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
