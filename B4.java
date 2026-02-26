import java.util.LinkedList;

class EmergencyRoom {
    private LinkedList<String> queue = new LinkedList<>();

    public void patientCheckIn(String name) {
        queue.addLast(name);
    }

    public void emergencyCheckIn(String name) {
        queue.addFirst(name);
    }

    public void treatPatient() {
        if (queue.isEmpty()) return;
        String name = queue.removeFirst();
        if (name.equals("C")) {
            System.out.println("Đang cấp cứu: " + name);
        } else {
            System.out.println("Đang khám: " + name);
        }
    }
}

public class B4 {
    public static void main(String[] args) {
        EmergencyRoom er = new EmergencyRoom();
        er.patientCheckIn("A");
        er.patientCheckIn("B");
        er.emergencyCheckIn("C");

        er.treatPatient();
        er.treatPatient();
        er.treatPatient();
    }
}