import java.io.*;

Interface Importer {
  Document importFile(File file) throws IOException;
}