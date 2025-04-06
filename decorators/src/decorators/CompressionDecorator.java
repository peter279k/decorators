package decorators;

public class CompressionDecorator extends DataSourceDecorator {

    CompressionDecorator(DataSource source) {
        super(source);
    }

    public void writeData(String data) {
        System.out.println("Writing data from the CompressionDecorator: " + data);

        super.writeData(compress(data));
    }

    public String readData() {
        System.out.println("Reading data from the CompressionDecorator");

        return decompress(super.readData());
    }

    private String compress(String data) {
        data = "compress_" + data;

        return data;
    }

    private String decompress(String data) {
        if (data.startsWith("compress_")) {
            data = data.substring("compress_".length());
        }

        return data;
    }
}
