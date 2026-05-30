import java.awt.image.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;

class ImageImporter implements Importer {
  public Document importFile(final File file) throws IOException {
    final Map<String, String> attributes = new HashMap<>();

    attributes.put(Attributes.PATH, file.getPath());

    final BufferedImage image = ImageIO.read(file);
    attributes.put(Attributes.WIDTH, String.valueOf(image.getWidth()));
    attributes.put(Attributes.HEIGHT, String.valueOf(image.getHeight()));
    attributes.put(Attributes.TYPE, "IMAGE");

    return new Document(attributes);
  }
}