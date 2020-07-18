package lombok;
// klasa modelu
@Data           // dodaje gettery, settery, toString, equals, hashCode
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    private String taskName;
    private String taskDescription;
    private boolean done;
    private User user;
}
