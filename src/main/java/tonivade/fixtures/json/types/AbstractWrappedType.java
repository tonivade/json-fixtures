package tonivade.fixtures.json.types;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractWrappedType implements ParameterizedType {

    private final Class<?>[] wrapped;

    public AbstractWrappedType(Class<?> ... wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Type[] getActualTypeArguments() {
        return wrapped;
    }

    @Override
    public Type getOwnerType() {
        return null;
    }
}
