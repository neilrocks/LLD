abstract class BasePizza {
    public abstract int cost();
}

class NonVeg extends BasePizza {
    public int cost() {
        return 30;
    }
}

class Veg extends BasePizza {
    public int cost() {
        return 25;
    }
}

abstract class ToppingDecorator extends BasePizza {
    protected BasePizza pizza;

    public ToppingDecorator(BasePizza pizza) {
        this.pizza = pizza;
    }

    public abstract int cost();
}

class ExtraCheese extends ToppingDecorator {
    public ExtraCheese(BasePizza pizza) {
        super(pizza);
    }

    public int cost() {
        return pizza.cost() + 100;
    }
}

class ExtraMushroom extends ToppingDecorator {
    public ExtraMushroom(BasePizza pizza) {
        super(pizza);
    }

    public int cost() {
        return pizza.cost() + 120;
    }
}

class ExtraMutton extends ToppingDecorator {
    public ExtraMutton(BasePizza pizza) {
        super(pizza);
    }

    public int cost() {
        return pizza.cost() + 140;
    }
}

class Main {
    public static void main(String[] args) {
        BasePizza pizza = new ExtraMutton(new ExtraMushroom(new NonVeg()));
        System.out.println("Cost is " + pizza.cost());
    }
}
