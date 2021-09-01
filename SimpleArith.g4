/*
 * SimpleArith.g4 -- ANTLR grammar for simple arithmetic expression language
 *
 * Michael McThrow
 * CS 152 -- Section 06
 * San José State University
 * Fall 2021
 */
grammar SimpleArith;

WS         : [ \t\r\n]+ -> skip ;

AddOp      : '+' | '-' ;
MultOp     : '*' | '/' ;

Integer    : '-'? [0-9]+ ;

expr       : '(' expr ')'      # parensExpr
           | expr MultOp expr  # multExpr
           | expr AddOp expr   # addExpr
           | Integer           # intExpr
           ;

Error      : . ;
