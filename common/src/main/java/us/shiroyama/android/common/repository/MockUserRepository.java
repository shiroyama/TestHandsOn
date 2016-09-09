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
        if (id == 1) {
            return new User(id, "shiroyama", "fu.shiroyama@gmail.com");
        }
        return null;
    }

    @Override
    public boolean save(User user) {
        if (user.getId() == 1) {
            return true;
        }
        return false;
    }
}
