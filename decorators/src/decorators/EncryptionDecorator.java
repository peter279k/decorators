package decorators;

public class EncryptionDecorator extends DataSourceDecorator {

    EncryptionDecorator(DataSource source) {
        super(source);
    }

    public void writeData(String data) {
        System.out.println("Writing data from the EncryptionDecorator: " + data);
        super.writeData(encrypt(data));
    }

    public String readData() {
        System.out.println("Reading data from the EncryptionDecorator");

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
