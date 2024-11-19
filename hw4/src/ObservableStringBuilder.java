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
        listeners.add(listener);
    }

    public void removeChangeListener(ChangeListener listener) {
        listeners.remove(listener);
    }

    private void notifyListeners() {
        for (ChangeListener listener : listeners) {
            listener.onChange();
        }
    }

    public ObservableStringBuilder append(String str) {
        stringBuilder.append(str);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder append(char c) {
        stringBuilder.append(c);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder delete(int start, int end) {
        stringBuilder.delete(start, end);
        notifyListeners();
        return this;
    }

    public ObservableStringBuilder insert(int offset, String str) {
        stringBuilder.insert(offset, str);
        notifyListeners();
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