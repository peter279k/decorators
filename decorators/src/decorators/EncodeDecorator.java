package decorators;

public class EncodeDecorator extends DataSourceDecorator {

    EncodeDecorator(DataSource source) {
        super(source);
    }

    public void writeData(String data) {
        System.out.println("Writing data from the EncodeDecorator: " + data);
        super.writeData(encode(data));
    }

    public String readData() {
        System.out.println("Reading data from the EncodeDecorator");

        return decode(super.readData());
    }

    private String encode(String data) {
        return "encode_" + data;
    }

    private String decode(String data) {
        if (data.startsWith("encode_")) {
            data = data.substring("encode_".length());
        }

        return data;
    }
}
