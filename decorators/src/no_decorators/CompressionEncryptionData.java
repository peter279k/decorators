package no_decorators;

public class CompressionEncryptionData extends DataSource {

    CompressionEncryptionData(String name) {
        super(name);
    }

    public void writeData(String data) {
        System.out.println("Writing data from the CompressionEncryptionData: " + data);

        super.writeData(compressEncrypt(data));
    }

    public String readData() {
        System.out.println("Reading data from the CompressionEncryptionData");

        return decryptDecompress(super.readData());
    }

    private String compressEncrypt(String data) {
        data = "compress_" + data;
        data = "encrypt_" + data;

        return data;
    }

    private String decryptDecompress(String data) {
        if (data.startsWith("encrypt_")) {
            data = data.substring("encrypt_".length());
        }
        if (data.startsWith("compress_")) {
            data = data.substring("compress_".length());
        }

        return data;
    }
}
