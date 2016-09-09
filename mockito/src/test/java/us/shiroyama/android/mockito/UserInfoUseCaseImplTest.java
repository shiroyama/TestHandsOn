package us.shiroyama.android.mockito;

import android.support.annotation.NonNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

import us.shiroyama.android.common.entity.User;
import us.shiroyama.android.common.exception.UserNotFoundException;
import us.shiroyama.android.common.repository.MockUserRepository;
import us.shiroyama.android.common.repository.UserRepository;
import us.shiroyama.android.common.usecase.UserInfoUseCase;
import us.shiroyama.android.common.usecase.UserInfoUseCaseImpl;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * {@link us.shiroyama.android.common.usecase.UserInfoUseCaseImpl}のテスト
 */
public class UserInfoUseCaseImplTest {
    private UserRepository userRepository;

    private UserInfoUseCaseImpl userInfoUseCaseImpl;

    private CountDownLatch latch;

    @Before
    public void setUp() {
        userRepository = new MockUserRepository();
        userInfoUseCaseImpl = new UserInfoUseCaseImpl(userRepository);
        latch = new CountDownLatch(1);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void findByIdでIDが1なら正しくUserが引ける() throws Exception {
        userInfoUseCaseImpl.findById(1,
                new UserInfoUseCase.UserFetchSuccess() {
                    @Override
                    public void onSuccess(@NonNull User user) {
                        assertThat(user.getId(), is(1L));
                        assertThat(user.getName(), is("shiroyama"));
                        assertThat(user.getEmail(), is("fu.shiroyama@gmail.com"));
                        latch.countDown();
                    }
                }, new UserInfoUseCase.UserFetchFailure() {
                    @Override
                    public void onFailure(@NonNull Throwable error) {
                        throw new RuntimeException("should not be here");
                    }
                });
        latch.await();
    }

    @Test
    public void findByIdでIDが0ならエラー() throws Exception {
        userInfoUseCaseImpl.findById(0,
                new UserInfoUseCase.UserFetchSuccess() {
                    @Override
                    public void onSuccess(@NonNull User user) {
                        throw new RuntimeException("should not be here");
                    }
                }, new UserInfoUseCase.UserFetchFailure() {
                    @Override
                    public void onFailure(@NonNull Throwable error) {
                        assertThat(error, is(instanceOf(UserNotFoundException.class)));
                        latch.countDown();
                    }
                });
        latch.await();
    }

    @Test
    public void saveでIDが1なら正しくUserを保存できる() throws Exception {
        User user = new User(1, "shiroyama", "fu.shiroyama@gmail.com");
        userInfoUseCaseImpl.save(user,
                new UserInfoUseCase.UserSaveSuccess() {
                    @Override
                    public void onSuccess(boolean isSuccessful) {
                        assertThat(isSuccessful, is(true));
                        latch.countDown();
                    }
                }, new UserInfoUseCase.UserSaveFailure() {
                    @Override
                    public void onFailure(@NonNull Throwable error) {
                        throw new RuntimeException("should not be here");
                    }
                });
        latch.await();
    }

    @Test
    public void saveでIDが0ならエラー() throws Exception {
        User user = new User(0, "tanaka", "tanaka@example.com");
        userInfoUseCaseImpl.save(user,
                new UserInfoUseCase.UserSaveSuccess() {
                    @Override
                    public void onSuccess(boolean isSuccessful) {
                        throw new RuntimeException("should not be here");
                    }
                }, new UserInfoUseCase.UserSaveFailure() {
                    @Override
                    public void onFailure(@NonNull Throwable error) {
                        assertThat(error, is(instanceOf(IllegalStateException.class)));
                        latch.countDown();
                    }
                });
        latch.await();
    }
}
