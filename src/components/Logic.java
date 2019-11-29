package components;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextPane;

public class Logic
{
	public static List<String> students = new ArrayList<>();
	
	public static List<JCheckBox> ticks = new ArrayList<>();
	
	/**
	 * Sets student list when "Set Student List" button clicked.
	 */
	public static void setStudentList(JButton btnSetStudentList, Box verticalBox, JTextPane txtpnOneStudentPer)
	{
		btnSetStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				students = Arrays.asList(txtpnOneStudentPer.getText().split("\n"));
				ticks.clear();
				verticalBox.removeAll();
				for(String student : students)
				{
					JCheckBox newCheck = new JCheckBox(student); // create a checkbox for each student in the list
					verticalBox.add(newCheck);
					newCheck.setSelected(true);
					ticks.add(newCheck);
				}
			}
		});
	}
	
	public static void deselectAll(JButton desAll)
	{
		desAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(JCheckBox tick : ticks)
				{
					if(tick.isSelected())
						tick.setSelected(false);
				}
			}
		});
	}
	
	public static void selectAll(JButton desAll)
	{
		desAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(JCheckBox tick : ticks)
				{
					if(!tick.isSelected())
						tick.setSelected(true);
				}
			}
		});
	}
	
	public static void saveStudentList(JButton btnSave, JPanel contentPane, JTextPane txtpnOneStudentPer)
	{
		/**
		 * Saves current list of students.
		 */
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser saveDialog = new JFileChooser();
				saveDialog.setCurrentDirectory(new File(System.getProperty("user.dir"))); // set directory to current directory
				int approved = saveDialog.showSaveDialog(contentPane);
				
				if(approved == JFileChooser.APPROVE_OPTION)
				{
					try {
						FileWriter saveFile = new FileWriter(saveDialog.getSelectedFile().getAbsolutePath());
						BufferedWriter saveWriter = new BufferedWriter(saveFile);
						saveWriter.write(txtpnOneStudentPer.getText());
						saveWriter.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	public static void loadStudentList(JButton btnLoad, JPanel contentPane, JTextPane txtpnOneStudentPer)
	{
		/**
		 * Loads list of students from current directory.
		 */
		btnLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser loadDialog = new JFileChooser();
				loadDialog.setCurrentDirectory(new File(System.getProperty("user.dir")));
				int approved = loadDialog.showOpenDialog(contentPane);
				
				if(approved == JFileChooser.APPROVE_OPTION)
				{
					try {
						txtpnOneStudentPer.setText(new String(Files.readAllBytes(loadDialog.getSelectedFile().toPath())));
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
	public static void makeGroups(JButton btnMakeGroupsOf, JSpinner spinner, DefaultListModel<String> groups)
	{
		/**
		 * Makes random groups of students.
		 */
		btnMakeGroupsOf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if((Integer)spinner.getValue() > 1 && (Integer)spinner.getValue() < 10)
				{
					groups.removeAllElements(); // clear all groups
					Logic logic = new Logic();
					List<JCheckBox> tickedTicks = logic.getTicked(ticks);
					int groupCt = tickedTicks.size()/(Integer)spinner.getValue();
					for(int k = 0; k < groupCt; k++)
					{
						String groupStr = "";
						for(int i = 0; i < (Integer)spinner.getValue(); i++)
						{
							JCheckBox studentGroup = tickedTicks.get((int)(Math.random()*tickedTicks.size()));
							groupStr += studentGroup.getText() + " | ";
							tickedTicks.remove(studentGroup);
						}
						groups.add(0, groupStr);
					}
					// place remaining students into separate group
					String remainGroup = "";
					for(JCheckBox tickLeft : tickedTicks)
					{
						remainGroup += tickLeft.getText() + " | ";
					}
					groups.add(0, remainGroup);
				}
			}
		});
	}
	
	public static void selectStudent(JButton btnSelectRandomStudents, JLabel randStudent)
	{
		/**
		 * Selects random student from list.
		 */
		btnSelectRandomStudents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				boolean ticked = false;
				while(!ticked)
				{
					JCheckBox randtick = ticks.get((int)(Math.random()*ticks.size()));
					ticked = randtick.isSelected();
					randStudent.setText(randtick.getText());
				}
			}
		});
	}
	
	public List<JCheckBox> getTicked(List<JCheckBox> ticks)
	{
		List<JCheckBox> tickedTicks = new ArrayList<>();
		for(int j = 0; j < ticks.size(); j++)
		{
			if(ticks.get(j).isSelected())
			{
				tickedTicks.add(ticks.get(j));
			}
		}
		return tickedTicks;
	}

	public static void toggleSelect(JButton togSel) {
		togSel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				for(JCheckBox tick : ticks)
				{
					if(tick.isSelected())
						tick.setSelected(false);
					else
						tick.setSelected(true);
				}
			}
		});
	}
}
