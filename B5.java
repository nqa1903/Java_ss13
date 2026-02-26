import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

class Patient {
    private String id;
    private String fullName;
    private int age;
    private String diagnosis;

    public Patient(String id, String fullName, int age, String diagnosis) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    @Override
    public String toString() {
        return "ID : " + id +
                " | FullName : " + fullName +
                " | Age : " + age +
                " | Diagnosis : " + diagnosis + " |";
    }
}

public class B5 {
    private static List<Patient> patients = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            menu();
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: addPatient(); break;
                case 2: updateDiagnosis(); break;
                case 3: dischargePatient(); break;
                case 4: sortPatients(); break;
                case 5: displayPatients(); break;
                case 6: return;
            }
        }
    }

    private static void menu() {
        System.out.println("====================MENU====================");
        System.out.println("1. Tiếp nhận bệnh nhân");
        System.out.println("2. Cập nhật chẩn đoán");
        System.out.println("3. Xuất viện");
        System.out.println("4. Sắp xếp danh sách bệnh nhân");
        System.out.println("5. Hiển thị danh sách bệnh nhân");
        System.out.println("6. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private static boolean idExists(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) return true;
        }
        return false;
    }

    private static Patient findById(String id) {
        for (Patient p : patients) {
            if (p.getId().equals(id)) return p;
        }
        return null;
    }

    private static void addPatient() {
        System.out.print("Nhập ID bệnh nhân: ");
        String id = sc.nextLine();
        if (idExists(id)) {
            System.out.println("ID đã tồn tại.");
            return;
        }
        System.out.print("Nhập tên bệnh nhân: ");
        String name = sc.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập chẩn đoán: ");
        String diagnosis = sc.nextLine();

        patients.add(new Patient(id, name, age, diagnosis));
        System.out.println("Bệnh nhân đã được thêm thành công.");
    }

    private static void updateDiagnosis() {
        System.out.print("Nhập ID bệnh nhân để cập nhật chẩn đoán: ");
        String id = sc.nextLine();
        Patient p = findById(id);
        if (p == null) {
            System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
            return;
        }
        System.out.print("Nhập chẩn đoán mới: ");
        String diagnosis = sc.nextLine();
        p.setDiagnosis(diagnosis);
        System.out.println("Chẩn đoán đã được cập nhật.");
    }

    private static void dischargePatient() {
        System.out.print("Nhập ID bệnh nhân để xuất viện: ");
        String id = sc.nextLine();
        Iterator<Patient> it = patients.iterator();
        while (it.hasNext()) {
            if (it.next().getId().equals(id)) {
                it.remove();
                System.out.println("Bệnh nhân đã xuất viện.");
                return;
            }
        }
        System.out.println("Không tìm thấy bệnh nhân với ID đã cho.");
    }

    private static void sortPatients() {
        Collections.sort(patients, new Comparator<Patient>() {
            @Override
            public int compare(Patient a, Patient b) {
                if (b.getAge() != a.getAge()) {
                    return b.getAge() - a.getAge();
                }
                return a.getFullName().compareToIgnoreCase(b.getFullName());
            }
        });
        System.out.println("Danh sách bệnh nhân đã được sắp xếp.");
    }

    private static void displayPatients() {
        System.out.println("===============Danh sách bệnh nhân===============");
        for (Patient p : patients) {
            System.out.println(p);
        }
    }
}