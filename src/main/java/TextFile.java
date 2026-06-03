import java.io.*;
import java.nio.file.*;
import java.util.*;

class TextFile {
  private final Map<String, String> attributes = new HashMap<>();
  private final List<String> lines;

  public TextFile(final File file) throws IOException {
    attributes.put(Attributes.PATH, file.getPath());
    lines = Files.readAllLines(file.toPath());
  }

  void addLineSuffix(final String prefix, final String attributeName) {
    for (final String line : lines) {
      if (line.startsWith(prefix)) {
        attributes.put(attributeName, line.substring(prefix.length()));
      }
    }
  }

  public Map<String, String> getAttributes() {
    return attributes;
  }

}