import java.util.function.Supplier

/**
 * 현재 Boolean 이 false 면 throwable 을 리턴한다.
 */
inline infix fun <X : Throwable> Boolean.isFalse(exceptionSupplier: Supplier<out X>) {
    if (this) {
        exceptionSupplier.get()
    }
}
