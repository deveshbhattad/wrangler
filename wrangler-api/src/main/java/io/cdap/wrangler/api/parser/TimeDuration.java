package io.cdap.wrangler.api.parser;

public class TimeDuration extends Token {
  private final double value;
  private final String unit;

  public TimeDuration(String symbol) {
    super(Type.TIME_DURATION, symbol);
    symbol = symbol.trim().toLowerCase();
    this.unit = symbol.replaceAll("[0-9.]", "");
    this.value = Double.parseDouble(symbol.replaceAll("[^0-9.]", ""));
  }

  public long getMilliseconds() {
    switch (unit) {
      case "ms": return (long)value;
      case "s":
      case "sec": return (long)(value * 1000);
      case "m":
      case "min": return (long)(value * 60 * 1000);
      case "h":
      case "hr": return (long)(value * 60 * 60 * 1000);
      default: return (long)value;
    }
  }
}
