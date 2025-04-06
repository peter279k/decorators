package decorators;

public class ClientApplication {

    public static void main(String[] args) {
        String records = "This is records";
        String fileName = "output.txt";

        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(new FileDataSource(fileName))
        );

        encoded.writeData(records);
        DataSource plain = new FileDataSource(fileName);

        System.out.println("Input: " + records);
        System.out.println("Encoded: " + plain.readData());
        System.out.println("Decoded: " + encoded.readData());
    }

}
