import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;

class TextFile {
  private final Map<String, String> attributes = new HashMap<>();
  private final List<String> lines;

  TextFile(final File file) throws IOException {
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

  int addLines(final int start, final Predicate<String> isEnd, final String attributeName) {
    final StringBuilder acc = new StringBuilder();
    int lineNumber;

    for (lineNumber = start; lineNumber < lines.size(); lineNumber++) {
      final String line = lines.get(lineNumber);

      if (isEnd.test(line)) {
        break;
      }

      acc.append(line);
      acc.append("\n");
    }

    attributes.put(attributeName, acc.toString().trim());

    return lineNumber;
  }
}