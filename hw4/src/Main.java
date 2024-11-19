public class Main {
    public static void main(String[] args) {
        ObservableStringBuilder observableStringBuilder = new ObservableStringBuilder();

        ChangeListener listener = new ChangeListener() {
            @Override
            public void onChange() {
                System.out.println("Состояние изменилось: " + observableStringBuilder.toString());
            }
        };

        observableStringBuilder.addChangeListener(listener);

        observableStringBuilder.append("Привет");
        observableStringBuilder.append(", мир");
        observableStringBuilder.delete(5, 6);
        observableStringBuilder.insert(5, "!");
    }
}