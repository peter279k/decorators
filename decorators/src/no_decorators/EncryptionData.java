package no_decorators;

public class EncryptionData extends DataSource {

    EncryptionData(String name) {
        super(name);
    }

    public void writeData(String data) {
        System.out.println("Writing data from the EncryptionData: " + data);
        super.writeData(encrypt(data));
    }

    public String readData() {
        System.out.println("Reading data from the EncryptionData");

        return decrypt(super.readData());
    }

    private String encrypt(String data) {
        return "encrypt_" + data;
    }

    private String decrypt(String data) {
        if (data.startsWith("encrypt_")) {
            data = data.substring("encrypt_".length());
        }

        return data;
    }
}
