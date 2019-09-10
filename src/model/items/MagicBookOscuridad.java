package model.items;

/**
 * This class represents a MagicBookOscuridad type item.
 * <p>
 * MagicBookOscuridad are strong against MagicBookAnima and weak against MagicBookLuz.
 *
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class MagicBookOscuridad extends AbstractItem {

  /**
   * Creates a new MagicBookOscuridad.
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
  public MagicBookOscuridad(final String name, final int power, final int minRange, final int maxRange) {
    super(name, power, minRange, maxRange);
  }
}
