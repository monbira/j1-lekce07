package cz.czechitas.lekce7;

import org.junit.jupiter.api.Test;

import java.time.Month;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Filip Jirsák
 */
class SvatkyTest {

  /**
   * Testuje metodu {@link Svatky#kdyMaSvatek(String)}
   */
  @Test
  void kdyMaSvatek() {
    Svatky svatky = new Svatky();
    assertEquals(MonthDay.of(5, 18), svatky.kdyMaSvatek("Nataša"));
    assertNull(svatky.kdyMaSvatek("Eva"));
    assertNull(svatky.kdyMaSvatek("odsihorugh"));
  }

  /**
   * Testuje metodu {@link Svatky#jeVSeznamu(String)}
   */
  @Test
  void jeVSeznamu() {
    Svatky svatky = new Svatky();
    assertTrue(svatky.jeVSeznamu("Nataša"));
    assertFalse(svatky.jeVSeznamu("Eva"));
    assertFalse(svatky.jeVSeznamu("odsihorugh"));
  }

  /**
   * Testuje metodu {@link Svatky#getPocetJmen()}
   */
  @Test
  void getPocetJmen() {
    Svatky svatky = new Svatky();
    assertEquals(37, svatky.getPocetJmen());
  }

  /**
   * Testuje metodu {@link Svatky#getSeznamJmen()}
   */
  @Test
  void getSeznamJmen() {
    Svatky svatky = new Svatky();
    assertEquals(37, svatky.getSeznamJmen().size());
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, int)}
   */
  @Test
  void pridatSvatekDenMesicInt() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Michal", 29, 9);
    assertTrue(svatky.jeVSeznamu("Michal"));
    assertEquals(MonthDay.of(9, 29), svatky.kdyMaSvatek("Michal"));
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, int, Month)}
   */
  @Test
  void pridatSvatekDenMesicMonth() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Michal", 29, Month.SEPTEMBER);
    assertTrue(svatky.jeVSeznamu("Michal"));
    assertEquals(MonthDay.of(Month.SEPTEMBER, 29), svatky.kdyMaSvatek("Michal"));
  }

  /**
   * Testuje metodu {@link Svatky#pridatSvatek(String, MonthDay)}
   */
  @Test
  void pridatSvatekMonthDay() {
    Svatky svatky = new Svatky();
    svatky.pridatSvatek("Michal", MonthDay.of(9, 29));
    assertTrue(svatky.jeVSeznamu("Michal"));
    assertEquals(MonthDay.of(9, 29), svatky.kdyMaSvatek("Michal"));

  }

  /**
   * Testuje metodu {@link Svatky#smazatSvatek(String)}
   */
  @Test
  void smazatSvatek() {
    //TODO Zkontrolovat, že po smazání bude počet svátků odpovídat novému počtu.
    Svatky svatky = new Svatky();
    svatky.smazatSvatek("Monika");
    assertEquals(36, svatky.getPocetJmen());
  }
}
