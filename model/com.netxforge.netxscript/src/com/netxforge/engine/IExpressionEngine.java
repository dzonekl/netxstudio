package com.netxforge.engine;

import java.util.List;

import com.netxforge.netxstudio.library.BaseExpressionResult;
import com.netxforge.netxstudio.library.Expression;

public interface IExpressionEngine {

	public abstract void run();

	public abstract Expression getExpression();

	public abstract void setExpression(Expression expression);

	public abstract List<BaseExpressionResult> getExpressionResult();
	
	public boolean errorOccurred();
	
	public Throwable getThrowable();
	
	public List<Object> getContext();
}