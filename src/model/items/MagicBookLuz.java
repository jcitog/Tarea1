package model.items;

/**
 * This class represents a MagicBookLuz type item.
 * <p>
 * MagicBookluz are strong against MagicBookOscuridad and weak against MagicBookAnima.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class MagicBookLuz extends AbstractItem {

  /**
   * Creates a new MagicBookLuz.
   *
   * @param name
   *     the name that identifies the weapon
   * @param power
   *     the base damage pf the weapon
   * @param minRange
   *     the minimum range of the weapon
   * @param maxRange
   *     the maximum range of the weapon
   */
  public MagicBookLuz(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
}
