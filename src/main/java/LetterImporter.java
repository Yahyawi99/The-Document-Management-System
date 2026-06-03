import java.io.*;
import java.util.*;

class LetterImporter implements Importer {

  public Document importFile(final File file) throws IOException {
    final TextFile txtFile = new TextFile(file);

    txtFile.addLineSuffix(Attributes.NAME_PREFIX, "PATIENT");

    final Map<String, String> attributes = txtFile.getAttributes();
    attributes.put(Attributes.TYPE, "LETTER");

    final int lineNumber = txtFile.addLines(2, String::isEmpty, "ADDRESS");
    txtFile.addLines(lineNumber + 1, (line) -> line.startsWith("regards,"),
        "BODY");

    return new Document(attributes);
  }
}