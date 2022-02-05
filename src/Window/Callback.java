package Window;

import java.awt.*;

public interface Callback<T> {
    void call(T arg);
}
