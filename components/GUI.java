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

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GUI extends JFrame {
    public static final long serialVersionUID = 1L;
    private JPanel contentPane;

    /**
     * Create the frame.
     */
    public GUI() {
        configureFrame();
        addComponents();
    }

    private void configureFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));
    }

    private void addComponents() {
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        contentPane.add(tabbedPane);

        JScrollPane scrollPane = new JScrollPane();
        tabbedPane.addTab("Enter Students", null, scrollPane, null);

        JTextPane txtpnOneStudentPer = new JTextPane();
        txtpnOneStudentPer.setToolTipText("Delimeter: newline");
        txtpnOneStudentPer.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        scrollPane.setViewportView(txtpnOneStudentPer);

        JButton btnSetStudentList = new JButton("Set Student List");

        JPanel selStu = new JPanel();
        GridBagLayout gbl_selStu = new GridBagLayout();
        gbl_selStu.columnWidths = new int[]{0, 0, 0};
        gbl_selStu.rowHeights = new int[]{0, 0, 0, 0};
        gbl_selStu.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
        gbl_selStu.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
        selStu.setLayout(gbl_selStu);

        JScrollPane scroll = new JScrollPane(selStu);

        JButton desAll = new JButton("Deselect All");
        JButton selAll = new JButton("Select All");
        JButton togSel = new JButton("Toggle Select");

        GridBagConstraints gbc_desAll = new GridBagConstraints();
        gbc_desAll.insets = new Insets(0, 0, 5, 0);
        gbc_desAll.anchor = GridBagConstraints.NORTHWEST;
        gbc_desAll.gridx = 0;
        gbc_desAll.gridy = 0;
        selStu.add(desAll, gbc_desAll);

        GridBagConstraints gbc_selAll = new GridBagConstraints();
        gbc_selAll.insets = new Insets(0, 0, 5, 0);
        gbc_selAll.anchor = GridBagConstraints.NORTHEAST;
        gbc_selAll.gridx = 0;
        gbc_selAll.gridy = 0;
        selStu.add(selAll, gbc_selAll);

        GridBagConstraints gbc_togSel = new GridBagConstraints();
        gbc_togSel.insets = new Insets(0, 0, 5, 0);
        gbc_togSel.anchor = GridBagConstraints.NORTH;
        gbc_togSel.gridx = 0;
        gbc_togSel.gridy = 0;
        selStu.add(togSel, gbc_togSel);

        Box verticalBox = Box.createVerticalBox();
        GridBagConstraints gbc_verticalBox = new GridBagConstraints();
        gbc_verticalBox.insets = new Insets(0, 0, 5, 0);
        gbc_verticalBox.gridx = 0;
        gbc_verticalBox.gridy = 1;
        selStu.add(verticalBox, gbc_verticalBox);
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


        JPanel advSet = new JPanel();
        GridBagLayout gbl_panel_2 = new GridBagLayout();
        gbl_panel_2.columnWidths = new int[]{75, 0};
        gbl_panel_2.rowHeights = new int[]{29, 0, 0};
        gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel_2.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        advSet.setLayout(gbl_panel_2);
        tabbedPane.addTab("Advanced Settings", null, advSet, null);
        //JLabel comingsoon = new JLabel("Coming Soon!");
        //comingsoon.setFont(new Font("Herculanum", Font.PLAIN, 50));
        //advSet.add(comingsoon);
        JToggleButton numGroups = new JToggleButton("Select based on students per group.");
        JLabel numGroupsLbl = new JLabel("Selection method:");
        GridBagConstraints gbc_numGroups = new GridBagConstraints();
        gbc_numGroups.gridx = 1;
        gbc_numGroups.gridy = 0;
        GridBagConstraints gbc_numGroupsLbl = new GridBagConstraints();
        gbc_numGroupsLbl.gridx = 0;
        gbc_numGroupsLbl.gridy = 0;

        JTextField delim = new JTextField("\\n", 3);
        JLabel delimLbl = new JLabel("Delimeter for student list (default = newline):");
        GridBagConstraints gbc_delim = new GridBagConstraints();
        gbc_delim.gridx = 1;
        gbc_delim.gridy = 1;
        GridBagConstraints gbc_delimLbl = new GridBagConstraints();
        gbc_delimLbl.gridx = 0;
        gbc_delimLbl.gridy = 1;

        advSet.add(numGroups, gbc_numGroups);
        advSet.add(numGroupsLbl, gbc_numGroupsLbl);
        advSet.add(delim, gbc_delim);
        advSet.add(delimLbl, gbc_delimLbl);

        setListeners(btnSetStudentList, verticalBox, txtpnOneStudentPer, btnSave, contentPane, btnLoad, btnMakeGroupsOf, spinner, groups, btnSelectRandomStudents, randStudent, desAll, selAll, togSel, numGroups, lblStudentsPerGroup, delim);
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
            JLabel randStudent,
            JButton desAll,
            JButton selAll,
            JButton togSel,
            JToggleButton numGroups,
            JLabel lblStudentsPerGroup,
            JTextField delim) {
        // Listener for setting student list button.
        Logic.setStudentList(btnSetStudentList, verticalBox, txtpnOneStudentPer, delim);

        // Listener for save button.
        Logic.saveStudentList(btnSave, contentPane, txtpnOneStudentPer);

        // Listener for load button.
        Logic.loadStudentList(btnLoad, contentPane, txtpnOneStudentPer);

        // Listener for make groups button.
        Logic.makeGroups(btnMakeGroupsOf, spinner, groups, numGroups);

        // Listener for select student button.
        Logic.selectStudent(btnSelectRandomStudents, randStudent);

        // Listener for deselect all button.
        Logic.deselectAll(desAll);

        // Listener for select all button.
        Logic.selectAll(selAll);

        // Listener for toggle select.
        Logic.toggleSelect(togSel);

        // Listener for toggle selection method.
        Logic.selectMethod(numGroups, lblStudentsPerGroup);
    }
}
