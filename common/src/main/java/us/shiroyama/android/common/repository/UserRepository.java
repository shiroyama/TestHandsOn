package us.shiroyama.android.common.repository;

import android.support.annotation.Nullable;

import us.shiroyama.android.common.entity.User;

/**
 * {@link User}エンティティを取得／保存するためのレポジトリ
 */
public interface UserRepository {
    /**
     * IDを元に{@link User}を返す
     *
     * @param id
     * @return {@link User}
     */
    @Nullable
    User findById(long id);

    /**
     * {@link User}を保存する
     *
     * @param user
     * @return 保存成功の可否
     */
    boolean save(User user);
}
