public enum TaskElement {
    BYE("bye"),
    LIST("list"),
    DONE("done"),
    TODO("todo"),
    DEADLINE("deadline"),
    EVENT("event"),
    DELETE("delete"),
    TAG("tag"),
    FIND("find");

    public final String label;

    private TaskElement(String label) {
        this.label = label;
    }
}
