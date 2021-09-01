/*
 * SimpleArithEvaluator.java -- Evaluates expressions in SimpleArith
 *
 * Michael McThrow
 * CS 152 -- Section 06
 * San José State University
 * Fall 2021
 */

public class SimpleArithEvaluator extends SimpleArithBaseVisitor<Integer> {
    /** Integer */
    
    public Integer visitIntExpr(SimpleArithParser.IntExprContext ctx) {
        return new Integer(ctx.Integer().getText());
    }

    /** expr AddOp expr */
    public Integer visitAddExpr(SimpleArithParser.AddExprContext ctx) {
        String op = ctx.AddOp().getText();

        if (op.equals("+"))
            return visit(ctx.expr(0)) + visit(ctx.expr(1));
        else
            return visit(ctx.expr(0)) - visit(ctx.expr(1));
    }

    /** '(' expr ')' */
    public Integer visitParensExpr(SimpleArithParser.ParensExprContext ctx) {
        return visit(ctx.expr());
    }

    /** expr MultOp expr */
    public Integer visitMultExpr(SimpleArithParser.MultExprContext ctx) {
        String op = ctx.MultOp().getText();

        if (op.equals("*"))
            return visit(ctx.expr(0)) * visit(ctx.expr(1));
        else
            return visit(ctx.expr(0)) / visit(ctx.expr(1));
    }
}
