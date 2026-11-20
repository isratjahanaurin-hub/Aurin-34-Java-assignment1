import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class Main {

    // Abstract class Employee
    static abstract class Employee {
        private String id;
        private String name;
        private double baseSalary;

        public Employee(String id, String name, double baseSalary) {
            this.id = id;
            this.name = name;
            this.baseSalary = baseSalary;
        }

        //Getter methods
        public String getId() { 
            return id; 
        }
        public String getName() { 
            return name; 
        }
        public double getBaseSalary() { 
            return baseSalary; 
        }

        public abstract String getType(); //abstract methods
        public abstract double calculateSalary(); 
    }

    // FullTimeEmployee sub class inherits super class Employee
    static class FullTimeEmployee extends Employee {
        private double bonus;

        public FullTimeEmployee(String id, String name, double baseSalary, double bonus) { //Constructor
            super(id, name, baseSalary);
            this.bonus = bonus;
        }

        @Override //method overriding
        public String getType() { 
            return "Full-Time"; 
        }

        @Override
        public double calculateSalary() { 
            return getBaseSalary() + bonus; 
        }
    }

    static class PartTimeEmployee extends Employee {
        private int hours;
        private double rate;

        public PartTimeEmployee(String id, String name, int hours, double rate) {
            super(id, name, hours * rate);
            this.hours = hours;
            this.rate = rate;
        }

        @Override
        public String getType() { 
            return "Part-Time"; 
        }

        @Override
        public double calculateSalary() { 
            return hours * rate; //salary calculation
        }
    }


    
    // UI Frame 
    static class EmployeeUI extends JFrame {
        private ArrayList<Employee> employees = new ArrayList<>();
        private DefaultTableModel tableModel;

        private JComboBox<String> typeBox;
        private JTextField idField, nameField, val1Field, val2Field, searchField;
        private JLabel val1Label, val2Label, totalLabel;

        public EmployeeUI() {
            setTitle("Employee Management System by Aurin-34");
            setSize(760, 480);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout(10, 10));

            // Top Header
            JLabel title = new JLabel("Employee Management System", SwingConstants.CENTER);
            title.setFont(new Font("SansSerif", Font.BOLD, 20));
            title.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
            add(title, BorderLayout.NORTH);

            // Left Form Panel
            JPanel formPanel = new JPanel(new GridLayout(10, 1, 5, 5));
            formPanel.setBorder(BorderFactory.createTitledBorder("Add Employee"));
            formPanel.setPreferredSize(new Dimension(240, 0));

            typeBox = new JComboBox<>(new String[]{"Full-Time", "Part-Time"});
            idField = new JTextField();
            nameField = new JTextField();
            val1Label = new JLabel("Base Salary (BDT):");
            val1Field = new JTextField();
            val2Label = new JLabel("Bonus (BDT):");
            val2Field = new JTextField();

            JButton addBtn = new JButton("Add Employee");
            addBtn.setBackground(new Color(37, 99, 235));
            addBtn.setForeground(Color.WHITE);
            addBtn.setFocusPainted(false);

            formPanel.add(new JLabel("Employee Type:"));
            formPanel.add(typeBox);
            formPanel.add(new JLabel("Employee ID:"));
            formPanel.add(idField);
            formPanel.add(new JLabel("Full Name:"));
            formPanel.add(nameField);
            formPanel.add(val1Label);
            formPanel.add(val1Field);
            formPanel.add(val2Label);
            formPanel.add(val2Field);

            JPanel leftWrapper = new JPanel(new BorderLayout(5, 8));
            leftWrapper.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 5));
            leftWrapper.add(formPanel, BorderLayout.CENTER);
            leftWrapper.add(addBtn, BorderLayout.SOUTH);
            add(leftWrapper, BorderLayout.WEST);

            // Center Table + Search Panel
            JPanel rightPanel = new JPanel(new BorderLayout(5, 8));
            rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));

            JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 0));
            searchField = new JTextField(14);
            JButton searchBtn = new JButton("Search ID");
            JButton showAllBtn = new JButton("Show All");
            searchPanel.add(new JLabel("Search:"));
            searchPanel.add(searchField);
            searchPanel.add(searchBtn);
            searchPanel.add(showAllBtn);

            tableModel = new DefaultTableModel(new String[]{"ID", "Name", "Type", "Total Salary (BDT)"}, 0) {
                @Override
                public boolean isCellEditable(int row, int column) { return false; }
            };
            JTable table = new JTable(tableModel);
            table.setRowHeight(24);
            table.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));

            totalLabel = new JLabel("Total Payroll: 0.00 BDT", SwingConstants.RIGHT);
            totalLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

            rightPanel.add(searchPanel, BorderLayout.NORTH);
            rightPanel.add(new JScrollPane(table), BorderLayout.CENTER);
            rightPanel.add(totalLabel, BorderLayout.SOUTH);
            add(rightPanel, BorderLayout.CENTER);

            // Switch labels based on Employee Type
            typeBox.addActionListener(e -> {
                if ("Full-Time".equals(typeBox.getSelectedItem())) {
                    val1Label.setText("Base Salary (BDT):");
                    val2Label.setText("Bonus (BDT):");
                } else {
                    val1Label.setText("Hours Worked:");
                    val2Label.setText("Hourly Rate (BDT):");
                }
            });

            // Add Employee Action
            addBtn.addActionListener(e -> addEmployee());

            // Search Action
            searchBtn.addActionListener(e -> {
                String query = searchField.getText().trim();
                if (query.isEmpty()) {
                    refreshTable(employees);
                    return;
                }
                ArrayList<Employee> filtered = new ArrayList<>();
                for (Employee emp : employees) {
                    if (emp.getId().equalsIgnoreCase(query)) {
                        filtered.add(emp);
                    }
                }
                if (filtered.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Employee ID not found!", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
                refreshTable(filtered);
            });

            showAllBtn.addActionListener(e -> {
                searchField.setText("");
                refreshTable(employees);
            });
        }

        private void addEmployee() {
            try {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                if (id.isEmpty() || name.isEmpty()) {
                    JOptionPane.showMessageDialog(this, "ID and Name are required.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                for (Employee emp : employees) {
                    if (emp.getId().equalsIgnoreCase(id)) {
                        JOptionPane.showMessageDialog(this, "Duplicate ID! Use a unique ID.", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }

                double v1 = Double.parseDouble(val1Field.getText().trim());
                double v2 = Double.parseDouble(val2Field.getText().trim());
                if (v1 <= 0 || v2 < 0) {
                    JOptionPane.showMessageDialog(this, "Enter valid positive values.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Employee emp;
                if ("Full-Time".equals(typeBox.getSelectedItem())) {
                    emp = new FullTimeEmployee(id, name, v1, v2);
                } else {
                    emp = new PartTimeEmployee(id, name, (int) v1, v2);
                }

                employees.add(emp);
                refreshTable(employees);
                clearForm();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid numbers for salary/hours/rate.", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        private void refreshTable(ArrayList<Employee> list) {
            tableModel.setRowCount(0);
            double total = 0;
            for (Employee emp : list) {
                double sal = emp.calculateSalary();
                total += sal;
                tableModel.addRow(new Object[]{emp.getId(), emp.getName(), emp.getType(), String.format("%.2f BDT", sal)});
            }
            totalLabel.setText(String.format("Total Payroll: %.2f BDT", total));
        }

        private void clearForm() {
            idField.setText("");
            nameField.setText("");
            val1Field.setText("");
            val2Field.setText("");
            idField.requestFocus();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeUI().setVisible(true)); //thread safety for java swing run
    }
}