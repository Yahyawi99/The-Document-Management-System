import java.io.*;
import java.util.*;

public class DocumentManagementSystem {
  private final Map<String, Importer> extensionToImporter = new HashMap<>();
  private final List<Document> documents = new ArrayList<>();

  public DocumentManagementSystem() {
    extensionToImporter.put("letter", new LetterImporter());
    extensionToImporter.put("report", new ReportImporter());
    extensionToImporter.put("jpg", new ImageImporter());
  }

  public void importFile(final String path) throws IOException {
    final File file = new File(path);

    if (!file.exists()) {
      throw new FileNotFoundException(path);
    }

    final int seperatorIndex = path.lastIndexOf(".");
    if (seperatorIndex != -1) {
      if (seperatorIndex == path.length()) {
        throw new FileNotFoundException("No extension found for file:" + path);
      }

      final String extension = path.substring(seperatorIndex + 1);
      final Importer importer = extensionToImporter.get(extension);

      if (importer == null) {
        throw new FileNotFoundException("No importer found for file:" + path);
      }

      final Document document = importer.importFile(file);
      documents.add(document);
    } else {
      throw new FileNotFoundException("No extension found for file:" + path);
    }
  }

  List<Document> contents() {
    return Collections.emptyList();
  }
}