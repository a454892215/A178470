package discuz.com.retrofit.library;

import java.lang.reflect.Type;

import retrofit2.Call;
import retrofit2.CallAdapter;
import rx.Observable;

/**
 * Created by pangxiaomin on 16/11/27.
 */
public class RxCallAdapter implements CallAdapter<Observable<?>> {

    public CallAdapter<?> adapter;

    public RxCallAdapter(CallAdapter<?> adapter) {
        this.adapter = adapter;
    }

    @Override
    public Type responseType() {
        return adapter.responseType();
    }

    @Override
    public <R> Observable<?> adapt(Call<R> call) {
        return ((Observable) adapter.adapt(call)).compose(new HTTPTransformer<>());
    }
}
