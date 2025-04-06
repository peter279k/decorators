package no_decorators;

public class ClientApplication {

    public static void main(String[] args) {
        String records = "This is records";
        String fileName = "output.txt";

        DataSource compressionEncryption = new CompressionEncryptionData(fileName);
        compressionEncryption.writeData(records);

        DataSource plain = new DataSource(fileName);
        
        System.out.println("Input: " + records);
        System.out.println("Encoded: " + plain.readData());
        System.out.println("Decoded: " + compressionEncryption.readData());
    }

}
