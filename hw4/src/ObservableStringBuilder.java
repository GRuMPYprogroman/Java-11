import java.util.ArrayList;
import java.util.List;

public class ObservableStringBuilder {
    private StringBuilder stringBuilder;
    private List<ChangeListener> listeners;

    public ObservableStringBuilder() {
        this.stringBuilder = new StringBuilder();
        this.listeners = new ArrayList<>();
    }

    public void addChangeListener(ChangeListener listener) {
        if (listener != null) {
            listeners.add(listener);
        } else {
            System.out.println("Предупреждение: попытка добавить null в качестве слушателя изменений.");
        }
    }

    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (ChangeListener listener : listeners) {
            try {
                listener.onChange();
            } catch (Exception e) {
                System.out.println("Ошибка в слушателе изменений: " + e.getMessage());
            }
        }
    }

    public ObservableStringBuilder append(String str) {
        if (str == null) {
            System.out.println("Ошибка: нельзя добавить null строку.");
            return this;
        }
        try {
            stringBuilder.append(str);
            notifyListeners();
        } catch (Exception e) {
            System.out.println("Исключение при добавлении строки: " + e.getMessage());
        }
        return this;
    }

    public ObservableStringBuilder append(char c) {
        try {
            stringBuilder.append(c);
            notifyListeners();
        } catch (Exception e) {
            System.out.println("Исключение при добавлении символа: " + e.getMessage());
        }
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        if (start < 0 || end > stringBuilder.length() || start > end) {
            System.out.println("Ошибка: некорректные индексы удаления (start=" + start + ", end=" + end + ").");
            return this;
        }
        try {
            stringBuilder.delete(start, end);
            notifyListeners();
        } catch (Exception e) {
            System.out.println("Исключение при удалении: " + e.getMessage());
        }
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        if (str == null) {
            System.out.println("Ошибка: нельзя вставить null строку.");
            return this;
        }
        if (offset < 0 || offset > stringBuilder.length()) {
            System.out.println("Ошибка: некорректный индекс вставки (offset=" + offset + ").");
            return this;
        }
        try {
            stringBuilder.insert(offset, str);
            notifyListeners();
        } catch (Exception e) {
            System.out.println("Исключение при вставке: " + e.getMessage());
        }
        return this;
    }

    public int length() {
        return stringBuilder.length();
    }

    @Override
    public String toString() {
        return stringBuilder.toString();
    }
}
