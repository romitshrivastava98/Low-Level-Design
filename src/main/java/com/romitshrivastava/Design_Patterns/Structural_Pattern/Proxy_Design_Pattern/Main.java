package com.romitshrivastava.Design_Patterns.Structural_Pattern.Proxy_Design_Pattern;

// 1️⃣ Subject Interface (Common for both Proxy & Real Object)
interface FileAccess {
    void readFile();
    void writeFile(String content);
}

// 2️⃣ RealSubject (Actual File Implementation)
class RealFile implements FileAccess {
    private String fileName;

    public RealFile(String fileName) {
        this.fileName = fileName;
        System.out.println("Opening file: " + fileName);
    }

    @Override
    public void readFile() {
        System.out.println("Reading contents of the file: " + fileName);
    }

    @Override
    public void writeFile(String content) {
        System.out.println("Writing '" + content + "' to file: " + fileName);
    }
}

// 3️⃣ Proxy Class (Controls Access)
class FileProxy implements FileAccess {
    private RealFile realFile;
    private String fileName;
    private boolean isAdmin;

    public FileProxy(String fileName, boolean isAdmin) {
        this.fileName = fileName;
        this.isAdmin = isAdmin;
    }

    @Override
    public void readFile() {
        if (realFile == null) {
            realFile = new RealFile(fileName); // Lazy Initialization
        }
        realFile.readFile();
    }

    @Override
    public void writeFile(String content) {
        if (isAdmin) {
            if (realFile == null) {
                realFile = new RealFile(fileName);
            }
            realFile.writeFile(content);
        } else {
            System.out.println("❌ Access Denied: You do not have permission to write to this file.");
        }
    }
}

// 4️⃣ Client Code (Using Proxy)
public class Main {
    public static void main(String[] args) {
        System.out.println("🔹 User with Admin Access:");
        FileAccess adminFile = new FileProxy("admin_data.txt", true);
        adminFile.readFile();
        adminFile.writeFile("Confidential Data");

        System.out.println("\n🔹 User without Admin Access:");
        FileAccess userFile = new FileProxy("user_data.txt", false);
        userFile.readFile();
        userFile.writeFile("Unauthorized Write Attempt");
    }
}
