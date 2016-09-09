package us.shiroyama.android.mockito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * {@link StringCollector}のテスト
 */
public class StringCollectorTest {
    private StringCollector stringCollector;

    private List<String> mockStrings;

    @SuppressWarnings("unchecked")
    @Before
    public void setUp() {
        // for @InjectMocks
        initMocks(this);

        mockStrings = mock(List.class);
        when(mockStrings.size()).thenReturn(15);

        stringCollector = new StringCollector();
        stringCollector.setStrings(mockStrings);

        when(mockStringsForInject.size()).thenReturn(27);

        mockStringsForSpy = spy(new ArrayList<String>());
        doReturn(38).when(mockStringsForSpy).size();

        stringCollectorForSpy = new StringCollector();
        stringCollectorForSpy.setStrings(mockStringsForSpy);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void addメソッドでListに要素が追加されていくことを検証() throws Exception {
        stringCollector.add("apple");
        stringCollector.add("orange");
        stringCollector.add("banana");

        verify(mockStrings, times(1)).add("apple");
        verify(mockStrings, times(1)).add("orange");
        verify(mockStrings, times(1)).add("banana");
    }

    @Test
    public void sizeメソッドが返す要素数をMockitoを使ってモックしてみよう() throws Exception {
        int expected = stringCollector.size();
        assertThat(expected, is(15));
        verify(mockStrings, times(1)).size();
    }

    @Mock
    List<String> mockStringsForInject;

    @InjectMocks
    StringCollector stringCollectorForInject;

    @Test
    public void MockitoのInjectMocksを使ってListにモックを差し込んでみよう() throws Exception {
        int expected = stringCollectorForInject.size();
        assertThat(expected, is(27));
        verify(mockStringsForInject, times(1)).size();
    }

    private StringCollector stringCollectorForSpy;

    private List<String> mockStringsForSpy;

    @Test
    public void MockitoのSpyを使ってListのsizeメソッドだけを差し替えてみよう() throws Exception {
        stringCollectorForSpy.add("AAA");
        stringCollectorForSpy.add("BBB");
        stringCollectorForSpy.add("CCC");

        assertThat(mockStringsForSpy.get(0), is("AAA"));
        assertThat(mockStringsForSpy.get(1), is("BBB"));
        assertThat(mockStringsForSpy.get(2), is("CCC"));

        int expected = stringCollectorForSpy.size();
        assertThat(expected, is(38));
        verify(mockStringsForSpy, times(1)).size();
    }
}
