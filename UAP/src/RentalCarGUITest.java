import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

class RentalCarGUITest {

    private RentalCarGUI rentalCarGUI;

    @BeforeEach
    public void setup() {
        rentalCarGUI = new RentalCarGUI();
    }

    @Test
    public void testAddVehicle() {
        // Simulasi penambahan kendaraan
        Vehicle vehicle = new Vehicle("Toyota Avanza", "SUV", 500000);
        assertEquals(true, rentalCarGUI.vehicles.add(vehicle));
        rentalCarGUI.vehicleListModel.addElement(vehicle.getName());

        // Verifikasi kendaraan ditambahkan
        assertEquals(1, rentalCarGUI.vehicles.size());
        assertEquals("Toyota Avanza", rentalCarGUI.vehicles.get(0).getName());
        assertEquals("SUV", rentalCarGUI.vehicles.get(0).getType());
        assertEquals(500000, rentalCarGUI.vehicles.get(0).getPrice());
    }

    @Test
    public void testDeleteVehicle() {
        // Simulasi penambahan kendaraan
        Vehicle vehicle = new Vehicle("Toyota Avanza", "SUV", 500000);
        rentalCarGUI.vehicles.add(vehicle);
        rentalCarGUI.vehicleListModel.addElement(vehicle.getName());

        // Hapus kendaraan
        rentalCarGUI.deleteVehicle(0);

        // Verifikasi kendaraan dihapus
        assertEquals(0, rentalCarGUI.vehicles.size());
        assertEquals(0, rentalCarGUI.vehicleListModel.getSize());
    }

    @Test
    public void testRentVehicle() {
        // Simulasi penambahan kendaraan
        Vehicle vehicle = new Vehicle("Innova Zenix", "Manual", 400000);
        rentalCarGUI.vehicles.add(vehicle);
        rentalCarGUI.vehicleListModel.addElement(vehicle.getName());

        // Validasi pemesanan kendaraan
        JTextField renterNameField = new JTextField("rere");
        JTextField rentDateField = new JTextField("2024-12-20");
        JTextField returnDateField = new JTextField("2024-12-22");
        JTextField guaranteeField = new JTextField("KTP");

        Object[] message = {
                "Nama Pemesan:", renterNameField,
                "Tanggal Sewa (YYYY-MM-DD):", rentDateField,
                "Tanggal Pengembalian (YYYY-MM-DD):", returnDateField,
                "Jaminan:", guaranteeField,
        };

        // Simulasi dialog input
        int option = JOptionPane.showConfirmDialog(null, message, "Sewa Kendaraan", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String renterName = renterNameField.getText();
            String rentDate = rentDateField.getText();
            String returnDate = returnDateField.getText();
            String guarantee = guaranteeField.getText();

            // Verifikasi hasil input
            assertEquals("rere", renterName);
            assertEquals("2024-12-20", rentDate);
            assertEquals("2024-12-22", returnDate);
            assertEquals("KTP", guarantee);
        }
    }

    @Test
    public void testAddVehicleInvalidPrice() {
        // Simulasi input harga tidak valid
        try {
            Vehicle vehicle = new Vehicle("Innova Zenix", "Manual", Double.parseDouble("abc"));
            fail("Harus menghasilkan NumberFormatException.");
        } catch (NumberFormatException e) {
            assertTrue(true, "Exception ditangkap dengan benar.");
        }
    }
}
