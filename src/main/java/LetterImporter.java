import java.util.*;
import java.io.*;

class LetterImporter implements Importer {
  private static final String PATH = "path";

  public Document importFile(final File file) throws IOException {
    final Map<String, String> attributes = new HashMap<>();

    attributes.put(PATH, file.getPath());

    return new Document(attributes);
  }
}