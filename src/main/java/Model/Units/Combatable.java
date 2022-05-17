package Model.Units;

public interface Combatable {
    void attack(Combatable target);

    void defend(Combatable target);
}
