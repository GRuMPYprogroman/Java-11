public class Main {
    public static void main(String[] args) {
        try {
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

            // Тестирование некорректного ввода
            observableStringBuilder.append(null); // Попытка добавить null
            observableStringBuilder.delete(-1, 10); // Некорректные индексы
            observableStringBuilder.insert(100, "Тест"); // Индекс за пределами длины
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        }
    }
}
