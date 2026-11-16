public class LocalInstance {
    int instanceVar = 50; // Instance variable

    void display() {
        int localVar = 20; // Local variable
        System.out.println("Local: " + localVar);
        System.out.println("Instance: " + instanceVar);
    }

    public static void main(String[] args) {
        LocalInstance obj = new LocalInstance();
        obj.display();
    }
}