package io.cdap.wrangler.parser;

import io.cdap.wrangler.api.parser.ByteSize;
import io.cdap.wrangler.api.parser.TimeDuration;
import io.cdap.wrangler.api.parser.Token;
import io.cdap.wrangler.api.parser.StringValue;
import io.cdap.wrangler.api.parser.Numeric;
import io.cdap.wrangler.api.parser.ColumnName;
import io.cdap.wrangler.api.parser.BooleanValue;

public class GrammarVisitor extends DirectivesBaseVisitor<Token> {

  @Override
  public Token visitValue(DirectivesParser.ValueContext ctx) {
    if (ctx.BYTE_SIZE() != null) {
      return new ByteSize(ctx.BYTE_SIZE().getText());
    } else if (ctx.TIME_DURATION() != null) {
      return new TimeDuration(ctx.TIME_DURATION().getText());
    } else if (ctx.String() != null) {
      return new StringValue(ctx.String().getText());
    } else if (ctx.Number() != null) {
      return new Numeric(ctx.Number().getText());
    } else if (ctx.Column() != null) {
      return new ColumnName(ctx.Column().getText());
    } else if (ctx.Bool() != null) {
      return new BooleanValue(ctx.Bool().getText());
    }
    return null;
  }
}
