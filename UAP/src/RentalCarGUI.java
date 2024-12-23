import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class RentalCarGUI extends JFrame {
    final List<Vehicle> vehicles = new ArrayList<>();
    final DefaultListModel<String> vehicleListModel = new DefaultListModel<>();

    public RentalCarGUI() {
        setTitle("RerinCar - Rental Mobil");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header Panel with Logo
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(153, 102, 255)); // Ungu
        headerPanel.setLayout(new BorderLayout());

        JLabel logo = new JLabel(new ImageIcon("logo.png")); // Logo file: logo.png
        JLabel header = new JLabel("RerinCar - Rental Mobil", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setForeground(Color.WHITE);

        headerPanel.add(logo, BorderLayout.WEST);
        headerPanel.add(header, BorderLayout.CENTER);
        add(headerPanel, BorderLayout.NORTH);

        // List Panel
        JPanel listPanel = new JPanel();
        listPanel.setBackground(new Color(255, 204, 255)); // Pink
        listPanel.setLayout(new BorderLayout());

        JList<String> vehicleList = new JList<>(vehicleListModel);
        vehicleList.setBackground(Color.WHITE);
        vehicleList.setForeground(Color.BLACK);
        listPanel.add(new JScrollPane(vehicleList), BorderLayout.CENTER);
        add(listPanel, BorderLayout.CENTER);

        // Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(255, 153, 255)); // Pink Lebih Gelap

        JButton addButton = new JButton("Tambah Kendaraan");
        JButton orderButton = new JButton("Sewa Kendaraan");
        JButton deleteButton = new JButton("Hapus Kendaraan");

        buttonPanel.add(addButton);
        buttonPanel.add(orderButton);
        buttonPanel.add(deleteButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(e -> addVehicle());
        orderButton.addActionListener(e -> rentVehicle(vehicleList.getSelectedIndex()));
        deleteButton.addActionListener(e -> deleteVehicle(vehicleList.getSelectedIndex()));

        setVisible(true);
    }

    private void addVehicle() {
        JTextField nameField = new JTextField();
        JTextField typeField = new JTextField();
        JTextField priceField = new JTextField();

        Object[] message = {
                "Nama Kendaraan:", nameField,
                "Tipe Kendaraan:", typeField,
                "Harga Sewa Per Hari:", priceField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Tambah Kendaraan", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            try {
                String name = nameField.getText();
                String type = typeField.getText();
                double price = Double.parseDouble(priceField.getText());

                Vehicle vehicle = new Vehicle(name, type, price);
                vehicles.add(vehicle);
                vehicleListModel.addElement(name);

                JOptionPane.showMessageDialog(this, "Kendaraan berhasil ditambahkan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void rentVehicle(int index) {
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "Pilih kendaraan untuk disewa!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Vehicle selectedVehicle = vehicles.get(index);

        JTextField renterNameField = new JTextField();
        JTextField rentDateField = new JTextField();
        JTextField returnDateField = new JTextField();
        JTextField guaranteeField = new JTextField();

        Object[] message = {
                "Nama Pemesan:", renterNameField,
                "Tanggal Sewa (YYYY-MM-DD):", rentDateField,
                "Tanggal Pengembalian (YYYY-MM-DD):", returnDateField,
                "Jaminan:", guaranteeField,
        };

        int option = JOptionPane.showConfirmDialog(this, message, "Sewa Kendaraan", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String renterName = renterNameField.getText();
            String rentDate = rentDateField.getText();
            String returnDate = returnDateField.getText();
            String guarantee = guaranteeField.getText();

            JOptionPane.showMessageDialog(this, String.format(
                    "Pemesanan berhasil!\nNama: %s\nKendaraan: %s\nHarga Sewa: %.2f\nTanggal Sewa: %s\nTanggal Pengembalian: %s\nJaminan: %s",
                    renterName, selectedVehicle.getName(), selectedVehicle.getPrice(), rentDate, returnDate, guarantee
            ), "Sukses", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void deleteVehicle(int index) {
        if (index >= 0) {
            vehicles.remove(index);
            vehicleListModel.remove(index);
            JOptionPane.showMessageDialog(this, "Kendaraan berhasil dihapus!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Pilih kendaraan untuk dihapus!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new RentalCarGUI();
    }
}

class Vehicle {
    private final String name;
    private final String type;
    private final double price;

    public Vehicle(String name, String type, double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}