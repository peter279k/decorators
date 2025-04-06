package no_decorators;

import java.io.*;

public class DataSource {
    private String name;

    DataSource(String name) {
        this.name = name;
    }

    public void writeData(String data) {
        System.out.println("Writing data: " + data);
        File file = new File(name);

        try {
            OutputStream output = new FileOutputStream(file);
            output.write(data.getBytes(), 0, data.length());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readData() {
        System.out.println("Reading data...");
        char buffer[] = null;
        File file = new File(name);
        try (FileReader reader = new FileReader(file)) {
            buffer = new char[(int) file.length()];
            reader.read(buffer);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return new String(buffer);
    }
}
