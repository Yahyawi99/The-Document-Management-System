import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.io.*;

class ImageImporter implements Importer {
  private static final String PATH = "path";
  private static final String WIDTH = "width";
  private static final String HEIGHT = "height";
  private static final String TYPE = "type";

  public Document importFile(final File file) throws IOException {
    final Map<String, String> attributes = new HashMap<>();

    attributes.put(PATH, file.getPath());

    final BufferedImage image = ImageIO.read(file);
    attributes.put(WIDTH, String.valueOf(image.getWidth()));
    attributes.put(HEIGHT, String.valueOf(image.getHeight()));
    attributes.put(TYPE, "IMAGE");

    return new Document(attributes);
  }
}