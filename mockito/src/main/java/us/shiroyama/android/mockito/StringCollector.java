package us.shiroyama.android.mockito;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

import java.util.ArrayList;
import java.util.List;

/**
 * 内部の{@link List}に文字列をためていくだけのクラス
 */
public class StringCollector {
    private List<String> strings = new ArrayList<>();

    public void add(@NonNull String string) {
        strings.add(string);
    }

    public int size() {
        return strings.size();
    }

    @VisibleForTesting
    void setStrings(List<String> strings) {
        this.strings = strings;
    }
}
