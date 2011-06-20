package com.netxforge.netxstudio.server.logic.expression;

import java.util.List;

import com.netxforge.netxstudio.library.Expression;
import com.netxforge.netxstudio.library.ExpressionResult;

public interface IExpressionEngine {

	public abstract void run();

	public abstract Expression getExpression();

	public abstract void setExpression(Expression expression);

	public abstract List<ExpressionResult> getExpressionResult();
	
	public boolean errorOccurred();
	
	public Throwable getThrowable();
	
	public List<Object> getContext();
}