package us.shiroyama.android.common.repository;

import android.support.annotation.Nullable;

import us.shiroyama.android.common.entity.User;

/**
 * ローカルデータベースをバックエンドにした{@link UserRepository}
 */
public class LocalDbUserRepository implements UserRepository {
    @Nullable
    @Override
    public User findById(long id) {
        // TODO 実際の処理を記述
        return null;
    }

    @Override
    public boolean save(User user) {
        // TODO 実際の処理を記述
        return false;
    }
}
