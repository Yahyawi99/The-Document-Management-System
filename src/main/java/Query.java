import java.util.*;
import java.util.function.Predicate;
import static java.util.stream.Collectors.toMap;

class Query implements Predicate<Document> {
  private final Map<String, String> clauses;

  // "patient:Joe,body:Diet Coke"
  static Query parse(final String query) {
    return new Query(Arrays.stream(query.split(","))
        .map(str -> str.split(":"))
        .collect(toMap(x -> x[0], x -> x[1])));
  }

  private Query(final Map<String, String> clauses) {
    this.clauses = clauses;
  }

  public boolean test(final Document doc) {
    return clauses.entrySet()
        .stream()
        .allMatch(entry -> {
          final String docValue = doc.getAttributes(entry.getKey());
          final String queryValue = entry.getValue();
          return docValue != null && docValue.contains(queryValue);
        });
  }
}
