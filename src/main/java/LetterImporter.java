class LetterImporter implements Importer {
  public Document importFile (final File file) throws IOException {
final Map<String, String> attributes = new HashMap<>;

attributes.put(PATH,file.getPath())

return new Document(attributes)
  }
}