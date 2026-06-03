import java.io.*;
import java.util.*;

public class InvoiceImporter implements Importer {

  public Document importFile(final File file) throws IOException {
    final TextFile txtFile = new TextFile(file);

    txtFile.addLineSuffix(Attributes.NAME_PREFIX, "PATIENT");
    txtFile.addLineSuffix(Attributes.AMOUNT_PREFIX, "AMOUNT");

    final Map<String, String> attributes = txtFile.getAttributes();
    attributes.put(Attributes.TYPE, "INVOICE");

    return new Document(attributes);
  }
}
