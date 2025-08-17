import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class stdGUI extends JFrame implements ActionListener {
    String NAME = "F:\\javatask\\unit4\\guii.txt";
    private ArrayList<newStudent> std;
    private DefaultListModel<String> listModel;
    private JList<String> studentlist;
    private JTextField idfield;
    private JTextField namefield;
    private JTextField emailfield;

    public stdGUI() {
        this.setTitle("student management system :)");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());

        std = loadStudent();
        listModel = new DefaultListModel<>();
        studentlist = new JList<>(listModel);
        refreshlist();

        JPanel input = new JPanel();
        input.setLayout(new GridLayout());
        input.add(new JLabel("ID: "));
        idfield = new JTextField();
        input.add(idfield);

        input.add(new JLabel("name: "));
        namefield = new JTextField();
        input.add(namefield);

        input.add(new JLabel("Email: "));
        emailfield = new JTextField();
        input.add(emailfield);

        JButton addButton = new JButton("add student");
        JButton updateButton = new JButton("updateButton");
        JButton deleteButton = new JButton("delete student");
        JButton loadButton = new JButton("load student");

        addButton.addActionListener(e -> createStudent());
        updateButton.addActionListener(e -> updateStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        loadButton.addActionListener(e -> refreshlist());

        JPanel buttonPanel = new JPanel(new GridLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(loadButton);

        this.add(new JScrollPane(studentlist), BorderLayout.CENTER);
        this.add(input, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public void createStudent() {
        try {
            int id = Integer.parseInt(idfield.getText());
            String name = namefield.getText();
            String email = emailfield.getText();

            std.add(new newStudent(name, email, id));
            saveStudent();
            refreshlist();
            JOptionPane.showMessageDialog(this, "student added successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "something went wrong please check your data ");
        }
    }

    public void updateStudent() {
        try {
            int id = Integer.parseInt(idfield.getText());
            for (newStudent a : std) {
                if (a.getId() == id) {
                    a.setName(namefield.getText());
                    a.setEmail(emailfield.getText());
                    saveStudent();
                    refreshlist();
                    JOptionPane.showMessageDialog(this, "student added successfully");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "student not found");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "invalid input");
        }
    }

    private void deleteStudent() {
        try {
            int id = Integer.parseInt(idfield.getText());
            std.removeIf(s -> s.getId() == id);
            saveStudent();
            refreshlist();
            JOptionPane.showMessageDialog(this, "student deleted successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "invalid");
        }
    }

    private void refreshlist() {
        listModel.clear();
        for (newStudent s : std) {
            listModel.addElement(s.toString());
        }
    }

    private void saveStudent(){

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NAME));
            oos.writeObject(std);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this,"error saving students: "+ e.getMessage());
        }
    }
    private ArrayList<newStudent> loadStudent() {
        File ff = new File(NAME);
        if (!ff.exists()) {
            return new ArrayList<>();
        }

        try {
            ObjectInputStream inn = new ObjectInputStream(new FileInputStream(NAME));
            return (ArrayList<newStudent>) inn.readObject();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "error loading students: " + e.getMessage());
            return new ArrayList<>();
        }


    }


        @Override
    public void actionPerformed(ActionEvent e) {

    }

}