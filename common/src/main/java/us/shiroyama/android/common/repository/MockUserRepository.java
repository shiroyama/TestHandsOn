package us.shiroyama.android.common.repository;

import android.support.annotation.Nullable;

import us.shiroyama.android.common.entity.User;

/**
 * テスト用のモック{@link UserRepository}
 */
public class MockUserRepository implements UserRepository {
    @Nullable
    @Override
    public User findById(long id) {
        try {
            // Imitates long-running task
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (id == 1) {
            return new User(id, "shiroyama", "fu.shiroyama@gmail.com");
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        try {
            // Imitates long-running task
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (user.getId() == 1) {
            return true;
        }
        return false;
    }
}
