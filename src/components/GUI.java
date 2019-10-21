package components;
/**
 * StudentGrouper
 * created by Manav Malik in 2019
 * licensed under MIT License
 * 
 * Used to generate random groups of
 * certain students and select a random
 * student from the class.
 */

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GUI()
	{
		configureFrame();
		addComponents();
	}
	
	private void configureFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
	}

	private void addComponents()
	{
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("Enter Students", null, scrollPane, null);
		
		JTextPane txtpnOneStudentPer = new JTextPane();
		txtpnOneStudentPer.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		txtpnOneStudentPer.setText("One student per line...");
		scrollPane.setViewportView(txtpnOneStudentPer);
		
		JButton btnSetStudentList = new JButton("Set Student List");
		
		JPanel selStu = new JPanel();
		JScrollPane scroll = new JScrollPane(selStu);
		
		Box verticalBox = Box.createVerticalBox();
		selStu.add(verticalBox);
		tabbedPane.addTab("Select Students", null, scroll, null);
		btnSetStudentList.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		scrollPane.setColumnHeaderView(btnSetStudentList);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setRowHeaderView(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{75, 0};
		gbl_panel_1.rowHeights = new int[]{29, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Pick Random", null, panel, null);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnSelectRandomStudents = new JButton("Select Random Student");
		GridBagConstraints gbc_btnSelectRandomStudents = new GridBagConstraints();
		gbc_btnSelectRandomStudents.insets = new Insets(0, 0, 5, 5);
		gbc_btnSelectRandomStudents.gridx = 0;
		gbc_btnSelectRandomStudents.gridy = 0;
		panel.add(btnSelectRandomStudents, gbc_btnSelectRandomStudents);
		
		JLabel randStudent = new JLabel("STUDENT");
		GridBagConstraints gbc_randStudent = new GridBagConstraints();
		gbc_randStudent.insets = new Insets(0, 0, 5, 5);
		gbc_randStudent.gridx = 1;
		gbc_randStudent.gridy = 0;
		panel.add(randStudent, gbc_randStudent);
		
		JButton btnMakeGroupsOf = new JButton("Make Groups");

		GridBagConstraints gbc_btnMakeGroupsOf = new GridBagConstraints();
		gbc_btnMakeGroupsOf.insets = new Insets(0, 0, 5, 5);
		gbc_btnMakeGroupsOf.gridx = 0;
		gbc_btnMakeGroupsOf.gridy = 1;
		panel.add(btnMakeGroupsOf, gbc_btnMakeGroupsOf);
		
		JSpinner spinner = new JSpinner();
		spinner.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.anchor = GridBagConstraints.EAST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 1;
		panel.add(spinner, gbc_spinner);
		
		JLabel lblStudentsPerGroup = new JLabel("students per group");
		GridBagConstraints gbc_lblStudentsPerGroup = new GridBagConstraints();
		gbc_lblStudentsPerGroup.insets = new Insets(0, 0, 5, 0);
		gbc_lblStudentsPerGroup.anchor = GridBagConstraints.WEST;
		gbc_lblStudentsPerGroup.gridx = 2;
		gbc_lblStudentsPerGroup.gridy = 1;
		panel.add(lblStudentsPerGroup, gbc_lblStudentsPerGroup);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 3;
		gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 2;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		DefaultListModel<String> groups = new DefaultListModel<String>();
		JList<String> list = new JList<String>(groups);
		scrollPane_1.setViewportView(list);
		
		JButton btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 5, 0);
		gbc_btnSave.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSave.gridx = 0;
		gbc_btnSave.gridy = 0;
		panel_1.add(btnSave, gbc_btnSave);
		
		JButton btnLoad = new JButton("Load");
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.gridx = 0;
		gbc_btnLoad.gridy = 1;
		panel_1.add(btnLoad, gbc_btnLoad);

		setListeners(btnSetStudentList, verticalBox, txtpnOneStudentPer, btnSave, contentPane, btnLoad, btnMakeGroupsOf, spinner, groups, btnSelectRandomStudents, randStudent);
	}
	
	private void setListeners(
			JButton btnSetStudentList, 
			Box verticalBox, 
			JTextPane txtpnOneStudentPer, 
			JButton btnSave, 
			JPanel contentPane,
			JButton btnLoad,
			JButton btnMakeGroupsOf, 
			JSpinner spinner, 
			DefaultListModel<String> groups,
			JButton btnSelectRandomStudents, 
			JLabel randStudent)
	{
		// Listener for setting student list button.
		Logic.setStudentList(btnSetStudentList, verticalBox, txtpnOneStudentPer);
		
		// Listener for save button.
		Logic.saveStudentList(btnSave, contentPane, txtpnOneStudentPer);
		
		// Listener for load button.
		Logic.loadStudentList(btnLoad, contentPane, txtpnOneStudentPer);
		
		// Listener for make groups button.
		Logic.makeGroups(btnMakeGroupsOf, spinner, groups);
		
		// Listener for select student button.
		Logic.selectStudent(btnSelectRandomStudents, randStudent);
	}
}
