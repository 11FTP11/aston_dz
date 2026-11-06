final class Immutable<T> {
	private final Mutable<T> container;

	Mutable<T> getValue() {
		return new Mutable<T>(this.container);
	}

	Immutable(T value) {
		this.container = new Mutable<T>(value);
	}

	Immutable(Mutable<T> instance) {
		this.container = new Mutable<T>(instance);
	}
}

class Mutable<T> {
	private T value;

	Mutable() {}

	Mutable(T value) {
		this.value = value;
	}

	Mutable(Mutable<T> instance) {
		if (instance != null) {
			this.value = instance.value;
		}
	}

	T getValue() {
		return value;	
	}

	Mutable<T> setValue(T value) {
		this.value = value;
		return this;
	}
}

public class Sol {
	public static void main(String[] args) {
		Mutable<Double> inner = new Mutable<>(3.14);
		Immutable<Double> obj = new Immutable<>(inner);
		inner.setValue(null);

		assert obj.getValue() != obj.getValue();
		assert !obj.getValue().getValue().equals(inner.getValue());

		System.out.format("immutable: %f\nmutable: %f\n", obj.getValue().getValue(), inner.getValue());
	}
}

