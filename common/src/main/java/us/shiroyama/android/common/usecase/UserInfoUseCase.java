package us.shiroyama.android.common.usecase;

import android.support.annotation.NonNull;

import us.shiroyama.android.common.entity.User;

/**
 * {@link User}エンティティを取得／保存するためのユースケース
 */
public interface UserInfoUseCase {
    void findById(long id, UserFetchSuccess onSuccess, UserFetchFailure onFailure);

    void save(@NonNull User user, UserSaveSuccess onSuccess, UserSaveFailure onFailure);

    interface UserFetchSuccess {
        void onSuccess(@NonNull User user);
    }

    interface UserFetchFailure {
        void onFailure(@NonNull Throwable error);
    }

    interface UserSaveSuccess {
        void onSuccess(boolean isSuccessful);
    }

    interface UserSaveFailure {
        void onFailure(@NonNull Throwable error);
    }
}
