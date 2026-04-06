class ImageImporter implements Importer {
  public Document importFile (final File file) throws IOException {
final Map<String, String> attributes = new HashMap<>;

attributes.put(PATH,file.getPath())

final BufferedImage image  = imageIO.read(file)

attributes.put(WIDTH,String.valueOf(image.getWidth()))
attributes.put(HEIGHT,String.valueOf(image.getHeight()))
attributes.put(TYPE,'IMAGE')

return new Document(attributes)
  }
}